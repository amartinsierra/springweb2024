package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import model.Curso;
import service.CursosService;

@Controller
public class CursosController {
	@Autowired
	CursosService service;
	@GetMapping(value="formAlta")
	public String prepararAlta(Model model) {
		model.addAttribute("curso", new Curso());
		return "nuevo";
	}
	
	
	@PostMapping(value="alta")
	public String alta(@ModelAttribute Curso curso) {
		return service.nuevo(curso)?"nuevo":"error";
	}
	@GetMapping(value="buscar")
	public String buscar(@RequestParam("precioMax") double precioMax,HttpServletRequest request) {
		request.setAttribute("cursos", service.preciosCursoMax(precioMax));
		return "cursos";
	}
	@PostMapping(value="eliminar")
	public String eliminar(@RequestParam("nombre") String nombre) {
		service.eliminarCurso(nombre);
		return "menu";
	}
}
