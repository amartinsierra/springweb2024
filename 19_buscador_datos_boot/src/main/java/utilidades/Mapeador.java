package utilidades;

import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

import entities.Resultado;
import model.ResultadoDto;
@Component
public class Mapeador {
	
	public ResultadoDto resultadoEntityToDto(Resultado resultado) {
		return new ResultadoDto(resultado.getUrl(),resultado.getTematica(),resultado.getDescripcion());
	}
	
	public Resultado resultadoDtoToEntity(ResultadoDto resultado) {
		return new Resultado(0,resultado.getUrl(),resultado.getTematica(),resultado.getDescripcion());
	}
}
