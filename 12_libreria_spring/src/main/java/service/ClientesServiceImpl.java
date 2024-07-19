package service;

import org.springframework.stereotype.Service;

import dao.ClientesDao;
import entities.Cliente;
import model.ClienteDto;
import utilidades.Mapeador;
@Service
public class ClientesServiceImpl implements ClientesService {
	
	ClientesDao clientesDao;
	Mapeador mapeador;

	public ClientesServiceImpl(ClientesDao clientesDao, Mapeador mapeador) {
		this.clientesDao = clientesDao;
		this.mapeador = mapeador;
	}

	@Override
	public boolean autenticar(String usuario, String password) {
		Cliente cliente=clientesDao.findByUsuario(usuario);
		return cliente!=null&&cliente.getPassword().equals(password);
	}

	@Override
	public boolean registrar(ClienteDto cliente) {
		if(clientesDao.findByUsuario(cliente.getUsuario())==null) {//si no encuentra cliente con ese usuario, lo guarda
			clientesDao.save(mapeador.clienteDtoToEntity(cliente));
			return true;
		}
		return false;
	}

}
