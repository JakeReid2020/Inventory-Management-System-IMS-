package com.qa.ims.controller;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.utils.Utils;

public class ItemContoller implements CrudController<Item>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO;
	private Utils utils;

	public ItemContoller(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	@Override
	public Item create() {
		LOGGER.info("Please enter a item title");
		String title = utils.getString();
		LOGGER.info("Please item price");
		Double price = utils.getDouble();
		LOGGER.info("Please item quantity");
		Long quantity = utils.getLong();
		Item item = itemDAO.create(new Item(title, price, quantity));
		LOGGER.info("Item created");
		return item;
	}

	@Override
	public Item update() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item.toString());
		}
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a item title");
		String title = utils.getString();
		LOGGER.info("Please enter a price");
		double price = utils.getDouble();
		LOGGER.info("please enter the quantity of stock");
		Long quantity = utils.getLong();
		Item item = itemDAO.update(new Item(id, title, price, quantity));
		LOGGER.info("Item Updated");
		return item;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		LOGGER.info(id + "Item Deleted");
		return itemDAO.delete(id);
		
	}

	


}
