package com.spring.sistemaescola.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="matricula_aluno")
	private long matriculaAluno;
	@Column(name="nome_aluno", nullable=false, length=40)
	private String nomeAluno;
	@Column(name="sobrenome_aluno", nullable=false, length=40)
	private String sobrenomeAluno;
	@Column(name="rg_aluno", nullable=false, length=15)
	private String rgAluno;
	@Column(name="cpf_aluno", nullable=false, length=14)
	private String cpfAluno;
	@Column(name="email_aluno", nullable=false, length=50)
	private String emailAluno;
	@Column(name="genero_aluno", nullable=false, length=1)
	private String generoAluno;
	@Column(name="responsavel_aluno", nullable=true, length=100)
	private String responsavelAluno;
	@Column(name="melhor_numero", nullable=true, length=14)
	private String melhorNumero;
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getGeneroAluno() {
		switch (generoAluno) {
			case "M":
				return "Masculino";
			case "F":
				return "Feminino";
			case "O":
				return "Outro";
			default:
				return "-";
		}
	}

	public void setGeneroAluno(String generoAluno) {
		this.generoAluno = generoAluno;
	}

	public long getMatriculaAluno() {
		return matriculaAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public String getSobrenomeAluno() {
		return sobrenomeAluno;
	}

	public String getRgAluno() {
		return rgAluno;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public String getResponsavelAluno() {
		return responsavelAluno;
	}

	public void setMatriculaAluno(long matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public void setSobrenomeAluno(String sobrenomeAluno) {
		this.sobrenomeAluno = sobrenomeAluno;
	}

	public void setRgAluno(String rgAluno) {
		this.rgAluno = rgAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}

	public void setResponsavelAluno(String responsavelAluno) {
		this.responsavelAluno = responsavelAluno;
	}

	public String getMelhorNumero() {
		return melhorNumero;
	}

	public void setMelhorNumero(String melhorNumero) {
		this.melhorNumero = melhorNumero;
	}

}
