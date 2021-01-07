package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.any;

import com.qa.ims.controller.OrderContoller;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;
	
	@Mock
	private OrderDAO orderdao;
	
	@Mock
	private CustomerDAO customerdao;
	
	@Mock
	private ItemDAO itemdao;
	
	
	@InjectMocks
	private OrderContoller orderController;
	
	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		
		Mockito.when(orderdao.readAll()).thenReturn(orders);

		assertEquals(orders, orderController.readAll());

		Mockito.verify(orderdao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testCreate() {
		List<Item> items = new ArrayList<>();
		List<Customer> customers = new ArrayList<>();
		long customerID = 3L;
		long itemID = 2L;
	
		Item game = new Item(1L,"Gta",50.00,1L);
		Order expected = new Order (1L,1L,items);		
		expected.getItems().add(game);
		expected.getItems().add(game);
		
		customers.add(new Customer(customerID, "Jake","Reid"));
		items.add(game);
		
		
		Mockito.when(customerdao.readAll()).thenReturn(customers);
		Mockito.when(utils.getLong()).thenReturn(customerID,itemID, itemID);
		Mockito.when(orderdao.create(any(Order.class))).thenReturn(new Order(3l,3l,new ArrayList<>()));
		Mockito.when(itemdao.readAll()).thenReturn(items);
		// No need to mock orderDAO.createLine() as return is void anyway.
		Mockito.when(utils.getString()).thenReturn("yes", "no");
		Mockito.when(orderdao.readLatest()).thenReturn(expected);
	
		assertEquals(expected, orderController.create());
		
		Mockito.verify(customerdao, Mockito.times(1)).readAll();
		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(orderdao, Mockito.times(1)).create(any(Order.class));
		Mockito.verify(itemdao, Mockito.times(2)).readAll();
		Mockito.verify(orderdao, Mockito.times(1)).readLatest();
	}
	


	
	@Test
	public void testUpdate() {
		List<Customer> customers = new ArrayList<>();
		List<Item> items = new ArrayList<>();
		long customerID = 2L;
		long itemID = 1L;
		long orderID = 2l;
		
		Item Game = new Item(itemID, "GTA", 60.99, 100L);
		Order current = new Order(orderID,3l,items);
		
		current.getItems().add(Game);
		current.getItems().add(Game);
		
		customers.add(new Customer(customerID, "Jake", "Reid"));
		items.add(Game);
		
		Mockito.when(utils.getLong()).thenReturn(orderID, orderID, itemID, itemID);
		Mockito.when(orderdao.readOrder(orderID)).thenReturn(null, current, current, current, current, current, current);
		Mockito.when(itemdao.readAll()).thenReturn(items);
		// No need to mock orderDAO.deleteLine() or createLine() as return is void anyway.
		Mockito.when(utils.getString()).thenReturn("delete", "add", "yes?", "exit");
		
		assertEquals(current, orderController.update());
		
		Mockito.verify(utils,Mockito.times(4)).getLong();
		Mockito.verify(utils, Mockito.times(4)).getString();
		Mockito.verify(orderdao, Mockito.times(7)).readOrder(anyLong());
		//Mockito.verify(itemdao, Mockito.times(1)).readAll();
	}
	
	
	@Test
	public void testDelete() {
		final long ID = 1;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(orderdao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.orderController.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(orderdao, Mockito.times(1)).delete(ID);
	}
	
	}
