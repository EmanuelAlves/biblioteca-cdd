package com.emanuel.biblioteca.novoemprestimo;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.emanuel.biblioteca.novolivro.Livro;
import com.emanuel.biblioteca.novousuario.Usuario;

@Component
public class VerificacaoEmprestimoValidator implements Validator {
	
	private EntityManager manager;
	
	public VerificacaoEmprestimoValidator(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoEmprestimoRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		NovoEmprestimoRequest request = (NovoEmprestimoRequest) target;
		Usuario usuario = manager.find(Usuario.class,  request.getIdUsuario());
		Livro livro = manager.find(Livro.class, request.getIdLivro());
		
		Assert.state(usuario != null, "O usuário deve ser diferente de null");
		Assert.state(livro != null, "O livro deve ser diferente de null");
		
		if (!livro.aceitaSerEmprestado(usuario)) {
			errors.reject(null, "Este usuário não pode pegar este livro");
		}
		
	}

}
