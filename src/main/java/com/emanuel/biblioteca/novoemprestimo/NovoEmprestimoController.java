package com.emanuel.biblioteca.novoemprestimo;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovoEmprestimoController {
	
	@Autowired
	private EntityManager manager;
	
	@Autowired
	private VerificacaoEmprestimoValidator verificacaoEmprestimoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(verificacaoEmprestimoValidator);
	}

	@PostMapping(value = "/api/emprestimos")
	public Long execute(@RequestBody @Valid NovoEmprestimoRequest request) {
		return 1L;
	}
}
