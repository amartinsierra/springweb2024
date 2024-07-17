package dao;

import java.util.List;

import entities.Curso;

public interface CursosDao {
	void save(Curso curso);
	List<Curso> findByPrecioMax(double precio);
	void deleteByNombre(String nombre);
	Curso findByNombre(String nombre);
	
}
