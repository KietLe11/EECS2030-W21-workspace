package generic_book;

/*
 * A generic book of objects whose static types 
 * are descendants of E, which is to be
 * instantiated when declaring a variable of type Book
 * e.g., Book<Date>
 */
public class Book<E> {
	private String[] names;
	private E[] records; 

	/* add a name-record pair to the book */
	public void add (String name, E record) {
		/* Your Exercise */
	}

	/* return the record associated with a given name */
	public E get (String name) { 
		/* Your Exercise */
		return null;
	}
}
