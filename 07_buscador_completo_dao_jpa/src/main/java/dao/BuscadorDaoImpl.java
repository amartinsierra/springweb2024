package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Resultado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class BuscadorDaoImpl implements BuscadorDao {
	@PersistenceContext
	EntityManager eManager;

	@Override
	public List<Resultado> findByTematica(String tematica) {
		String jpql="select r from Resultado r where r.tematica=?1";
		TypedQuery<Resultado> query=eManager.createQuery(jpql, Resultado.class);
		query.setParameter(1, tematica);
		return query.getResultList();
	}
	@Transactional
	@Override
	public void save(Resultado resultado) {
		eManager.persist(resultado);
	}

	@Override
	public Resultado findByUrl(String url) {
		String jpql="select r from Resultado r where r.url=:url";
		TypedQuery<Resultado> query= eManager.createQuery(jpql, Resultado.class);
		query.setParameter("url", url);
		return query.getResultList().stream()
				.findFirst()
				.orElse(null);
	}
	@Transactional
	@Override
	public void deleteByUrl(String url) {
		String jpql="delete from Resultado r where r.url=?1";
		Query query=eManager.createQuery(jpql);
		query.setParameter(1, url);
		query.executeUpdate();
	}

}
