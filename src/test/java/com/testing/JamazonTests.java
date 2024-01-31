package com.testing;

import com.testing.model.enums.SignOfTheStars;
import com.testing.model.pojos.*;
import com.testing.repo.*;
import com.testing.service.*;
import java.util.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;



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
		when(productRep.save(any(Product.class))).thenReturn(product);
		assertEquals(product, admin.addProduct(product));
	}

	@Test
	public void testDeleteProduct() {
		Long productId = 1L;
		Mockito.doNothing().when(productRep).deleteById(productId);
		admin.deleteProduct(productId);
		verify(productRep, times(1)).deleteById(productId);
	}

	@Test
	public void testEditProduct() {
		Product product = new Product();
		when(productRep.findById(any())).thenReturn(Optional.of(product));
		when(productRep.save(any(Product.class))).thenReturn(product);

		Product result = admin.editProduct(product);
		assertEquals(product, result);
	}

	//Customer management [admin control] Methods
	@Test
	public void testDeleteCustomer() {
		Customer customer = new Customer(101L, "first_name", "last_name", "test@mail.com","10/01/24","password", SignOfTheStars.ARIES );
		admin.deleteCustomer(customer.getCustomerId());
		verify(customerRep, times(1)).deleteById(customer.getCustomerId());
	}

	@Test
	public void testEditCustomer() {
		Customer customer = new Customer(101L, "first_name", "last_name", "test@mail.com","10/01/24","password", SignOfTheStars.ARIES );
		when(customerRep.findById(any())).thenReturn(Optional.of(customer));
		when(customerRep.save(any(Customer.class))).thenReturn(customer);

		Customer result = admin.editCustomer(customer);
		assertEquals(customer, result);
	}

	//Order [admin control] Methods
	@Test
	public void testViewAllOrders() {
		Orders orders = new Orders();
		List<Orders> ordersList = Collections.singletonList(orders);
		when(orderRep.findAll()).thenReturn(ordersList);

		List<Orders> result = admin.ViewAllOrders();
		assertEquals(ordersList, result);
	}

	@Test
	public void testOrderCount() {
		when(orderRep.count()).thenReturn(1L);

		long result = admin.OrdersCount();
		assertEquals(1L, result);
	}

	@Test
	public void testCancelOrder() {
		Long orderId = 1L;
		when(orderRep.findById(any())).thenReturn(Optional.of(new Orders()));
		doNothing().when(orderRep).deleteById(anyLong());

		assertDoesNotThrow(() -> admin.CancelOrders(orderId));
	}
}
