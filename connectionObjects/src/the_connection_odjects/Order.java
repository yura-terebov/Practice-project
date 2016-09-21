package the_connection_odjects;

import java.util.ArrayList;

public class Order {
	private ArrayList<Item> items;
	private static ArrayList<Order> allOrders = new ArrayList<Order>();
	
	public Order(Item item, Customer customer) {
		items = new ArrayList<Item>();
		add(item);
		item.add(this);
		
		customer.add(this);
		
		Order.allOrders.add(this);
	}

	public ArrayList<Item> getItems() {
		return (ArrayList<Item>) this.items.clone();
	}
	
	public ArrayList<Order> getAllOrders() {
		return (ArrayList<Order>) this.allOrders.clone();
	}
	
	public void add(Item i) {
		this.items.add(i);
		i.add(this);
	}
	
	public void delete(Item i) {
		this.items.remove(i);
	}

}
