package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AlumnosDao;
import dao.CursosDao;
import dao.MatriculasDao;
import model.AlumnoMatriculadoDto;
import model.CursoDto;
import utilidades.Mapeador;
@Service
public class FormacionServiceImpl implements FormacionService {
	
	CursosDao cursosDao;
	AlumnosDao alumnosDao;
	Mapeador mapeador;	
	MatriculasDao matriculasDao;
	public FormacionServiceImpl(CursosDao cursosDao, AlumnosDao alumnosDao, MatriculasDao matriculasDao, Mapeador mapeador) {
		this.cursosDao = cursosDao;
		this.alumnosDao = alumnosDao;
		this.matriculasDao=matriculasDao;
		this.mapeador=mapeador;
	}
	//esta anotación se pone para evitar que hibernate cierre la sesión al obtener el objeto principal
	//y así no falle cuando se recuperen los objetos relacionados 
	@Transactional
	@Override
	public List<CursoDto> cursos() {
		return cursosDao.findAll().stream()
				.map(c->mapeador.cursoEntityToDto(c))
				.toList(); 
	}
	@Transactional
	@Override
	public List<AlumnoMatriculadoDto> buscarAlumnosMatriculados(int idCurso) {
		//a partir del curso, obtiene las matriculas y en ellas están tanto curso como alumno
		return cursosDao.findById(idCurso).get() //Curso
				.getMatriculas().stream() //Stream<Matricula>
				.map(m->new AlumnoMatriculadoDto(mapeador.alumnoEntityToDto(m.getAlumno()),
						mapeador.cursoEntityToDto(m.getCurso()),
						m.getNota()))//Stream<AlumnoMatriculadoDto>
				.toList(); 
	}
	@Override
	public boolean altaCurso(CursoDto curso) {
		if(cursosDao.findByNombreAndFechaInicio(curso.getNombre(), curso.getFechaInicio())==null) {
			cursosDao.save(mapeador.cursoDtoToEntity(curso));
			return true;
		}
		return false;
	}
	@Override
	public double notaMediaCurso(int idCurso) {
		if(cursosDao.findById(idCurso).isPresent()) {
			return matriculasDao.avgByIdCurso(idCurso);
		}
		return 0;
	}

}
