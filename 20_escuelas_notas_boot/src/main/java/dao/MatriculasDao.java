package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Matricula;
import entities.MatriculaPk;

public interface MatriculasDao extends JpaRepository<Matricula,MatriculaPk>{
	@Query("select avg(m.nota) from Matricula m where m.curso.idCurso=?1")
	double avgByIdCurso(int idCurso);
	@Query("select avg(m.nota) from Matricula m where m.alumno.usuario=?1")
	double avgByUsuario(String usuario);
	
	@Query(value="select idCurso, nota from matriculas",nativeQuery = true)
	List<Object[]> buscarDatos();
	@Query(value="select alumnos.nombre, alumnos.email, matriculas.nota from alumnos, matriculas, cursos "
			+ "where alumnos.usuario=matriculas.usuario and matriculas.idCurso=cursos.idCurso and cursos.idCurso=?", nativeQuery=true)
	List<Object[]> datosAlumnoCurso(int idCurso);
}
