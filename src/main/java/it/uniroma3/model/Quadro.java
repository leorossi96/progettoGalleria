package it.uniroma3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Quadro{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty // corrisponde a @size(min=1) @NotBlank fa il trim e se vuota false
	private String titolo;
	@NotNull
	private String anno;
	@NotNull
	private String tecnica;
	@NotNull
	private String dimensione;
	@NotBlank
	@ManyToOne
	private Autore autore;
	
	protected Quadro(){}
	public Quadro(String titolo, String anno, String tecnica, String dimensione, Autore autore){
		this.titolo=titolo;
		this.anno=anno;
		this.tecnica=tecnica;
		this.dimensione=dimensione;
		this.autore=autore;
	}
	
	//getter e setter
	
	public Long getId() {
		return id;
	}

	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	public String getTecnica() {
		return tecnica;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	public String getDimensione() {
		return dimensione;
	}
	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}
	
}