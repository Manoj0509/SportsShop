package com.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.CartController;
import com.entities.CartEntity;
import com.entities.ProductEntity;
import com.exceptions.CartException;
import com.repository.ICartRepository;
import com.repository.IProductRepository;

//declare class as service class
@Service
public class CartServiceImpl implements ICartService {

	static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	// dependency injection
	@Autowired
	private ICartRepository iCartRepository;

	@Autowired
	private IProductRepository iProductRepository;

	// add cart to product
	@Override
	public CartEntity addCart(Long custId, Long prodID) throws CartException {
		LOGGER.info("addtocart() service is initiated");
		ProductEntity proEntity = iProductRepository.findById(prodID).orElse(null);
		CartEntity carEntity = null;
		if (proEntity == null)
			throw new CartException("No products found by id");
		else {
			CartEntity cartEntity = new CartEntity(proEntity.getProductName(), 1, proEntity.getMrp(),
					proEntity.getPriceAfterDiscount(), custId);
			carEntity = iCartRepository.save(cartEntity);
		}
		LOGGER.info("addtocart() service has Executed");
		return carEntity;
	}

	// delete product from cart
	@Override
	public CartEntity deleteCart(Long id) throws CartException {
		LOGGER.info("deletecart() service is initiated");
		CartEntity carEntity = iCartRepository.findById(id).orElse(null);
		if (carEntity == null)
			throw new CartException("CartNotFound");
		else
			iCartRepository.delete(carEntity);
		LOGGER.info("deletecart() service has Executed");
		return carEntity;
	}

	// display all product deatails in cart
	@Override
	public List<CartEntity> getallCartDetails() {
		LOGGER.info("getallcartdetails() service is initiated");
		List<CartEntity> cartList = iCartRepository.findAll();
		LOGGER.info("getallcartdetails() has Executed");
		return cartList;
	}

	// desplya the product in cart
	@Override
	public List<CartEntity> getCart(Long custId) {
		LOGGER.info("getCart() service is initiated");
		List<CartEntity> carEntity = iCartRepository.findByCustId(custId);
		LOGGER.info("getcartdetails() has Executed");
		return carEntity;
	}
}