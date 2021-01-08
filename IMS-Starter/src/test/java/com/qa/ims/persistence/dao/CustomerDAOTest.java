package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;



public class CustomerDAOTest {

	private final CustomerDAO DAO = new CustomerDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Customer created = new Customer(2L, "Jake", "Reid");
		System.out.println("Test Create");
		Customer new_customer = DAO.create(created);

		System.out.println(created);
		System.out.println(new_customer);

		assertEquals(created, new_customer);
		
		//assert.AreEqual(created,new_customer);
		//AssertThat(created, is(new_customer));
	}

	@Test
	public void testReadAll() {
		List<Customer> expected = new ArrayList<>();
		expected.add(new Customer(1L, "jordan", "harrison"));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		System.out.println("Read Latest");
		//this.testCreate();
		
		Customer new_customer = new Customer(1L, "jordan", "harrison");
		Customer last_customer = DAO.readLatest();
		System.out.println("Test");
		System.out.println(new_customer);
		System.out.println(last_customer);
		assertEquals(new_customer, last_customer);
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Customer(ID, "jordan", "harrison"), DAO.readCustomer(ID));
	}

	@Test
	public void testUpdate() {
		final Customer updated = new Customer(1L, "jordan", "harrison");
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
