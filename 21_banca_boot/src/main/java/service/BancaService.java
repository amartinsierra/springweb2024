package service;

import java.time.LocalDateTime;
import java.util.List;

import model.ClienteDto;
import model.MovimientoDto;

public interface BancaService {
	boolean validarCuenta(int numeroCuenta);
	void ingreso(int numeroCuenta, double cantidad);
	void extraccion(int numeroCuenta, double cantidad);
	void transferencia(int numeroCuentaOrigen, int numeroCuentaDestino, double cantidad);
	List<ClienteDto> titularesCuenta(int numeroCuenta);
	List<MovimientoDto> movimientosCuentaFecha(int numeroCuenta, LocalDateTime fecha);
}
