package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Quadro;
import it.uniroma3.repository.QuadroRepository;


@Service
@Transactional
public class QuadroService {

	@Autowired
	private QuadroRepository repository;

	public QuadroService() {
		
	}
	
	public void inserisciQuadro(Quadro quadro) {
		repository.save(quadro);
	}
	
	public Quadro getOneQuadro(Long id) {
		Quadro quadro = repository.findOne(id);
		return quadro;
	}

	public List<Quadro> getQuadri() {
		return repository.findAll();
	}
	}