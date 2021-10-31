package ejercicio2_listas_genericas;

public class GenericLinkedList<E> implements GenericList<E> {
	
	//***CLASE PRIVADA NODO
	
	private class node<E>{
		private E elem;
		private node<E> next;
		
		public E getElem() {
			return elem;
		}
		
		public void setElem(E elem) {
			this.elem = elem;
		}
		
		public node<E> getNext(){
			return next;
		}
		
		public void setNext(node<E> next) {
			this.next = next;
		}
		
		public node (E e, node<E> siguiente){
			this.elem = e;
			this.next = siguiente;
		}
	}
	
	//***FIN CLASE PRIVADA NODO
	
	//***REVISAR METODO FORWARD!!!***
	//Paso previo a generar iterator solo recorre la lista
	private node<E> forward(int indice) {
		if ((indice < 1) || (indice > (this.size + 1))) {
			throw new RuntimeException("Out of bounds");
		}
		
		node<E> anterior = null;
		node<E> actual = this.head;
		for (int i = 1; i < indice; i++) {
			anterior = actual;
			actual = actual.getNext();
		}
		
		return anterior;
	}
	
	//ATRIBUTOS DE LA CLASE
	
	private int size;
	private node<E> head;
	
	//CONSTRUCTOR DE LA CLASE
	
	public GenericLinkedList() {
		this.size = 0;
		this.head = null;
	}
	
	//METODOS DE LA CLASE

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	@Override
	
	//Se crea un nodo con el valor que nos han pasado, ese nodo se inserta por la cabecera (es lo mas sencillo)
	public void add(E valor) {
		
		node<E> nodo_a_insertar = new node<E>(valor, this.head);
		this.head = nodo_a_insertar;
		this.size ++;
		
	}

	@Override
	public void add(int indice, E valor) {
		
	}

	@Override
	public E remove() {
		if (this.isEmpty()) {
			throw new RuntimeException("List is empty");
		}
		
		else {
			node<E> nodo_a_eliminar = this.head;
			this.head = this.head.getNext();
			return nodo_a_eliminar.getElem();
		}
	}

	@Override
	public E remove(int indice) {
		return null;
	}

	@Override
	public E get() {
		
		if (this.isEmpty()) {
			throw new RuntimeException ("The list is empty");
		}
		
		else {
			return this.head.getElem();
		}
	}

	@Override
	public E get(int indice) {
		return null;
	}

	@Override
	public int search(E valor) {
		return 0;
	}

	@Override
	public boolean contains(E valor) {
		return false;
	}
}
