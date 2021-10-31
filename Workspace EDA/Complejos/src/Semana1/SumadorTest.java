package Semana1;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class SumadorTest extends TestCase {
	
	//OJO, LOS TEST LOS PONES APARTE DE LO QUE PRUEBAN

	@Test
	public void test_3_plus_4() {
		Sumador s = new Sumador();
		int r = s.add(3, 4);
		if (r != 7) {
			fail("Suma incorrecta");
		}
		
		//Se usa esto en vez del if, then fail.
		Assert.assertEquals("Suma incorrecta", 7, r);
	}
	
	
	@Test
	public void testAdd() {
		
	}
	
	@Test
	public void testAdd2() {
		
	}

}
