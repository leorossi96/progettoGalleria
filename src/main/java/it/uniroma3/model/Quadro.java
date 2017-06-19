package it.uniroma3.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import it.uniroma3.model.Autore;

@Entity
public class Quadro{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="quadro_id")
	private Long id;
	
	
	@NotNull
	@NotEmpty
	
	private String titolo;
	
	@NotNull
	@Max(value = 2017)
	private Integer anno;
	
	
	@NotNull
	@NotEmpty
	private String tecnica;
	
	@NotEmpty
	private String dimensione;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Autore autore;
	
	
	protected Quadro(){}
	public Quadro(String titolo, Integer anno, String tecnica, String dimensione, Autore autore){
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
	public Integer getAnno() {
		return anno;
	}
	public void setAnno(Integer anno) {
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