package model;

public class CartItem {
	
	private String name;
	private int productId;
	private int quantity;
	private float unitCost;
	private float subTotal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(float unitCost) {
		this.unitCost = unitCost;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	public CartItem(String name, int productId, int quantity, float unitCost, float subTotal) {
		super();
		this.name = name;
		this.productId = productId;
		this.quantity = quantity;
		this.unitCost = unitCost;
		this.subTotal = subTotal;
	}
	
	
	

}
