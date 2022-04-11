package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

class OCLDriverTest {

	@Test
	void test() {

		Customer sarfaraz = new Customer("sarfaraz94", "abcd1234", "true", "1455 de massoinevve", "Sarfaraz",
				"sarfaraz94@xyz.com", "1234567890123456", "1455 de massoinevve", 1145145141, false);

		Customer fazil = new Customer("fazil94", "12345678", "true", "1454 de massoinevve", "Fazil", "fazil94@xyz.com",
				"1234567890123456", "1454 de massoinevve", 1145145142, false);
		// blackListed Customer
		Customer blackListedCustomer = new Customer("fazil94", "12345678", "true", "1454 de massoinevve", "Fazil",
				"fazil94@xyz.com", "1234567890123456", "1454 de massoinevve", 1145145142, true);

		Genre comic = new Genre("comic", "DC and Marvel comic books", 1234);

		List<String> bookGenreList = new ArrayList<>();

		bookGenreList.add("horror");
		bookGenreList.add("comics");
		bookGenreList.add("Adventure");
		bookGenreList.add("fantasy");
		bookGenreList.add("Action");
		// To verify fail scenario
		// bookGenreList.add("drama");

		System.out.println(bookGenreList.size());
		Genre genre = new Genre();

		Book batmanBook = new Book("TheBatman", bookGenreList, "Adam West", "Story of a Batman in gotham",
				"TheBatmanPhoto", 101, 100);
		Book spiderManBook = new Book("TheBatman", bookGenreList, "Stan Lee", "Story of a Spiderman",
				"TheSpiderManPhoto", 102, 50);

		ShoppingCart cart1 = new ShoppingCart(201, 301, 3, "26-02-2022", 150);

		List<Book> bookList = new ArrayList<>();
		bookList.add(batmanBook);
		bookList.add(spiderManBook);

		// OCL-I and OCL-II. All Admin and user email must be unique.

		User admin1 = new Admin("1234", "asfer128", "true", "fazil", "fazil@gmail.com");
		User admin2 = new Admin("12345", "asfer2312", "true", "sohail", "sohail@gmail.com");
		User user = new User();
		List<User> list1 = new ArrayList<>();
		list1.add(admin1);
		list1.add(admin2);
		list1.add(fazil);
		list1.add(sarfaraz);
		boolean uniqueUserFlag = user.verifyUniqueUser(list1);
		assertEquals(true, uniqueUserFlag);

		// OCl-IV constraint for 5 Genre Books
		List<String> genreList = new ArrayList<>();

		genreList.add("horror");
		genreList.add("comics");
		genreList.add("Adventure");
		genreList.add("fantasy");
		genreList.add("Action");

		boolean genreFlag = genre.getAllBooks(bookList);
		assertEquals(true, genreFlag);

		// OCL-V. The user's password should be at least 8 characters long.
		boolean passwordFlag = user.verifyPassword(list1);
		assertEquals(true, passwordFlag);

		// OCL-VII. When customer place an order, it should be added to the orders of
		// that customer.
		Order order = new Order();
		assertEquals(true, order.updateOrder(spiderManBook, sarfaraz));

		// OCL-X. Calling the addCartitem method in the ShoppingCart class, adds an item
		// to cart if it already does not exist in the cart
		boolean value1 = cart1.ocladdCartItem(batmanBook, sarfaraz);
		// For BlackListedCustomer- book will be not be added
		// boolean value1 = cart1.addCartItem(batmanBook,blackListedCustomer);

		cart1.ocladdCartItem(spiderManBook, sarfaraz);
		// cart1.addCartItem(spiderManBook,sarfaraz);
		assertEquals(true, value1);

		// OCL-IX. Calling the calcTotalPrice method in the ShoppingCart class,
		// calculates all the prices again everytime
		cart1.calcTotalPrice(bookList, sarfaraz);

		cart1.checkOut(bookList, sarfaraz);
		// OCL-VIII. Calling the deleteCartitem method in the ShoppingCart class,
		// deletes an item from cart if it already exists in the cart.
		boolean value11 = cart1.deleteCartItem(batmanBook);
		assertEquals(true, value11);

		cart1.viewCartDetails();
		cart1.updateQuantity();

		// ShoppingCart cart2= new ShoppingCart(202, 302, 3, "27-02-2022", 160);
		Order order1 = new Order("12021994", "12031994", fazil.getCustomerName(), fazil.getUserId(), "ordered",
				343223213, 12343);

		int quantity = 10;
		OrderDetail orderdetail = new OrderDetail(spiderManBook.getProductName(), order1.getOrderId(),
				cart1.getProductId(), quantity, spiderManBook.getPrice(), quantity * spiderManBook.getPrice(),
				spiderManBook);

		// OCL- VI. A Shopping cart cannot have more than 100 books
		// OCL-III. Customer cannot have more than 100 orders at a time
		Order orderObj= new Order();
		List<Order> orderList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			orderList.add(i, new Order("12021994", "12031994", fazil.getCustomerName(), fazil.getUserId(), "ordered",
					343223213, 12343));
		}
		System.out.println(orderList.size());
		// orderList.add(100,new Order("12021994", "12031994",fazil.getCustomerName(),
		// fazil.getUserId(), "ordered", "343223213", 12343));
		boolean orderFlag = orderObj.verifyOrderLimit(orderList);

		assertEquals(true, orderFlag);

		// OCL-XI. All ISBNs of the books should be unique.
		List<Book> bookISBNList = new ArrayList<>();
		bookISBNList.add(spiderManBook);
		bookISBNList.add(batmanBook);
		Book book = new Book();
		boolean value41 = book.verifyuniqueISBN(bookISBNList);
		assertEquals(true, value41);

		//OCL-XII If a Customer is blacklisted, then that customer can no longer order books
		// OCL-XIII. Calling addBlacklistedCustomer() method in the Admin class, will
		// add a user to the black list.
		Admin admin = new Admin();
		admin.addBlacklistedCustomer(sarfaraz);
		boolean value46 = cart1.ocladdCartItem(spiderManBook, sarfaraz);
		assertEquals(true, value46);

		// OCL-XIV. Calling removeBlacklistedCustomer() method in the Admin class, will
		// remove a user from the black list
		admin.removeBlacklistedCustomer(sarfaraz);
		boolean value451 = cart1.ocladdCartItem(spiderManBook, sarfaraz);
		assertEquals(true, value451);

	}

}
