package com.maen.ec.ApiRestProject.controller;

import com.maen.ec.ApiRestProject.model.dto.CustomerDto;
import com.maen.ec.ApiRestProject.model.entity.Customer;
import com.maen.ec.ApiRestProject.model.payload.MessageResponse;
import com.maen.ec.ApiRestProject.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Indica que esta clase es un controlador.
@RequestMapping("/api/v1") //Especifica que este controlador va hacer un recurso y va a consumido por peticiones.
public class CustomerController {

    //Llamar al servicio que tiene la logica de negocio.
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<?> getAll(){
        List<Customer> getList = customerService.getAll();
        if (getList.isEmpty()){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("No data available.")
                            .object(null)
                            .build()
                    ,HttpStatus.OK);
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("")
                        .object(getList)
                        .build()
                ,HttpStatus.OK);
    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody CustomerDto customerDto) {
        Customer customerSave = null;
        try {
            customerSave = customerService.save(customerDto);
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Record saved successfully.")
                    .object(CustomerDto.builder()
                            .idCustomer(customerSave.getIdCustomer())
                            .name(customerSave.getName())
                            .lastname(customerSave.getLastname())
                            .email(customerSave.getEmail())
                            .registrationDate(customerSave.getRegistrationDate())
                            .build())
                    .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException ex) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(ex.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody CustomerDto customerDto, @PathVariable Long id) {
        Customer customerUpdate = null;
        try {
            if (customerService.existsById(id)) {
                customerDto.setIdCustomer(id);
                customerUpdate = customerService.save(customerDto);
                return new ResponseEntity<>(MessageResponse.builder()
                        .message("Registration correctly updated.")
                        .object(CustomerDto.builder()
                                .idCustomer(customerUpdate.getIdCustomer())
                                .name(customerUpdate.getName())
                                .lastname(customerUpdate.getLastname())
                                .email(customerUpdate.getEmail())
                                .registrationDate(customerUpdate.getRegistrationDate())
                                .build())
                        .build()
                        , HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("Record not found.")
                                .object(null)
                                .build()
                        , HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException ex) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(ex.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        try {
            Customer customerDelete = customerService.findById(id);
            customerService.delete(customerDelete);
            return new ResponseEntity<>(customerDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException ex){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(ex.getMessage())
                            .object(null)
                            .build()
                    ,HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if (customer == null){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("The registry does not exist.")
                            .object(null)
                            .build()
                    ,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("")
                        .object(CustomerDto.builder()
                                .idCustomer(customer.getIdCustomer())
                                .name(customer.getName())
                                .lastname(customer.getLastname())
                                .email(customer.getEmail())
                                .registrationDate(customer.getRegistrationDate())
                                .build())
                        .build()
                ,HttpStatus.OK);
    }
}
