package dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Venta;

public interface VentasDao extends JpaRepository<Venta, Integer> {
	@Query("select v from Venta v where v.cliente.usuario=?1")
	List<Venta> findByUsuario(String usuario);
	
	List<Venta> findByFechaBetween(LocalDate f1, LocalDate f2);
	List<Venta> findByFechaLessThan(LocalDate f1);
}
