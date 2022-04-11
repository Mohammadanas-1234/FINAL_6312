// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package model;

import java.util.ArrayList;
import java.util.List;

/************************************************************/
/**
 * 
 */
public class Customer extends User {
	
	public Customer(String userId, String password, String loginStatus, String address, String customerName,
			String email, String creditCardInfo, String shippingInfo, int phoneNo, boolean isBlacklisted) {
		super(userId, password, loginStatus);
		this.address = address;
		this.customerName = customerName;
		this.email = email;
		this.creditCardInfo = creditCardInfo;
		this.shippingInfo = shippingInfo;
		this.phoneNo = phoneNo;
		this.isBlacklisted = isBlacklisted;
	}
	
	public Customer(String userId,String password) {
		super(userId, password);
		
		
	
		// TODO Auto-generated constructor stub
	}


	public Customer() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 */
	private String address;
	/**
	 * 
	 */
	private String customerName;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String creditCardInfo;
	/**
	 * 
	 */
	private String shippingInfo;
	/**
	 * 
	 */
	private int phoneNo;
	/**
	 * 
	 */
	private boolean isBlacklisted;
	 private List<Book> shoppingCartList;
	

	public List<Book> getShoppingCartList() {
		return shoppingCartList;
	}

	public void setShoppingCartList(List<Book> shoppingCartList) {
		this.shoppingCartList = shoppingCartList;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreditCardInfo() {
		return creditCardInfo;
	}

	public void setCreditCardInfo(String creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}

	public String getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(String shippingInfo) {
		this.shippingInfo = shippingInfo;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public boolean isBlacklisted() {
		return isBlacklisted;
	}

	public void setBlacklisted(boolean isBlacklisted) {
		this.isBlacklisted = isBlacklisted;
	}

	/**
	 * 
	 */
	public void register(Customer customer) {
		Utils.addNewUser(customer);
		
	}

	/**
	 * 
	 */
	public void login(String userId,String password ) {
		Customer customer= new Customer();
		customer.verifyLogin(userId, password);
		
		
		
	}

	/**
	 * 
	 */
	public void updateProfile() {
		System.out.println("Method to update existing profile");
		
	}

	/**
	 * 
	 */
	public void placeOrder(Customer user, Order order, OrderDetail orderDetail) {
		Utils.addNewOrder(user, order, orderDetail);
		
	}
}