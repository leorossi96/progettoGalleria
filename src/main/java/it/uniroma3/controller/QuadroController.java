//package it.uniroma3.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import it.uniroma3.model.Quadro;
//import it.uniroma3.service.QuadroService;
//
//@Controller
//public class QuadroController {
//	
//	
//	@Autowired
//	QuadroService service;
//	
//	@GetMapping(value="/quadri")
//	public String paginaLista(Model model){
//		List<Quadro> quadri = service.getQuadri();
//		model.addAttribute("quadri",quadri);
//		return "quadri";
//	}
//	
//	
//
//}
