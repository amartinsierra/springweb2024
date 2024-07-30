package entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="matriculas")
public class Matricula {
	@EmbeddedId
	private MatriculaPk pk;
	private double nota;
	
	
	@ManyToOne
	@JoinColumn(name="usuario",referencedColumnName = "usuario",updatable = false,insertable = false)
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name="idCurso",referencedColumnName = "idCurso",updatable = false,insertable = false)
	private Curso curso;
	
	
	public Matricula(MatriculaPk pk, double nota, Alumno alumno, Curso curso) {
		this.pk = pk;
		this.nota = nota;
		this.alumno = alumno;
		this.curso = curso;
	}
	public Matricula() {
	}
	public MatriculaPk getPk() {
		return pk;
	}
	public void setPk(MatriculaPk pk) {
		this.pk = pk;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
