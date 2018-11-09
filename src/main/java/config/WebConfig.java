package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import dao.OrderDAO;
import dao.OrderDAOImplementation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "controller")
public class WebConfig implements WebMvcConfigurer {
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public OrderDAO getUserDAO() {
		return new OrderDAOImplementation();
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/testdb");
		dataSource.setUsername("postgres");
		dataSource.setPassword("787878");
		dataSource.setDriverClassName("org.postgresql.Driver");
		return dataSource;
	}
	
	@Bean
    public ViewResolver getviewResolver() {
		FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
		viewResolver.setOrder(1);
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".ftl");
        return viewResolver;
    }
	
	@Bean
	public FreeMarkerConfigurer getFreeMarkerConfigurer() {
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
		freeMarkerConfigurer.setTemplateLoaderPaths("/", "/WEB-INF", "/WEB-INF/exceptions");
		return freeMarkerConfigurer;
	}
}
