package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usersession {
	static Customer customer;
	public static void main(String[] args) {
		customer = new Customer();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Welcome to The Book Shop");
			System.out.println("Select an option to Continue");

			System.out.println("For User login, Enter 1");
			System.out.println("For User Registration, Enter 2");
			

			String userLoginOption = scanner.nextLine();
			if (userLoginOption.equals("1")) {
				loginScenario(scanner);
			} else if (userLoginOption.equals("2")) {
				userRegistration(scanner);
			} else {
			System.out.println("Please Restart and enter valid option ");
				System.exit(1);
			}
		}
	}

	public static void loginScenario(Scanner scanner) {

		System.out.print(" Enter user name => ");
		String userName = scanner.nextLine();

		System.out.print(" Enter password => ");
		String password = scanner.nextLine();
		User user = new User(userName, password);

		Customer customer = user.verifyLogin(userName, password);
		

		Book book = new Book();
		//book.initialzeBookData();
		List<Book> bookList = Utils.getBookData();

		if (customer != null) {
			System.out.println("List of Books to Select");
			System.out.println("Index--BookName--BookDescription--Author--BookPrice");
			for (int j = 0; j < bookList.size(); j++) {
				System.out.println(
						j + 1 + ". " + bookList.get(j).getProductName() + "--" + bookList.get(j).getDescription() + "--"
								+ bookList.get(j).getAuthor() + "--" + bookList.get(j).getPrice());
			}
			System.out.println(" Enter bookname to order => ");

			String selectedBook = scanner.nextLine();

			ShoppingCart cart = new ShoppingCart();
			for (int k = 0; k < bookList.size(); k++) {

				if (selectedBook.equals(bookList.get(k).getProductName())) {
					book = bookList.get(k);
				}
			}
			System.out.println("Enter Quantity: ");
			String quantity = scanner.nextLine();
			cart.addCartItem(book, customer, Integer.parseInt(quantity));

			System.out.println("Enter yes to proceed to checkout?");
			String checkoutoption = scanner.nextLine();
			if (checkoutoption.equalsIgnoreCase("yes")) {
				Order order = new Order();
				order.checkOut(book, customer, Integer.parseInt(quantity));
				System.out.println("Order Placed Successfully");
			}

		}

	}

	public static void userRegistration(Scanner scanner) {
		System.out.println("Enter UserEmail=>");
		Customer customer = new Customer();
		String userid = scanner.nextLine();
		customer.setEmail(userid);
		customer.setUserId(userid);
		System.out.println("Enter Password=>");
		customer.setPassword(scanner.nextLine());
		customer.setLoginStatus("true");
		System.out.println("Enter Full Name=>");
		customer.setCustomerName(scanner.nextLine());
		System.out.println("Enter Address");
		customer.setAddress(scanner.nextLine());
		System.out.println("Enter CreditCardinfo=>");
		customer.setCreditCardInfo(scanner.nextLine());
		System.out.println("Enter Shipping Info=>");
		customer.setShippingInfo(scanner.nextLine());
		System.out.println("Enter Phone No.");
		customer.setPhoneNo(Integer.parseInt(scanner.nextLine()));
		customer.setBlacklisted(false);

		System.out.println("Enter yes to create a account");
		if (scanner.nextLine().equalsIgnoreCase("yes")) {
			Utils.addNewUser(customer);
			System.out.println("User created successfully");
		}

	}
}
