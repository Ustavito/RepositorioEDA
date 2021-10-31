package ejercicio2_listas_genericas;

public class GenericArrayList<E> implements GenericList<E> {
	
	private final int MAX;
	private E [] listaVector;
	private int tope;
	
	public GenericArrayList (int maximo) {
		
		MAX = maximo;
		
		//TODO PREGUNTAR AL PROFE
		//Como declarar un array de elementos genericos
		//listaVector = new E [MAX];
		
		this.tope = 0;
	}

	@Override
	public int size() {
		return this.tope;
	}

	@Override
	public boolean isEmpty() {
		return this.tope == 0;
	}

	@Override
	public void add(E valor) {
		// TODO Auto-generated method stub
		if (tope < MAX) {
			listaVector[tope] = valor;
			tope ++;
		}
		
		else {
			throw new RuntimeException("Out of bounds");
		}
	}

	@Override
	public void add(int indice, E valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int indice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get(int indice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int search(E valor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(E valor) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
