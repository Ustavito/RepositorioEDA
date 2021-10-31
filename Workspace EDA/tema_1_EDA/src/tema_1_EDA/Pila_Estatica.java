package tema_1_EDA;

//Pila estatica, de momento solo vale para enteros
public class Pila_Estatica {
	
	private static final int MAX_SIZE = 10;
	private int[] pila = new int[MAX_SIZE];
	private int top = 0;
	
	
	public Pila_Estatica () {
		
	}
	
	public void push (int elemento) {
		if (this.top <= 9) {
			this.pila[this.top + 1] = elemento; 
		}
	}
	
	public int pop() {
		if (this.top >= 0) {
			return this.pila[this.top];
			
			
		}
		
		else return 0;
	}

}
