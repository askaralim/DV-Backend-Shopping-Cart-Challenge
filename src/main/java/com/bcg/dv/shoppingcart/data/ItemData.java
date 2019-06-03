package com.bcg.dv.shoppingcart.data;

import com.bcg.dv.shoppingcart.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ItemData {
	private static ConcurrentHashMap<String, Item> items = new ConcurrentHashMap<>();

	static{
		Item googleHome = new Item("120P90", "Google Home", 49.99, 10);
		Item macbookPro = new Item("43N23P", "MacBook Pro", 5399.99, 5);
		Item alexaSpeaker = new Item("A304SD", "Alexa Speaker", 109.50, 10);
		Item raspberryPiB = new Item("234234", "Raspberry Pi B", 30.00, 2);

		items.put(googleHome.getSku(), googleHome);
		items.put(macbookPro.getSku(), macbookPro);
		items.put(alexaSpeaker.getSku(), alexaSpeaker);
		items.put(raspberryPiB.getSku(), raspberryPiB);
	}

	public static List<Item> getItems() {
		List<Item> list = new ArrayList<>();

		for (String id : items.keySet()) {
			list.add(items.get(id));
		}

		return list;
	}

	public static Item get(String sku) {
		return items.get(sku);
	}

	public static void add(Item item) {
		items.put(item.getSku(), item);
	}

	public static void update(Item item) {
		items.put(item.getSku(), item);
	}

	public static void delete(String itemSku) {
		items.remove(itemSku);
	}
}