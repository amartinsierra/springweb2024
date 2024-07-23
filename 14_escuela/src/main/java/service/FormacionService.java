package service;

import java.util.List;

import model.AlumnoDto;
import model.CursoDto;

public interface FormacionService {
	List<CursoDto> cursos();
	List<AlumnoDto> buscarAlumnosMatriculados(int idCurso);
}
