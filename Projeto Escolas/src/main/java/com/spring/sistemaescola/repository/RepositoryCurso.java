package com.spring.sistemaescola.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.sistemaescola.models.Curso;

public interface RepositoryCurso extends CrudRepository<Curso, String> {
	Curso findByidCurso (long idCurso);
	Curso deleteByidCurso (long idCurso);

}
