package service;

import java.util.List;

import model.ClienteDto;
import model.VentaDto;

public interface ClientesService {
	boolean autenticar(String usuario, String password);
	boolean registrar(ClienteDto cliente);
	List<VentaDto> ventasCliente(String usuario);
}
