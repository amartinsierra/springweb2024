package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Resultado;
@Service("buscadorNuevo")
public class BuscadorServiceNuevoImpl implements BuscadorService {

	@Override
	public List<Resultado> buscar(String tematica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean agregar(Resultado resultado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Resultado buscarPorUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(String url) {
		// TODO Auto-generated method stub

	}

}
