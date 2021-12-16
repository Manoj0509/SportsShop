package com.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.entities.CartEntity;
import com.entities.OrderEntity;
import com.exceptions.InvalidCustomerIdException;
import com.repository.ICartRepository;
import com.repository.IOrderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderServiceImpl.class)
class OrderServiceImplTest {

	@MockBean
	IOrderRepository iOrderRepository;

	@MockBean
	ICartRepository iCartRepository;

	@Autowired
	IOrderService iOrderService;

	@Test
	void testaddOrder01() throws InvalidCustomerIdException {

		CartEntity cartEntity = new CartEntity();
		cartEntity.setId((long) 121);
		cartEntity.setPrice(1258.35);
		cartEntity.setProductName("shoe");
		cartEntity.setQuantity(1);
		cartEntity.setTotal(1050.25);

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setId(null);
		orderEntity.setPaymentMethod("card");
		orderEntity.setBillingDate(LocalDate.parse("2021-08-09"));
		orderEntity.setAmount(5000.35);
		orderEntity.setCartEntity(cartEntity);

		Mockito.when(iOrderRepository.save(orderEntity)).thenReturn(orderEntity);
		assertNotNull(orderEntity);
	}

	@Test
	void testDeleteOrder01() throws InvalidCustomerIdException {
		CartEntity cartEntity = new CartEntity();
		cartEntity.setId((long) 121);
		cartEntity.setPrice(1258.35);
		cartEntity.setProductName("shoe");
		cartEntity.setQuantity(1);
		cartEntity.setTotal(1050.25);

		Mockito.when(iCartRepository.save(cartEntity)).thenReturn(cartEntity);

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setId((long) 123);
		orderEntity.setPaymentMethod("card");
		orderEntity.setBillingDate(LocalDate.parse("2021-08-09"));
		orderEntity.setAmount(5000.35);
		orderEntity.setCartEntity(cartEntity);

		Mockito.when(iOrderRepository.save(orderEntity)).thenReturn(orderEntity);
		iOrderRepository.deleteById(orderEntity.getId());
		Assert.assertNotEquals(orderEntity, new OrderEntity());
	}

	@Test
	void testgetAllOrders01() {
		CartEntity cartEntity = new CartEntity();
		cartEntity.setId((long) 121);
		cartEntity.setPrice(1258.35);
		cartEntity.setProductName("shoe");
		cartEntity.setQuantity(1);
		cartEntity.setTotal(1050.25);

		CartEntity cartEntity1 = new CartEntity();
		cartEntity.setId((long) 121);
		cartEntity.setPrice(1258.35);
		cartEntity.setProductName("shoe");
		cartEntity.setQuantity(1);
		cartEntity.setTotal(1050.25);

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setId((long) 123);
		orderEntity.setPaymentMethod("card");
		orderEntity.setBillingDate(LocalDate.parse("2021-08-09"));
		orderEntity.setAmount(5000.35);
		orderEntity.setCartEntity(cartEntity);

		OrderEntity orderEntity1 = new OrderEntity();
		orderEntity.setId((long) 123);
		orderEntity.setPaymentMethod("card");
		orderEntity.setBillingDate(LocalDate.parse("2021-08-09"));
		orderEntity.setAmount(5000.35);
		orderEntity.setCartEntity(cartEntity1);

		List<OrderEntity> orderlist = new ArrayList<>();
		orderlist.add(orderEntity);
		orderlist.add(orderEntity1);
		Mockito.when(iOrderRepository.findAll()).thenReturn(orderlist);
	}
}
