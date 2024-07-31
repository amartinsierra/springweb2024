package entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMovimiento;
	private LocalDateTime fecha;
	private double cantidad;
	private String operacion;
	
	@ManyToOne
	@JoinColumn(name = "idCuenta", referencedColumnName = "numeroCuenta")
	private Cuenta cuenta;

	public Movimiento(int idMovimiento, LocalDateTime fecha, double cantidad, String operacion, Cuenta cuenta) {
		this.idMovimiento = idMovimiento;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
		this.cuenta = cuenta;
	}

	public Movimiento() {
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
} 
