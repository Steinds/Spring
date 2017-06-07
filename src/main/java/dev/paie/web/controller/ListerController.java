package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class ListerController {
	
	@Autowired GradeRepository gs;
	@Autowired EntrepriseRepository er;
	@Autowired ProfilRepository pr;
	@Autowired RemunerationEmployeRepository remu;


	@RequestMapping(method = RequestMethod.GET, path = "/liste")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/lister");
		
		List<RemunerationEmploye> remuE =remu.findAll() ;
		System.out.println(remuE);
		mv.addObject("employes",remuE);
		return mv;
	}

}
