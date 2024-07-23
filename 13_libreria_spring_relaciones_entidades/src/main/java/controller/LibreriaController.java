package controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpSession;
import model.ClienteDto;
import model.LibroDto;
import model.TemaDto;
import service.ClientesService;
import service.LibrosService;

@Controller
public class LibreriaController {
	ClientesService clientesService;
	LibrosService librosService;
	public LibreriaController(ClientesService clientesService, LibrosService librosService) {
		this.clientesService = clientesService;
		this.librosService = librosService;
	}
	@GetMapping(value="agregarCarrito",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LibroDto> agregarCarrito(@RequestParam("isbn") int isbn,@SessionAttribute("carrito") List<LibroDto> carrito) {
		//recogemos el libro cuyo ISBN se recibe como parámetro
		LibroDto libro=librosService.getLibro(isbn);		
		carrito.add(libro);
		return carrito;
	}
	@PostMapping(value="registrarCliente",produces=MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String registro(@ModelAttribute ClienteDto cliente) {
		return String.valueOf(clientesService.registrar(cliente));
	}
	
	@PostMapping(value="altaLibro",produces=MediaType.TEXT_PLAIN_VALUE)
	//el idTema lo recogemos a parte para después construir el TemaDto
	public @ResponseBody String altaLibro(@ModelAttribute LibroDto libro, @RequestParam("idTema")int idTema) {
		libro.setTemaDto(librosService.getTema(idTema));
		return String.valueOf(librosService.guardarLibro(libro));
	}
	@GetMapping(value="librosTema",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LibroDto> librosTema(@RequestParam("idTema")int idTema){
		return librosService.librosTema(idTema);
	}
	@GetMapping(value="login")
	public String autenticar(@RequestParam("usuario") String usuario,
			@RequestParam("password") String password,
			HttpSession sesion) {
		if(clientesService.autenticar(usuario, password)) {
			sesion.setAttribute("usuario", usuario);
			return "inicio";
		}
		return "registro";
	}
	@GetMapping(value="eliminarCarrito",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LibroDto> quitarCarrito(@RequestParam("pos") int pos, @SessionAttribute("carrito") List<LibroDto> carrito){
		carrito.remove(pos);
		return carrito;
	}
	@GetMapping(value="temas")
	public String temas(Model model) {
		model.addAttribute("temas", librosService.getTemas());
		return "visor";
	}
	@GetMapping(value="prepararAlta")
	public String preparaAlta(Model model) {
		model.addAttribute("temas", librosService.getTemas());
		return "alta";
	}
	@GetMapping(value="temaTitulo", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody TemaDto temaPorTitulo(@RequestParam("titulo") String titulo) {
		return librosService.buscarTemaTituloLibro(titulo);
	}
	
	@GetMapping(value="misCompras")
	public String misCompras(Model model, @SessionAttribute("usuario") String usuario) {
		model.addAttribute("compras", clientesService.ventasCliente(usuario));
		return "compras";
	}
}
