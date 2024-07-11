package controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@ComponentScan(basePackages = {"controller"})
@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer{
	@Bean
	public InternalResourceViewResolver resolver() {
		var resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/toBuscarResultados").setViewName("buscarResultados");
		registry.addViewController("/toAlta").setViewName("alta");
		registry.addViewController("/").setViewName("inicio");
		registry.addViewController("/toInicio").setViewName("inicio");
		registry.addViewController("/toEliminar").setViewName("eliminar");
		registry.addViewController("/toBuscar").setViewName("buscar");
		WebMvcConfigurer.super.addViewControllers(registry);
	}
	
}
