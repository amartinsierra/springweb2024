package model;

public class AlumnoMatriculadoDto {
	private AlumnoDto alumnoDto;
	private CursoDto cursoDto;
	private double nota;
	public AlumnoMatriculadoDto(AlumnoDto alumnoDto, CursoDto cursoDto, double nota) {
		this.alumnoDto = alumnoDto;
		this.cursoDto = cursoDto;
		this.nota = nota;
	}
	public AlumnoDto getAlumnoDto() {
		return alumnoDto;
	}
	public void setAlumnoDto(AlumnoDto alumnoDto) {
		this.alumnoDto = alumnoDto;
	}
	public CursoDto getCursoDto() {
		return cursoDto;
	}
	public void setCursoDto(CursoDto cursoDto) {
		this.cursoDto = cursoDto;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
}
