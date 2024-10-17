package br.com.fuctura2.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries(@NamedQuery(name = "Livro.consultarPoTitulo", query = "select l from Livro l where l.titulo =:titulo"))
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String genero;
	private String editora;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Escritor escritor;

	public Livro() {
		super();
	}

	public Livro(Integer id, String titulo, String genero, String editora, Escritor escritor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.editora = editora;
		this.escritor = escritor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Escritor getEscritor() {
		return escritor;
	}

	public void setEscritor(Escritor escritor) {
		this.escritor = escritor;
	}

	@Override
	public String toString() {
		return "\n--------------------------------------" +
			   "\nTítulo do livro:       " + this.titulo  +
			   "\nGênero do livro:       " + this.genero  +
			   "\nEditora:               " + this.editora +
			   "\nNome do escritor:      " + this.escritor.getNome() +
			   "\n---------------------------------------";
	}
	
	
	
}
