package com.bcg.dv.shoppingcart.promotion;

import com.bcg.dv.shoppingcart.data.ItemData;
import com.bcg.dv.shoppingcart.model.Cart;
import com.bcg.dv.shoppingcart.model.Item;

public class BuyOneGetOnePromotion extends Promotion {
	private String freeItemSKU;

	public BuyOneGetOnePromotion(String itemSKU, String freeItemSKU) {
		this.itemSKU = itemSKU;
		this.freeItemSKU = freeItemSKU;
	}

	@Override
	public Double calculate(Cart cart, Item item, Long quantity) {
		double totalPrice = item.getPrice() * quantity;

		Item freeItem = ItemData.get(freeItemSKU);

		if (freeItem.getInventoryQty() >= 1) {
			freeItem.setInventoryQty(freeItem.getInventoryQty() - 1);

			if (cart.getItems().containsKey(freeItem)) {
				cart.getItems().compute(freeItem, (p,q) -> q+1);
			}
			else cart.getItems().put(freeItem, 1l);
		}

		return totalPrice;
	}
}