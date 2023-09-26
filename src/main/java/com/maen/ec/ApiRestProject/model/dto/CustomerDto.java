package com.maen.ec.ApiRestProject.model.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

//Esta clase hace referencia a una entidad o tabla de la base de datos.
@Data //Generar los metodos Get y Set en automatico.
@ToString //Devuelve una representación en cadena de texto del objeto sobre el cual se invoque.
@Builder //Permite enviar datos en vez de los contructores.
public class CustomerDto implements Serializable {

    //Atributos.
    private Long idCustomer;
    private String name;
    private String lastname;
    private String email;
    private Date registrationDate;
}
