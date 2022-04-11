package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {

	public static String excelFilePath = "src/model/COEN6312 DataFile.xlsx";

	public static List<Customer> getUserData() {
		List<Customer> userList = new ArrayList<>();
		
		
		try {

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			Customer user;

			for (int i = 1; i <= rowCount; i++) {
				Row row = sheet.getRow(i);
				user = new Customer();
				if (row.getCell(9).getStringCellValue().equalsIgnoreCase("Y")) {
					user.setUserId(row.getCell(0).getStringCellValue());
					user.setEmail(row.getCell(0).getStringCellValue());
					user.setPassword(row.getCell(1).getStringCellValue());
					user.setLoginStatus(row.getCell(2).getStringCellValue());
					user.setAddress(row.getCell(3).getStringCellValue());
					user.setCustomerName(row.getCell(4).getStringCellValue());
					user.setCreditCardInfo(row.getCell(5).getStringCellValue());
					user.setShippingInfo(row.getCell(6).getStringCellValue());
					user.setPhoneNo(Integer.parseInt(row.getCell(7).getStringCellValue()));
					user.setBlacklisted(Boolean.parseBoolean(row.getCell(8).getStringCellValue()));

					userList.add(user);
				}
			}
			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;

	}

	public static List<ShoppingCart> getCartData(String userId) {
		List<ShoppingCart> ShoppingCartList = new ArrayList<>();
		try {

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(3);
			int rowCount = sheet.getLastRowNum();
			ShoppingCart ShoppingCart = new ShoppingCart();
			for (int i = 1; i <= rowCount; i++) {
				Row row = sheet.getRow(i);
				if (row.getCell(1).getStringCellValue().equalsIgnoreCase(userId)) {
					ShoppingCart.setCartId(Integer.parseInt(row.getCell(0).getStringCellValue()));
					ShoppingCart.setQuantity(Integer.parseInt(row.getCell(4).getStringCellValue()));
					ShoppingCart.setTotalPrice(Integer.parseInt(row.getCell(5).getStringCellValue()));
					ShoppingCart.setDateAdded(row.getCell(6).getStringCellValue());
					ShoppingCartList.add(ShoppingCart);
				}
			}
			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ShoppingCartList;

	}

	public static List<List<Object>> getOrderData(String userId) {
		List<Object> orderList = new ArrayList<>();
		List<Object> orderDetailList = new ArrayList<>();
		List<List<Object>> orderFinalList = new ArrayList<>();
		try {

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(4);
			int rowCount = sheet.getLastRowNum();
			Order order = new Order();
			OrderDetail orderDetail = new OrderDetail();

			for (int i = 1; i <= rowCount; i++) {
				Row row = sheet.getRow(i);
				if (row.getCell(1).getStringCellValue().equalsIgnoreCase(userId)) {
					order.setOrderId(Integer.parseInt(row.getCell(0).getStringCellValue()));
					order.setDateCreated(row.getCell(7).getStringCellValue());
					order.setDateShipped(row.getCell(8).getStringCellValue());
					order.setStatus(row.getCell(9).getStringCellValue());
					order.setShippingId(Integer.parseInt(row.getCell(10).getStringCellValue()));
					orderDetail.setOrderId(Integer.parseInt(row.getCell(0).getStringCellValue()));
					orderDetail.setProductName(row.getCell(3).getStringCellValue());
					orderDetail.setProductId(Integer.parseInt(row.getCell(4).getStringCellValue()));
					orderDetail.setQuantity(Integer.parseInt(row.getCell(5).getStringCellValue()));
					orderDetail.setSubTotal(Integer.parseInt(row.getCell(6).getStringCellValue()));
					orderList.add(order);
					orderDetailList.add(orderDetail);
				}
			}
			inputStream.close();
			orderFinalList.add(orderList);
			orderFinalList.add(orderDetailList);
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderFinalList;

	}

	public static List<Book> getBookData() {
		List<Book> bookList = new ArrayList<>();
		try {

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(1);
			int rowCount = sheet.getLastRowNum();
			Book book;
			for (int i = 1; i <= rowCount; i++) {
				Row row = sheet.getRow(i);
				book = new Book();
				if (row.getCell(6).getStringCellValue().equalsIgnoreCase("Y")) {
					book.setISBN(Integer.parseInt(row.getCell(0).getStringCellValue()));
					book.setProductName(row.getCell(1).getStringCellValue());
					book.setDescription(row.getCell(2).getStringCellValue());
					book.setAuthor(row.getCell(3).getStringCellValue());
					book.setPrice(Integer.parseInt(row.getCell(4).getStringCellValue()));

					String csv = row.getCell(5).getStringCellValue();

					List<String> fixedLengthList = Arrays.asList(csv.split(","));
					book.setGenre(new ArrayList<String>(fixedLengthList));
					bookList.add(book);
				}
			}

			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;

	}

	public static List<Genre> getGenreData() {
		List<Genre> genreList = new ArrayList<>();
		try {

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(2);
			int rowCount = sheet.getLastRowNum();
			Genre genre = new Genre();
			for (int i = 1; i <= rowCount; i++) {
				Row row = sheet.getRow(i);

				genre.setGenreId(Integer.parseInt(row.getCell(0).getStringCellValue()));
				genre.setGenreName(row.getCell(1).getStringCellValue());
				genre.setDescription(row.getCell(2).getStringCellValue());
				genreList.add(genre);

			}
			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return genreList;

	}

	public static int addNewUser(Customer user) {
		int newUserId = 0;
		try {

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			newUserId = rowCount + 1;
			sheet.createRow(newUserId);

			Row row = sheet.getRow(rowCount + 1);
			row.createCell(0).setCellValue(user.getUserId());
			row.createCell(1).setCellValue(user.getPassword());
			row.createCell(2).setCellValue(user.getLoginStatus());
			row.createCell(3).setCellValue(user.getAddress());
			row.createCell(4).setCellValue(user.getCustomerName());
			row.createCell(5).setCellValue(user.getCreditCardInfo());
			row.createCell(6).setCellValue(user.getShippingInfo());
			row.createCell(7).setCellValue(String.valueOf(user.getPhoneNo()));
			row.createCell(8).setCellValue("true");
			row.createCell(9).setCellValue("Y");

			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return newUserId;

	}

	public static int addNewBook(Book book) {
		int newBookID = 0;
		try {

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(1);
			int rowCount = sheet.getLastRowNum();
			newBookID = rowCount + 1;
			sheet.createRow(newBookID);

			Row row = sheet.getRow(rowCount + 1);
			row.createCell(0).setCellValue(Integer.toString(newBookID));
			row.createCell(1).setCellValue(book.getProductName());
			row.createCell(2).setCellValue(book.getDescription());
			row.createCell(3).setCellValue(book.getAuthor());
			row.createCell(4).setCellValue(Integer.toString(book.getPrice()));
			String csv = book.getGenre().get(0);
			
			/*for (int i = 1; i < book.getGenreData().size(); i++) {
				csv = csv + "," + book.getGenreData().get(i);
			}*/
  System.out.println(csv);
			row.createCell(5).setCellValue(csv);
			row.createCell(6).setCellValue("Y");
			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return newBookID;

	}

	public static int addNewCartItem(Customer user, ShoppingCart shoppingCart) {
		int newCartId = 0;
		try {

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(3);
			int rowCount = sheet.getLastRowNum();
			newCartId = rowCount + 1;
			sheet.createRow(newCartId);

			Row row = sheet.getRow(rowCount + 1);
			row.createCell(0).setCellValue(Integer.toString(newCartId));
			row.createCell(1).setCellValue(user.getUserId());
			row.createCell(2).setCellValue(user.getCustomerName());
			row.createCell(3).setCellValue(Integer.toString(shoppingCart.getProductId()));
			row.createCell(4).setCellValue(Integer.toString(shoppingCart.getQuantity()));
			row.createCell(5).setCellValue(Integer.toString(shoppingCart.getTotalPrice()));
			row.createCell(6).setCellValue(String.valueOf(shoppingCart.getDateAdded()));

			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return newCartId;

	}

	public static int addNewOrder(Customer user, Order order, OrderDetail orderDetail) {
		int newOrderId = 0;
		try {

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(4);
			int rowCount = sheet.getLastRowNum();
			newOrderId = rowCount + 1;
			sheet.createRow(newOrderId);

			Row row = sheet.getRow(rowCount + 1);
			row.createCell(0).setCellValue(Integer.toString(newOrderId));
			row.createCell(1).setCellValue(user.getUserId());
			row.createCell(2).setCellValue(user.getCustomerName());
			row.createCell(3).setCellValue(orderDetail.getProductName());
			row.createCell(4).setCellValue(Integer.toString(orderDetail.getProductId()));
			row.createCell(5).setCellValue(Integer.toString(orderDetail.getQuantity()));
			row.createCell(6).setCellValue(orderDetail.getSubTotal());
			row.createCell(7).setCellValue(String.valueOf(order.getDateCreated()));
			row.createCell(8).setCellValue(String.valueOf(order.getDateShipped()));
			row.createCell(9).setCellValue("Order Placed");
			row.createCell(10).setCellValue(Integer.toString(newOrderId));

			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return newOrderId;

	}

	public static List<Admin> getAdminData() {
		List<Admin> adminList = new ArrayList<>();
		try {

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(5);
			int rowCount = sheet.getLastRowNum();
			Admin admin;

			for (int i = 1; i <= rowCount; i++) {
				Row row = sheet.getRow(i);
				admin = new Admin();
				admin.setUserId(row.getCell(0).getStringCellValue());
				admin.setPassword(row.getCell(1).getStringCellValue());
				admin.setLoginStatus(row.getCell(2).getStringCellValue());
				admin.setEmail(row.getCell(0).getStringCellValue());
				admin.setName(row.getCell(3).getStringCellValue());

				adminList.add(admin);
			}

			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return adminList;

	}

	public static void deleteBook(String bookName) {
		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(1);
			int rowCount = sheet.getLastRowNum();
			for (int i = 1; i <= rowCount; i++) {
				Row row = sheet.getRow(i);
				if (bookName.equalsIgnoreCase(row.getCell(1).getStringCellValue())) {
					Cell cellUpdate = row.getCell(6);
					cellUpdate.setCellValue("N");
				}
			}
			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();

		} catch (Exception E) {
			E.printStackTrace();
		}

	}

	public static void deleteUser(String userId) {
		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			for (int i = 1; i <= rowCount; i++) {
				Row row = sheet.getRow(i);
				if (userId.equalsIgnoreCase(row.getCell(0).getStringCellValue())) {
					Cell cellUpdate = row.getCell(9);
					cellUpdate.setCellValue("N");
				}
			}
			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();

		} catch (Exception E) {
			E.printStackTrace();
		}

	}

}