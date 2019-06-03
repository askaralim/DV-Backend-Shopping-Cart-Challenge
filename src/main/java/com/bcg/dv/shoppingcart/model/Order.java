package com.bcg.dv.shoppingcart.model;

import java.util.Map;
import java.util.stream.Collectors;

public class Order extends Cart {
	public Order(Map<Item, Long> items, Double totalPrice) {
		this.items = items.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(),  e -> e.getValue()));

		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(50);

		sb.append("Order is created, contains ");

		for (Item item : items.keySet()) {
			sb.append(item.getName());
			sb.append(" * ");
			sb.append(items.get(item));
			sb.append(", ");
		}

		sb.append(", totalPrice is $");
		sb.append(totalPrice);
		sb.append(".");

		return sb.toString();
	}
}