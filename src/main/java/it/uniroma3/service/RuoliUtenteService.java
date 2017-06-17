package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.RuoliUtente;
//import it.uniroma3.model.Utente;
import it.uniroma3.repository.RuoliUtenteRepository;

@Service
@Transactional
public class RuoliUtenteService {

	@Autowired
	private RuoliUtenteRepository repository;
	
	public RuoliUtenteService(){
		
	}
	
	public void inserisciRuoliUtente(RuoliUtente ru){
		repository.save(ru);
	}
	
//	public List<RuoliUtente> getRuoliUtenteByUtente(Utente utente){
//		List<String> ruoli = repository.findRoleByUtente(utente);
//		return ruoli;
//	}
	
	public List<String> getRuoliUtenteByUsername(String username){
		List<String> ruoli = repository.findRoleByUsername(username);
		return ruoli;
	}
}
