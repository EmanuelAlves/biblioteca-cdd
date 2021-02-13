package com.emanuel.biblioteca.novousuario;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovoUsuarioController {

	@Autowired
	private EntityManager manager;
	
	@Transactional
	@PostMapping(value = "usuarios")
	public Long execute(@RequestBody @Valid NovoUsuarioRequest request) {
		Usuario novo = request.toModel();
		manager.persist(novo);
		
		return novo.getId();
	}
}
