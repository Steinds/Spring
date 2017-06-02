package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService
{
	private ClassPathXmlApplicationContext context;
	private PaieUtils paieUtils;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		
		context = new ClassPathXmlApplicationContext("app-config.xml");
		paieUtils = context.getBean("paieUtils", PaieUtils.class);
		
		ResultatCalculRemuneration result = new ResultatCalculRemuneration();
		BigDecimal salaireDeBase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		result.setSalaireBrut(paieUtils.formaterBigDecimal(((bulletin.getPrimeExceptionnelle()).add(salaireDeBase))));
		BigDecimal salaireBrut =new BigDecimal(result.getSalaireBrut());
		result.setSalaireDeBase(paieUtils.formaterBigDecimal(salaireDeBase));
		BigDecimal TotalRetenueSalarial = new BigDecimal(0);
		BigDecimal TotalCotisationPatronales = new BigDecimal(0);
		BigDecimal val = new BigDecimal(0);
		
		for ( Cotisation cot : bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()){
			if (cot.getTauxSalarial()!=null)
			TotalRetenueSalarial = TotalRetenueSalarial.add(cot.getTauxSalarial()	.multiply(salaireBrut)); 
			}
		
		for ( Cotisation cot : bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()){
			if (cot.getTauxPatronal()!=null)
			TotalCotisationPatronales = TotalCotisationPatronales.add(cot.getTauxPatronal().multiply(salaireBrut)); 
			}
		
		for ( Cotisation cot : bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables()){
			if (cot.getTauxSalarial()!=null)
			val = val.add(cot.getTauxSalarial()	.multiply(salaireBrut)); 
			
		}
		BigDecimal netImposable = salaireBrut.subtract(TotalRetenueSalarial);
		result.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(TotalRetenueSalarial));
		result.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(TotalCotisationPatronales));
		result.setNetImposable(paieUtils.formaterBigDecimal(netImposable));
		result.setNetAPayer(paieUtils.formaterBigDecimal(netImposable.subtract(val)));

		return result ;
	}

}