package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.service.GradeService;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	
	@Autowired GradeService gs;
	@Autowired EntrepriseRepository er;
	@Autowired ProfilRepository pr;
	
	
 @RequestMapping(method = RequestMethod.GET, path = "/creer")
 public ModelAndView creerEmploye() {
 ModelAndView mv = new ModelAndView();
 mv.setViewName("employes/creerEmploye");
 mv.addObject("prefixMatricule","M00");
 List<Entreprise> e =er.findAll() ;
 List<ProfilRemuneration> p = pr.findAll();
 List<Grade> g = gs.lister() ;
 mv.addObject("grade",g);
 mv.addObject("entreprise",e);
 mv.addObject("profil",p);
 
 return mv;
}
}
