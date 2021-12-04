package general_book;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestGeneralBook {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Date birthday; String phoneNumber;
		Book b; boolean isWednesday;
		b = new Book();
		phoneNumber = "416-67-1010";
		b.add ("Suyeon", phoneNumber);
		birthday = new Date(1975, 4, 10);
		b.add ("Yuna", birthday); 
		
		/* The following line does not compile 
		 * because static type of return value 
		 * from Book.get(...) is Object, which
		 * does not declare the getDay() method
		 * which is Date-specific.
		 */ 
		// isWednesday = b.get("Yuna").getDay() == 4;
		
		// Instead, an explicit cast and instanceof check.
		if(b.get("Yuna") instanceof Date) {
			isWednesday = ((Date) b.get("Yuna")).getDay() == 4; 
		}
	}

}
