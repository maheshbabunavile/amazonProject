package amazon;

import java.util.Scanner;

public class Customer {

	static Scanner scanner = new Scanner(System.in);

	static AmazonHome amazonHome = new AmazonHome();
	private String customerName;
	private int customerAge;
	private long customerPhone;
	private String customerUserName;
	private String customerPassword;

	public Customer(String customerName, int customerAge, long customerPhone, String customerUserName,
			String customerPassword) {
		super();
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerPhone = customerPhone;
		this.customerUserName = customerUserName;
		this.customerPassword = customerPassword;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public long getCustomerPhone() {
		return customerPhone;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerAge=" + customerAge + ", customerPhone="
				+ customerPhone + ", customerUserName=" + customerUserName + ", customerPassword=" + customerPassword
				+ "]";
	}

	public static void createCustomer() {

		System.out.println("Enter the Customer Name;");
		String name = scanner.next();
		System.out.println("Enter the Customer Age");
		int age = scanner.nextInt();
		System.out.println("Enter the Customer Phone Number");
		while (true) {
			long phone = scanner.nextLong();
			if (amazonHome.isPerfectPhone(phone)) {
				boolean phverify = false;
				for (Customer customer : amazonHome.customers) {
					if (phone == customer.getCustomerPhone()) {
						phverify = true;
					}
				}
				if (!phverify) {

					while (true) {
						System.out.println("Enter the Customer Unique UserId");
						String userId = scanner.next();
						boolean flag3 = false;
						for (Customer customer1 : amazonHome.customers) {
							if (userId.equals(customer1.getCustomerPhone())) {
								flag3 = true;
							}

						}
						if (!flag3) {
							while (true) {
								System.out.println("Enter the Customer Password");
								String password = scanner.next();
								if (amazonHome.isPerfectPassword(password)) {

									Customer customer = new Customer(name, age, phone, userId, password);
									AmazonHome.customers.add(customer);
									amazonHome.customerlogin();
									break;
								} else {
									amazonHome.exPassword();
								}
							}
							break;
						} else {
							System.out.println("Entered UserId is Already Presented Choose a Different UserId");
						}
					}

					break;
				} else {
					System.out.println("Entered Mobile Number is already there");
					System.out.println("Enter the New phone Number");
				}
			} else {
				amazonHome.exPhone();
			}
		}

	}

	public static void resetCustomer() {

		while (true) {
			boolean verPh = false;
			System.out.println("Verify your mobile number...");
			long ph = scanner.nextLong();
			for (Customer customer : amazonHome.customers) {
				if (ph == customer.getCustomerPhone()) {
					verPh = true;
					while (true) {
						System.out.println("Enter New UserName");
						String newUSer = scanner.next();
						boolean flag1 = false;

						if ((newUSer.equals(customer.getCustomerUserName()))) {
							flag1 = true;
						}

						if (flag1) {
							System.out.println("Entered UserId is Already Present..");
						} else {
							while (true) {
								System.out.println("Enter new Password");
								String newPass = scanner.next();
								if (amazonHome.isPerfectPassword(newPass)) {
									customer.setCustomerUserName(newUSer);
									customer.setCustomerPassword(newUSer);
									System.out.println(customer);
									amazonHome.customerlogin();
									break;
								} else {
									amazonHome.exPassword();
								}
							}

							break;

						}
					}
				}

			}
			if (!verPh) {
				System.out.println("Entered Mobile Number is not Found ..Enter Existing Phone Number");

			} else if (verPh) {
				break;
			}

		}
	}

	public static void customerHome() {
		System.out.println("      Welcome to Customer Home Page     ");

		System.out.println("Select 1 for Display All Products");
		System.out.println("Select 2 for Display a Single Product");
		String opt1 = scanner.next();
		if (opt1.equalsIgnoreCase("1")) {
			Products.displayAllProducts();
		} else if (opt1.equalsIgnoreCase("2")) {
			Products.displayByProduct();
		}
		System.out.println("Do you want to Continue");
		System.out.println("Press 1 for Continue");
		System.out.println("Press Any key to Exit");
		String opt = scanner.next();
		if (opt.equalsIgnoreCase("1")) {
			customerHome();
		} else {
			System.out.println("Bye Customer");
			return;
		}

	}

}
