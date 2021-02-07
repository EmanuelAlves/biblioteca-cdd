package com.emanuel.biblioteca.novainstancia;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.emanuel.biblioteca.novolivro.Livro;

@Repository
public interface LivroRepository extends org.springframework.data.repository.Repository<Livro, Long> {

	Optional<Livro> findByIsbn(String isbn);
}
