package it.uniroma3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.model.Utente;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Long> {
	public Utente findByUsername(String username);
}