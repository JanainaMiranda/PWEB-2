package br.edu.ifal.website.modelo;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.ElementCollection;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

import br.edu.ifal.website.Enum.TipodeAluno;


@Entity
@DiscriminatorValue("A")
public class Aluno extends Pessoa {

	@Column
	private String matricula;

	@ManyToMany
	private List<Disciplina> disciplinas;
	
	@ElementCollection
	private List<String> telefones;

	@Column(name = "aluno_Enum", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipodeAluno tipoDeAluno = TipodeAluno.BOLSAASSISTENCIA;
	
	@Embedded
	private Endereco endereco;
	

	public Aluno(String matricula) {
		super();
		this.matricula = matricula;
	}

	public Aluno() {
		super();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (disciplinas == null) {
			if (other.disciplinas != null)
				return false;
		} else if (!disciplinas.equals(other.disciplinas))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", disciplinas=" + disciplinas + "]";
	}
	
	

}
