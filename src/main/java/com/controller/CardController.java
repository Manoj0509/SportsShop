package com.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.CardEntity;
import com.exceptions.CardNotFoundException;
import com.services.CardServiceImpl;


@RestController
@RequestMapping("/onlinesportshopee")

public class CardController {

	static final Logger LOGGER = LoggerFactory.getLogger(CardController.class);

	@Autowired
	private CardServiceImpl cardServiceImpl;

	@PostMapping("/cards")
	public ResponseEntity<CardEntity> addCard(@RequestBody CardEntity card) throws CardNotFoundException {
		LOGGER.info("add-card URL is opened");
		LOGGER.info("addCard() is initiated");
		CardEntity cardDto = cardServiceImpl.addCard(card);
		LOGGER.info("addCard() has executed");
		return new ResponseEntity<CardEntity>(cardDto, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/cards/{id}")
	public ResponseEntity<CardEntity> removeCard(@PathVariable Long id) throws CardNotFoundException {
		LOGGER.info("remove-card URL is opened");
		LOGGER.info("removeCard() is initiated");
		CardEntity cardDto = cardServiceImpl.removeCard(id);
		LOGGER.info("removeCard() has executed");
		return new ResponseEntity<CardEntity>(cardDto, HttpStatus.ACCEPTED);

	}

	@PutMapping("/cards/{id}")
	public ResponseEntity<CardEntity> updateCard(@PathVariable Long id, @RequestBody CardEntity card) {
		LOGGER.info("update-card URL is opened");
		LOGGER.info("updateCard() is initiated");
		CardEntity cardDto = cardServiceImpl.updateCard(id, card);
		LOGGER.info("updateCard() has executed");
		return new ResponseEntity<CardEntity>(cardDto, HttpStatus.ACCEPTED);

	}

	@GetMapping("/cards/{id}")
	public ResponseEntity<CardEntity> getCardDetails(@PathVariable Long id) {
		LOGGER.info("get-card-details URL is opened");
		LOGGER.info("getCardDetails() is initiated");
		CardEntity cardDto = cardServiceImpl.getCardDetails(id);
		LOGGER.info("getCardDetails() has executed");
		return new ResponseEntity<CardEntity>(cardDto, HttpStatus.ACCEPTED);
	}

	@GetMapping("/cards")
	public List<CardEntity> getAllCards() {
		LOGGER.info("get-all-cards URL is opened");
		LOGGER.info("getAllCards() is initiated");
		LOGGER.info("getAllCards() has executed");
		return cardServiceImpl.getAllCards();
	}
}
