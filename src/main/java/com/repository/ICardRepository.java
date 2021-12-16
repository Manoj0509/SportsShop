package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.CardEntity;

@Repository
public interface ICardRepository extends JpaRepository<CardEntity, Long> {

}
