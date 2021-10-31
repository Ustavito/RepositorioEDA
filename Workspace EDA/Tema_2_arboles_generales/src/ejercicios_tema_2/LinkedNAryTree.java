package ejercicios_tema_2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedNAryTree<E> implements NAryTree<E> {
	
	//E y T son diferentes, porque no es el mismo E
	//Podría poner E sin embargo
	
	private TreeNode<E> root;
	
	//CLASE PRIVADA NODO DEL ARBOL
	private class TreeNode<T> implements Position<T>{
		
		T element;
		List<TreeNode<T>> lista = new LinkedList<TreeNode<T>>();
		TreeNode<T> parent;
		
		public TreeNode (T elem, TreeNode<T> padre){
			this.element = elem;
			this.parent = padre;
			this.lista = new LinkedList<TreeNode<T>>();
		}

		@Override
		public T getElement() {
			return element;
		}
		
		public void setElement(T elem) {
			this.element = elem;
		}
		
		public TreeNode<T> getParent(){
			return this.parent;
		}
		
		public void setParent(TreeNode<T> padreNuevo) {
			this.parent = padreNuevo;
		}
		
		public List<TreeNode<T>> getChildren(){
			return  lista;
		}
		
		public void addChildren(TreeNode<T> hijo) {
			this.lista.add(hijo);
		}
		
		public void removeChildren(TreeNode<T> hijo) {
			this.lista.remove(hijo);
		}
	}
	//FIN DE LA CLASE PRIVADA NODO DEL ARBOL
	
	public LinkedNAryTree () {
		root = null;
	}
	
	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public E replace(Position<E> v, E elem) {
		
		TreeNode<E> nodo = checkPosition(v);
		E aux = nodo.getElement();
		nodo.setElement(elem);
		return aux;
	}

	@Override
	public Position<E> addRoot(E vaule) {
		root = new TreeNode<E>(vaule, null);
		return (Position<E>)root; //No hace falta el casting
	}

	@Override
	public Iterator<Position<E>> iterator() {
		
		//Devuelve algo que permite recorrer el arbol
		return null;
	}

	@Override
	public Position<E> add(Position<E> pos, E e) {
		
		//Confirma que se pasa una posicion valida
		TreeNode<E> padre = checkPosition(pos);
		
		//Crea un nodo nuevo a partir del elemento pasado y lo enlaza al position pasado
		TreeNode<E> insertar = new TreeNode<E>(e, padre);
		
		//Agrega a la lista del position pasado el nodo creado
		padre.addChildren(insertar);
		return insertar;
	}

	@Override
	public Position<E> add(Position<E> pos, int n, E e) {
		TreeNode<E> padre = checkPosition(pos);
		TreeNode<E> insertar = new TreeNode<E>(e, padre);
		
		//Agrega al nodo en la posicion n de la lista de hijos
		padre.lista.add(n, insertar);
		
		return insertar;
	}

	@Override
	public NAryTree<E> subTree(Position<E> pos) {
		
		//Revisar este ejercicio
		TreeNode<E> newNode = checkPosition(pos);
		LinkedNAryTree<E> arbol = new LinkedNAryTree<E>();
		arbol.addRoot(newNode.getElement());
		newNode.setParent(null);
		
		return arbol;
	}

	@Override
	public void attach(Position<E> pos, NAryTree<E> tree) {
		// TODO Auto-generated method stub
	}

	@Override
	public Position<E> root() {
		return root;
	}

	@Override
	public Position<E> parent(Position<E> v) {
		
		if (isRoot(v)) {
			throw new RuntimeException("Eso es la raiz");
		}
		
		TreeNode<E> nodo = checkPosition(v);
		return nodo.getParent();
	}

	@Override
	public boolean isLeaf(Position<E> v) {
		
		TreeNode<E> nodo = checkPosition(v);
		return nodo.getChildren().isEmpty();
	}

	@Override
	public boolean isRoot(Position<E> v) {
		
		TreeNode<E> nodo = checkPosition(v);
		return nodo.getParent() == null;
	}

	@Override
	public boolean isInternal(Position<E> v) {
		
		TreeNode<E> nodo = checkPosition(v);
		return ! isLeaf(nodo);
	}

	@Override
	//Preguntar por este metodo
	public Iterable<? extends Position<E>> children(Position<E> v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void swapElements(Position<E> p1, Position<E> p2) {
		TreeNode<E> nodo1 = checkPosition(p1);
		TreeNode<E> nodo2 = checkPosition(p2);
		E e = p1.getElement();
		nodo1.setElement(nodo2.getElement());
		nodo2.setElement(e);
	}

	@Override
	
	//Podriamos convertir el remove en static, asi evitamos borrar nodos de otros arboles
	public void remove(Position<E> p) {
		
		//TODO -> Preguntar por eficiencia
		TreeNode<E> nodo = checkPosition(p);
		TreeNode<E> padre = nodo.getParent();
		nodo.setParent(null);
		padre.removeChildren(nodo);
	}
	
	//Se busca compromiso entre seguridad y eficiencia
	//Ojo, esta comprobacion causa O(n) en subTree
	//Pero si no se usa podría modificarse un arbol diferente
	
	private TreeNode<E> checkPosition (Position<E> pos){
		if (pos == null || !(pos instanceof TreeNode)) {
			throw new RuntimeException ("That is not a node");
		}
		
		else {
			return (TreeNode<E>) pos;
		}
	}
}