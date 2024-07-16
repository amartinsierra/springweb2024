package model;

public class ResultadoDto {
	private String url;
	private String tematica;
	private String descripcion;
	public ResultadoDto(String url, String tematica, String descripcion) {
		super();
		this.url = url;
		this.tematica = tematica;
		this.descripcion = descripcion;
	}
	public ResultadoDto() {
		super();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
