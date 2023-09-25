package com.maen.ec.ApiRestProject.model.dao;

import com.maen.ec.ApiRestProject.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;

//De esta interface(REPOSITORIO) se van a mandar a llamar a los metodos CRUD.
public interface CustomerDAO extends CrudRepository<Customer, Long> {
}
