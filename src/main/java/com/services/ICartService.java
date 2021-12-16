package com.services;

import java.util.List;
import com.entities.CartEntity;
import com.exceptions.CartException;

public interface ICartService {

	public CartEntity addCart(Long custId, Long prodID) throws CartException;

	public CartEntity deleteCart(Long id) throws CartException;

	public List<CartEntity> getallCartDetails();

	public List<CartEntity> getCart(Long custId);

}
