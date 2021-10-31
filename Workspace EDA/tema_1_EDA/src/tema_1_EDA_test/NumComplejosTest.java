package tema_1_EDA_test;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tema_1_EDA.NumComplejos;

//PENDIENTE: REFACTORIZAR
class NumComplejosTest {
	
	//private static NumComplejos complejo;
	
	
	//@BeforeEach
	//public static void setup() {
		//complejo = new NumComplejos(0,0);
	//}

	@Test
	void getRealPartTest() {
		NumComplejos complejo = new NumComplejos(2.3, 5);
		assertEquals(2.3, complejo.realPart());
	}
	
	@Test
	void getImagPartTest() {
		NumComplejos complejo = new NumComplejos(4.2, 9.1);
		assertEquals (9.1, complejo.imagPart());
	}
	
	@Test
	void addComplexTest() {
		NumComplejos c1 = new NumComplejos(3, -4);
		NumComplejos c2 = new NumComplejos(2, 7);
		NumComplejos suma = c1.add(c2);
		
		assertEquals(5, suma.realPart());
		assertEquals(3, suma.imagPart());
	}
	
	@Test
	void substractComplexTest() {
		NumComplejos c1 = new NumComplejos(9, 5);
		NumComplejos c2 = new NumComplejos(4, 7);
		NumComplejos resta = c1.substract(c2);
		
		assertEquals(5, resta.realPart());
		assertEquals(-2, resta.imagPart());
	}
	
	@Test
	void multiplyComplexTest() {
		NumComplejos c1 = new NumComplejos(5, 6);
		NumComplejos c2 = new NumComplejos(3, 2);
		NumComplejos multi = c1.multiply(c2);
		
		assertEquals(3, multi.realPart());
		assertEquals(28, multi.imagPart());
	}
	
	@Test
	void divisionComplexTest() {
		NumComplejos c1 = new NumComplejos(13, 1);
		NumComplejos c2 = new NumComplejos(1, -3);
		NumComplejos multi = c1.divide(c2);
		
		assertEquals(1, multi.realPart());
		assertEquals(4, multi.imagPart());
	}
	
	@Test
	void moduleComplexTest() {
		NumComplejos c = new NumComplejos(4, -3);
		assertEquals(5, c.module());
	}
	
	@Test
	void conjugateTest() {
		NumComplejos c = new NumComplejos(8, -2);
		NumComplejos conjugado = c.conjugate();
		assertEquals(- c.imagPart(), conjugado.imagPart());
	}
}