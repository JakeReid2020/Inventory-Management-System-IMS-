package com.qa.ims;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemContoller;
import com.qa.ims.controller.OrderContoller;

import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class imsTest {


	@Mock
	private CustomerController customers;
	
	@Mock
	private ItemContoller items;
	
	@Mock
	private OrderContoller orders;
	
	@Mock
	private Utils utils;
	
	@InjectMocks
	private IMS ims;
	
	@Test
	public void systemTest() {
		Mockito.when(utils.getString()).thenReturn("root","root")
		.thenReturn("CUSTOMER","create","read","update","delete","return")
		.thenReturn("ITEM","create","read","update","delete","return")
		.thenReturn("ORDER","create","read","update","delete","return","stop");
		Mockito.when(customers.create()).thenReturn(null);
		Mockito.when(customers.readAll()).thenReturn(null);
		Mockito.when(customers.update()).thenReturn(null);
		Mockito.when(customers.delete()).thenReturn(0);
		Mockito.when(items.create()).thenReturn(null);
		Mockito.when(items.readAll()).thenReturn(null);
		Mockito.when(items.update()).thenReturn(null);
		Mockito.when(items.delete()).thenReturn(0);
		Mockito.when(orders.create()).thenReturn(null);
		Mockito.when(orders.readAll()).thenReturn(null);
		Mockito.when(orders.update()).thenReturn(null);
		Mockito.when(orders.delete()).thenReturn(0);
	}
}
