package dev.paie.service;


import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

@ContextConfiguration(classes = {ServicesConfig.class})
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	
	@Autowired private GradeService gradeService;
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouveau grade
		Grade grade = new Grade();

		grade.setCode("m01");
		grade.setNbHeuresBase(new BigDecimal(1.2));
		grade.setTauxBase(new BigDecimal(1.0));
		gradeService.sauvegarder(grade);
		List<Grade> listerGradeApresSave = gradeService.lister();
		assertTrue(listerGradeApresSave.stream().anyMatch( g ->g.getCode().equals("m01")));
		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		// TODO modifier un grade
		
		grade.setCode("m02");
		gradeService.mettreAJour(grade);
		List<Grade> listerGradeMAJ = gradeService.lister();
		assertTrue(listerGradeMAJ.stream().anyMatch( g ->g.getCode().equals("m02")));
		// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
	}
}
