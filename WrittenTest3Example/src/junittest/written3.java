package junittest;

import static org.junit.Assert.*;

import org.junit.Test;
import model.*;
import model.B;
import model.C;
import model.F;
import model.G;

public class written3 {

	@Test
	public void test() {
		B obj2 = new C();
		G obj = new F();
		obj = (G)obj2;
		
		A a = (A)obj;
		
		
	}

}
