package it.uniroma3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.service.QuadroService;


	@Controller
	public class MainController{

		
		@RequestMapping(value = "/")
		public String index(){
			return "index";
		}
		
		@RequestMapping(value = "/login")
		public String login(){
			return "login";
		}
	}