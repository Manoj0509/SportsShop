package com.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.CartEntity;
import com.entities.OrderEntity;
import com.exceptions.OrderNotFoundException;
import com.repository.ICartRepository;
import com.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
	@Autowired
	private IOrderRepository iOrderRepository;

	@Autowired
	private ICartRepository iCartRepository;

	@Override
	public OrderEntity addOrder(Long custID) throws OrderNotFoundException {
		LOGGER.info("addOrder() service is initiated");
		List<CartEntity> cartEntity = iCartRepository.findByCustId(custID);
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date dateobj = new Date();
		OrderEntity orderEntity = null;
		for (CartEntity cart : cartEntity) {
			OrderEntity ordEntity = new OrderEntity(cart.getTotal(), df.format(dateobj), "card", cart.getProductName(),
					custID);
			orderEntity = iOrderRepository.save(ordEntity);
		}

		LOGGER.info("addOrder() service has executed");
		return orderEntity;
	}

	@Override
	public OrderEntity updateOrder(Long id, OrderEntity order) throws OrderNotFoundException {
		LOGGER.info("updateOrder() service is initiated");
		OrderEntity existOrd = iOrderRepository.findById(id).orElse(null);
		if (existOrd == null)
			throw new OrderNotFoundException("orderIdIncorrect");
		else
			existOrd = iOrderRepository.save(order);
		LOGGER.info("updateOrder() service has executed");
		return existOrd;
	}

	@Override
	public OrderEntity removeOrder(Long id) throws OrderNotFoundException {
		LOGGER.info("removeOrder() service is initiated");
		OrderEntity ordEntity = iOrderRepository.findById(id).orElse(null);
		if (ordEntity == null)
			throw new OrderNotFoundException("orderIdIncorrect");
		else
			iOrderRepository.delete(ordEntity);
		LOGGER.info("deleteOrder() service has executed");
		return ordEntity;
	}

	@Override
	public List<OrderEntity> getAllOrders() {
		List<OrderEntity> orderList = iOrderRepository.findAll();
		return orderList;
	}

	@Override
	public List<OrderEntity> getOrders(Long custId) {
		LOGGER.info("getCart() service is initiated");
		List<OrderEntity> ordEntity = iOrderRepository.findByCustId(custId);
		LOGGER.info("getcartdetails() has Executed");
		return ordEntity;
	}
}
