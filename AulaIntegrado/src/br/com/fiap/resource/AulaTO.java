package br.com.fiap.resource;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="TB_AULA")
@SequenceGenerator(name="aula", sequenceName="SQ_TB_AULA" ,allocationSize=1)

public class AulaTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="aula",strategy=GenerationType.SEQUENCE)
	@Column
	private int codigo;
	
	@Column
	private String materia;
	
	@Column
	private String professor;
	
	@Column
	private String sala;
	
	@Column
	private String quantidade;
	
	
	public AulaTO() {
		super();
	}



	public AulaTO(String materia, String professor, String sala, String quantidade) {
		super();
		this.materia = materia;
		this.professor = professor;
		this.sala = sala;
		this.quantidade = quantidade;
	}
	
	
	
	public String getMateria() {
		return materia;
	}




	public void setMateria(String materia) {
		this.materia = materia;
	}




	public String getProfessor() {
		return professor;
	}




	public void setProfessor(String professor) {
		this.professor = professor;
	}




	public String getSala() {
		return sala;
	}




	public void setSala(String sala) {
		this.sala = sala;
	}




	public String getQuantidade() {
		return quantidade;
	}




	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}




	
	
}
