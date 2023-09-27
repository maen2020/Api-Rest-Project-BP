package com.maen.ec.ApiRestProject.model.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//Clase que servira para mostrar las excepciones globales.
@Data //Genera los Get y Set.
@NoArgsConstructor //Genera un constructor vacio.
public class ApiResponse {

    //Atributos que seran mostrados en el response del las excepciones globales.
    private String message;
    private Date time = new Date();
    private String url;

    //Se genera un construtor con dos parametros(La fecha la obtiene del sistema.).
    public ApiResponse(String message, String url){
        this.message = message;
        this.url = url.replace("uri=", "");
    }
}
