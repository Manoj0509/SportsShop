package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.CustomerEntity;

//@Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on object
@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
