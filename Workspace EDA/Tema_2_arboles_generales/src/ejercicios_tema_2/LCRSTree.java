package ejercicios_tema_2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LCRSTree<E> implements NAryTree<E> {
	
	LCRSNode<E> root;
	int size;
	
	public LCRSTree (E elem){
		root = new LCRSNode<E>(elem);
		this.size = 0;
	}
	
	
	private class LCRSNode<T> implements Position<T>{
		
		private T element;
		LCRSNode<T> parent;
		LCRSNode<T> lchild;
		LCRSNode<T> siblings;
		
		public LCRSNode (T elem) {
			this.element = elem;
			this.parent = null;
			this.lchild = null;
			this.siblings = null;
		}
		
		@Override
		public T getElement() {
			return element;
		}
		
		public LCRSNode<T> getParent(){
			return parent;
		}
		
		public LCRSNode<T> getLeftChild(){
			return lchild;
		}
		
		public boolean hasSiblings() {
			return siblings == null;
		}
		
		public boolean hasChild() {
			return !(lchild == null);
		}
		
		public LCRSNode<T> getSibling(){
			return siblings;
		}
		
		public void setElement(T e) {
			this.element = e;
		}
		
	}
	

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E replace(Position<E> v, E elem) {
		
		LCRSNode<E> nodo = checkPosition(v);
		E auxiliar = nodo.getElement();
		nodo.setElement(elem);
		return auxiliar;
	}

	@Override
	public Position<E> addRoot(E vaule) {
		
		//TODO revisa este metodo
		LCRSTree<E> raiz = new LCRSTree<E>(vaule);
		return raiz.root();
	}

	@Override
	public Iterator<Position<E>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> add(Position<E> pos, E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> add(Position<E> pos, int n, E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NAryTree<E> subTree(Position<E> pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attach(Position<E> pos, NAryTree<E> tree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Position<E> root() {
		return this.root;
	}

	@Override
	public Position<E> parent(Position<E> v) {
		LCRSNode<E> nodo = checkPosition(v);
		return nodo.getParent();
	}

	@Override
	public boolean isLeaf(Position<E> v) {
		LCRSNode<E> nodo = checkPosition(v);
		return nodo.hasChild();
	}

	@Override
	public boolean isRoot(Position<E> v) {
		LCRSNode<E> nodo = checkPosition(v);
		return nodo.getParent() == null;
	}

	@Override
	public boolean isInternal(Position<E> v) {
		LCRSNode<E> nodo = checkPosition(v);
		return !(nodo.hasChild());
	}

	@Override
	public Iterable<? extends Position<E>> children(Position<E> v) {
		LCRSNode<E> nodo = checkPosition(v);
		List<LCRSNode<E>> hijos = new LinkedList<LCRSNode<E>>();
		LCRSNode<E> hijo = nodo.getLeftChild();
		hijos.add(hijo);
		
		if (hijo.hasSiblings()) {
			agregaHermano(hijos, hijo.getSibling());
		}

		
		
		return hijos;
	}
	
	private void agregaHermano(List<LCRSNode<E>> lista, LCRSNode<E> nodo) {
		lista.add(nodo);
		if (nodo.hasSiblings()) {
			agregaHermano(lista, nodo.getSibling());
		}
	}

	
	
	
	@Override
	public void swapElements(Position<E> p1, Position<E> p2) {
		LCRSNode<E> nodo1 = checkPosition(p1);
		LCRSNode<E> nodo2 = checkPosition(p2);

		E aux = nodo1.getElement();
		nodo1.setElement(nodo2.getElement());
		nodo2.setElement(aux);
	}

	@Override
	public void remove(Position<E> p) {
		// TODO Auto-generated method stub
		
	}
	
	private LCRSNode<E> checkPosition (Position<E> pos){
		if (pos == null || !(pos instanceof LCRSNode)) {
			throw new RuntimeException ("That is not a node");
		}
		
		else {
			return (LCRSNode<E>) pos;
		}
	}



}
