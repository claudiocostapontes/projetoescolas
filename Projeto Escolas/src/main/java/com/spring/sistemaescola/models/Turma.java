package com.spring.sistemaescola.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Turma implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cod_turma")
	private long codigoTurma;
	@Column(name="id_curso", nullable=false)
	private long idCurso;
	@Column(name="matricula_professor", nullable=false)
	private long matriculaProfessor;
	@Column(name="turno", nullable=true, length=1)
	private int turno;
	@Column(name="vagas", nullable=true, length=1)
	private int qtdVagas;
	
	public Turma() {
		// TODO Auto-generated constructor stub
	}


	public long getIdCurso() {
		return idCurso;
	}

	public long getMatriculaProfessor() {
		return matriculaProfessor;
	}

	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}

	public void setMatriculaProfessor(long matriculaProfessor) {
		this.matriculaProfessor = matriculaProfessor;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getCodigoTurma() {
		return codigoTurma;
	}

	

	public int getQtdVagas() {
		return qtdVagas;
	}

	public void setCodigoTurma(long codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	public void setQtdVagas(int qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

}
