package com.maen.ec.ApiRestProject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

//Esta clase hace referencia a una entidad o tabla de la base de datos.
@Data //Generar los metodos Get y Set en automatico.
@NoArgsConstructor //Constructor vacio.
@AllArgsConstructor //Contructor con parametros.
@ToString //Devuelve una representación en cadena de texto del objeto sobre el cual se invoque.
public class Customer {

    //Atributos.
    private Long idCustomer;
    private String name;
    private String lastname;
    private String email;
    private Date registrationDate;
}
