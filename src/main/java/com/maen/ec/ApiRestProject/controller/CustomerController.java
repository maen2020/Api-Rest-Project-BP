package com.maen.ec.ApiRestProject.controller;

import com.maen.ec.ApiRestProject.model.dto.CustomerDto;
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
    public CustomerDto create(@RequestBody CustomerDto customerDto){
        Customer customerSave = customerService.save(customerDto);
        return CustomerDto.builder()
                .idCustomer(customerSave.getIdCustomer())
                .name(customerSave.getName())
                .lastname(customerSave.getLastname())
                .email(customerSave.getEmail())
                .registrationDate(customerSave.getRegistrationDate())
                .build();
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto update(@RequestBody CustomerDto customerDto){
        Customer customerUpdate = customerService.save(customerDto);
        return CustomerDto.builder()
                .idCustomer(customerUpdate.getIdCustomer())
                .name(customerUpdate.getName())
                .lastname(customerUpdate.getLastname())
                .email(customerUpdate.getEmail())
                .registrationDate(customerUpdate.getRegistrationDate())
                .build();
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
    public CustomerDto showById(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        return CustomerDto.builder()
                .idCustomer(customer.getIdCustomer())
                .name(customer.getName())
                .lastname(customer.getLastname())
                .email(customer.getEmail())
                .registrationDate(customer.getRegistrationDate())
                .build();
    }
}
