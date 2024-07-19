package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import entities.Resultado;

public interface BuscadorDao extends JpaRepository<Resultado,Integer>{
	List<Resultado> findByTematica(String tematica);
	
	@Query("select r from Resultado r where trim(r.url)=?1")
	Resultado findByUrl(String url);
	@Transactional
	@Modifying
	void deleteByUrl(String url);
}
