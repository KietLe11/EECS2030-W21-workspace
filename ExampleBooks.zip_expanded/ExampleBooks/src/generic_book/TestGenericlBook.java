package generic_book;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestGenericlBook {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Date birthday; String phoneNumber;
		Book<Date> b; boolean isWednesday;
		/*
		 * Alternatively,
		 * b = new Book<>();
		 */
		b = new Book<Date>(); 
		phoneNumber = "416-67-1010";
		/*
		 * The following line does not compile
		 * because it's already been committed that
		 * 'b' stores object whose static types are 
		 * descendants of Date class only.
		 */
		// b.add ("Suyeon", phoneNumber);
		birthday = new Date(1975, 4, 10);
		b.add ("Yuna", birthday); 
		
		/* The following line compiles 
		 * because static type of return value 
		 * from Book.get(...) is E, which
		 * has already been committed to Date
		 * when declaring Book<Date>.
		 * Compared with the case of general book,
		 * no type cast and instanceof check are necessary. 
		 */ 
		isWednesday = b.get("Yuna").getDay() == 4;
	}

}
