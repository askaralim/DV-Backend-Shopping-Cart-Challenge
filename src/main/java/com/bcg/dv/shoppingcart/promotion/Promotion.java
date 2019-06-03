package com.bcg.dv.shoppingcart.promotion;

import com.bcg.dv.shoppingcart.model.Cart;
import com.bcg.dv.shoppingcart.model.Item;

public abstract class Promotion {
	protected String itemSKU;

	public abstract Double calculate(Cart cart, Item item, Long quantity);

	public String getItemSKU() {
		return itemSKU;
	}
}