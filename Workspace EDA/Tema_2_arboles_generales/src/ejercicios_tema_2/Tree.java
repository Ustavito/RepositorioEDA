package ejercicios_tema_2;

public interface Tree<E> extends Iterable<Position<E>>{
	
	//Devuelve si esta vacio o no
	public boolean isEmpty();
	
	//Devuelve la raiz
	public Position<E> root();
	
	//Devuelve el padre de un nodo dado
	public Position<E> parent(Position<E> v);
	
	//Dado un nodo y un elemento, reemplaza y devuelve lo reemplazado
	public E replace (Position<E> v, E elem);
	
	//Dado un valor lo agrega como raiz y devuelve el position
	public Position<E> addRoot (E vaule);
	
	//Dice si un nodo es hoja, raiz o interno
	public boolean isLeaf(Position<E> v);
	public boolean isRoot(Position<E> v);
	public boolean isInternal(Position<E> v);
	
	//Devuelve coleccion iterable del hijo de un nodo
	public Iterable <? extends Position<E>> children(Position<E> v);
	
	

}
