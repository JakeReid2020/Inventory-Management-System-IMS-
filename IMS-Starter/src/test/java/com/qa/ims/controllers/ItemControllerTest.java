package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemContoller;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	
	@Mock
	private Utils utils;
	
	@Mock
	private ItemDAO itemdao;

	
	@InjectMocks
	private ItemContoller controller;
	
	@Test
	public void testCreate() {
		Item expected = new Item ("Gta",100.0,1L);
		Item created = new Item (1L,"Gta",100.0,1L);
		Mockito.when(utils.getString()).thenReturn ("GTA");
		Mockito.when(utils.getDouble()).thenReturn (100.0);
		Mockito.when(utils.getLong()).thenReturn (1L);
		Mockito.when(this.itemdao.create(Mockito.any())).thenReturn(created);
		
		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(utils, Mockito.times(1)).getLong();
	}
	
	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
	
		Mockito.when(itemdao.readAll()).thenReturn(items);

		assertEquals(items, controller.readAll());

		Mockito.verify(itemdao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testUpdate() {
		Item updated = new Item(1L,"Gta",100.0,1L);

		Mockito.when(this.utils.getLong()).thenReturn((1L), updated.getQuantity());
		Mockito.when(this.utils.getString()).thenReturn(updated.getTitle());
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getPrice());
		Mockito.when(this.itemdao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.itemdao, Mockito.times(1)).update(updated);
	}
	
	@Test
	public void testDelete() {
		final long ID = 1;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(itemdao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(itemdao, Mockito.times(1)).delete(ID);
	}

}
