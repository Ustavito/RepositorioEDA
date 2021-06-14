package tema1_introduccion;

public interface lista<E> {
	
	//Devuelve la cantidad de elementos de la lista
	int size();
	
	//Devuelve True o False en funcion de si la lista esta vacia o no
	boolean isEmpty();
	
	//Devuelve el primer elemento de la lista
	Position<E> first();
	
	//Devuelve el ultimo elemento de la lista
	Position<E> last();
	
	//Devuelve en siguiente dada una posicion que le pases
	Position<E> next(Position<E> pos) throws RuntimeException;
	
	//Devuelve el anterior dada una posicion que le pases
	Position<E> previous(Position<E> pos) throws RuntimeException;
	
	//Añade al inicio dado un elemento que le pases
	Position<E> addFirst (E elemento);
	
	//Añade al final dado un elemento que le pases
	Position<E> addLast (E elemento);
	
	//Añade después de una posición que le pases, dado un elemento que le pases
	Position<E> addAfter (Position<E> pos, E elemento) throws RuntimeException;
	
	//Añade antes de una posición que le pases, dado un elemento que le pases
	Position<E> addBefore (Position<E> pos, E elemento) throws RuntimeException;
	
	//Elimina un elemento, dada una posicion que le pases
	E remove (Position<E> pos) throws RuntimeException;
	
	//Pone un elemento que le pases en la posicion que le pases
	E set (Position<E> pos, E elemento) throws RuntimeException;

}
