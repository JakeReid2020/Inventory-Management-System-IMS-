package com.qa.ims.persistence.domain;

public class Item {
	
	private Long id;
	private String title;
	private Double price;
	private Long quantity;

	public Item(Long id, String title, Double price, Long quantity) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}


	public Item(String title, Double price, Long quantity) {
		super();
		this.id = 1L;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Item(String title, Double price) {
		super();
		this.id = 1L;
		this.title = title;
		this.price = price;
		this.quantity = 1L;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "id:" + id + " title:" + title + " price = £" + price + ",quantity=" + quantity ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
