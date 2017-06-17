package it.uniroma3.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.model.RuoliUtente;

@Repository
public interface RuoliUtenteRepository extends CrudRepository<RuoliUtente, Long> {

	@Query("SELECT a.role FROM UserRole a, User b WHERE b.userName=?1 and a.userid=b.userId")
	 List<String> findRoleByUsername(String username);
}