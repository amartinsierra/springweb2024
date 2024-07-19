package service;

import model.ClienteDto;

public interface ClientesService {
	boolean autenticar(String usuario, String password);
	boolean registrar(ClienteDto cliente);
}
