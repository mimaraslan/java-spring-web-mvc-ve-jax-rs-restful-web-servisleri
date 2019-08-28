package com.turkeyjug.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	

	// http://localhost:8085/006_SpringMvcRestful/gida/yazlik/55
	@RequestMapping(value = "/gida/yazlik/{birimFiyati}", method = RequestMethod.GET)
	public ModelAndView metod4(@PathVariable ("birimFiyati") String fiyati) {

		ModelAndView modelAndView = new ModelAndView("AnasayfaView");
		
		modelAndView.addObject("mesaj","FIYATI BILGISI");
		modelAndView.addObject("tutar",fiyati);
		
		return modelAndView;
	}
	
	
	

	// http://localhost:8085/006_SpringMvcRestful/detay/Burak/Ankara/burak12345@aaaa.com
	@RequestMapping(value = "/detay/{adiSoyadi}/{sehir}/{email}", method = RequestMethod.GET)
	public ModelAndView metod5(
			@PathVariable ("adiSoyadi") String adiSoyadi,
			@PathVariable ("sehir") String sehir,
			@PathVariable ("email") String email
			) {

		ModelAndView modelAndView = new ModelAndView("PersonelMerkez");
		
		modelAndView.addObject("mesaj","PERSONEL BILGISI");
		modelAndView.addObject("adiSoyadi",adiSoyadi);
		modelAndView.addObject("sehir",sehir);
		modelAndView.addObject("email",email);
		
		System.out.println("ModelAndView");
		
		return modelAndView;
	}	
	
	
	
	// http://localhost:8085/006_SpringMvcRestful/detay2/Burak/Ankara/burak12345@aaaa.com
	@RequestMapping(value = "/detay2/{adiSoyadi}/{sehir}/{email}", method = RequestMethod.GET)
	public String metod6(
			@PathVariable ("adiSoyadi") String adiSoyadi,
			@PathVariable ("sehir") String sehir,
			@PathVariable ("email") String email, Model model
			) {
		
		model.addAttribute("mesaj","PERSONEL BILGISI");
		model.addAttribute("adiSoyadi",adiSoyadi);
		model.addAttribute("sehir",sehir);
		model.addAttribute("email",email);
		
		System.out.println("Model");
		
		return "PersonelMerkez";
	}
	
}







