package arboles_binarios;

import java.util.Iterator;

import ejercicios_tema_2.Position;

public class LinkedBinaryTree<E> implements BinaryTree<E>{
	
	private BTNode<E> root;
	
	public LinkedBinaryTree(E elem) {
		this.root = new BTNode<E>(elem);
	}
	
	private class BTNode<T> implements Position<T>{
		
		private T element;
		private BTNode<T> hijoIzq;
		private BTNode<T> hijoDer;
		private BTNode<T> padre;
		
		public BTNode (T elem) {
			element = elem;
		}

		@Override
		public T getElement() {
			return element;
		}
		
		public void setElement(T elem) {
			this.element = elem;
		}
		
		public void setParent(BTNode<T> padre) {
			this.padre = padre;
		}
		
		public BTNode<T> getIzq(){
			return this.hijoIzq;
		}
		
		public BTNode<T> getDer(){
			return this.hijoDer;
		}
		
		public BTNode<T> getParent(){
			return this.padre;
		}

		public void setLeft(BTNode<T> hijo) {
			this.hijoIzq = hijo;
			
		}
		
		public void setRight(BTNode<T> hijo) {
			this.hijoDer = hijo;
		}
		
	}
	
	

    @Override
    public Position<E> left(Position<E> v) {
        BTNode<E> nodo = checkPosition(v);
        return nodo.getIzq();
    }

    @Override
    public Position<E> right(Position<E> v) {
        BTNode<E> nodo = checkPosition(v);
        return nodo.getDer();
    }

    @Override
    public boolean hasLeft(Position<E> v) {
    	BTNode<E> nodo = checkPosition(v);
        return nodo.getIzq() == null;
    }

    @Override
    public boolean hasRight(Position<E> v) {
    	BTNode<E> nodo = checkPosition(v);
        return ! (nodo.getDer() == null);
    }

    @Override
    //TODO revisa este metodo
    public boolean isInternal(Position<E> v) {
    	return !(isLeaf(v));
    }

    @Override
    
    //Tambien puedes implementar usando has right y has left
    public boolean isLeaf(Position<E> p) {
    	BTNode<E> nodo = checkPosition(p);
    	boolean hi = !(nodo.getIzq() == null);
    	boolean hd = !(nodo.getDer() == null);
       return hi && hd;
    }

    @Override
    public boolean isRoot(Position<E> p) {
    	BTNode<E> nodo = checkPosition(p);
        return nodo.getParent() == null;
    }

    @Override
    public Position<E> root() {
        return this.root;
    }

    @Override
    public E replace(Position<E> p, E e) {
    	BTNode<E> nodo = checkPosition(p);
    	E aux = nodo.getElement();
    	nodo.setElement(e);
    	return aux;
    }

    @Override
    
    //TODO Refactorizar
    public Position<E> sibling(Position<E> p) {
    	
    	BTNode<E> nodo = checkPosition(p);
    	if (isRoot(nodo)) {
    		throw new RuntimeException("That is the root, it does not have siblings");
    	}
    	
    	BTNode<E> padre = nodo.getParent();
    	
    	
    	if (padre.getDer() == nodo) {
    		nodo = padre.getIzq();
    	}
    	
    	else {
    		nodo = padre.getDer();
    	}
    	
    	
        return nodo;
    }

    @Override
    public Position<E> addRoot(E e) {
    	
    	if (!this.isEmpty()) {
    		throw new RuntimeException("The tree is not empty");
    	}
    	
    	BTNode<E> nodo = new BTNode<E>(e);
    	root = nodo;
    	return nodo;
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e) {
    	
    	if (hasLeft(p)) {
    		throw new RuntimeException("It already have a left children");
    	}
    	
    	BTNode<E> nodo = checkPosition(p);
    	BTNode<E> hijo = new BTNode<E>(e);
    	
    	hijo.setParent(nodo);
    	nodo.setLeft(hijo);
    	
    	return hijo;
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) {
        if (hasRight(p)) {
        	throw new RuntimeException("It already have a left children");
        }
        
        BTNode<E> nodo = checkPosition(p);
        BTNode<E> hijo = new BTNode<E>(e);
        
        hijo.setParent(nodo);
        nodo.setRight(hijo);
        
        return hijo;
    }

    @Override
    public E remove(Position<E> p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {
    	
    	BTNode<E> nodo1 = checkPosition(p1);
    	BTNode<E> nodo2 = checkPosition(p2);
    	
    	E aux = nodo1.getElement();
    	nodo1.setElement(nodo2.getElement());
    	nodo2.setElement(aux);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Position<E> parent(Position<E> v) {
    	//TODO meter excepcion
    	BTNode<E> nodo = checkPosition(v);
    	return nodo.getParent();
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void attachLeft(Position<String> h, LinkedBinaryTree<String> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void attachRight(Position<String> h, LinkedBinaryTree<String> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedBinaryTree<String> subTree(Position<String> h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	
	//Revisar arboles narios, te vale la implementacion.
	public Iterator<Position<E>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attachLeft(Position<String> h, BinaryTree<String> t1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachRight(Position<String> h, BinaryTree<String> t1) {
		// TODO Auto-generated method stub
		
	}
	
	private BTNode<E> checkPosition (Position<E> pos){
		if (pos == null || !(pos instanceof BTNode)) {
			throw new RuntimeException ("That is not a node");
		}
		
		else {
			return (BTNode<E>) pos;
		}
	}
}