package com.qa.ims.persistance.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;

public class ItemTest {
	Item testItem1 = new Item("wet socks",300.23,3L);
	Item testItem2 = new Item("dry socks",0.50,2L);
	Item nullItem1 = new Item(null, null, null, null);
	Item nullItem2 = new Item(1l, "dry socks", null, null);
	Item nullItem3 = new Item(1l, "dry socks", 0.50, null);
	Item nullItem4 = new Item(1l, null, 0.50, 8l);
	Item nullItem5 = new Item(1l, "dry socks", null, 8l);
	Item fullItem = new Item(1l, "Iphone", 0.50, 8l);
	Item fullItem2 = new Item(1l, "dry socks", 0.55, 8l);
	Item fullItem3 = new Item(1l, "dry socks", 0.50, 9l);
	Customer testCustomer = new Customer("piers","barber");
	
	@Test
	public void testSetters() {
		testItem1.setId(5l);
		testItem1.setTitle("damp socks");
		testItem1.setPrice(20.43);
		testItem1.setQuantity(3l);
		
		assertFalse(testItem1.equals(testItem2));
	}
	

	@Test
	public void testEquals() {
		assertFalse(testItem1.equals(null));
		assertFalse(testItem1.equals(testCustomer));
		assertFalse(nullItem1.equals(testItem1));
		assertFalse(nullItem1.equals(nullItem2));
		assertFalse(nullItem1.equals(nullItem3));
	//	assertFalse(nullItem2.equals(testItem1));
		assertFalse(nullItem3.equals(testItem1));
		assertFalse(fullItem.equals(testItem1));
		assertFalse(nullItem4.equals(fullItem));
	//	assertFalse(nullItem5.equals(fullItem));
		assertFalse(fullItem.equals(fullItem2));
		assertFalse(nullItem3.equals(fullItem));
		assertFalse(fullItem.equals(fullItem3));
		assertTrue(fullItem.equals(new Item(1l, "Iphone", 0.50, 8l)));
	}
	
}
