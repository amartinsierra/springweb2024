package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import entities.Curso;

public interface CursosDao extends JpaRepository<Curso,Integer>{
	@Query("select c from Curso c where c.precio<=?1")
	List<Curso> findByPrecioMax(double precio);
	
	@Transactional
	@Modifying
	void deleteByNombre(String nombre);
	Curso findByNombre(String nombre);
	
}
