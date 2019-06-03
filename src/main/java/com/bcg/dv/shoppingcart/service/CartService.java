package com.bcg.dv.shoppingcart.service;

import com.bcg.dv.shoppingcart.model.Item;
import com.bcg.dv.shoppingcart.model.Order;

import java.util.Map;

public interface CartService {
	void addItem(String itemSku) throws Exception;
	Map<Item, Long> getItems();
	void removeItem(String itemSku);
	void clear();
	Order checkout();
}
