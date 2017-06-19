package it.uniroma3.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Autore{
	
	

@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)  // Indicates that the persistence provider must assign primary keys for the entity using database identity column.
private Long id;

@NotNull
private String nome;

@NotNull
private String cognome;

@NotNull
private String nazionalita;

@NotNull
@DateTimeFormat(pattern = "dd/MM/yyyy")
private Date dataNascita;

@DateTimeFormat(pattern = "dd/MM/yyyy")
private Date dataMorte;

protected Autore(){}

public Autore (String firstName, String lastName, String nazionalita, Date dataNascita, Date dataMorte){
	this.nome=firstName;
	this.cognome=lastName;
	this.nazionalita=nazionalita;
	this.dataNascita=dataNascita;
	this.dataMorte=dataMorte;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCognome() {
	return cognome;
}

public void setCognome(String cognome) {
	this.cognome = cognome;
}

public String getNazionalita() {
	return nazionalita;
}

public void setNazionalita(String nazionalità) {
	this.nazionalita = nazionalità;
}

public Date getDataNascita() {
	return dataNascita;
}

public void setDataNascita(Date dataNascita) {
	this.dataNascita = dataNascita;
}

public Date getDataMorte() {
	return dataMorte;
}

public void setDataMorte(Date dataMorte) {
	this.dataMorte = dataMorte;
}

}
