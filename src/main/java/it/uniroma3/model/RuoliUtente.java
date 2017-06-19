package it.uniroma3.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class RuoliUtente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Utente utente;
	@NotBlank
	private String ruolo;
	private String username;
	
	public RuoliUtente(){
		
	}
	
	public RuoliUtente(String ruolo, Utente utente){
		this.ruolo = ruolo;
		this.utente = utente;
		this.username = utente.getUsername();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public String getRuoli() {
		return ruolo;
	}
	public void setRuoli(String ruoli) {
		this.ruolo = ruoli;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
