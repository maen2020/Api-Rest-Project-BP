package com.maen.ec.ApiRestProject.service.impl;

import com.maen.ec.ApiRestProject.model.dao.CustomerDAO;
import com.maen.ec.ApiRestProject.model.dto.CustomerDto;
import com.maen.ec.ApiRestProject.model.entity.Customer;
import com.maen.ec.ApiRestProject.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Dentro de esta clase se tiene que mandar a llamar(implements) a la interfaz ICustomer para hacer uso
//de esos metodos.

/**
 * Dentro de esta clase se hace el match con lo que se tiene en el DAO,
 * la informacion se procesa y se manda al ICustomerDAO.
 */
@Service //Indicar que la clase va a trabajar como servicio dentro de la logica de negocio.
public class CustomerImplService implements ICustomerService {

    //Instaciar e inyeccion del ICustomerDAO.
    @Autowired
    private CustomerDAO customerDAO;
    @Transactional
    @Override
    public Customer save(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .idCustomer(customerDto.getIdCustomer())
                .name(customerDto.getName())
                .lastname(customerDto.getLastname())
                .email(customerDto.getEmail())
                .registrationDate(customerDto.getRegistrationDate())
                .build();
        return customerDAO.save(customer);
    }

    @Transactional(readOnly = true)
    @Override
    public Customer findById(Long id) {
        return customerDAO.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Customer customer) {
        customerDAO.delete(customer);
    }

    @Override
    public boolean existsById(Long id) {
        return customerDAO.existsById(id);
    }
}
