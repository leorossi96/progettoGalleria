package it.uniroma3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Utente;
import it.uniroma3.repository.UtenteRepository;

@Service
public class UtenteService{


	@Autowired
	private UtenteRepository repository;

	public UtenteService() {
		
	}
	

	public Utente getUtenteByUsername(String username){
		Utente utente = repository.findByUsername(username);
		return utente;
	}
}