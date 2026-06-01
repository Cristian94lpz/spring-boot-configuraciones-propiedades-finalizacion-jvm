package com.springexample.beans;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/*
    @ConfigurationProperties
    se utiliza para vincular o enlazar propiedades de configuración externas definidas
    en application.properties o application.yml a un objeto Java simple (POJO)

    Para la definicion de un POJO para @ConfigurationProperties es:
    * obligatorio la definicion de metodos setter / getter
    * no se permite enlace a propiedades estaticas
    * constructor vacio por defecto

    El prefijo definido en la anotacion enlaza las propiedades con tal prefijo
    en el archivo de propiedades al los campos del bean anotado con @ConfigurationProperties

    Para habilitar una clase @ConfigurationProperties y permitir el enlace de propiedades
    se debe anotar con @Configuration o agregar @EnableConfigurationProperties en la clase principal
    de la aplicacion Spring o tambien podemos usar la anotacion @ConfigurationPropertiesScan en la clase
    principal de la aplicacion Spring y evitar anotar la clase con @Component o @Configuration o usar
    @EnableConfigurationProperties

    Podemos anidar propiedades definiendo colecciones o mapas en la clase POJO
    Las propiedades en el archivo de propiedades deberan anotarse para colecciones como:
    jwt.security[0]=valor tomamos a security como el nombre de la coleccion
    O para mapas como:
    jwt.security.key=valor tomamos a security como el nombre del mapa

    Para usar las propiedades en un bean se debe inyectar el bean anotado con @ConfigurationProperties
    en el bean y usar los metodos get para obtener las propiedades

    Podemos usar la @ConfigurationProperties(prefix="valor") para vincular propiedades a un metodo de bean,
    en vez de a una clase como en este caso
        @Bean
        @ConfigurationProperties(prefix="item")
        public Item item(){
            return new Item();
        }

    Podemos utilizar validacion con formato JSR-380 en los campos del POJO pero
    antes se debera definir la dependencia:
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
 */
/*
    Los metodos getter/setter no estan disenados para ser usados directamente
    El nombre del prefijo debe estar en kebab case (minuscula, se separa con guion las palabras camelcase)
 */
@ConfigurationProperties(prefix = "jwt")
public class AuthenticationTokenSettings {

    /*
        Puedo definir valores predeterminados, inicializando los campos
        El valor declarado sera usado como reserva si la propiedad correspondiente
        no se encuentra en el archivo de propiedades
     */
    private String secret;
    private String issuer;
    private String audience;
    private Duration clockSkew;
    private Duration validFor = Duration.ofMillis(36000);
    private String refreshLimit;

    public AuthenticationTokenSettings(){}

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public Duration getClockSkew() {
        return clockSkew;
    }

    public void setClockSkew(Duration clockSkew) {
        this.clockSkew = clockSkew;
    }

    public Duration getValidFor() {
        return validFor;
    }

    public void setValidFor(Duration validFor) {
        this.validFor = validFor;
    }

    public String getRefreshLimit() {
        return refreshLimit;
    }

    public void setRefreshLimit(String refreshLimit) {
        this.refreshLimit = refreshLimit;
    }


}
