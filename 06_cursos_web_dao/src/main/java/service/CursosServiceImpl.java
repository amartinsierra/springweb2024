package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CursosDao;
import model.Curso;
@Service
public class CursosServiceImpl implements CursosService{
	
	CursosDao cursosDao;
	public CursosServiceImpl(CursosDao cursosDao) {
		this.cursosDao = cursosDao;
	}

	@Override
	public boolean nuevo(Curso curso) {		
		if(cursosDao.findByNombre(curso.getNombre())==null) {
			cursosDao.save(curso);
			return true;
		}
		return false;
		
	}
	
	@Override
	public List<Curso> preciosCursoMax(double precioMax){		
		return cursosDao.findByPrecioMax(precioMax);
	}
	
	@Override
	public void eliminarCurso(String nombre) {		
		cursosDao.deleteByNombre(nombre);
		
	}
	
	
}
