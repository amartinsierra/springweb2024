package entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="temas")

public class Tema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTema;
	private String tema;
	@OneToMany(mappedBy = "tema",cascade = CascadeType.REMOVE)
	private List<Libro> libros;
	
	public Tema(int idTema, String tema) {
		super();
		this.idTema = idTema;
		this.tema = tema;
	}
	public Tema() {
		super();
	}
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
}
