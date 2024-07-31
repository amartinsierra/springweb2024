package dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Movimiento;

public interface MovimientosDao extends JpaRepository<Movimiento, Integer> {
	@Query("select m from Movimiento m where m.cuenta.numeroCuenta=?1 and m.fecha>=?2")
	List<Movimiento> findByCuentaFecha(int idCuenta, LocalDateTime fecha);
}
