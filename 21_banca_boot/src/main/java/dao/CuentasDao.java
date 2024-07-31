package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Cuenta;

public interface CuentasDao extends JpaRepository<Cuenta, Integer> {

}
