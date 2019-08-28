package com.turkeyjug.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// http://localhost:8085/006_SpringMvcRestful
@Controller
public class AnasayfaController {
		
	
	// http://localhost:8085/006_SpringMvcRestful
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	
	
	// http://localhost:8085/006_SpringMvcRestful/anasayfa
	@RequestMapping(value = "/anasayfa", method = RequestMethod.GET)
	public String home(Model model) {

		model.addAttribute("mesaj", "SELAMLAR SPRING MVC" );
		
		return "AnasayfaView";
	}
	
	
	
	// http://localhost:8085/006_SpringMvcRestful/karsilama.jsf
	@RequestMapping(value = "/karsilama.jsf", method = RequestMethod.GET)
	public ModelAndView karislamaMetodu() {

		String adi = "Omer";
		String soyadi = "Metin";
		
		ModelAndView modelAndView = new ModelAndView("AnasayfaView");
		
		modelAndView.addObject("mesaj","PERSONEL BILGISI");

		modelAndView.addObject("parametreAdi",adi);
		modelAndView.addObject("parametreSoyadi",soyadi);
		
		return modelAndView;
	}
	
	
	
	
	
}
