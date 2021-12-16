package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.AddressEntity;

@Repository
public interface IAddressRepository extends JpaRepository<AddressEntity, Long> {

}
//