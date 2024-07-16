package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.ResultadoDto;
@Service("buscadorNuevo")
public class BuscadorServiceNuevoImpl implements BuscadorService {

	@Override
	public List<ResultadoDto> buscar(String tematica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean agregar(ResultadoDto resultado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultadoDto buscarPorUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(String url) {
		// TODO Auto-generated method stub

	}

}
