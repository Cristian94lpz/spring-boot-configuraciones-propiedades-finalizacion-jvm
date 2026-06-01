package com.springexample.configuraciones.convertidores;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Duration;

/*
    @ConfigurationPropertiesBinding se utiliza para registrar convertidores
    especificamente para el proceso de enlace de propiedades de configuracion
    con @ConfigurationProperties, osea, esta implementacion de Converter<S,T>
    solo se utilizara para convertir propiedades de un beans @ConfigurationProperties
 */
@Component
@ConfigurationPropertiesBinding
public class DurationConverter implements Converter<String, Duration> {

    @Override
    public Duration convert(String source) {
        return Duration.ofMillis(Long.valueOf(source));
    }
}
