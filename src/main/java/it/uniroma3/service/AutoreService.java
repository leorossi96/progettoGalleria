package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Autore;
import it.uniroma3.repository.AutoreRepository;

@Service
@Transactional
public class AutoreService {


	@Autowired
	private AutoreRepository repository;

	public AutoreService() {
		
	}
	
	public void inserisciAutore(Autore autore) {
		repository.save(autore);
	}

	public Autore getOneAutore(Long id){
		return repository.findOne(id);
	}
	public List<Autore> getAutori() {
		List<Autore> autori = repository.findAll();
		return autori;
	}
}