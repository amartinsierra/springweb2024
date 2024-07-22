package model;

import java.time.LocalDateTime;

public class VentaDto {
	private int idVenta;
	private String usuario;
	private String tituloLibro;
	private LocalDateTime fecha;
	public VentaDto(int idVenta, String usuario, String tituloLibro, LocalDateTime fecha) {
		this.idVenta = idVenta;
		this.usuario = usuario;
		this.tituloLibro = tituloLibro;
		this.fecha = fecha;
	}
	public VentaDto() {
	}
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTituloLibro() {
		return tituloLibro;
	}
	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
}
