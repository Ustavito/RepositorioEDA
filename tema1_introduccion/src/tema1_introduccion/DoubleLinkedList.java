package tema1_introduccion;


public class DoubleLinkedList<E> implements lista<E> {
	
//*********************************INICIO CLASE PRIVADA NODO ***********************************
	
	private class nodo<T> implements Position<T>{
		
		//Enlace al siguiente nodo
		private nodo<T> prev;
		
		//Enlace al nodo anterior
		private nodo<T> next;
		
		//Elemento como tal de la lista
		private T elemento;
		
		//Referencia a la lista a la que pertenece el nodo
		private DoubleLinkedList<T> miLista;
		
		public nodo(nodo<T> newPrevio, nodo<T> newSiguiente, T newElemento, DoubleLinkedList<T> lista) {
			this.prev = newPrevio;
			this.next = newSiguiente;
			this.elemento = newElemento;
			this.miLista = lista;
		}
		
		@Override
		public T getElement() {
			return this.elemento;
		}
		
		public nodo<T> getNextNode(){
			return this.next;
		}
		
		public nodo<T> getPrevNode(){
			return this.prev;
		}
		
		public void setNext(nodo<T> nuevo) {
			this.next = nuevo;
		}
		
		public void setPrev(nodo<T> nuevo) {
			this.prev = nuevo;
		}
		
		public void setElement(T nuevoElemento) {
			this.elemento = nuevoElemento;
		}
		
		public DoubleLinkedList<T> getMylist() {
			return this.miLista;
		}
	}
	//*********************************FIN CLASE PRIVADA NODO ***********************************
	
	//Contiene el tamaño de la lista
	protected int size;
	
	//Contiene el nodo cabecera
	protected nodo<E> cabecera;
	
	//Contiene el nodo final
	protected nodo<E> trailer;
	
	//SON PROTECTED PORQUE SOLO SE USAN DE AUXILIARES DENTRO DE LA CLASE
	
	//Constructor sin argumentos
	public DoubleLinkedList() {
		this.size = 0;
		this.cabecera = null;
		this.trailer = null;
	}
	
	private nodo<E> checkPosition(Position<E> pos) throws RuntimeException {
		if (pos == null || !(pos instanceof nodo)) {
			throw new RuntimeException("Posición no válida");
		}
		//Se convierte la posicion en un nodo
		nodo<E> node = (nodo<E>) pos;
		
        if (this != node.getMylist()) {
            throw new RuntimeException("Esa posicion no es de esta lista");
        }
        return node;
		
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public Position<E> first() throws RuntimeException {
		if (this.isEmpty()) {
			throw new RuntimeException("Lista vacía");
		}
		return this.cabecera;
	}

	@Override
	public Position<E> last() throws RuntimeException {
		if (this.isEmpty()) {
			throw new RuntimeException("Lista vacía");
		}
		return this.trailer;
	}

	@Override
	public Position<E> previous(Position<E> pos) throws RuntimeException {
		nodo<E> nodoActual = checkPosition(pos);
		nodo<E> previo = nodoActual.getPrevNode();
		
		if (previo == null) {
			throw new RuntimeException("Estas en el primer elemento");
		}
		
		return previo;
	}

	@Override
	public Position<E> next(Position<E> pos) throws RuntimeException {
		nodo<E> nodoActual = checkPosition(pos);
		nodo<E> sig = nodoActual.getNextNode();
		
		if (sig == null) {
			throw new RuntimeException("Estas en el ultimo elemento");
		}
		
		return sig;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Position<E> addFirst(E elemento) {
		
		nodo<E> nuevo;
		
		if (this.isEmpty()) {
			nuevo = new nodo<E>(null, null, elemento, this);
		}
		
		else {
			nuevo = new nodo<E>(null, this.cabecera, elemento, this);
			this.cabecera.setPrev(nuevo);
			this.cabecera.setElement((E) nuevo);
		}
		
		size ++;
		return nuevo;
	}

	@Override
	public Position<E> addLast(E elemento) {
		
		nodo<E> nuevo;
		
		if (this.isEmpty()) {
			nuevo = new nodo<E>(null, null, elemento, this);
		}
		else {
			//Si la lista no es vacia:
			//1) crea un nodo nuevo y lo enlaza con el final
			//2) enlaza el final al nodo nuevo
			//3) actualiza el final para que sea el nodo nuevo
			nuevo = new nodo<E>(this.trailer, null, elemento, this);
			this.trailer.setNext(nuevo);
			this.trailer = nuevo;
		}
		return null;
	}

	@Override
	public Position<E> addAfter(Position<E> pos, E elemento) throws RuntimeException {
		
		nodo<E> referenciado = checkPosition(pos);
		nodo<E> nuevo;
		
		if (referenciado == this.cabecera) {
			nuevo = new nodo<E>(referenciado, null,  elemento, this);
			referenciado.setNext(nuevo);
			this.trailer = nuevo;
			
			this.cabecera.setNext(nuevo);
		}
		
		else {
			nuevo = new nodo<E>(referenciado, referenciado.getNextNode(), elemento, this);
			referenciado.getNextNode().setPrev(nuevo);
			referenciado.setNext(nuevo);
			
		}
		this.size++;
		return nuevo;
	}

	@Override
	public Position<E> addBefore(Position<E> pos, E elemento) throws RuntimeException {
		nodo<E> referenciado = checkPosition(pos);
		nodo<E> nuevo;
		
		if (referenciado == this.cabecera) {
			nuevo = new nodo<E> (null, referenciado, elemento, this);
			referenciado.setPrev(nuevo);
			this.cabecera = nuevo;
			this.cabecera.setNext(nuevo.getNextNode());
		}
		
		else {
			nuevo = new nodo<E>(referenciado.getPrevNode(), referenciado, elemento, this);
			referenciado.getPrevNode().setNext(nuevo);
			referenciado.setPrev(nuevo);
		}
		
		this.size ++;
		
		
		return nuevo;
	}

	@Override
	public E remove(Position<E> pos) throws RuntimeException {
		nodo<E> nodoAeliminar = checkPosition(pos);
		E elementoAeliminar = nodoAeliminar.getElement();
		
		if (this.cabecera == this.trailer) {
			this.cabecera = null;
			this.trailer = null;
		}
		
		else if (nodoAeliminar == this.cabecera) {
			this.cabecera = this.cabecera.getNextNode();
		}
		
		else if(nodoAeliminar == this.trailer) {
			this.trailer = this.trailer.getPrevNode();
		}
		
		else {
			nodo<E> previoAlEliminado = nodoAeliminar.getPrevNode();
			nodo<E> posteriorAlEliminado = nodoAeliminar.getNextNode();
			
			previoAlEliminado.setNext(posteriorAlEliminado);
			posteriorAlEliminado.setPrev(previoAlEliminado);
		}
		
		this.size --;
		
		
		return elementoAeliminar;
	}

	@Override
	public E set(Position<E> pos, E elemento) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
