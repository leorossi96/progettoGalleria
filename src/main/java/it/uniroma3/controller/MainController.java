package it.uniroma3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.service.QuadroService;


	@Controller
	public class MainController{

		@Autowired
		private QuadroService quadroService; 
	
		@RequestMapping(value = "/")//tutte le richieste http che hanno url="/" sono mappate verso il metodo index()
		public String index(){
			return "index";
		}
		
		@RequestMapping(value = "/enter")
		public String enter(){
			return "login";
		}
		@RequestMapping(value="/login")
		public String login(){
			return "login";
		}
		
		// Login form with error
		@RequestMapping("/login-error.html")
		public String loginError(Model model) {
			model.addAttribute("loginError", true);
			return "login";
		}
		
		
		
//		@Autowired
//		private QuadroService quadroService;
//		
//		@GetMapping(value="/quadri")
//		public String showForm(Model model){
//			List<Quadro> quadri = (List<Quadro>) quadroService.findAll(); 
//			model.addAttribute("quadri",quadri);
//			return "quadri";
//		}
	}