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
import it.uniroma3.service.QuadroService;
import it.uniroma3.service.AutoreService;

@Controller
public class QuadroController {
	
	
	@Autowired
	QuadroService quadroService;
	
	@Autowired
	AutoreService autoreService;
	
	//aggiungo al model il parametro quadri con i quadri presenti nel db e vado alla pagina /quadri
	@GetMapping(value="/quadri")
	public String listaQuadri(Model model){
		List<Quadro> quadri = quadroService.getQuadri();
		model.addAttribute("quadri",quadri);
		return "quadri";
	}
	
	//indirizzo alla pagina con la form di inserimento del quadro
	@GetMapping(value="/inserimentoQuadro")
	public String formInserimento(Quadro quadro, Model model){
		List<Autore> autori = autoreService.getAutori();
		model.addAttribute("autori", autori);
		return "formQuadro";
	}
	
	//Aggiungo il quadro nel db e ritorno alla pagina della descrizione
	@PostMapping(value="/inserimentoQuadro")
	public String inserisciQuadroDellaForm(@Valid @ModelAttribute Quadro quadro, BindingResult bindingResult,Model model){
		if (bindingResult.hasErrors()) {
            return "form";
        }
		else{
			model.addAttribute(quadro);
			quadroService.inserisciQuadro(quadro);
		}
		return "quadri";
	}


}
