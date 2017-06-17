package it.uniroma3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.model.Autore;
import it.uniroma3.model.Quadro;
import it.uniroma3.service.AutoreService;
import it.uniroma3.service.QuadroService;

@Controller
public class AutoreController {

	@Autowired
	QuadroService quadroService;

	@Autowired
	AutoreService autoreService;

	//indirizzo alla pagina con la form di inserimento dell'autore
	@GetMapping(value="/inserimentoAutore")
	public String formInserimento(Autore autore){
		return "formAutore";
	}

	//Aggiungo l'autore nel db e ritorno alla pagina della descrizione
	@PostMapping(value="/inserimentoAutore")
	public String inserisciQuadroDellaForm(@Valid @ModelAttribute Autore autore, BindingResult bindingResult,Model model){
		if (bindingResult.hasErrors()) {
			return "formAutore";
		}
		else{
			model.addAttribute(autore);
			autoreService.inserisciAutore(autore);
		}
		return "formQuadro";
	}


}
