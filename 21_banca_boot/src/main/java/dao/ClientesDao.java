package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Cliente;

public interface ClientesDao extends JpaRepository<Cliente, Integer> {
	@Query("select c from Cliente c join c.cuentas q where q.numeroCuenta=?1")
	List<Cliente> findByNumeroCuenta(int numeroCuenta);
}
