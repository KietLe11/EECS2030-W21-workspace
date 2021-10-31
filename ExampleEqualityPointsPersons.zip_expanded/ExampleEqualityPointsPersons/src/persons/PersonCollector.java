package persons;

public class PersonCollector {
	private Person[] persons; 
	private int nop; /* number of persons */
	
	public PersonCollector() { 
		persons = new Person[10];
	}
	
	public Person[] getPersons() {
		Person[] ps = new Person[this.nop];
		for(int i = 0; i < this.nop; i ++) {
			ps[i] = this.persons[i];
		}
		return ps;
	}
	
	public void addPerson(Person p) { 
		persons[nop] = p;
		nop ++;
	}
	
	public boolean equals (Object obj) {
		if(this == obj) { return true; }
		if(obj == null || this.getClass() != obj.getClass()) {
			return false; }
		PersonCollector other = (PersonCollector) obj;
		boolean equal = false;
		if(this.nop == other.nop) {
			equal = true;
			for(int i = 0; equal && i < this.nop; i ++) {
				equal = this.persons[i].equals(other.persons[i]); 
			} 
		} 
		return equal;
	}
}
