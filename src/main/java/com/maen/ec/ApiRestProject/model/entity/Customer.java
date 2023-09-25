package com.maen.ec.ApiRestProject.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

//Esta clase hace referencia a una entidad o tabla de la base de datos.
@Data //Generar los metodos Get y Set en automatico.
@NoArgsConstructor //Constructor vacio.
@AllArgsConstructor //Contructor con parametros.
@ToString //Devuelve una representación en cadena de texto del objeto sobre el cual se invoque.
@Entity //Definir la clase como entidad.
@Table(name = "customers") //Hace referencia hacia la tabla de la base de datos.
public class Customer implements Serializable {

    //Atributos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long idCustomer;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "registration_date")
    private Date registrationDate;
}
