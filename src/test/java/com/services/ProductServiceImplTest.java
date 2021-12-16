package com.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.repository.IProductRepository;
import com.entities.ProductEntity;
import com.exceptions.InvalidProductInputException;
import com.exceptions.ProductNotFoundException;
import com.services.IProductService;
import com.services.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductServiceImpl.class)
class ProductServiceImplTest {

	@MockBean
	private IProductRepository productRepository;

	@Autowired
	private IProductService productService;

	@Test
	public void testAddProduct() {
		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long) 101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));

		Mockito.when(productRepository.save(productEnt)).thenReturn(productEnt);
		assertNotNull(productEnt);
	}

	@Test
	public void testDeleteProduct() throws ProductNotFoundException, InvalidProductInputException {

		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long) 101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));

		Mockito.when(productRepository.save(productEnt)).thenReturn(productEnt);
		productRepository.deleteById(productEnt.getId());
		Assert.assertNotEquals(productEnt, new ProductEntity());

	}

	@Test
	public void testUpdateProduct() throws ProductNotFoundException, InvalidProductInputException {

		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long) 101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));

		productRepository.save(productEnt);
		productEnt.setSize("9UK");
		productEnt.setColour("Black");
		productRepository.save(productEnt);
		System.out.println(productEnt.getSize());
		System.out.println(productEnt.getColour());
		Assert.assertNotEquals(productEnt, new ProductEntity());
	}

	@Test
	public void testGetProduct() throws ProductNotFoundException, InvalidProductInputException {

		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long) 101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));

		ProductEntity pe = productRepository.save(productEnt);
		Mockito.when(pe).thenReturn(productEnt);
		Assert.assertNotEquals(productEnt, pe);

	}

	@Test
	public void testGetAllProducts() throws ProductNotFoundException, InvalidProductInputException {

		ProductEntity productEnt1 = new ProductEntity();
		productEnt1.setId((long) 101);
		productEnt1.setProductName("Shoes");
		productEnt1.setCategory("Sports Shoes");
		productEnt1.setDescription("Light weight, made with high quality material");
		productEnt1.setBrand("Adidas");
		productEnt1.setColour("White");
		productEnt1.setSize("10UK");
		productEnt1.setMrp(7000.00);
		productEnt1.setPriceAfterDiscount(5000.00);
		productEnt1.setInStock(true);
		productEnt1.setExpectedDelivery(LocalDate.parse("2021-05-29"));

		ProductEntity productEnt2 = new ProductEntity();
		productEnt2.setId((long) 102);
		productEnt2.setProductName("Band");
		productEnt2.setCategory("Fitness Band");
		productEnt2.setDescription("heart rate detection, steps tracking ");
		productEnt2.setBrand("OnePlus");
		productEnt2.setColour("Black");
		productEnt2.setSize("350mm");
		productEnt2.setMrp(3000.00);
		productEnt2.setPriceAfterDiscount(2500.00);
		productEnt2.setInStock(true);
		productEnt2.setExpectedDelivery(LocalDate.parse("2021-05-29"));

		List<ProductEntity> productList = new ArrayList<>();
		productList.add(productEnt1);
		productList.add(productEnt2);

		Mockito.when(productRepository.findAll()).thenReturn(productList);
		Assert.assertNotEquals(productList, new ProductEntity());
		;

	}

	@Test
	public void testGetProductByName() throws ProductNotFoundException, InvalidProductInputException {

		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long) 101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));

		productRepository.save(productEnt);
		productRepository.findByName("Shoes");
		Assert.assertNotEquals(productEnt, new ProductEntity());

	}

	@Test
	public void testGetProductBySize() throws ProductNotFoundException, InvalidProductInputException {

		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long) 101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));

		productRepository.save(productEnt);
		productRepository.findBySize("10UK");
		Assert.assertNotEquals(productEnt, new ProductEntity());

	}

	@Test
	public void testGetProductByPrice() throws ProductNotFoundException, InvalidProductInputException {

		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long) 101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));

		productRepository.save(productEnt);
		productRepository.findByPrice(7000.00);
		Assert.assertNotEquals(productEnt, new ProductEntity());
	}

	@Test
	public void testGetProductByColour() throws ProductNotFoundException, InvalidProductInputException {

		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long) 101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));

		productRepository.save(productEnt);
		productRepository.findByColor("White");
		Assert.assertNotEquals(productEnt, new ProductEntity());
	}

}
