package com.bcg.dv.shoppingcart.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	protected Map<Item, Long> items;
	protected Double totalPrice;

	public Cart() {
		items = new LinkedHashMap<>();
	}

	public Map<Item, Long> getItems() {
		return items;
	}

	public void setItems(Map<Item, Long> items) {
		this.items = items;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}