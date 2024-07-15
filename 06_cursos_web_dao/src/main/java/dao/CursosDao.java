package dao;

import java.util.List;

import model.Curso;

public interface CursosDao {
	void save(Curso curso);
	List<Curso> findByPrecioMax(double precio);
	void deleteByNombre(String nombre);
	Curso findByNombre(String nombre);
	double averageByTematica(String tematica);
}
