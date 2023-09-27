package com.maen.ec.ApiRestProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Clase que implementa los metodos para capturar lo errores en tiempo de ejecucion.
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    //Atributos para especificar los mensajes que van a enviarse como parametros.
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue){
        super(String.format("%s was not found with: %s = '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName){
        super((String.format("No records were found.", resourceName)));
        this.resourceName = resourceName;
    }
}
