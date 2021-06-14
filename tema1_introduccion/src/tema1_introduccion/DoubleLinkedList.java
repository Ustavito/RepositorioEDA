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

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public Position<E> first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> next(Position<E> pos) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> previous(Position<E> pos) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> addFirst(E elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> addLast(E elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> addAfter(Position<E> pos, E elemento) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> addBefore(Position<E> pos, E elemento) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(Position<E> pos) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(Position<E> pos, E elemento) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
