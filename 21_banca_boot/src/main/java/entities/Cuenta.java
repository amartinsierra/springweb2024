package entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cuentas")
public class Cuenta {
	@Id
	private int numeroCuenta;
	private double saldo;
	@Column(name="tipocuenta")
	private String tipoCuenta;
	@ManyToMany()
	@JoinTable(name = "titulares",joinColumns =@JoinColumn(name="idCuenta",referencedColumnName ="numeroCuenta"),
								  inverseJoinColumns = @JoinColumn(name="idCliente",referencedColumnName = "dni"))
	private List<Cliente> clientes;
	@OneToMany(mappedBy="cuenta")
	private List<Movimiento> movimientos;
	public Cuenta(int numeroCuenta, double saldo, String tipoCuenta) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
	}
	public Cuenta() {
	}
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	
} 