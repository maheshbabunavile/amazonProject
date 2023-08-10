package amazon;

import java.util.Scanner;

public class Products {
	static AmazonHome amazonHome = new AmazonHome();

	static Scanner scanner = new Scanner(System.in);

	private String productName;
	private String productDesc;
	private double productPrice;

	public Products(String productName, String productDesc, double productPrice) {
		super();
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Products [productName=" + productName + ", productDesc=" + productDesc + ", productPrice="
				+ productPrice + "]";
	}

	public static void dynamicProducts() {
		System.out.println("Enter Product name");
		String name = scanner.next();
		System.out.println("Enter Products Description");
		String disc = scanner.next();
		System.out.println("Enter Products Price");
		double price = scanner.nextDouble();

		Products pro = new Products(name, disc, price);
		AmazonHome.products.add(pro);
		System.out.println(AmazonHome.products);
	}

	public static void displayAllProducts() {
		System.out.println(amazonHome.merchants);
	}

	public static void searchByName() {
		System.out.println("Enter the Product name to search");
		String pro = scanner.next();
		for (Products product : amazonHome.products) {
			if (pro.equalsIgnoreCase(product.getProductName())) {
				System.out.println(product);
			}
		}
	}

	public static void searchByPrice() {
		System.out.println("Enter the Product Price to Search");
		double pri = scanner.nextDouble();
		boolean flag = false;

		for (Products product : amazonHome.products) {
			if (pri == product.getProductPrice()) {
				System.out.println(product);
			}
		}

	}

	public static void displayByProduct() {
		System.out.println("Enter 1 for Search by name of the product");
		System.out.println("Enter 2 for Search by Price of the Product");
		String opt = scanner.next();
		if (opt.equalsIgnoreCase("1")) {
			searchByName();
		} else if (opt.equalsIgnoreCase("2")) {
			searchByPrice();
		}
	}

	public static void deleteProductByName() {
		System.out.println("Please Confirm your merchant Details");
		if (Merchant.merchantConfirm()) {
			System.out.println("Enter the Product Name to Delete");
			String dName = scanner.next();
			for (Products product : amazonHome.products) {
				if (dName.equalsIgnoreCase(product.getProductName())) {
					amazonHome.products.remove(product);
					System.out.println("Successfully removed the Product");
					System.out.println(amazonHome.products);
					return;
				}
			}

		} else {
			System.out.println("Login is Failed");
		}

	}

}
