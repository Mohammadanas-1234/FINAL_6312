package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminSession {
	static Customer customer;

	public static void main(String[] args) {
		customer = new Customer();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Welcome to The Book Shop");

			System.out.print(" Enter Admin user name => ");
			String userName = scanner.nextLine();

			System.out.print(" Enter Admin password => ");
			String password = scanner.nextLine();

			Admin admin = new Admin();
			Admin adminData = admin.verifyAdminLogin(userName, password);

			System.out.println("Enter option to select the action");
			System.out.println("1. Add New Book");
			System.out.println("2. Delete  Book");
			System.out.println("3. Add New User");
			System.out.println("4. Delete  User");
			System.out.println("Enter any other key to Logout");

			String adminActions = scanner.nextLine();
			if (adminActions.equals("1")) {
				addNewBook(scanner);
			} else if (adminActions.equals("2")) {
				deleteBook(scanner);
			} else if (adminActions.equals("3")) {
				addNewUser(scanner);
			} else if (adminActions.equals("4")) {
				deleteUser(scanner);
			} else {
				System.out.println("Successfully Logged Out");
				System.exit(1);

			}
		}
	}

	public static void addNewBook(Scanner scanner) {
		Book book = new Book();
		System.out.println("Enter BookName");
		book.setProductName(scanner.nextLine());
		System.out.println("Enter Book Description");
		book.setDescription(scanner.nextLine());
		System.out.println("Enter Author Name");
		book.setAuthor(scanner.nextLine());
		System.out.println("Enter Price");
		book.setPrice(Integer.parseInt(scanner.nextLine()));
		System.out.println("Enter Genres");
		List<String> genreList = new ArrayList<>();
		genreList.add(scanner.nextLine());
		book.setGenre(genreList);
		System.out.println("Enter Yes to confirm to add a new book");
		if (scanner.nextLine().equalsIgnoreCase("yes")) {
			Utils.addNewBook(book);
			System.out.println("Book added to the DataBase Successfully");
		}

	}

	public static void addNewUser(Scanner scanner) {
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

	public static void deleteBook(Scanner scanner) {
		List<Book> bookList = Utils.getBookData();

		if (customer != null) {
			System.out.println("List of Books to Select");
			System.out.println("Index--BookName--BookDescription--Author--BookPrice");
			for (int j = 0; j < bookList.size(); j++) {
				System.out.println(
						j + 1 + ". " + bookList.get(j).getProductName() + "--" + bookList.get(j).getDescription() + "--"
								+ bookList.get(j).getAuthor() + "--" + bookList.get(j).getPrice());
			}
			System.out.println(" Enter bookname to Delete => ");
			Utils.deleteBook(scanner.nextLine());
			System.out.println("Book Deleted Successfully from DataBase");

		}
	}

	public static void deleteUser(Scanner scanner) {
		List<Customer> userList = Utils.getUserData();

		if (customer != null) {
			System.out.println("Index--UserId--UserName");
			for (int j = 0; j < userList.size(); j++) {
				System.out
						.println(j + 1 + ". " + userList.get(j).getUserId() + "--" + userList.get(j).getCustomerName());
			}
			System.out.println(" Enter UserName to Delete => ");
			Utils.deleteUser(scanner.nextLine());
			System.out.println("User Deleted Successfully from Database");

		}
	}
}
