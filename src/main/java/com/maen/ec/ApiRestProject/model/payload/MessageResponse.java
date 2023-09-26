package com.maen.ec.ApiRestProject.model.payload;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

//Clase de validacion de statsu code mediante un payload.
@Data //Generar los metodos Get y Set en automatico.
@ToString //Devuelve una representación en cadena de texto del objeto sobre el cual se invoque.
@Builder //Permite enviar datos en vez de los constructores.
public class MessageResponse implements Serializable {

    private String message;
    private Object object;
}
