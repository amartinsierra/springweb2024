package dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Tema;

public interface TemasDao extends JpaRepository<Tema, Integer> {
	
}
