package dev.paie.web.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired PeriodeRepository pr;
	@Autowired RemunerationEmployeRepository remu;
	@Autowired BulletinSalaireRepository bsr;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		
		List<Periode> pe =pr.findAll() ;
		List<RemunerationEmploye> remuE = remu.findAll();
		mv.addObject("periode",pe);
		mv.addObject("employe",remuE);
		return mv;
	}

	
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView saveBulletin(@RequestParam(value="matricule")String matricule,@RequestParam(value="periode")String periode,@RequestParam(value="prime")BigDecimal primeExceptionnelle) {
		ModelAndView mv = new ModelAndView();
		System.out.println(matricule);
		System.out.println(periode);
		
		
		mv.setViewName("bulletins/creerBulletin");
		BulletinSalaire bull = new BulletinSalaire();
		bull.setRemunerationEmploye(remu.findByMatricule(matricule).get(0));
		bull.setPeriode(pr.findOne(Integer.parseInt(periode)));
		bull.setPrimeExceptionnelle(primeExceptionnelle);
		
		bsr.saveAndFlush(bull);
		return new ModelAndView("redirect:./liste");
	}
}