package model;

import java.time.LocalDate;
import java.util.List;

public class CursoDto {
	private int idCurso;
	private String nombre;
	private int duracion;
	private LocalDate fechaInicio;
	private double precio;
	private List<AlumnoDto> alumnos;
	public CursoDto(int idCurso, String nombre, int duracion, LocalDate fechaInicio, double precio,List<AlumnoDto> alumnos) {
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.fechaInicio = fechaInicio;
		this.precio = precio;
		this.alumnos=alumnos;
	}
	public CursoDto() {
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public List<AlumnoDto> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<AlumnoDto> alumnos) {
		this.alumnos = alumnos;
	}
	
}
