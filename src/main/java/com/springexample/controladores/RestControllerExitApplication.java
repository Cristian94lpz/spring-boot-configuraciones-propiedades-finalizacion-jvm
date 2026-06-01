package com.springexample.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerExitApplication {

    @Autowired
    private ApplicationContext applicationContext;

    public RestControllerExitApplication(){}

    /*
        Con ConfigurableApplicationContext.close() se logra:
        * ejecutar los metodos @PreDestroy de todos los beans
        * los recursos, como las conexiones a base de datos y los hilos, se liberan correctamente
        * se activa el ciclo de vida de cierre de Spring

     */
    @GetMapping("/exit-complete")
    public void exitApplication(){
        System.out.println("Inicio de ApplicationContext.close() desde controllador rest");
        ((ConfigurableApplicationContext) applicationContext).close();
    }

    /*
        Con System.exit() finalizamos la JVM inmediatamente. Es un metodo abrupto.
     */
    @GetMapping("/exit-jvm")
    public void exitJvm(){
        System.out.println("Inicio de System.exit() desde controllador rest");
        System.exit(0);//Puedo ejecutar antes del cierre una funcion que devuelva un valor int
    }

    /*
        SpringApplication.exit() se utiliza para cerrar el contexto de la aplicacion, ejecuta:
        * ejecutar los metodos @PreDestroy de todos los beans
        * se activa el ciclo de vida de cierre de Spring
        Al finalizar fuerza la finalizacion de la JVM, lo que no es apropiado en casos donde
        se requiere administrar recursos en multiples procesos
     */
    @GetMapping("/exit-spring")
    public void exitSpring(){
        System.out.println("Inicio de SpringApplication.exit() desde controllador rest");
        SpringApplication.exit(((ConfigurableApplicationContext)applicationContext),()->0);
    }

    /*
        Despues de invocar los metodos de limpieza del ciclo de vida de Spring se
        realiza un cierre abrupto de la JVM.
     */
    @GetMapping("/exit-mix")
    public void exitMix(){
        System.out.println("Inicio de System.exit() con SpringApplication.exit() desde controllador rest");
        SpringApplication.exit(((ConfigurableApplicationContext)applicationContext),()->0);
        System.exit(0);
    }

    /*
        El que Spring recomienda en su documentacion
        Similar al metodo exitMix()
     */
    @GetMapping("/exit-comb")
    public void exitSpringRecommend(){
        System.out.println("Inicio de System.exit() con SpringApplication.exit() desde controllador rest");
        System.exit(SpringApplication.exit(((ConfigurableApplicationContext)applicationContext),()->0));
    }
}
