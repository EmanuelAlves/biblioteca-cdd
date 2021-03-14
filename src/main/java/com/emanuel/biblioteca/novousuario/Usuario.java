package com.emanuel.biblioteca.novousuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotNull TipoUsuario tipo;
	
	public Usuario() {}

	public Usuario(@NotNull TipoUsuario tipo) {
		this.tipo = tipo;
	}
	
	public Long getId() {
		Assert.state(id != null, "O id não pode ser null." );
		return id;
	}

	public boolean padrao() {
		return this.tipo.equals(TipoUsuario.PADRAO);
	}
}
