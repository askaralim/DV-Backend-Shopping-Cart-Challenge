package com.bcg.dv.shoppingcart.service.impl;

import com.bcg.dv.shoppingcart.data.ItemData;
import com.bcg.dv.shoppingcart.model.Item;
import com.bcg.dv.shoppingcart.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

	@Override
	public List<Item> getItems() {
		return ItemData.getItems();
	}

	@Override
	public void add(Item item) {
		ItemData.add(item);
	}

	@Override
	public void update(Item item) {
		ItemData.update(item);
	}

	@Override
	public void delete(String id) {
		ItemData.delete(id);
	}
}
