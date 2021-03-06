// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package model;

import java.util.List;

/************************************************************/
/**
 * 
 */
public class Admin extends User {

	public Admin(String userId, String password, String loginStatus, String name, String email) {
		super(userId, password, loginStatus);
		this.name = name;
		this.email = email;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String email;

	/**
	 * 
	 */
	public void addMember(Customer customer) {
		Utils.addNewUser(customer);
	}

	/**
	 * 
	 */
	public void deleteMember(String userId) {
		Utils.deleteUser(userId);
	}

	/**
	 * 
	 */
	public void addBook(Book book) {
		Utils.addNewBook(book);
	}

	/**
	 * 
	 */
	public void deleteBook(String bookName) {
		Utils.deleteBook(bookName);
	}

	/**
	 * 
	 */
	public void addGenre() {
		System.out.println("Method to Add Genre to DB");
	}

	/**
	 * 
	 */
	public void deleteGenre() {
		System.out.println("Method to Delete Genre to DB");
	}

	/**
	 * 
	 * @param c
	 */
	public void addBlacklistedCustomer(Customer c) {

		c.setBlacklisted(true);

	}

	/**
	 * 
	 * @param c
	 */
	public void removeBlacklistedCustomer(Customer c) {

		c.setBlacklisted(false);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Admin verifyAdminLogin(String userId, String password) {

		List<Admin> adminListDB = Utils.getAdminData();
		Admin admin = new Admin();
		boolean loginStatus = false;
		for (int i = 0; i < adminListDB.size(); i++) {

			if (userId.equalsIgnoreCase(adminListDB.get(i).getEmail())) {
				System.out.println(adminListDB.get(i).getEmail());
				if (password.equals(adminListDB.get(i).getPassword())) {
					System.out.println("Successful Login");
					admin = adminListDB.get(i);
					break;
				} else {
					System.out.println(" Invalid Username or Password ");
					System.out.println("Please Rerun the system to start again.");
					System.exit(1);
				}

			} else {
				System.out.println(" Invalid Username or Password ");
				System.out.println("Please Rerun the system to start again.");
				System.exit(1);
			}
		}
		return admin;

	}

}
