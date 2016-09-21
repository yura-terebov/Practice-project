package the_connection_odjects;

import java.util.ArrayList;

public class Item {
	private static ArrayList<Item> allItems = new ArrayList<Item>();
	private  ArrayList<Order> allOrders = new ArrayList<Order>();
	
	public Item(Category category) {
		category.add(this);
		Item.allItems.add(this);
	}
	
	public ArrayList<Item> getAllItems() {
		return (ArrayList<Item>) Item.allItems.clone();
	}
	
	public ArrayList<Order> getAllOrders() {
		return (ArrayList<Order>) this.allOrders.clone();
	}
	

	public void add(Order r) {
		this.allOrders.add(r);
	}
}
