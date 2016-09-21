package the_connection_odjects;

import java.util.ArrayList;

public class Customer {
	private ArrayList<Order> orders;
	private static ArrayList<Customer> allCustomers = new ArrayList<Customer>();
	
	public Customer() {
		this.orders = new ArrayList<Order>();
		Customer.allCustomers.add(this);
	}
	
	public ArrayList<Customer> getAllCustomer() {
		return (ArrayList<Customer>) Customer.allCustomers.clone();
	}
	
	public ArrayList<Order> getOrders() {
		return (ArrayList<Order>) this.orders.clone();
	}
	
	public void add(Order r) {
		this.orders.add(r);
	}
	
	public void createNewOrder(Item item) {
		Order order = new Order(item, this);
	}
}
