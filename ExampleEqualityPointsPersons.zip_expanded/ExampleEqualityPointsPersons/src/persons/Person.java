package persons;

public class Person {
	private String firstName; 
	private String lastName; 
	private double weight; 
	private double height;
	
	public Person(String firstName, String lastName, double weight, double height) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.weight = weight;
		this.height = height;
	}
	
	public boolean equals (Object obj) {
		if(this == obj) { return true; }
		if(obj == null || this.getClass() != obj.getClass()) {
			return false; }
		Person other = (Person) obj;
		return
					this.weight == other.weight 
				&& 	this.height == other.height
				&& 	this.firstName.equals (other.firstName)
				&& 	this.lastName.equals (other.lastName); 
	} 
}