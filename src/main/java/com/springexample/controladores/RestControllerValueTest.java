package com.springexample.controladores;

import com.springexample.beans.AuthenticationTokenSettings;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerValueTest {

    @Resource
    private String valueExample;
    private String appName;
    private String appTimezone;
    private AuthenticationTokenSettings token;

    public RestControllerValueTest(@Value("${app.name}") String appName,
                                   @Value("${app.timezone}") String appTimezone,
                                   AuthenticationTokenSettings token){
        this.appName = appName;
        this.appTimezone = appTimezone;
        this.token = token;
    }

    @ResponseBody
    @GetMapping("/madera")
    public ResponseEntity<String> getMadera(){
        return ResponseEntity.ok(valueExample);
    }

    /*
        Siempre debe referirse a los nombres de las propiedades en el marcador
        de posición utilizando su forma canónica (solo minusculas)
        Por ejemplo, `${demo.item-price}` tomará las formas `demo.item-price` y `demo.itemPrice`
        del archivo `application.properties`, así como `DEMO_ITEMPRICE` del entorno del sistema.
        Si usa `${demo.itemPrice}` en su lugar, tomará la forma `demo.itemPrice` del archivo
        `application.properties`, así como `DEMO_ITEMPRICE` del entorno del sistema, pero no se
        considerará `demo.item-price`.
     */
    @ResponseBody
    @GetMapping("/marcador-posicion")
    public ResponseEntity<String> getMarcadores(){
        return ResponseEntity.ok(appName + "-" + appTimezone);
    }

    @ResponseBody
    @GetMapping("/jwt")
    public ResponseEntity<AuthenticationTokenSettings> getJwt(){
        return ResponseEntity.ok(token);
    }
}
