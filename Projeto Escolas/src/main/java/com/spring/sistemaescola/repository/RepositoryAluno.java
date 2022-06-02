package com.spring.sistemaescola.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.sistemaescola.models.Aluno;


public interface RepositoryAluno extends CrudRepository<Aluno, String> {

	Aluno findBymatriculaAluno (long matriculaAluno);
	Aluno deleteBymatriculaAluno (long matriculaAluno);
	
}
