package com.emanuel.biblioteca.novolivro;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.ISBN.Type;

import com.emanuel.biblioteca.util.UniqueValue;

public class NovoLivroRequest {
	
	@NotBlank
	private String titulo;
	@Positive
	private BigDecimal preco;
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	@ISBN(type = Type.ISBN_10)
	private String isbn;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Livro toModel() {
		return new Livro(titulo, preco, isbn);
	}
	

}
