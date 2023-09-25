package com.maen.ec.ApiRestProject.controller;

import com.maen.ec.ApiRestProject.model.entity.Customer;
import com.maen.ec.ApiRestProject.service.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController //Indica que esta clase es un controlador.
@RequestMapping("/api/v1") //Especifica que este controlador va hacer un recurso y va a consumido por peticiones.
public class CustomerController {

    //Llamar al servicio que tiene la logica de negocio.
    @Autowired
    private ICustomer customerService;

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer update(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>(); //Mapa de errores.
        try {
            Customer customerDelete = customerService.findById(id);
            customerService.delete(customerDelete);
            return new ResponseEntity<>(customerDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException ex){
            response.put("Message: ", ex.getMessage());
            response.put("Customer: ", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer showById(@PathVariable Long id){
        return  customerService.findById(id);
    }
}
