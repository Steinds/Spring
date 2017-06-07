package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinSalaireRepository;

@Controller
@RequestMapping("/bulletins")
public class ListerBulletinsController {
	
	@Autowired BulletinSalaireRepository bsr;


	@RequestMapping(method = RequestMethod.GET, path = "/liste")
	public ModelAndView listerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerbulletin");
		
		List<BulletinSalaire> bulletins =bsr.findAll() ;
		
		mv.addObject("bulletins",bulletins);
		return mv;
	}

}