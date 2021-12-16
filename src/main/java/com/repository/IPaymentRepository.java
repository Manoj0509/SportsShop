package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.PaymentEntity;

@Repository
public interface IPaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
