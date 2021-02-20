package com.emanuel.biblioteca.novoemprestimo;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovoEmprestimoController {

	@PostMapping(value = "/api/emprestimos")
	public Long execute(@RequestBody @Valid NovoEmprestimoRequest request) {
		return 1L;
	}
}
