package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.ResultadosDao;
import model.Resultado;
@Service("buscadorEstandar")
@Scope("singleton")
public class BuscadorServiceImpl implements BuscadorService {
	@Autowired
	ResultadosDao resultadosDao;
	@Override
	public List<Resultado> buscar(String tematica) {
		return resultadosDao.findByTematica(tematica);
	}

	@Override
	public boolean agregar(Resultado resultado) {
		if(resultadosDao.findByUrl(resultado.getUrl())==null) {
			resultadosDao.save(resultado);
			return true;
		}
		return false;
	}

	@Override
	public Resultado buscarPorUrl(String url) {
		return resultadosDao.findByUrl(url);
	}

	@Override
	public void eliminar(String url) {
		resultadosDao.deleteByUrl(url);
	}

}
