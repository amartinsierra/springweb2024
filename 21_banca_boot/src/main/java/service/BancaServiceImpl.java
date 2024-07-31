package service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ClientesDao;
import dao.CuentasDao;
import dao.MovimientosDao;
import entities.Cuenta;
import entities.Movimiento;
import model.ClienteDto;
import model.MovimientoDto;
import utilidades.Mapeador;
@Service
public class BancaServiceImpl implements BancaService {
	ClientesDao clientesDao;
	MovimientosDao movimientosDao;
	CuentasDao cuentasDao;
	Mapeador mapeador;
	
	public BancaServiceImpl(ClientesDao clientesDao, MovimientosDao movimientosDao, CuentasDao cuentasDao,
			Mapeador mapeador) {
		this.clientesDao = clientesDao;
		this.movimientosDao = movimientosDao;
		this.cuentasDao = cuentasDao;
		this.mapeador = mapeador;
	}

	@Override
	public boolean validarCuenta(int numeroCuenta) {
		//return cuentasDao.findById(numeroCuenta).isPresent();
		return cuentasDao.existsById(numeroCuenta);
	}
	@Transactional
	@Override
	public void ingreso(int numeroCuenta, double cantidad) {		
			Cuenta cuenta=cuentasDao.findById(numeroCuenta).orElse(null);
			if(cuenta!=null) {
				cuenta.setSaldo(cuenta.getSaldo()+cantidad);
				operacion(cantidad,"ingreso",cuenta);			
			}else {
				throw new RuntimeException();
			}
		

	}
	@Transactional
	@Override
	public void extraccion(int numeroCuenta, double cantidad) {
		Cuenta cuenta=cuentasDao.findById(numeroCuenta).orElse(null);
		if(cuenta!=null) {
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			operacion(cantidad,"extracción",cuenta);		
		}else {
			throw new RuntimeException();
		}

	}
	
	public void operacion(double cantidad,String operacion,Cuenta cuenta) {
		
		movimientosDao.save(new Movimiento(0,LocalDateTime.now(), 
						cantidad,
						operacion,
						cuenta
						));
			
		cuentasDao.save(cuenta);
	} 
	@Transactional
	@Override
	public void transferencia(int numeroCuentaOrigen, int numeroCuentaDestino, double cantidad) {
		ingreso(numeroCuentaDestino,cantidad);
		extraccion(numeroCuentaOrigen,cantidad);
	}

	@Override
	public List<ClienteDto> titularesCuenta(int numeroCuenta) {
		if(validarCuenta(numeroCuenta)) {
			return clientesDao.findByNumeroCuenta(numeroCuenta).stream()
					.map(c->mapeador.clienteEntityToDto(c))
					.toList();
		}else {
			throw new RuntimeException();
		}
	}

	@Override
	public List<MovimientoDto> movimientosCuentaFecha(int numeroCuenta, LocalDateTime fecha) {
		if(validarCuenta(numeroCuenta)) {
			return movimientosDao.findByCuentaFecha(numeroCuenta, fecha).stream()
					.map(m->mapeador.movimientoEntityToDto(m))
					.toList();
		}else {
			throw new RuntimeException();
		}
	}

}
