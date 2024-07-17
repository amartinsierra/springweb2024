package service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableJpaRepositories(basePackages = {"dao"},entityManagerFactoryRef = "factory",transactionManagerRef = "txManager")
@ComponentScan(basePackages = {"service","utilidades"})
@PropertySource("classpath:config/application.properties")
@EnableTransactionManagement
@Configuration
public class ServiceConfig {
	@Value("${driver}")
	String driver;
	@Value("${url}")
	String url;
	@Value("${usuario}")
	String usuario;
	@Value("${pass}")
	String contra;
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource data=new DriverManagerDataSource();
		data.setDriverClassName(driver);
		data.setUrl(url);
		data.setUsername(usuario);
		data.setPassword(contra);
		return data;
	}
	//adaptador de Hibernate/JPA
	@Bean
	public HibernateJpaVendorAdapter adapter() {
		HibernateJpaVendorAdapter adp=new HibernateJpaVendorAdapter();
		adp.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adp;
	}
	
	//factoria EntityManager: Objeto para acceder a capa de persistencia con JPA
	@Bean
	public LocalContainerEntityManagerFactoryBean factory(DriverManagerDataSource dataSource,
			HibernateJpaVendorAdapter adapter) {
		LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("entities");
		factory.setJpaVendorAdapter(adapter);
		return factory;
	}	
	
	//creación y configuración del transactionmanager
	@Bean
	public JpaTransactionManager txManager(LocalContainerEntityManagerFactoryBean factory) {
		JpaTransactionManager manager=new JpaTransactionManager();
		manager.setEntityManagerFactory(factory.getObject());
		return manager;
	} 
}
