package com.testing;

import com.testing.model.pojos.*;
import com.testing.repo.*;
import com.testing.service.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JamazonTests {

	//Auto-wires
	@Autowired
	private AdminService admin;
	@Autowired
	private CustomerService customer;

	//Mock Beans
	@MockBean
	private CustomerRepository customerRep;
	@MockBean
	private OrdersRepository orderRep;
	@MockBean
	private ProductRepository productRep;

	//Product Tests
	@Test
	public void testAddProduct() {
		Product product = new Product();
		Mockito.when(productRep.save(any(Product.class))).thenReturn(product);
		Assert.assertEquals(product, admin.addProduct(product));
	}

	@Test
	public void testDeleteProduct() {
		Long productId = 1L;
		Mockito.doNothing().when(productRep).deleteById(productId);
		admin.deleteProduct(productId);
		verify(productRep, times(1)).deleteById(productId);
	}



}
