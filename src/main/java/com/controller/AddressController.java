package com.controller;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entities.AddressEntity;
import com.exceptions.AddressNotFoundException;
import com.services.AddressServiceImpl;

// @RestController is processed if an appropriate HandlerMapping-HandlerAdapter pair is configured such as 
//the RequestMappingHandlerMapping-RequestMappingHandlerAdapterpair which are the default in the MVC Java config and the MVC namespace.
@RestController
//Annotation for mapping web requests onto methods in request-handling classeswith flexible method signatures
@RequestMapping("/onlinesportshopee")

public class AddressController {

	// The org.slf4j.Logger interface is the main user entry point of SLF4J API.It
	// is expected that logging takes place through concrete implementationsof this
	// interface.
	static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

	@Autowired
	private AddressServiceImpl AddressServiceImpl;

	// mapping and crud operation for address for http request.
	@PostMapping("/address/addAddress")
	public ResponseEntity<Object> addAddress(@RequestBody AddressEntity address) throws AddressNotFoundException {
		LOGGER.info("addAddress URL is opened");
		LOGGER.info("addAddress() is initiated");
		AddressEntity addressDTO = null;
		ResponseEntity<Object> addressResponse = null;
		addressDTO = AddressServiceImpl.addAddress(address);
		addressResponse = new ResponseEntity(addressDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addAddress() has executed");
		return addressResponse;
	}

	@DeleteMapping("/address/removeAddress/Address/{custId}")
	public ResponseEntity<Object> removeAddress(@PathVariable long custId) throws AddressNotFoundException {
		LOGGER.info("removeAddress URL is opened");
		LOGGER.info("removeAddress() is initiated");
		AddressEntity addressDTO = null;
		ResponseEntity<Object> addressResponse = null;
		addressDTO = AddressServiceImpl.removeAddress(custId);
		addressResponse = new ResponseEntity(addressDTO, HttpStatus.ACCEPTED);
		LOGGER.info("removeAddress() has executed");
		return addressResponse;
	}

	@PutMapping("/address/updateAddress/{custId}")
	public ResponseEntity<Object> updateAddress(@PathVariable long custId, @RequestBody AddressEntity address)
			throws AddressNotFoundException {
		LOGGER.info("updateAddress URL is opened");
		LOGGER.info("updateAddress() is initiated");
		AddressEntity addressDTO = null;
		ResponseEntity<Object> addressResponse = null;
		addressDTO = AddressServiceImpl.updateAddress(custId, address);
		addressResponse = new ResponseEntity(addressDTO, HttpStatus.ACCEPTED);
		LOGGER.info("updateAddress() has executed");
		return addressResponse;
	}

	// to get the address details
	@GetMapping("/address/getAddressDetails")
	public ResponseEntity<Object> getAddress() throws AddressNotFoundException {
		LOGGER.info("getAddressDetails URL is opened");
		LOGGER.info("getAddress() is initiated");
		List<AddressEntity> addressDTO = null;
		ResponseEntity<Object> addressResponse = null;
		addressDTO = AddressServiceImpl.getAllAddress();
		addressResponse = new ResponseEntity(addressDTO, HttpStatus.ACCEPTED);
		LOGGER.info("getAddress() has executed");
		return addressResponse;
	}

	//

}
