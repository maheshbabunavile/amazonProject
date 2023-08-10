package amazon;

import java.util.*;

public class Merchant {
	static Scanner scanner = new Scanner(System.in);

	static int merchantCount = 3;

	static AmazonHome amazonHome = new AmazonHome();
	private int merchantId;
	private String merchantName;
	private int merchantAge;
	private long merchantPhone;
	private String merchantUserId;
	private String merchantPassword;

	public Merchant(int merchantId, String merchantName, int merchantAge, long merchantPhone, String merchantUserId,
			String merchantPassword) {
		super();
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.merchantAge = merchantAge;
		this.merchantPhone = merchantPhone;
		this.merchantUserId = merchantUserId;
		this.merchantPassword = merchantPassword;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public int getMerchantAge() {
		return merchantAge;
	}

	public long getMerchantPhone() {
		return merchantPhone;
	}

	public String getMerchantUserId() {
		return merchantUserId;
	}

	public String getMerchantPassword() {
		return merchantPassword;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public void setMerchantAge(int merchantAge) {
		this.merchantAge = merchantAge;
	}

	public void setMerchantPhone(long merchantPhone) {
		this.merchantPhone = merchantPhone;
	}

	public void setMerchantUserId(String merchantUserId) {
		this.merchantUserId = merchantUserId;
	}

	public void setMerchantPassword(String merchantPassword) {
		this.merchantPassword = merchantPassword;
	}

	@Override
	public String toString() {
		return "Merchant [merchantId=" + merchantId + ", merchantName=" + merchantName + ", merchantAge=" + merchantAge
				+ ", merchantPhone=" + merchantPhone + ", merchantUserId=" + merchantUserId + ", merchantPassword="
				+ merchantPassword + "]";
	}

	public static void createMerchant() {
		merchantCount++;
		System.out.println("Enter the Merchant Name;");
		String name = scanner.next();
		System.out.println("Enter the Merchant Age");
		int age = scanner.nextInt();
		System.out.println("Enter the Merchant Phone Number");
		while (true) {
			long phone = scanner.nextLong();
			if (amazonHome.isPerfectPhone(phone)) {
				boolean phverify = false;
				for (Merchant merchant : amazonHome.merchants) {
					if (phone == merchant.getMerchantPhone()) {
						phverify = true;
					}
				}
				if (!phverify) {

					while (true) {
						System.out.println("Enter the Merchant Unique UserId");
						String userId = scanner.next();
						boolean flag3 = false;
						for (Merchant merchant1 : amazonHome.merchants) {
							if (userId.equals(merchant1.getMerchantUserId())) {
								flag3 = true;
							}

						}
						if (!flag3) {
							while (true) {
								System.out.println("Enter the Merchant Password");
								String password = scanner.next();
								if (amazonHome.isPerfectPassword(password)) {

									AmazonHome.merchants
											.add(new Merchant(merchantCount, name, age, phone, userId, password));
									AmazonHome.merchantlogin();
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

	public static void resetMerchant() {
		while (true) {
			boolean verPh = false;
			System.out.println("Verify your mobile number...");
			long ph = scanner.nextLong();
			for (Merchant merchant : amazonHome.merchants) {
				if (ph == merchant.getMerchantPhone()) {
					verPh = true;
					System.out.println("Enter New UserName");
					while (true) {
						
						String newUSer = scanner.next();
						boolean flag1 = false;

						if ((newUSer.equals(merchant.getMerchantUserId()))) {
							flag1 = true;
						}

						if (flag1) {
							System.out.println("please enter a new Unique Username");
						} else {
							while (true) {
								System.out.println("Enter new Password");
								String newPass = scanner.next();
								if (amazonHome.isPerfectPassword(newPass)) {
									merchant.setMerchantUserId(newUSer);
									merchant.setMerchantPassword(newPass);
									System.out.println(merchant);
									amazonHome.merchantlogin();
									break;
								}
								else
								{
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

	public static boolean merchantConfirm() {
		System.out.println("Enter Merchant User Id");
		String user = scanner.next();

		System.out.println("Enter Merchant user Password");
		String pass = scanner.next();
		for (Merchant mer : amazonHome.merchants) {
			if (user.equals(mer.getMerchantUserId()) && pass.equals(mer.getMerchantPassword())) {
				return true;

			}
		}
		return false;
	}

	public static void merchantHome() {
		System.out.println("      Welcome to Merchant Home Page     ");
		System.out.println("Select 1 for Insert Products");
		System.out.println("Select 2 for Display All Products");
		System.out.println("Select 3 for Display a Single Product");
		System.out.println("Select 4 for Delete A Product");
		String opt1 = scanner.next();
		if (opt1.equalsIgnoreCase("1")) {
			Products.dynamicProducts();
		} else if (opt1.equalsIgnoreCase("2")) {
			Products.displayAllProducts();
		} else if (opt1.equalsIgnoreCase("3")) {
			Products.displayByProduct();
		} else if (opt1.equalsIgnoreCase("4")) {
			Products.deleteProductByName();
		}
		System.out.println("Do you want to Continue");
		System.out.println("Press 1 for Continue");
		System.out.println("Press Any key to Exit");
		String opt = scanner.next();
		if (opt.equalsIgnoreCase("1")) {
			merchantHome();
		} else {
			System.out.println("Bye Merchant");
			return;
		}

	}

}
