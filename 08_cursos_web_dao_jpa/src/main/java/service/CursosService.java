package service;

import java.util.List;

import model.CursoDto;

public interface CursosService {

	//modificar este método para que añada el curso si no hay otro
	//con el mismo nombre, si ya existe no se añade y se devuelve false
	boolean nuevo(CursoDto curso);

	List<CursoDto> preciosCursoMax(double precioMax);

	void eliminarCurso(String nombre);

}