package console_apps;

import java.util.Scanner;

import model.Product;
import model.RefurbishedStore;

public class ProductApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		Product p = new Product();
		System.out.println(p); //implicitly: system.out.println(p.toString())
		
		Product p2 = new Product("iPad Pro 12.9", 1289.00);
		System.out.println(p2);
		
//		System.out.println("Enter a model:");
//		String model = input.nextLine();
//		
//		System.out.println("Enter the original price:");
//		double originalPrice = input.nextDouble();
//		Product p3 = new Product(model, originalPrice);
//		System.out.println(p3);
		
		RefurbishedStore rs = new RefurbishedStore();
		boolean b = false;
		for(int i = 1; rs.getNumberOfEntries()>i;i++ ) {
			b = b && rs.getPrivateEntriesArray()[i].getProduct() == null;
		}
		assertTrue(b);
		
		input.close();
	}

}
