package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Tema;

public interface TemasDao extends JpaRepository<Tema, Integer> {
	@Query("select t from Tema t join t.libros l where l.titulo=?1")
	Tema findByTituloLibro(String titulo);
}
