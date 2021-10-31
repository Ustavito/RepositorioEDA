package tema_1_EDA;

public class NumComplejos {
	
	private double real;
	private double imag;
	
	public NumComplejos(double r, double i){
		real = r;
		imag = i;
	}
	
	public NumComplejos(NumComplejos c) {
		this.real = c.realPart();
		this.imag = c.imagPart();
	}
	
	public double realPart() {
		return this.real;
	}
	
	public double imagPart() {
		return this.imag;
	}
	
	public void setRealPart(double r) {
		this.real = r;
	}
	
	public void setImagPart(double i) {
		this.imag = i;
	}
	
	public void setAll(double r, double i) {
		real = r;
		imag = i;
	}
	
	public NumComplejos conjugate() {
		NumComplejos conjugado = new NumComplejos (this.realPart(), -this.imagPart());
		return conjugado;
	}
	
	public NumComplejos add (NumComplejos c) {
		NumComplejos suma = new NumComplejos(this.realPart() + c.realPart() , this.imagPart() + c.imagPart());
		return suma;
	}
	
	public NumComplejos substract (NumComplejos c) {
		NumComplejos resta = new NumComplejos(this.realPart() - c.realPart(), this.imagPart() - c.imagPart());
		return resta;
	}
	
	public NumComplejos multiply (NumComplejos c) {
		NumComplejos multi = new NumComplejos(0,0);
		multi.setRealPart((this.realPart()*c.realPart()) - this.imagPart()*c.imagPart());
		multi.setImagPart(this.imagPart()*c.realPart() + this.realPart()*c.imagPart());
		return multi;
	}
	
	public NumComplejos divide (NumComplejos c) {
		NumComplejos numerador = new NumComplejos(this.multiply(c));
		double denominador = (Math.pow(c.realPart(), 2) + Math.pow(c.imagPart(), 2));
		NumComplejos division = new NumComplejos (0,0);
		division.setRealPart(numerador.realPart()/denominador);
		division.setImagPart(numerador.imagPart()/denominador);
		return division;
	}
	
	public double module() {
		double a = Math.pow(this.realPart(), 2);
		double b = Math.pow(this.imagPart(), 2);
		
		double modulo = Math.sqrt(a + b);
		return modulo;	
	}
}