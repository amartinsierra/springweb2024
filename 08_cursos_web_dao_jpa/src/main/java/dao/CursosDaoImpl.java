package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
@Repository
public class CursosDaoImpl implements CursosDao {
	
	@PersistenceContext
	EntityManager eManager;
	
	@Transactional
	@Override
	public void save(Curso curso) {
		eManager.persist(curso);

	}

	@Override
	public List<Curso> findByPrecioMax(double precio) {
		String jpql="select c from Curso c where c.precio<?1";
		TypedQuery<Curso> query=eManager.createQuery(jpql, Curso.class);
		query.setParameter(1, precio);
		return query.getResultList();
	}
	@Transactional
	@Override
	public void deleteByNombre(String nombre) {
		String jpql="delete from Curso c where c.nombre=?1";
		Query query=eManager.createQuery(jpql);
		query.setParameter(1, nombre);
		query.executeUpdate();

	}

	@Override
	public Curso findByNombre(String nombre) {		
		String jpql="select c from Curso c where c.nombre=?1";
		TypedQuery<Curso> query=eManager.createQuery(jpql,Curso.class);
		query.setParameter(1, nombre);
		try {
			return query.getSingleResult();
		}catch(NoResultException ex) {
			return null;
		}
	}

	

}
