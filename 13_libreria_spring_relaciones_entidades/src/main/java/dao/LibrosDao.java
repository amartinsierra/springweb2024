package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Libro;

public interface LibrosDao extends JpaRepository<Libro, Integer> {
	@Query("select l from Libro l where l.tema.idTema=?1")
	List<Libro> findByIdTema(int idTema);
	
	List<Libro> findByPrecioBetween(double pMin, double pMax);
	@Query("select l from Libro l where l.tema.tema=?1")
	List<Libro> findByNombreTema(String tema);
}
