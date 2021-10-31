package ejercicios_tema_2;

public interface NAryTree<E> extends Tree<E> {
	
	//Implementaciones: LinkedNAryTree, LCRSTree
	public Position<E> addRoot(E e);
	
	//Agrega nodo cuyo padre es el position pasado
	public Position<E> add (Position<E> pos, E e);
	
	//Agrega nodo cuyo padre es el position y trata de poner al hijo en position n
	public Position<E> add (Position<E> pos, final int n, E e);
	
	//Cambia dos elementos en dos nodos
	public void swapElements(Position<E> p1, Position <E> p2);
	
	//Reemplaza un elemento en un nodo y devuelve el elemento reemplazado
	public E replace (Position<E> p, E e);
	
	//Elimina un nodo y su subarbol
	public void remove(Position<E> p);
	
	//Crea un nuevo subarbol desde la posicion dada
	public NAryTree<E> subTree(Position<E> v);
	
	//Agrega el arbol dado como hijo del nodo pos
	public void attach(Position<E> pos, NAryTree<E> tree);
}
