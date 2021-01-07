package com.qa.ims.persistence.domain;

import java.util.List;

public class Order {

	private Long id;
	private Long customerid;
	private List<Item> items;
	
	public Order(Long id, Long customerid, List<Item>items) {
		super();
		this.id = id;
		this.customerid = customerid;
		this.items = items;
	}
	
	public Order(Long customerid) {
		super();
		this.id = 0L;
		this.customerid = customerid;
	}


	public Long getcustomerid() {
		// TODO Auto-generated method stub
		return customerid;
	}

	public void setcustomerid(Long customerid) {
		this.customerid = customerid;
	}

	public void setID (Long id) {
	 this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItem(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		String lines = "\n";
		double totalPrice = 0.0;
		for (Item item : items) {
			totalPrice += item.getPrice();
			lines += item.toString() + " \n";
		}
		return "Order [id=" + id + ", customer_id=" + customerid + ", Items: " + lines + " Total Price: £" + totalPrice + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customerid == null) {
			if (other.customerid != null)
				return false;
		} else if (!customerid.equals(other.customerid))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

}
