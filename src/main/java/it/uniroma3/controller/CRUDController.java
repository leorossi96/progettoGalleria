package it.uniroma3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.model.Autore;
import it.uniroma3.model.Quadro;
import it.uniroma3.service.QuadroService;
import it.uniroma3.service.AutoreService;

@Controller
public class CRUDController {


	@Autowired
	QuadroService quadroService;

	@Autowired
	AutoreService autoreService;

	//aggiungo al model il parametro quadri con i quadri presenti nel db e vado alla pagina /quadri
	@GetMapping(value="/quadri")
	public String listaQuadri(Model model){
		List<Autore> autori = autoreService.getAutori();
		List<Quadro> quadri = quadroService.getQuadri();
		model.addAttribute("autori",autori);
		model.addAttribute("quadri",quadri);
		return "quadri";
	}

	//indirizzo alla pagina con la form di inserimento del quadro
	@GetMapping(value="/inserimentoQuadro")
	public String formInserimento(Quadro quadro,Model model){
		model.addAttribute("quadro", quadro);
		List<Autore> autori = autoreService.getAutori();
		model.addAttribute("autori", autori);
		return "formQuadro";
	}

	//Aggiungo il quadro nel db e ritorno alla pagina della descrizione
	@PostMapping(value="/inserimentoQuadro")
	public String inserisciQuadroDellaForm(@Valid @ModelAttribute Quadro quadro, BindingResult bindingResult,Model model, @RequestParam(value="autore", required=false) Long autoreId){
		if (bindingResult.hasErrors() ) {

			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors ) {
				System.out.println (error.getObjectName() + " - " + error.getRejectedValue()+ " - " + error.getDefaultMessage());
			}
			List<Autore> autori = autoreService.getAutori();
			model.addAttribute("autori", autori);
			model.addAttribute("quadro", quadro);
			model.addAttribute("autore", autoreId);
			return "formQuadro";
		}
		else if (autoreService.getOneAutore(autoreId)!=null){
			quadro.setAutore(autoreService.getOneAutore(autoreId));
			model.addAttribute("quadro",quadro);
			quadroService.inserisciQuadro(quadro);
			model.addAttribute("quadri", quadroService.getQuadri());
			model.addAttribute("messaggio", "Quadro inserito con successo"); //DA MOSTRARE
			return "quadri";
		}
		else{
			model.addAttribute("autori",autoreService.getAutori());
			model.addAttribute("quadro", quadro);
			model.addAttribute("autore", autoreId);
			model.addAttribute("messaggio", "Seleziona un autore esistente o inseriscine uno nuovo"); // DA MOSTRARE
			return "formQuadro";
		}
			
		}
	
	@GetMapping(value="/quadriPerAutore")
	public String quadriPerAutore( Model model, @RequestParam(value="autoreScelto") Long autoreId){
		Autore autoreScelto = autoreService.getOneAutore(autoreId);
		List<Quadro> quadriPerAutore = quadroService.getQuadriByAutore(autoreScelto);
		model.addAttribute("quadri", quadriPerAutore);
		List<Autore> autori = autoreService.getAutori();
		model.addAttribute("autori", autori);
		return "quadri";
	}
	
	@GetMapping(value="/quadriPerTecnica")
	public String quadriPerTecnica( Model model, @RequestParam(value="tecnica") String tecnica){
		List<Quadro> quadriPerTecnica = quadroService.getQuadroByTecnica(tecnica);
		model.addAttribute("quadri", quadriPerTecnica);
		List<Autore> autori = autoreService.getAutori();
		model.addAttribute("autori", autori);
		return "quadri";
	}
	
	@GetMapping(value="/quadriPerAnno")
	public String quadriPerAnno( Model model, @RequestParam(value="anno") Integer anno){
		List<Quadro> quadriPerAnno = quadroService.getQuadroByAnno(anno);
		model.addAttribute("quadri", quadriPerAnno);
		List<Autore> autori = autoreService.getAutori();
		model.addAttribute("autori", autori);
		return "quadri";
	}




	//elimina un quadro dal db
	@RequestMapping(value="/cancella")
	public String eliminaQuadro(@RequestParam("quadroDaCancellare") Long quadroId){
		Quadro q = quadroService.getOneQuadro(quadroId);
		quadroService.delete(q);
		return "quadri";
	}

	
	@RequestMapping(value="/modifica", method = RequestMethod.GET)
	public String dettagliQuadro(@ModelAttribute("quadroDaModificare") Long quadroId, Model model){
		Quadro quadro = quadroService.getOneQuadro(quadroId);
		model.addAttribute("autori", autoreService.getAutori());
		model.addAttribute("quadro", quadro);
		return "/formQuadro";
	}

	//Form per modificare un quadro nel db
	@PostMapping(value="/modifica")
	public String modificaQuadro(@Valid @ModelAttribute Quadro quadroModificato, BindingResult bindingResult,Model model,@RequestParam("quadro") Long quadroId, @RequestParam("autoreScelto") Long autoreId){
		if (bindingResult.hasErrors()){
			return "quadri";
		}
		else{
			model.addAttribute("quadro", quadroModificato);
			Autore a = autoreService.getOneAutore(autoreId);
			quadroService.modificaQuadro(quadroId, quadroModificato.getTitolo(), quadroModificato.getAnno(), a, quadroModificato.getDimensione(), quadroModificato.getTecnica());
		}
		return "dettagliQuadro";
	}

	//Indirizzo alla pagina con la form di inserimento dell'autore
	@GetMapping(value="/inserimentoAutore")
	public String formInserimento(Autore autore){
		return "formAutore";
	}

	//Aggiungo l'autore nel db e ritorno alla pagina della descrizione
	@PostMapping(value="/inserimentoAutore")
	public String inserisciQuadroDellaForm(@Valid @ModelAttribute Autore autore, BindingResult bindingResult, Model model, Quadro quadro){
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors ) {
				System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
			}
			return "formAutore";
		}
		else{
			model.addAttribute(autore);
			model.addAttribute("quadro", quadro);
			model.addAttribute("messaggioNuovoAutore", "Quadro inserito con successo"); //DA MOSTRARE
			autoreService.inserisciAutore(autore);
			return formInserimento( quadro, model);
		}
		}

		@RequestMapping(value="/dettagliQuadro")
		public String dettagli(@RequestParam("id") Long quadroId, Model model){
			Quadro quadro = quadroService.getOneQuadro(quadroId);
			model.addAttribute("quadro", quadro);
			return "dettagliQuadro";
		}





	}
