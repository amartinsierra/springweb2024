package dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Alumno;

public interface AlumnosDao extends JpaRepository<Alumno,String>{
	@Query("select distinct(a) from Alumno a join a.cursos c where c.idCurso=?1")
	List<Alumno> findByIdCurso(int idCurso);
	@Query("select distinct(a) from Alumno a join a.cursos c where c.fechaInicio>=?1")
	List<Alumno> findByFecha(LocalDate fecha);
}
