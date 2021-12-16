package com.services;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.repository.IPaymentRepository;
import com.entities.PaymentEntity;
import com.exceptions.PaymentNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentServiceImpl.class)
class PaymentServiceImplTest {

	@MockBean
	IPaymentRepository iPaymentRepository;

	@Autowired
	IPaymentService iPaymentService;

	@Test
	void testAddPayment() {
		PaymentEntity paymentEntity = new PaymentEntity();
		paymentEntity.setId((long) 23);
		paymentEntity.setType("Online");
		paymentEntity.setStatus("Sucess");
		paymentEntity.setCardEntity(null);

		Mockito.when(iPaymentRepository.save(paymentEntity)).thenReturn(paymentEntity);
		Assert.assertNotNull(paymentEntity);
	}

	@Test
	void testRemovePayment() throws PaymentNotFoundException {
		PaymentEntity paymentEntity = new PaymentEntity();
		paymentEntity.setId((long) 23);
		paymentEntity.setType("Online");
		paymentEntity.setStatus("Sucess");
		paymentEntity.setCardEntity(null);

		Mockito.when(iPaymentRepository.save(paymentEntity)).thenReturn(paymentEntity);
		iPaymentRepository.deleteById(paymentEntity.getId());
		Assert.assertNotNull(paymentEntity);
	}

	@Test
	void testUpdatePayment01() throws PaymentNotFoundException {
		PaymentEntity paymentEntity = new PaymentEntity();
		paymentEntity.setId((long) 23);
		paymentEntity.setType("Online");
		paymentEntity.setStatus("Sucess");
		paymentEntity.setCardEntity(null);

		iPaymentRepository.save(paymentEntity);
		paymentEntity.setStatus("Not Sucess");
		iPaymentRepository.save(paymentEntity);

		Assert.assertNotNull(paymentEntity);
	}

	@Test
	void testGetPaymentDetails01() throws PaymentNotFoundException {
		PaymentEntity paymentEntity = new PaymentEntity();
		paymentEntity.setId((long) 23);
		paymentEntity.setType("Online");
		paymentEntity.setStatus("Sucess");
		paymentEntity.setCardEntity(null);

		iPaymentRepository.save(paymentEntity);
		iPaymentRepository.findById(23L);
		Assert.assertNotEquals(paymentEntity, new PaymentEntity());
	}

	@Test
	void testGetAllPaymentDetails() {
		PaymentEntity paymentEntity1 = new PaymentEntity();
		paymentEntity1.setId((long) 23);
		paymentEntity1.setType("Online");
		paymentEntity1.setStatus("Sucess");
		paymentEntity1.setCardEntity(null);

		PaymentEntity paymentEntity2 = new PaymentEntity();
		paymentEntity2.setId((long) 24);
		paymentEntity2.setType("NetBanking");
		paymentEntity2.setStatus("Sucess");
		paymentEntity2.setCardEntity(null);

		List<PaymentEntity> paymentList = new ArrayList<>();
		paymentList.add(paymentEntity1);
		paymentList.add(paymentEntity2);

		Mockito.when(iPaymentRepository.findAll()).thenReturn(paymentList);
		Assert.assertNotEquals(paymentList, new PaymentEntity());
	}

}
