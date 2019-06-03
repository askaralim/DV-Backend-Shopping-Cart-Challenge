package com.bcg.dv.shoppingcart.service;

import com.bcg.dv.shoppingcart.model.Item;

import java.util.List;

public interface ItemService {
	List<Item> getItems();
	void add(Item item);
	void update(Item item);
	void delete(String id);
}