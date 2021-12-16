package com.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entities.CartEntity;
import com.exceptions.CartException;
import com.services.ICartService;

//rest full web services
@RestController

//map the HttP request
@RequestMapping("/onlinesportshopee")
public class CartController {

	static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	// dependency injection.
	@Autowired
	private ICartService cartService;

	// add the product to cart
	@PostMapping("/cart/addtocart/{custId}/{ProdID}")
	public ResponseEntity<CartEntity> addtocart(@PathVariable("custId") Long custId,
			@PathVariable("ProdID") Long ProdID) throws CartException {
		LOGGER.info("add-cart URL is opened");
		LOGGER.info("addtocart() is initiated");
		CartEntity cartDTO = cartService.addCart(custId, ProdID);
		LOGGER.info("addtocart() has Executed");
		return new ResponseEntity<CartEntity>(cartDTO, HttpStatus.ACCEPTED);
	}

	// display the deleted product from the cart
	@GetMapping("/cart/getCartDetails/{custId}")
	public List<CartEntity> getCartdetails(@PathVariable Long custId) throws CartException {
		LOGGER.info("getCartDetails URL is opened");
		LOGGER.info("getCart() has Executed");
		return cartService.getCart(custId);
	}

	// delete the product from cart
	@DeleteMapping("/cart/removefromcart/{delID}")
	public ResponseEntity<CartEntity> deletecart(@PathVariable long delID) throws CartException {
		LOGGER.info("remove-cart URL is opened");
		LOGGER.info("deletecart() is initiated");
		CartEntity cartDTO = cartService.deleteCart(delID);
		LOGGER.info("deletecart() has Executed");
		return new ResponseEntity<CartEntity>(cartDTO, HttpStatus.ACCEPTED);
	}

	// display the product details in cart
	@GetMapping("/cart/getallcartdetials")
	public List<CartEntity> getAllProduct() {
		LOGGER.info("getall-cartdetails URL is opened");
		LOGGER.info("getallcartdetails() initiated");
		return cartService.getallCartDetails();
	}
}