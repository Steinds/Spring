package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;
import dev.paie.spring.JpaConfig;


//TODO compléter la configuration
@ContextConfiguration(classes = {JpaConfig.class, ServicesConfig.class})
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
 @Autowired private CotisationService cotisationService;
 @Test
 @Transactional
 public void test_sauvegarder_lister_mettre_a_jour() {
 // TODO sauvegarder une nouvelle cotisation
	 
	 Cotisation cotisa = new Cotisation();
	 	
	 	cotisa.setCode("m01");
		cotisa.setLibelle("hey");
		cotisa.setTauxSalarial(new BigDecimal(0.1));
		cotisa.setTauxPatronal(new BigDecimal(0.1));
		
		cotisationService.sauvegarder(cotisa);
		
		List<Cotisation> listerCotisationApresSave = cotisationService.lister();
		assertTrue(listerCotisationApresSave.stream().anyMatch( g ->g.getCode().equals("m01")));
		
		cotisa.setCode("modif");
		cotisationService.mettreAJour(cotisa);
		List<Cotisation> listerCotisationApresMAJ = cotisationService.lister();
		assertTrue(listerCotisationApresMAJ.stream().anyMatch( g ->g.getCode().equals("modif")));
 // TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la méthode lister
 // TODO modifier une cotisation
 // TODO vérifier que les modifications sont bien prises en compte via la méthode lister
 }
}
