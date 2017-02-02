package co.com.uni5d.config;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;

@Configuration
@ComponentScan("co.com.uni5d")
public class Configuracion {
	
	
	@Bean(name="mirest")
	public RestOperations crearBean(final RestTemplateBuilder builder) {
		return builder.setReadTimeout(300000).setConnectTimeout(30000).build();
	}

  

}
