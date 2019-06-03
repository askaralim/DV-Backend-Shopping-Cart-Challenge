package com.bcg.dv.shoppingcart.service.impl;

import com.bcg.dv.shoppingcart.data.ItemData;
import com.bcg.dv.shoppingcart.data.PromotionData;
import com.bcg.dv.shoppingcart.model.Cart;
import com.bcg.dv.shoppingcart.model.Item;
import com.bcg.dv.shoppingcart.model.Order;
import com.bcg.dv.shoppingcart.promotion.Promotion;
import com.bcg.dv.shoppingcart.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
	private static Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

	static Cart cart = new Cart();

	@Override
	public void addItem(String itemSku) throws Exception {
		Item item = ItemData.get(itemSku);

		if (item.getInventoryQty() < 1) {
			throw new Exception(item.getName() + " is sold out.");
		}

		item.setInventoryQty(item.getInventoryQty() - 1);

		if (cart.getItems().containsKey(item)) {
			cart.getItems().compute(item, (p,q) -> q+1);
		}
		else cart.getItems().put(item, 1l);

		calculateTotalPrice(cart);
	}

	@Override
	public Map<Item, Long> getItems() {
		return cart.getItems();
	}

	@Override
	public void removeItem(String itemSku) {
		cart.getItems().remove(itemSku);
	}

	@Override
	public void clear() {
		cart.getItems().clear();
	}

	@Override
	public Order checkout() {
		Order order = new Order(cart.getItems(), cart.getTotalPrice());

		logger.info(order.toString() + ", reset cart.");
		clear();

		return order;
	}

	private void calculateTotalPrice(Cart cart) {
		double totalPrice = 0d;
		Map<Item, Long> itemMap = cart.getItems();

		for (Item item : itemMap.keySet()) {
			double itemPrice = 0d;
			long quantity = itemMap.get(item);

			Promotion promotion = PromotionData.get(item.getSku());

			if (promotion != null) {
				itemPrice = promotion.calculate(cart, item, quantity);
			}
			else itemPrice = item.getPrice() * quantity;

			totalPrice += itemPrice;
		}

		cart.setTotalPrice(totalPrice);
	}
}
