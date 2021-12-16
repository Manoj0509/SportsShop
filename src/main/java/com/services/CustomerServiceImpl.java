package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.CustomerEntity;
import com.exceptions.CustomerNotFoundException;
import com.repository.ICustomerRepository;
import com.repository.ILoginRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// @Service annotation is used with classes that provide some business functionalities.
@Service
public class CustomerServiceImpl implements ICustomerService {
//
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private ICustomerRepository icustomerRepository;
	@Autowired
	ILoginRepository loginDao;

	public CustomerEntity addCustomer(CustomerEntity customer) throws CustomerNotFoundException {
		LOGGER.info("addCustomer() service is initiated");
		CustomerEntity customerentity = icustomerRepository.save(customer);
		LOGGER.info("addCustomer() service has executed");
		return customerentity;
	}

	@Override
	public CustomerEntity signIn(CustomerEntity customer) throws CustomerNotFoundException {
		LOGGER.info("signin() service is initiated");
		CustomerEntity custid = icustomerRepository.findById(customer.getId()).orElse(null);
		if (custid == null) {
			String customernotfound = "No customer found by the customer id " + customer.getId();
			throw new CustomerNotFoundException(customernotfound);
		} else {
			if (customer.getId().equals(custid.getId()) && customer.getPassword().equals(custid.getPassword())) {
				LOGGER.info("signin() service has Executed");
				return custid;
			} else {
				throw new CustomerNotFoundException("Customer name and password are invalid");
			}
		}
	}

	@Override
	public String signOut(CustomerEntity user) {
		LOGGER.info("signout() service is initiated");
		return "Signout Successfull";
	}

	@Override
	public CustomerEntity removeCustomer(Long custId) throws CustomerNotFoundException {
		LOGGER.info("removeCustomer() service is initiated");
		CustomerEntity existcustomer = icustomerRepository.findById(custId).orElse(null);

		icustomerRepository.delete(existcustomer);
		LOGGER.info("removeCustomer() service has executed");
		return existcustomer;
	}

	@Override
	public CustomerEntity updateCustomer(Long custId, CustomerEntity customer) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		LOGGER.info("updateCustomer() service is initiated");
		CustomerEntity updatecustomer = icustomerRepository.findById(custId).orElse(null);

		CustomerEntity customerentity = icustomerRepository.save(customer);

		LOGGER.info("updateCustomer() service has executed");
		return customerentity;
	}

	@Override
	public CustomerEntity getCustomer(Long custId) throws CustomerNotFoundException {
		LOGGER.info("getCustomer() service is initiated");
		CustomerEntity getCustomer = icustomerRepository.findById(custId).orElse(null);
		if (getCustomer == null) {
			throw new CustomerNotFoundException("CustomerNotFound");
		}
		LOGGER.info("getCustomer() service has executed");
		return getCustomer;
	}

	@Override
	public List<CustomerEntity> getAllCustomers() {
		LOGGER.info("getAllCustomer() service is initiated");
		List<CustomerEntity> custlist = icustomerRepository.findAll();
		LOGGER.info("getAllCustomer() service has executed");
		return custlist;
	}
}
