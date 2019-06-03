package com.bcg.dv.shoppingcart.promotion;

import com.bcg.dv.shoppingcart.model.Cart;
import com.bcg.dv.shoppingcart.model.Item;

public class BuyMoreHaveDiscountPromotion extends Promotion {
	private Long qty;
	private Double discount;

	public BuyMoreHaveDiscountPromotion(String itemSKU, Long qty, Double discount) {
		this.itemSKU = itemSKU;
		this.qty = qty;
		this.discount = discount;
	}

	@Override
	public Double calculate(Cart cart, Item item, Long quantity) {
		double totalPrice = item.getPrice() * quantity;

		if (quantity >= qty) {
			totalPrice = totalPrice * (1 - discount);
		}

		return totalPrice;
	}
}