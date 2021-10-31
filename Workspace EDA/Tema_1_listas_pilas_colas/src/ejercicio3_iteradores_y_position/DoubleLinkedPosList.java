package ejercicio3_iteradores_y_position;

import java.util.Iterator;

public class DoubleLinkedPosList<E> implements MyListBetter<E> {
	
	private int size;
	private node<E> head;
	
	private class node<E> implements Position<E>{
		private E elem;
		private node<E> next;
		private node<E> prev;
		
		public E getElem() {
			return elem;
		}
			
		public void setElem(E elem) {
			this.elem = elem;
		}
			
		public node<E> getNext(){
			return next;
		}
		
		public node<E> getPrev(){
			return prev;
		}
			
		public void setNext(node<E> next) {
			this.next = next;
		}
		
		public void setPrev(node<E> prev) {
			this.prev = prev;
		}
			
		public node (E e, node<E> anterior, node<E> siguiente){
			this.elem = e;
			this.next = siguiente;
			this.prev = anterior;
		}

		@Override
		public E getElement() {
			return this.elem;
		}
	}
	
	//CHECKPOSITION METODO PRIVADO
	private node<E> checkPosition (Position<E> pos){
		if (pos == null || !(pos instanceof node)) {
			throw new RuntimeException ("That is not a node");
		}
		else {
			return (node<E>) pos;
		}
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isempty() {
		return (this.size == 0);
	}

	@Override
	
	//Insercion por cabecera
	public Position<E> add(E value) {
		
		//Se crea el nodo nuevo y se enlaza con la cabecera
		node<E> insertar = new node<E>(value, null, this.head);
		
		//Se enlaza la antigua cabecera con el nodo nuevo
		this.head.setPrev(insertar);
		
		//Se declara la nueva cabecera
		this.head = insertar;
		
		//Se devuelve el position del nodo insertado
		return (Position<E>) insertar;
	}

	@Override
	public Position<E> addAfter(Position<E> pos, E value) {
		
		node<E> insertarDespuesDe = (checkPosition(pos));
		
		node<E> nuevoNodo = new node<E>(value, insertarDespuesDe, insertarDespuesDe.getNext());
		
		//Se enlazan los nodos con el nodo nuevo
		insertarDespuesDe.getNext().setPrev(nuevoNodo);
		insertarDespuesDe.setNext(nuevoNodo);
		
		
		
		
		
		
		
		return (Position<E>) nuevoNodo;
	}

	@Override
	public Position<E> addBefore(Position<E> pos, E value) {
		node<E> insertarAntesDe = (checkPosition(pos));
		node<E> nuevoNodo = new node<E>(value, insertarAntesDe.getPrev(), insertarAntesDe);
		
		if (insertarAntesDe == this.head) {
			this.head.setPrev(nuevoNodo);
			this.head = nuevoNodo;
			
		}
		
		else {
			insertarAntesDe.getPrev().setNext(nuevoNodo);
			insertarAntesDe.setPrev(nuevoNodo);
		}
		
		return nuevoNodo;
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
	
	

}
