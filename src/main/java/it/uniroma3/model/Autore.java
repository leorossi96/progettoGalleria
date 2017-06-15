package it.uniroma3.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Autore{
	
	

@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)  // Indicates that the persistence provider must assign primary keys for the entity using database identity column.
private Long id;

@NotNull
private String firstName;

@NotNull
private String lastName;

@NotNull
private String nazionalità;

@NotNull
@DateTimeFormat(pattern = "dd/MM/yyyy")
private Date dataNascita;

@NotNull
@DateTimeFormat(pattern = "dd/MM/yyyy")
private Date dataMorte;

protected Autore(){}

public Autore (String firstName, String lastName, String nazionalità, Date dataNascita, Date dataMorte){
	this.firstName=firstName;
	this.lastName=lastName;
	this.nazionalità=nazionalità;
	this.dataNascita=dataNascita;
	this.dataMorte=dataMorte;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getNazionalità() {
	return nazionalità;
}

public void setNazionalità(String nazionalità) {
	this.nazionalità = nazionalità;
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
