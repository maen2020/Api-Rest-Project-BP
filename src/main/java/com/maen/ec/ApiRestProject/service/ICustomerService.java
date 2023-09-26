package com.maen.ec.ApiRestProject.service;

import com.maen.ec.ApiRestProject.model.dto.CustomerDto;
import com.maen.ec.ApiRestProject.model.entity.Customer;

import java.util.List;

//Clase(Interfaz) que va a contener los metodos que seran utilizados en el CRUD.
public interface ICustomerService {

    //Metodos del CRUD.
    List<Customer> getAll();
    Customer save(CustomerDto customer);
    Customer findById(Long id);
    void delete(Customer customer); //Existen dos formas de eliminar (Entidad completa o id).
    boolean existsById(Long id); //Validar si existe el Id.
}
