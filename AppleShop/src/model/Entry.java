package model;

/*
 * Template of a unit of storage in the apple refurbished shop.
 * Think of a shop as a collection of entries
 */

public class Entry {
	private String serialNumber; //e.g., FGDFWF234FD (unique)
	private Product product; 
	/*
	 *the type of attribute is a reference/address type, denoting an existing class consequently at the runtime, 
	 *this attribute will store the address of some Product object 
	 */		
	
	public Entry(String serialNumber ,Product product) {
		
		this.serialNumber = serialNumber;
		
		this.product = product;
		
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	/*
	 * An overloaded version of the setProduct mutator.
	 * This version of does not expect the user to create a Product object and pass it as an argument.
	 * Instead, we would expect the user to pass a String model and a value of the original price.
	 * (internally inside the mothod, it's expected that a local, new Product object is created accordingly)
	 */
	
	public void setProduct(String model, double originalPrice) {
		//this.product = new Product(model, originalPrice);
		Product p = new Product(model, originalPrice); //everytime you use the "new" keyword, you are guarenteed to make a new location in memory
		this.product = p;
	}
	public String toString() {
		
		return "[" +this.serialNumber+ "]" + " " +this.product.toString();
	}
	
}
