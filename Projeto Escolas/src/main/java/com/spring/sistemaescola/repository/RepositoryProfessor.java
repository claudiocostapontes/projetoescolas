package com.spring.sistemaescola.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.sistemaescola.models.Professor;

public interface RepositoryProfessor extends CrudRepository<Professor, String> {
	Professor findBymatriculaProfessor(long matriculaProfessor);
	Professor deleteBymatriculaProfessor(long matriculaProfessor);	
}
