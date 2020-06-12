package com.generation.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_LIVRO")
public class Livro {

	@Id
	@Column(name = "cd_isbn", nullable = false)
	private long isbn;
	
	@Column(name = "nm_titulo", nullable = false, length = 100)
	private String titulo;
	
	@Column(name = "nm_autor", nullable = false, length = 30)
	private String autor;
	
	@Column(name = "aa_edicao", nullable = false)
	private int ano;
	
	@Column(name = "nm_editora", nullable = false, length = 50)
	private String editora;
	
	@Column(name = "nm_genero", nullable = false, length = 15)
	private String genero;
	
	

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}
	
	@Size(min = 2, max = 100)
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
