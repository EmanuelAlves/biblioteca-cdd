package com.emanuel.biblioteca.novoemprestimo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

public class NovoEmprestimoRequest {

	@NotNull
	@Positive
	private Long idUsuario;
	@NotNull
	@Positive
	private Long idLivro;
	@Range(min = 1, max = 60)
	private Integer tempo;
	
	public NovoEmprestimoRequest(@NotNull Long idUsuario, @NotNull Long idLivro) {
		super();
		this.idUsuario = idUsuario;
		this.idLivro = idLivro;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public Long getIdLivro() {
		return idLivro;
	}	
	
}
