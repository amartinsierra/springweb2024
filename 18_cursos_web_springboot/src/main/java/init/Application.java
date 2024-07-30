package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {"controller","service"})
public class Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/toNuevo").setViewName("nuevo");
		registry.addViewController("/toEliminar").setViewName("eliminar");
		registry.addViewController("/").setViewName("menu");
		registry.addViewController("/toInicio").setViewName("menu");
		registry.addViewController("/toBuscar").setViewName("buscar");
		WebMvcConfigurer.super.addViewControllers(registry);
	}
}
