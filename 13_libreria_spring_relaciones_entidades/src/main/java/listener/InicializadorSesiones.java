package listener;

import java.util.ArrayList;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import model.LibroDto;

@WebListener
public class InicializadorSesiones implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setAttribute("carrito", new ArrayList<LibroDto>());
	}
	
}
