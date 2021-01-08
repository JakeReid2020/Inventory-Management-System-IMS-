package com.qa.ims.persistance.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;

public class CustomerTest {
	private Customer testCustomer = new Customer(1l,"Jake","Reid");
	private Customer testCustomer2 = new Customer(1l,"Jake","Reid");
	private Customer testCustomer3 = new Customer(2l,"Jake","Reid");
	private Customer nullCustomer1 = new Customer(null,null,null);
	private Customer nullCustomer2 = new Customer(1l,null,null);
	private Customer nullCustomer3 = new Customer(1l,"Bob",null);
	private Item testItem = new Item("GTA",4.99,40l);
	
	@Test
	public void testSetters() {
		testCustomer.setId(1l);
		testCustomer.setFirstName("Tim");
		testCustomer.setSurname("NoName");
		assertFalse(testCustomer.equals(testCustomer2));
	}
	
	@Test
	public void testGetters() {
		long id = 1l;
		String fName = "Jake";
		String lName = "Reid";
		assertTrue(testCustomer.getId().equals(id));
		assertTrue(testCustomer.getFirstName().equals(fName));
		assertTrue(testCustomer.getSurname().equals(lName));
	}
	
	@Test
	public void testEquals() {
		assertFalse(nullCustomer1.equals(testCustomer));
		assertFalse(nullCustomer2.equals(testCustomer));
		assertFalse(nullCustomer3.equals(testCustomer));
		assertFalse(testCustomer.equals(nullCustomer1));
		assertFalse(testCustomer.equals(nullCustomer2));
		assertFalse(testCustomer.equals(nullCustomer3));
		assertTrue(testCustomer.equals(testCustomer));
		assertFalse(testCustomer.equals(null));
		assertFalse(testCustomer.equals(testItem));
		assertFalse(testCustomer.equals(testCustomer3));
	}
}
