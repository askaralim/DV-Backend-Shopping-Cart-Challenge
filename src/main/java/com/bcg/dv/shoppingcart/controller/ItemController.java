package com.bcg.dv.shoppingcart.controller;

import com.bcg.dv.shoppingcart.model.Item;
import com.bcg.dv.shoppingcart.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("/addItem")
	public String addItem() {
		return "";
	}

	@RequestMapping("/saveItem")
	public String saveItem(Item item) {
		itemService.add(item);
		return "home";
	}
}