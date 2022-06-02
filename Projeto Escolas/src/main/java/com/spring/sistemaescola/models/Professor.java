package com.spring.sistemaescola.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="matricula_professor")
	private long matriculaProfessor;
	@Column(name="nome_professor", nullable=false, length=40)
	private String nomeProfessor;
	@Column(name="sobrenome_professor", nullable=false, length=40)
	private String sobrenomeProfessor;
	@Column(name="rg_professor", nullable=false, length=15)
	private String rgProfessor;
	@Column(name="cpf_professor", nullable=false, length=14)
	private String cpfProfessor;
	@Column(name="email_professor", nullable=false, length=50)
	private String emailProfessor;
	@Column(name="genero_professor", nullable=false, length=1)
	private String generoProfessor;
	@Column(name="melhor_numero", nullable=true, length=14)
	private String melhorNumero;
	
	public Professor() {
		// TODO Auto-generated constructor stub
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getGeneroProfessor() {
		switch (generoProfessor) {
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

	public void setGeneroProfessor(String generoProfessor) {
		this.generoProfessor = generoProfessor;
	}

	public long getMatriculaProfessor() {
		return matriculaProfessor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public String getSobrenomeProfessor() {
		return sobrenomeProfessor;
	}

	public String getRgProfessor() {
		return rgProfessor;
	}

	public String getCpfProfessor() {
		return cpfProfessor;
	}

	public String getEmailProfessor() {
		return emailProfessor;
	}

	public void setMatriculaProfessor(long matriculaProfessor) {
		this.matriculaProfessor = matriculaProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public void setSobrenomeProfessor(String sobrenomeProfessor) {
		this.sobrenomeProfessor = sobrenomeProfessor;
	}

	public void setRgProfessor(String rgProfessor) {
		this.rgProfessor = rgProfessor;
	}

	public void setCpfProfessor(String cpfProfessor) {
		this.cpfProfessor = cpfProfessor;
	}

	public void setEmailProfessor(String emailProfessor) {
		this.emailProfessor = emailProfessor;
	}

	public String getMelhorNumero() {
		return melhorNumero;
	}

	public void setMelhorNumero(String melhorNumero) {
		this.melhorNumero = melhorNumero;
	}	
}
