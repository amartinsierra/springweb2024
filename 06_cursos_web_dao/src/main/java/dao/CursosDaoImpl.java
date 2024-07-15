package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Curso;
@Repository
public class CursosDaoImpl implements CursosDao {
	
	JdbcTemplate template;
	public CursosDaoImpl(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void save(Curso curso) {
		String sql="insert into cursos (nombre,tematica,duracion,precio) values(?,?,?,?)";
		template.update(sql,curso.getNombre(),curso.getTematica(),curso.getDuracion(),curso.getPrecio());

	}

	@Override
	public List<Curso> findByPrecioMax(double precio) {
		String sql="select * from cursos where precio<=?";
		return template.query(sql, (r,f)->new Curso(r.getInt("codCurso"),
													r.getString("nombre"),
													r.getString("tematica"),
													r.getInt("duracion"),
													r.getDouble("precio")),precio);
	}

	@Override
	public void deleteByNombre(String nombre) {
		String sql="delete from cursos where nombre=?";
		template.update(sql,nombre);

	}

	@Override
	public Curso findByNombre(String nombre) {
		/*String sql="select * from cursos where nombre=?";
		List<Curso> cursos= template.query(sql, (r,f)->new Curso(r.getInt("codCurso"),
													r.getString("nombre"),
													r.getString("tematica"),
													r.getInt("duracion"),
													r.getDouble("precio")),nombre);
		return cursos.size()>0?cursos.get(0):null;
		*/
		String sql="select * from cursos where nombre=?";
		try {
			return template.queryForObject(sql, (r,f)->new Curso(r.getInt("codCurso"),
					r.getString("nombre"),
					r.getString("tematica"),
					r.getInt("duracion"),
					r.getDouble("precio")),nombre);
		}catch(EmptyResultDataAccessException ex) {
			return null;
		}
	}

	@Override
	public double averageByTematica(String tematica) {
		String sql="select avg(precio) from cursos where tematica=?";
		return template.queryForObject(sql, Double.class,tematica);
	}

}
