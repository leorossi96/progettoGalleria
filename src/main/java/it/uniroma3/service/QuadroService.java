package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Autore;
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
	
	public void modificaQuadro(Long id, String titolo, Integer anno, Autore autore, String dimensione, String tecnica){
		Quadro q = this.getOneQuadro(id);
//		this.delete(q);
		q.setTitolo(titolo);
		q.setAnno(anno);
		q.setAutore(autore);
		q.setDimensione(dimensione);
		q.setTecnica(tecnica);
		repository.save(q);
	}

	public List<Quadro> getQuadri() {
		List<Quadro> quadri = repository.findAll();
		return quadri;
	}
	
	public Quadro getOneQuadro(Long id) {
		Quadro quadro = repository.findOne(id);
		return quadro;
	}

	public void delete(Quadro q){
		repository.delete(q);
	}
	
	public List<Quadro> getQuadriByAutore(Autore autore){
		List<Quadro> quadri = repository.findByAutore(autore);
		return quadri;
	}
	
	public Quadro getQuadroByTitolo(String titolo){
		Quadro quadro = repository.findByTitolo(titolo);
		return quadro;
	}
	
	public List<Quadro> getQuadroByTecnica(String tecnica){
		List<Quadro> quadri = repository.findByTecnica(tecnica);
		return quadri;
	}
	
	public List<Quadro> getQuadroByAnno(Integer anno){
		List<Quadro> quadri = repository.findByAnno(anno);
		return quadri;
	}
}