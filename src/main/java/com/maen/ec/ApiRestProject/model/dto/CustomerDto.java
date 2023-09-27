package com.maen.ec.ApiRestProject.model.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @Size(min = 2, max = 25)
    @NotEmpty(message = "Name required!!")
    private String name;
    @NotEmpty(message = "Lastname required!")
    @Size(min = 2, max = 25)
    private String lastname;
    @Email
    @NotEmpty(message = "Email required!")
    private String email;
    private Date registrationDate;
}
