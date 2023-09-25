package com.maen.ec.ApiRestProject.service;

import com.maen.ec.ApiRestProject.model.entity.Customer;

//Clase(Interfaz) que va a contener los metodos que seran utilizados en el CRUD.
public interface ICustomer {

    //Metodos del CRUD.
    Customer save(Customer customer);
    Customer findById(Long id);
    void delete(Customer customer); //Existen dos formas de eliminar (Entidad completa o id).
}
