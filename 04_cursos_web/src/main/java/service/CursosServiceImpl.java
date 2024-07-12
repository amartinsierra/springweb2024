package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Curso;
@Service
public class CursosServiceImpl implements CursosService{
	//para que el arraylist no se pierda y todas las intancias
	//lo compartan
	private static ArrayList<Curso> cursos=new ArrayList<>();
	
	//modificar este método para que añada el curso si no hay otro
	//con el mismo nombre, si ya existe no se añade y se devuelve false
	@Override
	public boolean nuevo(Curso curso) {		
		if(cursos.stream().anyMatch(c->c.getNombre().equals(curso.getNombre()))) {
			return false;
		}
		cursos.add(curso);
		return true;
		
	}
	
	@Override
	public List<Curso> preciosCursoMax(double precioMax){		
		return cursos.stream()
				.filter(c->c.getPrecio()<precioMax)
				.toList();
	}
	
	@Override
	public void eliminarCurso(String nombre) {		
		cursos.removeIf(c->c.getNombre().equals(nombre));
		
	}
	
	
}
