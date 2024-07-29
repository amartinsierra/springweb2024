package utilidades;

import org.springframework.stereotype.Component;

import entities.Alumno;
import entities.Curso;
import model.AlumnoDto;
import model.CursoDto;

@Component
public class Mapeador {
	public CursoDto cursoEntityToDto(Curso curso) {
		return new CursoDto(curso.getIdCurso(),
				curso.getNombre(),
				curso.getDuracion(),
				curso.getFechaInicio(),
				curso.getPrecio(),
				curso.getMatriculas().stream()
				.map(m->alumnoEntityToDto(m.getAlumno()))
				.toList());
	}
	public AlumnoDto alumnoEntityToDto(Alumno alumno) {
		return new AlumnoDto(alumno.getUsuario(),
				alumno.getPassword(),
				alumno.getNombre(),
				alumno.getEmail(),
				alumno.getEdad());
	}
	public Curso cursoDtoToEntity(CursoDto curso) {
		return new Curso(0,
				curso.getNombre(),
				curso.getDuracion(),
				curso.getFechaInicio(),
				curso.getPrecio());
	}
}
