package utilidades;

import org.springframework.stereotype.Component;

import entities.Cliente;
import entities.Movimiento;
import model.ClienteDto;
import model.MovimientoDto;
@Component
public class Mapeador {
	public ClienteDto clienteEntityToDto(Cliente cliente) {
		return new ClienteDto(cliente.getDni(),
								cliente.getNombre(),
								cliente.getDireccion(),
								cliente.getTelefono());
	}
	public MovimientoDto movimientoEntityToDto(Movimiento movimiento) {
		return new MovimientoDto(movimiento.getIdMovimiento(),
								movimiento.getCuenta().getNumeroCuenta(),
								movimiento.getFecha(),
								movimiento.getCantidad(),
								movimiento.getOperacion());
	} 
}
