package utilidades;

import java.util.Optional;

import org.springframework.stereotype.Component;

import dao.TemasDao;
import entities.Cliente;
import entities.Libro;
import entities.Tema;
import model.ClienteDto;
import model.LibroDto;
import model.TemaDto;
@Component
public class Mapeador {
	
	TemasDao temasDao;
	
	public Mapeador(TemasDao temasDao) {
		this.temasDao = temasDao;
	}
	public  TemaDto temaEntityToDto(Tema tema) {
		return new TemaDto(tema.getIdTema(),tema.getTema());
	}
	public  LibroDto libroEntityToDto(Libro libro) {
		Optional<Tema> opTema=temasDao.findById(libro.getTema().getIdTema());
		return new LibroDto(libro.getIsbn(),
						libro.getTitulo(),
						libro.getAutor(),
						libro.getPrecio(),
						libro.getPaginas(),
						temaEntityToDto(opTema.isPresent()?opTema.get():new Tema())
						);
	}
	public  Libro libroDtoToEntity(LibroDto libro) {
		return new Libro(libro.getIsbn(),
				libro.getTitulo(),
				libro.getAutor(),
				libro.getPrecio(),
				libro.getPaginas(),
				new Tema(libro.getTemaDto().getIdTema(),null)
				);
	}
	
	public Cliente clienteDtoToEntity(ClienteDto cliente) {
		return new Cliente(0,
				cliente.getUsuario(),
				cliente.getPassword(),
				cliente.getEmail(),
				cliente.getTelefono());
	}
}
