package com.bcg.dv.shoppingcart.promotion;

import com.bcg.dv.shoppingcart.model.Cart;
import com.bcg.dv.shoppingcart.model.Item;

public class BuyMoreByLessPricePromotion extends Promotion {
	private Long buyQty;
	private Long offerQty;

	public BuyMoreByLessPricePromotion(String itemSKU, Long buyQty, Long offerQty) {
		this.itemSKU = itemSKU;
		this.buyQty = buyQty;
		this.offerQty = offerQty;
	}

	@Override
	public Double calculate(Cart cart, Item item, Long quantity) {
		double totalPrice = (quantity / buyQty) * offerQty * item.getPrice() + (quantity % buyQty) * item.getPrice();

		return totalPrice;
	}
}