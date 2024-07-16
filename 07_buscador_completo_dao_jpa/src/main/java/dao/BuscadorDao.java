package dao;

import java.util.List;

import entities.Resultado;

public interface BuscadorDao {
	List<Resultado> findByTematica(String tematica);
	void save(Resultado resultado);
	Resultado findByUrl(String url);
	void deleteByUrl(String url);
}
