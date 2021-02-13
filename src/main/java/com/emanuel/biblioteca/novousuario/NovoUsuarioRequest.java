package com.emanuel.biblioteca.novousuario;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

public class NovoUsuarioRequest {
	
	@NotNull
	private TipoUsuario tipo;

	@JsonCreator(mode = Mode.PROPERTIES)
	public NovoUsuarioRequest(@NotNull TipoUsuario tipo) {
		super();
		this.setTipo(tipo);
	}
	
	
	public Usuario toModel() {
		return new Usuario(getTipo());
	}


	public TipoUsuario getTipo() {
		return tipo;
	}


	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}
	
}
