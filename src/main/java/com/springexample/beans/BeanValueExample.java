package com.springexample.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanValueExample {

    private String madera;

    /*
        @Value se puede utilizar a nivel de campo, metodo, constructor
        Y su fuente de propiedades es Environment y todas las demas propiedades
        que se pudieran agregar a Environment, como por medio de un @PropertySource
        Para que @Value funcione debe estar configurado un bean que se encargue de
        resolver los marcadores de posicion, en SpringBoot este bean se configura automaticamente,
        si no hay que agregar el bean PropertySourcesPlaceHolderConfigurer
     */
    public BeanValueExample(@Value("${app.madera}") String madera){
        this.madera = madera;
    }

    @Bean
    public String valueExample(){
        return this.madera;
    }
}
