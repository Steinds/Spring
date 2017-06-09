package dev.paie.web.controller;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.GradeService;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired GradeRepository gs;
	@Autowired EntrepriseRepository er;
	@Autowired ProfilRepository pr;
	@Autowired RemunerationEmployeRepository remu;


	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("prefixMatricule","M00");
		List<Entreprise> e =er.findAll() ;
		List<ProfilRemuneration> p = pr.findAll();
		List<Grade> g = gs.findAll() ;
		mv.addObject("grade",g);
		mv.addObject("entreprise",e);
		mv.addObject("profil",p);

		return mv;
	}

	
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView saveEmploye(@RequestParam(value="matricule")String matricule,@RequestParam(value="entreprise")String entreprise,@RequestParam(value="grade")String grade,@RequestParam(value="profil")String profil) {
		ModelAndView mv = new ModelAndView();
		System.out.println(matricule);
		System.out.println(entreprise);
		System.out.println(profil);
		System.out.println(grade);
		
		mv.setViewName("employes/creerEmploye");
		RemunerationEmploye remuE = new RemunerationEmploye();
		remuE.setEntreprise(er.findOne(Integer.parseInt(entreprise)));
		remuE.setGrade(gs.findOne(Integer.parseInt(grade)));
		remuE.setProfilRemuneration(pr.findOne(Integer.parseInt(profil)));
		remuE.setMatricule(matricule);
		remuE.setDateCrea(ZonedDateTime.now());
		
		remu.saveAndFlush(remuE);
		return new ModelAndView("redirect:./liste");
	}
}
