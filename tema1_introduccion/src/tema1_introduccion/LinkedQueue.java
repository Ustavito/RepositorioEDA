package tema1_introduccion;

public class LinkedQueue<E> implements Cola<E> {
	
	
	//*********************CLASE PRIVADA NODO*******************
	
	private class nodoCola<T> implements Position<T>{
		
		private T elemento;
		
		nodoCola<T> anterior;
		
		nodoCola<T> siguiente;
		
		private LinkedQueue<T> miCola;
		
		public nodoCola (T elem, nodoCola<T> ant, nodoCola<T> sig, LinkedQueue<T> cola) {
			this.elemento = elem;
			this.anterior = ant;
			this.siguiente = sig;
			this.miCola = cola;
			
			
		}
		

		@Override
		public T getElement() {
			return this.elemento;
		}
		
		public void setElement(T nuevoElemento) {
			this.elemento = nuevoElemento;
		}
		
		public LinkedQueue<T> getMyQueue() {
			return this.miCola;
		}
		
		public nodoCola<T> getPreviousNode(){
			return this.anterior;
		}
		
		public void setPreviousNode(nodoCola<T> nodoNuevo) {
			this.anterior = nodoNuevo;
		}
		
		public nodoCola<T> getNextNode(){
			return this.siguiente;
		}
		
		public void setNextNode(nodoCola<T> nodoNuevo) {
			this.siguiente = nodoNuevo;
		}
		
	}
	
	//********************FIN CLASE PRIVADA NODO *****************************
	
	protected int size;
	
	protected nodoCola<E> ultimoDeCola;
	
	protected nodoCola<E> primeroDeCola;
	
	public LinkedQueue() {
		this.primeroDeCola = null;
		this.ultimoDeCola = null;
		this.size = 0;
	}
	
	
	private nodoCola<E> checkPosition(Position<E> pos) throws RuntimeException {
		if (pos == null || !(pos instanceof nodoCola)) {
			throw new RuntimeException("Position invalid");
		}
		//Se convierte la posicion en un nodo
		nodoCola<E> nodo = (nodoCola<E>) pos;
		
        if (this != nodo.getMyQueue()) {
            throw new RuntimeException("Esa posicion no es de esta lista");
        }
        return nodo;
	}
	
	
	
	
	
	
	

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E front() throws RuntimeException {
		
		if (this.isEmpty()) {
			throw new RuntimeException("Cola vacia");
		}
		
		else {
			return this.primeroDeCola.getElement();
		}
	}

	@Override
	public void enqueue(E elemento) {
		
		if (this.primeroDeCola == null) {
			nodoCola<E> nuevo = new nodoCola<E>(elemento, null, null, this);
			this.primeroDeCola = nuevo;
			this.ultimoDeCola = nuevo;
		}
		
		else {
			nodoCola<E> nuevo = new nodoCola<E>(elemento, null, ultimoDeCola, this);
			this.ultimoDeCola.setNextNode(nuevo);
			this.ultimoDeCola = nuevo;
		}
		
	}

	@Override
	public E dequeue() throws RuntimeException {
		if (this.primeroDeCola == null) {
			throw new RuntimeException("Cola vacia");
		}
		else {
			E aux = this.primeroDeCola.getElement();
			this.primeroDeCola = this.primeroDeCola.getNextNode();
			this.primeroDeCola.setPreviousNode(null);
			
			
			
			
			return aux;
		}
	}

}
