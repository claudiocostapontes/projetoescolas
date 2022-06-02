package com.spring.sistemaescola.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pauta implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cod_pauta", nullable=false)
	private long codigoPauta;
	@Column(name="cod_turma", nullable=false)
	private long codigoTurma;
	@Column(name="matricula_aluno", nullable=false)
	private long matriculaAluno;
	@Column(name="nota", nullable=true)
	private double nota;
	@Column(name="situacao", nullable=true, length=2)
	private String situacao;
	
	public Pauta() {
		// TODO Auto-generated constructor stub
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getCodigoTurma() {
		return codigoTurma;
	}

	public long getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setCodigoTurma(long codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	public void setMatriculaAluno(long matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	public long getCodigoPauta() {
		return codigoPauta;
	}

	public double getNota() {
		return nota;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setCodigoPauta(long codigoPauta) {
		this.codigoPauta = codigoPauta;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
