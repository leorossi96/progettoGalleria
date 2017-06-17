package it.uniroma3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.Autore;

public interface AutoreRepository extends CrudRepository<Autore, Long> {
	
	List<Autore> findAll();

}
