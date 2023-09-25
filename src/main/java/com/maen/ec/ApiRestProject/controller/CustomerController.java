package com.maen.ec.ApiRestProject.controller;

import com.maen.ec.ApiRestProject.model.entity.Customer;
import com.maen.ec.ApiRestProject.service.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //Indica que esta clase es un controlador.
@RequestMapping("/api/v1") //Especifica que este controlador va hacer un recurso y va a consumido por peticiones.
public class CustomerController {

    //Llamar al servicio que tiene la logica de negocio.
    @Autowired
    private ICustomer customerService;

    @PostMapping("/customers")
    public Customer create(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PutMapping("/customers")
    public Customer update(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable Long id){
        Customer customerDelete = customerService.findById(id);
        customerService.delete(customerDelete);
    }

    @GetMapping("/customers/{id}")
    public Customer showById(@PathVariable Long id){
        return  customerService.findById(id);
    }
}
