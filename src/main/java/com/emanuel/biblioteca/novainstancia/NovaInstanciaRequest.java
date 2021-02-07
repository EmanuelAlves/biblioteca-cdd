package com.emanuel.biblioteca.novainstancia;

import javax.validation.constraints.NotNull;

import com.emanuel.biblioteca.novolivro.Livro;

public class NovaInstanciaRequest {
	
	@NotNull
	private Tipo tipo;

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Instancia toModel(Livro livro) {
		return new Instancia(tipo, livro);
	}

}
