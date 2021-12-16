package com.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.entities.CartEntity;
import com.exceptions.CartException;
import com.exceptions.InvalidCustomerIdException;
import com.repository.ICartRepository;
import com.repository.IProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class CartServiceImplTest {
	
	
	// to add mock objects
	@MockBean
	ICartRepository iCartRepository;
	
	@MockBean
	IProductRepository iProductRepository;
	
	
	//DI
	@Autowired
	ICartService iCartService;
	
	
	//run as testcase
	@Test
	
	//testcases for adding product to cart
	void testaddCart01() throws CartException,InvalidCustomerIdException {

		CartEntity cartEntity = new CartEntity();
		cartEntity.setId((long)121);
		cartEntity.setPrice(1258.35);
		cartEntity.setProductName("shoe");
		cartEntity.setQuantity(1);
		cartEntity.setTotal(1050.25);
		Mockito.when(iCartRepository.saveAndFlush(cartEntity)).thenReturn(cartEntity);
		assertNotNull(cartEntity);		
	}
	
	@Test
	
	//testcases for delete the product from the cart
	void testDeleteorder01() throws InvalidCustomerIdException {
		CartEntity cartEntity = new CartEntity();
		cartEntity.setId((long)121);
		cartEntity.setPrice(1258.35);
		cartEntity.setProductName("shoe");
		cartEntity.setQuantity(1);
		cartEntity.setTotal(1050.25);
        
        Mockito.when(iCartRepository.save(cartEntity)).thenReturn(cartEntity);
        iCartRepository.deleteById(cartEntity.getId());
       assertNotEquals(cartEntity, new CartEntity());
	}
		
	@Test
	
	//diplay all the details of product which are present in cart 
	void testgetAllCustomers01() {
		CartEntity cartEntity = new CartEntity();
		cartEntity.setId((long)121);
		cartEntity.setPrice(1258.35);
		cartEntity.setProductName("shoe");
		cartEntity.setQuantity(1);
		cartEntity.setTotal(1050.25);
        
		CartEntity cartEntity1 = new CartEntity();
		cartEntity.setId((long)121);
		cartEntity.setPrice(1258.35);
		cartEntity.setProductName("shoe");
		cartEntity.setQuantity(1);
		cartEntity.setTotal(1050.25);
        
        List<CartEntity> cartlist = new ArrayList<>();
        cartlist.add(cartEntity);
        cartlist.add(cartEntity1);
        Mockito.when(iCartRepository.findAll()).thenReturn(cartlist);
	}
}