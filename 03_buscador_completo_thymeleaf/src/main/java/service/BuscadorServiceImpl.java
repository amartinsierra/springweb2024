package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Resultado;
@Service("buscadorEstandar")
public class BuscadorServiceImpl implements BuscadorService {
	static List<Resultado> resultados=new ArrayList<>(List.of(
			new Resultado("http://www.fnac.es","libros","Libros y más"),
			new Resultado("http://www.mybook.com","libros","librería de temas varios"),
			new Resultado("http://www.game.es","juegos","Juegos variados"),
			new Resultado("http://www.music.es","música","Lamejor música"),
			new Resultado("http://www.tech.com","libros","Libros técnicos"),
			new Resultado("http://www.eljuego.es","juegos","Juegos on-line")
			));
	@Override
	public List<Resultado> buscar(String tematica) {
		return resultados.stream()
				.filter(r->r.getTematica().equals(tematica))
				.toList();
	}

	@Override
	public boolean agregar(Resultado resultado) {
		if(!resultados.stream().anyMatch(r->r.getUrl().equals(resultado.getUrl()))) {
			resultados.add(resultado);
			return true;
		}
		return false;
	}

	@Override
	public Resultado buscarPorUrl(String url) {
		return resultados.stream()
				.filter(r->r.getUrl().equals(url))
				.findFirst()
				.orElse(null);
	}

	@Override
	public void eliminar(String url) {
		resultados.removeIf(r->r.getUrl().equals(url));
	}

}
