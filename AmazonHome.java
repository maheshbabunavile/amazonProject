package amazon;

import java.util.ArrayList;
import java.util.*;

public class AmazonHome {

	static ArrayList<Products> products = new ArrayList<Products>();
	static ArrayList<Customer> customers = new ArrayList<Customer>();
	static ArrayList<Merchant> merchants = new ArrayList<Merchant>();

	static Scanner scanner = new Scanner(System.in);

	public void saveAll() {
		insertProducts();
		saveMerchant();
		saveCustomer();
	}

	public static void insertProducts() {
		products.add(new Products("Iphone", "14 Pro Max", 150000));
		products.add(new Products("Samsung", "S 22 Ultra", 120000));
		products.add(new Products("1+", "11 Pro", 80000));
	}

	public static void saveMerchant() {
		merchants.add(new Merchant(1, "Mahesh", 26, 7207187007l, "mahesh123", "Mahesh@123"));
		merchants.add(new Merchant(2, "Anwi", 26, 9052991914l, "anwi987", "Anwi@987"));
	}

	public static void saveCustomer() {
		customers.add(new Customer("Aravind", 23, 9874382783l, "aravind567", "Aravind@567"));
		customers.add(new Customer("Madhu", 25, 9515087489l, "madhu456", "Madhu@456"));
	}

	public static boolean merchantlogin() {
		int i = 3;
		boolean flag = false;
		while (i > 0) {
			System.out.println("Enter Merchant User Id");
			String user = scanner.next();

			System.out.println("Enter Merchant user Password");
			String pass = scanner.next();
			for (Merchant mer : merchants) {
				if (user.equals(mer.getMerchantUserId()) && pass.equals(mer.getMerchantPassword())) {
					flag = true;
					Merchant.merchantHome();
					return true;

				}
			}
			i--;
			if (!flag && i > 0) {
				System.out.println("Please Enter Valid UserId and password");
				System.out.println("You have ony " + i + " chances left");
			} else if (i == 0) {
				System.out.println("Enter 1 for forgot && Reset username and password");
				System.out.println("Enter any key to Cancel");
				String opt = scanner.next();
				if (opt.equalsIgnoreCase("1")) {
					Merchant.resetMerchant();
					return true;
				} else {
					break;
				}
			}
		}
		return false;
	}

	public static boolean customerlogin() {
		int i = 3;
		boolean flag = false;
		while (i > 0) {
			System.out.println("Enter Customer User Id");
			String user = scanner.next();

			System.out.println("Enter Customer user Password");
			String pass = scanner.next();
			for (Customer cus : customers) {
				if (user.equals(cus.getCustomerUserName()) && pass.equals(cus.getCustomerPassword())) {
					flag = true;
					Customer.customerHome();
					return true;

				}
			}
			i--;
			if (!flag && i > 0) {
				System.out.println("Please Enter Valid UserId and password");
				System.out.println("You have ony " + i + " chances left");
			} else if (i == 0) {
				System.out.println("Enter 1 for forgot && Reset username and password");
				System.out.println("Enter any key to Cancel");
				String opt = scanner.next();
				if (opt.equalsIgnoreCase("1")) {
					Customer.resetCustomer();
					return true;
				} else {
					break;
				}
			}
		}
		return false;
	}

	public static boolean isPerfectPhone(long l) {
		int c = 0;
		while (l != 0) {
			c++;
			l /= 10;
		}
		if (c == 10) {
			return true;
		}
		return false;
	}

	public static void exPhone() {
		System.out.println("Phone Number Must Contain 10 Numbers");
	}

	public static void exPassword() {
		System.out.println(" Password Length must be Greater than 7 and Less than 16");
		System.out.println(" Password must have atLeast one Capital Letter");
		System.out.println(" Password must have atLeast one Small Letter");
		System.out.println(" Password must have atLeast one Number");
		System.out.println(" Password must have atLeast one Spcial Character ");

	}

	public static boolean isPerfectPassword(String str) {
		String res = str;
		int total = str.length();
		if (total <= 8 && total >= 15) {
			return false;
		}
		int cap = 0;
		int small = 0;
		int num = 0;
		int symbol = 0;
		for (int i = 0; i < res.length(); i++) {
			char ch = res.charAt(i);
			if (ch >= 65 && ch <= 90) {
				cap++;
			} else if (ch >= 97 && ch <= 122) {
				small++;
			} else if (ch >= 48 && ch <= 57) {
				num++;
			} else {
				symbol++;
			}
		}
		if (cap > 0 && small > 0 && num > 0 && symbol > 0) {
			return true;
		}
		return false;
	}

	public static void homePage() {
		System.out.println("                      Welcome To Amazon                      ");
		System.out.println();
		System.out.println();
		System.out.println("Enter 1 for Merchant");
		System.out.println("Enter 2 for Customer");
		String optionUser = scanner.next();
		if (optionUser.equalsIgnoreCase("1")) {
			System.err.println("      Welcome Merchant           ");
			System.out.println();
			System.out.println("Enter 1 for Old Merchant ");
			System.out.println("Enter 2 for new Merchant ");
			String optionMerchant = scanner.next();
			if (optionMerchant.equalsIgnoreCase("1")) {
				if (!merchantlogin()) {

					System.out.println("Username is not found Please Register First");
					Merchant.createMerchant();
				}

			} else if (optionMerchant.equalsIgnoreCase("2")) {
				Merchant.createMerchant();
			}
		}

		else if (optionUser.equalsIgnoreCase("2")) {
			System.err.println("      Welcome Customer           ");
			System.out.println();
			System.out.println("Enter 1 for Old Customer ");
			System.out.println("Enter 2 for new Customer ");
			String optionCustomer = scanner.next();
			if (optionCustomer.equalsIgnoreCase("1")) {

				if (!customerlogin()) {
					System.out.println("Username is not found Please Register First");
					Customer.createCustomer();
				}
			}

			else if (optionCustomer.equalsIgnoreCase("2")) {
				Customer.createCustomer();
			}
		}

	}

}
