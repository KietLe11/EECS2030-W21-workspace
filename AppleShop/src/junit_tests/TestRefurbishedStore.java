package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Entry;
import model.Product;
import model.RefurbishedStore;

public class TestRefurbishedStore {

	@Test
	public void test_refurbished_store_1(){
		//Create an empty store
		RefurbishedStore rs = new RefurbishedStore(); //maximum is 5 entries
		
		assertTrue(rs.getNumberOfEntries() == 0);
		assertTrue(rs.getPrivateEntriesArray().length ==5);
		assertTrue(rs.getPrivateEntriesArray()[0] ==null);
		assertTrue(rs.getPrivateEntriesArray()[1] ==null);
		assertTrue(rs.getPrivateEntriesArray()[2] ==null);
		assertTrue(rs.getPrivateEntriesArray()[3] ==null);
		assertTrue(rs.getPrivateEntriesArray()[4] ==null);
		assertTrue(rs.getEntries().length == 0);
		
		Product p1 = new Product("iPad Pro 12.9", 1709.00);
		p1.setFinish("Space Grey");
		p1.setStorage(1000);
		p1.setHasCellularConnectivity(true);
		p1.setDiscountValue(220);
		Entry e1 = new Entry("F9FDN4NKQ1GC", p1);
		//Add entry 1
		rs.addEntry(e1);
		
		assertTrue(rs.getNumberOfEntries() == 1);
		assertTrue(rs.getPrivateEntriesArray().length ==5);
		assertTrue(rs.getPrivateEntriesArray()[0] ==e1);
		assertTrue(rs.getPrivateEntriesArray()[1] ==null);
		assertTrue(rs.getPrivateEntriesArray()[2] ==null);
		assertTrue(rs.getPrivateEntriesArray()[3] ==null);
		assertTrue(rs.getPrivateEntriesArray()[4] ==null);
		assertTrue(rs.getEntries().length == 1);
		assertTrue(rs.getEntries()[0] == e1);
		
		Product p2 = new Product ("iPad Air", 649.00);
		p2.setFinish("Gold");
		p2.setStorage(64);
		p2.setHasCellularConnectivity(false);
		p2.setDiscountValue(100);
		//Add entry 2
		rs.addEntry("C9FZN4J8QC82", p2);
		
		
		assertTrue(rs.getNumberOfEntries() == 2);
		assertTrue(rs.getPrivateEntriesArray().length ==5);
		assertTrue(rs.getPrivateEntriesArray()[0] ==e1);
		assertTrue(rs.getPrivateEntriesArray()[1].getSerialNumber().equals("C9FZN4J8QC82"));
		assertTrue(rs.getPrivateEntriesArray()[1].getProduct() == p2);
		assertTrue(rs.getPrivateEntriesArray()[2] ==null);
		assertTrue(rs.getPrivateEntriesArray()[3] ==null);
		assertTrue(rs.getPrivateEntriesArray()[4] ==null);
		assertTrue(rs.getEntries().length == 2);
		assertTrue(rs.getEntries()[0] ==e1);
		assertTrue(rs.getEntries()[1].getSerialNumber().equals("C9FZN4J8QC82"));
		assertTrue(rs.getEntries()[1].getProduct() == p2);
		
		//Add entry 3
		rs.addEntry("7YM4PFZ779UB", "iPad Pro 10.5", 929.00);
		
		assertTrue(rs.getNumberOfEntries() == 3);
		assertTrue(rs.getPrivateEntriesArray().length ==5);
		assertTrue(rs.getPrivateEntriesArray()[0] ==e1);
		assertTrue(rs.getPrivateEntriesArray()[1].getSerialNumber().equals("C9FZN4J8QC82"));
		assertTrue(rs.getPrivateEntriesArray()[1].getProduct() == p2);
		assertTrue(rs.getPrivateEntriesArray()[2].getSerialNumber().equals("7YM4PFZ779UB"));
		assertTrue(rs.getPrivateEntriesArray()[2].getProduct().getModel().equals("iPad Pro 10.5"));
		assertEquals(rs.getPrivateEntriesArray()[2].getProduct().getOriginalPrice(), 929.00, 0.1);
		assertTrue(rs.getPrivateEntriesArray()[3] ==null);
		assertTrue(rs.getPrivateEntriesArray()[4] ==null);
		assertTrue(rs.getEntries().length == 3);
		assertTrue(rs.getEntries()[0] ==e1);
		assertTrue(rs.getEntries()[1].getSerialNumber().equals("C9FZN4J8QC82"));
		assertTrue(rs.getEntries()[1].getProduct() == p2);
		assertTrue(rs.getEntries()[2].getSerialNumber().equals("7YM4PFZ779UB"));
		assertTrue(rs.getEntries()[2].getProduct().getModel().equals("iPad Pro 10.5"));
		assertEquals(rs.getEntries()[2].getProduct().getOriginalPrice(), 929.00, 0.1);
		
		
		
		
	}
	
	@Test
	public void test_refurbished_store_2(){
		//Create an empty store
		RefurbishedStore rs = new RefurbishedStore(); //maximum is 5 entries
		
		Product p1 = new Product("iPad Pro 12.9", 1709.00);
		p1.setFinish("Space Grey");
		p1.setStorage(1000);
		p1.setHasCellularConnectivity(true);
		p1.setDiscountValue(220);
		Entry e1 = new Entry("F9FDN4NKQ1GC", p1);
		//Add entry 1
		rs.addEntry(e1);
		
		Product p2 = new Product ("iPad Air", 649.00);
		p2.setFinish("Gold");
		p2.setStorage(64);
		p2.setHasCellularConnectivity(false);
		p2.setDiscountValue(100);
		//Add entry 2
		rs.addEntry("C9FZN4J8QC82", p2);
		
		//Add entry 3
		rs.addEntry("7YM4PFZ779UB", "iPad Pro 10.5", 929.00);
		
		assertTrue(rs.getProduct("F9FDN4NKQ1GC") == p1);
		assertTrue(rs.getProduct("C9FZN4J8QC82") ==p2);
		assertTrue(rs.getProduct("7YM4PFZ779UB").getModel().equals("iPad Pro 10.5"));
		assertTrue(rs.getProduct("7YM4PFZ779UB").getFinish() == null);
		assertTrue(rs.getProduct("7YM4PFZ779UB").getStorage() == 0);
		assertTrue(rs.getProduct("7YM4PFZ779UB").hasCellularConnectivity() ==false);
		assertEquals(929.00, rs.getProduct("7YM4PFZ779UB").getOriginalPrice(), 0.1);
		assertEquals(0.0, rs.getProduct("7YM4PFZ779UB").getDiscountValue(), 0.1);
		
		 rs.getProduct("7YM4PFZ779UB").setFinish("Silver");
		 rs.getProduct("7YM4PFZ779UB").setStorage(256); //256GB
		 Product p3 = rs.getEntries()[2].getProduct();
		 p3.setHasCellularConnectivity(false);
		 p3.setDiscountValue(270.00);
		 
		 assertTrue(rs.getProduct("7YM4PFZ779UB").getModel().equals("iPad Pro 10.5"));
		 assertTrue(rs.getProduct("7YM4PFZ779UB").getFinish().equals("Silver"));
		 assertTrue(rs.getProduct("7YM4PFZ779UB").getStorage() == 256);
		 assertTrue(rs.getProduct("7YM4PFZ779UB").hasCellularConnectivity() ==false);
		 assertEquals(929.00, rs.getProduct("7YM4PFZ779UB").getOriginalPrice(), 0.1);
		 assertEquals(270.0, rs.getProduct("7YM4PFZ779UB").getDiscountValue(), 0.1);
	}
	
	@Test
	public void test_refurbished_store_3(){
		//Create an empty store
		RefurbishedStore rs = new RefurbishedStore(); //maximum is 5 entries
		
		Product p1 = new Product("iPad Pro 12.9", 1709.00);
		p1.setFinish("Space Grey");
		p1.setStorage(1000);
		p1.setHasCellularConnectivity(true);
		p1.setDiscountValue(220);
		Entry e1 = new Entry("F9FDN4NKQ1GC", p1);
		//Add entry 1
		rs.addEntry(e1);
		
		Product p2 = new Product ("iPad Air", 649.00);
		p2.setFinish("Gold");
		p2.setStorage(64);
		p2.setHasCellularConnectivity(false);
		p2.setDiscountValue(100);
		//Add entry 2
		rs.addEntry("C9FZN4J8QC82", p2);
		
		//Add entry 3
		rs.addEntry("7YM4PFZ779UB", "iPad Pro 10.5", 929.00);
		
		//setup the attributes to appropriate values
		rs.getProduct("7YM4PFZ779UB").setFinish("Silver");
		rs.getProduct("7YM4PFZ779UB").setStorage(256); //256GB
		Product p3 = rs.getEntries()[2].getProduct();
		p3.setHasCellularConnectivity(false);
		p3.setDiscountValue(270.00);
		
		assertTrue(rs.getSpaceGreyOrPro().length == 2);
		assertTrue(rs.getSpaceGreyOrPro()[0].equals("F9FDN4NKQ1GC") && rs.getSpaceGreyOrPro()[1].equals("7YM4PFZ779UB"));
		
		assertTrue(rs.getSpaceGreyPro().length ==1);
		assertTrue(rs.getSpaceGreyPro()[0].equals("F9FDN4NKQ1GC"));
	}

}
