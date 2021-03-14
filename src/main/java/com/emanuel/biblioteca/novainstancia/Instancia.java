package com.emanuel.biblioteca.novainstancia;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import com.emanuel.biblioteca.novolivro.Livro;

@Entity
public class Instancia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Tipo tipo;
	@NotNull
	@Valid
	@ManyToOne
	private Livro livro;
	
	public Instancia() {}

	public Instancia(@NotNull Tipo tipo, Livro livro) {
		this.tipo = tipo;
		this.livro = livro;
	}
	
	public Long getId() {
		Assert.state(Objects.nonNull(id),"O id está nulo. Chamou o persist?");
		return id;
	}
	
	public boolean verificaTipo(Tipo tipo) {
		return this.tipo.equals(tipo);
	}
}
