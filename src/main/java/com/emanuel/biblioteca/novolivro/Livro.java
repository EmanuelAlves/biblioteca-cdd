package com.emanuel.biblioteca.novolivro;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.ISBN.Type;

import com.emanuel.biblioteca.novainstancia.Instancia;
import com.emanuel.biblioteca.novainstancia.Tipo;
import com.emanuel.biblioteca.novousuario.Usuario;


@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank 
	private String titulo;
	
	@Positive 
	private BigDecimal preco;
	
	@Column(unique = true)
	@NotBlank
	@ISBN(type = Type.ISBN_10) 
	private String isbn;
	
	@OneToMany(mappedBy = "livro")
	private List<Instancia> lstInstancias = new ArrayList<Instancia>();
	
	@Deprecated
	public Livro() {}

	public Livro(@NotBlank String titulo, @Positive BigDecimal preco, @ISBN(type = Type.ISBN_10) String isbn) {
		this.titulo = titulo;
		this.preco = preco;
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
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

	public boolean aceitaSerEmprestado(Usuario usuario) {
		boolean podeSerEmprestatoParaQualquerPessoa = lstInstancias.stream().anyMatch(Instancia -> Instancia.verificaTipo(Tipo.LIVRE));
				
		if (podeSerEmprestatoParaQualquerPessoa) {
			return true;
		}
				
		if (usuario.padrao()) {
			return false;
		}		
		
		return lstInstancias.stream().anyMatch(Instancia -> Instancia.verificaTipo(Tipo.RESTRITO));
	}

}
