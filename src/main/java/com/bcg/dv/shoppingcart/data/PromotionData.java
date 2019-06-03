package com.bcg.dv.shoppingcart.data;

import com.bcg.dv.shoppingcart.promotion.BuyMoreByLessPricePromotion;
import com.bcg.dv.shoppingcart.promotion.BuyMoreHaveDiscountPromotion;
import com.bcg.dv.shoppingcart.promotion.BuyOneGetOnePromotion;
import com.bcg.dv.shoppingcart.promotion.Promotion;

import java.util.ArrayList;
import java.util.List;

public class PromotionData {
	private static List<Promotion> promotions = new ArrayList<>();

	static{
		Promotion macbookProPromotion = new BuyOneGetOnePromotion("43N23P", "234234");
		Promotion googleHomePromotion = new BuyMoreByLessPricePromotion("120P90", 3l, 2l);
		Promotion alexaSpeakerPromotion = new BuyMoreHaveDiscountPromotion("A304SD", 3l, 0.1);

		promotions.add(macbookProPromotion);
		promotions.add(googleHomePromotion);
		promotions.add(alexaSpeakerPromotion);
	}

	public static Promotion get(String itemSKU) {
		for (Promotion promotion : promotions) {
			if (promotion.getItemSKU().equals(itemSKU)) {
				return promotion;
			}
		}
		return null;
	}

	public static void add(Promotion promotion) {
		promotions.add(promotion);
	}

	public static void delete(Promotion promotion) {
		promotions.remove(promotion);
	}
}
