package com.springexample;

import com.springexample.beans.AuthenticationTokenSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


/*
	** Estructura del codigo **
	Se recomienda ubicar la clase principal en un paquete raiz
	por encima de las demas clases, si no configuro @ComponentScan explicitamente.

	@SpringBootApplication es la combinacion de las metaanotaciones
	@SpringBootConfiguration, @EnableAutoConfiguration y @ComponentScan.
	Con @SpringBootApplication se buscaran clases @Configuration y @Component en
	el mismo paquete donde se encuentra la clase anotada y en todos los subpaquetes.

 */
@SpringBootApplication(proxyBeanMethods = true)
@EnableConfigurationProperties(value = {AuthenticationTokenSettings.class})
public class SpringexampleApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringexampleApplication.class, args);
	}


}
