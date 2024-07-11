package controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@ComponentScan(basePackages = {"controller"})
@EnableWebMvc
@Configuration
public class MvcConfig {
	@Bean
	public InternalResourceViewResolver resolver() {
		var resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
