package com.bcg.dv.shoppingcart.model;

public class Item {
	private String sku;
	private String name;
	private double price;
	private int inventoryQty;

	public Item(String sku, String name, double price, int inventoryQty) {
		this.sku = sku;
		this.name = name;
		this.price = price;
		this.inventoryQty = inventoryQty;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInventoryQty() {
		return inventoryQty;
	}

	public void setInventoryQty(int invetoryQty) {
		this.inventoryQty = invetoryQty;
	}
}