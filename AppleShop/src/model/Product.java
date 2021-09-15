package model;

/*
 * This is a template for individual apple ipads in the refurbished store
 */
public class Product {

	//Section one: attributes. Should be private so that they are only visible in the current class Product
	//If you intend to make an attribute public, it will be visible to all classes
	//Instead, create a public accessor for this private attribute
	private String model; //e.g., iPad Pro 12.9
	private String finish; //e.g, Silver, Space Grey
	private int storage; //e.g, 32GB, 256GB, 512GB
	private boolean hasCellularConnectivity; //does it have cellular? e.g., flse (only wifi), true (wifi + cellular)
	private double originalPrice; //e.g., 1789.00
	private double discountValue; //e.g., 350.00
	
	//Section two: constructors
	//if no constructors are declared here, an implicit, default constructor is available. If you create one, then the default disappears.
	//advice: if you really find the default constructor useful, define one explicitly
	//otherwise as soon as any additional constructors are added, the implicit one becomes unavailable
	
	public Product() {
		//do nothing: all attributes will be stored in their default values after an object is created
	}
	
	//an overloaded version of the constructor
	public Product(String model, double originalPrice) {
		
		this.model = model;
		this.originalPrice = originalPrice;
		
	}
	
	//Section three: accessors, these get information from the objects
	public String getModel() {
		
		return this.model;
		
	}
	
	//Section four: Mutators, methods to change the objects
	public void setModel(String model) {
		this.model = model;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public boolean isHasCellularConnectivity() {
		return hasCellularConnectivity;
	}

	public void setHasCellularConnectivity(boolean hasCellularConnectivity) {
		this.hasCellularConnectivity = hasCellularConnectivity;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
	
	
	
}
