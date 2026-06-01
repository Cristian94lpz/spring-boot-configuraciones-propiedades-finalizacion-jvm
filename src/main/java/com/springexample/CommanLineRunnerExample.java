package com.springexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Properties;

/*
    La interfaz CommandLineRunner sirve para ejecutar tareas despues
    del inicio de la aplicacion pero antes de que se comience a recibir trafico.
    Ejemplo, carga de datos iniciales en BD o prueba de BD (Data Seeding),
    precalentamiento de cache (Cache Warming), probar APIs o servicios externos,etc
    Se debe utilizar @Order si se va a definir varias clases con CommandLineRunner
 */

@Component
@Order(1)
public class CommanLineRunnerExample implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ejecucion de CommandLineRunnerExample");
        Properties properties = System.getProperties();
        System.out.println("Propiedades del sistema");
        for(Map.Entry<Object,Object> prop : properties.entrySet()){
            System.out.println(prop.getKey()+"="+prop.getValue());
        }
    }
}
