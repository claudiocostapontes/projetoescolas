package com.spring.sistemaescola.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.sistemaescola.models.Pauta;


public interface RepositoryPauta extends CrudRepository<Pauta, String> {
	Pauta findBycodigoPauta (long codigoPauta);
	Pauta deleteBycodigoPauta (long codigoPauta);
}
