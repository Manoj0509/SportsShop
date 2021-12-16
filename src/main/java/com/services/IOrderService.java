package com.services;

import com.entities.OrderEntity;

import com.exceptions.InvalidOrderIdException;
import com.exceptions.OrderNotFoundException;
import java.util.List;

public interface IOrderService {
	public OrderEntity addOrder(Long custID) throws OrderNotFoundException, InvalidOrderIdException;

	public OrderEntity updateOrder(Long id, OrderEntity order) throws OrderNotFoundException, InvalidOrderIdException;

	public OrderEntity removeOrder(Long id) throws InvalidOrderIdException, OrderNotFoundException;

	public List<OrderEntity> getAllOrders();

	public List<OrderEntity> getOrders(Long custId);

}
