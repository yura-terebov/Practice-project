package the_connection_odjects;

import java.util.ArrayList;

public class Category {
	private ArrayList<Item> items;
	private static ArrayList<Category> allCategories = new ArrayList<Category>();
	
	public Category() {
		this.items = new ArrayList<Item>();
		Category.allCategories.add(this);
	}
	
	public ArrayList<Item> getItems() {
		return (ArrayList<Item>) this.items.clone();
	}
	
	public ArrayList<Category> getAllCategory() {
		return (ArrayList<Category>) Category.allCategories.clone();
	}
	
	public void add(Item i) {
		this.items.add(i);
	}
	
	public void delete(Item i) {
		this.items.remove(i);
	}
	
	public void show() {
	    for (Item current : this.items) {
	        System.out.print(current + ", ");
	    }
	    System.out.println("\n");
	}
}
