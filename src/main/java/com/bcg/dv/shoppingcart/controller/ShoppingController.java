package com.bcg.dv.shoppingcart.controller;

import com.bcg.dv.shoppingcart.model.Order;
import com.bcg.dv.shoppingcart.service.CartService;
import com.bcg.dv.shoppingcart.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingController {
	private static Logger logger = LoggerFactory.getLogger(ShoppingController.class);

	@Autowired
	private ItemService itemService;

	@Autowired
	private CartService cartService;

	@RequestMapping("/")
	public String index() {
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("items" , itemService.getItems());
		return "home";
	}

	@RequestMapping("/addToCart")
	public String addToCart( String itemSku) {
		try {
			cartService.addItem(itemSku);
		}
		catch (Exception e) {
			logger.warn(e.getMessage());
		}

		return "redirect:/home";
	}

	@RequestMapping("/myCart")
	public String myCart(Model model) {
		model.addAttribute("items" , cartService.getItems());
		return "cart";
	}

	@RequestMapping("/checkout")
	public String checkout(Model model) {
		Order order = cartService.checkout();
		model.addAttribute("order" , order);
		return "order";
	}
}