package model;

/*
 * template of a collection of entries.
 */

public class RefurbishedStore {
	private Entry[] entries; //an array of entry object references: each slot stores the reference of some entry object
	/*
	 * two purposes of tis auxiliary counter "noe": 
	 * 1. records how many non-null entries have ben stored in the 'entries' array
	 * 3. indicates the index of the 'entries' array that will store the next new entry refence
	 */
	private int noe; //Number of Entries
	private final int MAX_CAPACITY = 5; //THIS IS A constant maximum capacity
	
	public RefurbishedStore() {
		this.entries = new Entry[MAX_CAPACITY];
		this.noe = 0;
	}
	
	public int getNumberOfEntries() {
		return this.noe;
	}
	
	public Entry [] getPrivateEntriesArray() {
		return this.entries;
	}
	/*
	 * Retrieve the array of entries, arranged in the choronological order
	 * in which they were inserted.
	 * That is, the earlier an entry was inserted, the more front it appears in the return array
	 */
	public Entry[] getEntries() {
		Entry[] es = new Entry[noe];
		for(int i =0; i<this.noe; i++) {
			es[i] = this.entries[i];
		}
		return es;
	}
	
	//FOr now, assume that the serial number of input entry 'e' does not exist in the collection
	public void addEntry(Entry e) {
		this.entries[this.noe] = e;
		this.noe++;
	}
	
	public void addEntry(String sn, Product p) {
//		Entry ne = new Entry(sn,p);
//		this.entries[this.noe] = ne;
//		this.noe++;
		this.addEntry(new Entry(sn,p)); 
	}
	
	public void addEntry(String sn, String model, double originalPrice) {
//		Product p = new Product(model, originalPrice);
//		Entry ne = new Entry(sn,p);
//		this.entries[this.noe] = ne;
//		this.noe++;
		this.addEntry(new Entry(sn,new Product(model, originalPrice))); 
	}
	
	public Product getProduct(String sn) {
		int index = -1; /*expected to be re-asssigned to a valid index if the 'sn' exists in the store*/
		//problematic exit condition : i< this.entries.length
		for(int i =0; i<this.noe; i++) {
			Entry e = this.entries[i];
			if(e.getSerialNumber().equals(sn)) {
				index = i;
			}
		}
		
		if(index<0) {
			return null;
		}
		else {
			return this.entries[index].getProduct();
		}
	}
	/*
	 * Return the serial numbers of all products that are
	 * either with Space Grey finish or is a Pro.
	 */
	public String[] getSpaceGreyOrPro() {
		int count = 0; //number of products that satisfy the search criteria
		int[] indices = new int[this.noe]; //indices of entry objects, in the entries array, that satisfy the search criteria
		
		//Step 1: Collect all products satisfying the search criteria
		for(int i =0; i<this.noe; i++) {
			Product p = this.entries[i].getProduct();
			if(p.getModel().contains("Pro") || (p.getFinish() != null && p.getFinish().contains("Space Grey"))) {
				indices[count] = i;
				count++;
			}
		}
		
		//Step 2: Create an array of string (for serial numbers) whose size is 'count'
		String[] sns = new String[count];
		
		for(int i = 0; i<count ; i++) {
			sns[i] =this.entries[indices[i]].getSerialNumber();
		}
		return sns;
	}
	
	/*
	 * Return the serial numbers of all products that are
	 * both with Space Grey finish and is a Pro.
	 */
	public String[] getSpaceGreyPro() {
		int count = 0; //number of products that satisfy the search criteria
		int[] indices = new int[this.noe]; //indices of entry objects, in the entries array, that satisfy the search criteria
		
		//Step 1: Collect all products satisfying the search criteria
		for(int i =0; i<this.noe; i++) {
			Product p = this.entries[i].getProduct();
			if(p.getModel().contains("Pro") && p.getFinish() !=null && p.getFinish().contains("Space Grey")) {
				indices[count] = i;
				count++;
			}
		}
		
		//Step 2: Create an array of string (for serial numbers) whose size is 'count'
		String[] sns = new String[count];
		
		for(int i = 0; i<count ; i++) {
			sns[i] =this.entries[indices[i]].getSerialNumber();
		}
		return sns;
	}
}


