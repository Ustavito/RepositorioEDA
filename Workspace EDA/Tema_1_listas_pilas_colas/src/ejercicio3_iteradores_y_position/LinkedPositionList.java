package ejercicio3_iteradores_y_position;

import java.util.Iterator;

//Cambiar la lista a doblemente enlazada

public class LinkedPositionList<E> implements MyListBetter<E> {
	
	private class node<E> implements Position<E>{
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

		@Override
		public E getElement() {
			return this.elem;
		}
	}
	
	private int size;
	private node<E> head;

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isempty() {
		return this.size == 0;
	}

	@Override
	public Position<E> add(E value) {
		
		node<E> nuevoNodo = new node<E>(value, this.head);
		this.head = nuevoNodo;
		this.size ++;
		
		
		return (Position<E>) nuevoNodo;
	}

	@Override
	public Position<E> addBefore(Position<E> pos, E value) {
		
		node<E> siguiente = checkPosition(pos);
		
		//Caso 1, si el nodo se inserta por cabecera
		//Se inserta al inicio del todo
		if (this.head == siguiente) {
			
			node<E> nodoInsertar = new node<E>(value, this.head);
			this.head = nodoInsertar;
			this.size++;	
		}
		
		//Caso 2, se inserta en el cuerpo
		else {
			
			node<E> nodoInsertar = new node<E>(value, siguiente);
			//Necesito doble enlace para acceder a elementos anteriores, o al menos getPrev
			
			
			
			
		}
		
		
		
		return null;
	}

	@Override
	public Position<E> addAfter(Position<E> pos, E value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(Position<E> pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> set(Position<E> pos, E value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> search(E value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Position<E>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private node<E> checkPosition (Position<E> pos){
		if (pos == null || !(pos instanceof node)) {
			throw new RuntimeException ("That is not a node");
		}
		
		else {
			return (node<E>) pos;
		}
	}

}
