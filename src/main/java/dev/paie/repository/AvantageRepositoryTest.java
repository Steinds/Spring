package dev.paie.repository;

import static org.junit.Assert.assertThat;




import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.spring.JpaConfig;


//TODO compléter la configuration
@ContextConfiguration(classes = { ServicesConfig.class, JpaConfig.class})
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
 @Autowired private AvantageRepository avantageRepository;
 @Test
 public void test_sauvegarder_lister_mettre_a_jour() {
	 Avantage a = new Avantage();
	 a.setCode("m01");
	 a.setMontant(12);
	 a.setNom("hey");
	 avantageRepository.save(a);
	 assertThat(avantageRepository.findOne(a.getId()).getCode(), CoreMatchers.equalTo(a.getCode()));
	 a.setCode("new");
	 avantageRepository.save(a);
	 assertThat(avantageRepository.findOne(a.getId()).getCode(), CoreMatchers.equalTo(a.getCode()));
	 assertThat(avantageRepository.findByCode(a.getCode()).get(0).getCode(), CoreMatchers.equalTo(a.getCode()));
	 
 // TODO sauvegarder un nouvel avantage
 // TODO vérifier qu'il est possible de récupérer le nouvel avantage via la mthode findOne
 // TODO modifier un avantage
 // TODO vérifier que les modifications sont bien prises en compte via la mthode findOne
 }
}

