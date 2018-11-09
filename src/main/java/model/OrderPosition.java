package model;

public class OrderPosition {
	private long itemId;
	private String name;
	private double price;
	private int count;
	private double total;
	
	public int getCount() {
		return count;
	}
	public long getItemId() {
		return itemId;
	}
	public double getPrice() {
		return price;
	}
	public double getTotal() {
		return total;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
