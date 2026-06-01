# SpringBoot

## Orden de valor para propiedades externalizadas

Las propiedades posteriores pueden sobreescribir los valores de propiedades anteriores

1. Propiedades predeterminadas SpringApplication.setDefaultProperties(Map)
2. Anotaciones @PropertySource , estas propiedades se usan cuando se ha actualizado el contexto de la aplicacion
3. Datos de configuracion application.properties (los perfiles tienen prioridad)
4. RandomValuePropertySource con propiedades solo en random.*
5. Variables de entorno del sistema operativo
6. Propiedades del sistema java (System.getProperties())
7. Atributos JNDI de java:comp/env
8. Parametros de inicializacion de ServletContext 
9. Parametros de inicializacion de ServletConfig
10. Propiedades SPRING_APPLICATION_JSON
11. Argumentos de la linea de comandos
12. Atributo properties en tus pruebas
13. Anotaciones @DynamicPropertySource
14. Anotaciones @TestPropertySource
15. Propiedades de configuracion global en DevTools en el directorio $HOME/.config/spring-boot cuando DevTools esta activo

## Usar propiedades definidas en Maven de <properties> en archivo application.properties
Para referenciar a una propiedad de Maven se debe usar `@...@`. Para usar esta referencia se debe
usar `spring-boot-starter-parent`.

Ejemplo:
```
    app.java.version=@java.version@

```

## Activar perfiles desde java -jar
```
$ java -jar -Dspring.profiles.active=production demo-0.0.1-SNAPSHOT.jar
```