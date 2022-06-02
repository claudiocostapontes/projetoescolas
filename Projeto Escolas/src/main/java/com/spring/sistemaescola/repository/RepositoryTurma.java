package com.spring.sistemaescola.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.sistemaescola.models.Turma;

public interface RepositoryTurma extends CrudRepository<Turma, String> {
	Turma findBycodigoTurma (long codigoTurma);
	Turma deleteBycodigoTurma (long codigoTurma);
}

