package utilidades;

import org.springframework.stereotype.Component;

import entities.Curso;
import model.CursoDto;
@Component
public class Mapeador {
	
	public CursoDto cursoEntityToDto(Curso curso) {
		return new CursoDto(curso.getCodCurso(),curso.getNombre(),curso.getTematica(),curso.getDuracion(),curso.getPrecio());
	}
	
	public Curso cursoDtoToEntity(CursoDto curso) {
		return new Curso(curso.getCodCurso(),curso.getNombre(),curso.getTematica(),curso.getDuracion(),curso.getPrecio());
	}
}
