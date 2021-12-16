package com.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.entities.AddressEntity;
import com.exceptions.AddressNotFoundException;
import com.repository.IAddressRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AddressServiceImpl {
//
	static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);

	@Autowired
	private IAddressRepository iaddressRepository;

	public AddressEntity addAddress(AddressEntity address) throws AddressNotFoundException {
		LOGGER.info("addAddress() service is initiated");
		AddressEntity addressentity;
		if (address == null)
			addressentity = null;
		else {
			addressentity = iaddressRepository.save(address);
		}
		LOGGER.info("addAddress() service has executed");
		return addressentity;
	}

	public AddressEntity removeAddress(long custId) throws AddressNotFoundException {
		LOGGER.info("removeAddress() service is initiated");
		AddressEntity existaddress = iaddressRepository.findById(custId).orElse(null);
		if (existaddress == null) {
			throw new AddressNotFoundException("AddressNotFound");
		} else {
			iaddressRepository.delete(existaddress);
		}
		LOGGER.info("removeAddress() service has executed");
		return existaddress;
	}

	public AddressEntity updateAddress(long custId, AddressEntity address) throws AddressNotFoundException {
		// TODO Auto-generated method stub
		LOGGER.info("updateAddress() service is initiated");
		AddressEntity addressentity = null;
		AddressEntity updateaddress = iaddressRepository.findById(custId).orElse(null);
		if (updateaddress == null) {
			throw new AddressNotFoundException("AddressNotFound");
		} else {
			addressentity = iaddressRepository.save(address);
		}
		LOGGER.info("updateAddress() service has executed");
		return addressentity;
	}

	public List<AddressEntity> getAllAddress() throws AddressNotFoundException {
		LOGGER.info("getAddress() service is initiated");
		List<AddressEntity> getAddress = iaddressRepository.findAll();
		;
		if (getAddress == null) {
			throw new AddressNotFoundException("AddressNotFound");
		}
		LOGGER.info("getAddress() service has executed");
		return getAddress;
	}

}
