package tema1_introduccion;

public interface lista<E> {
	
	int size();
	
	boolean isEmpty();
	
	Position<E> first();
	
	Position<E> last();
	
	Position<E> next(Position<E> pos) throws RuntimeException;
	
	Position<E> previous(Position<E> pos) throws RuntimeException;
	
	Position<E> addFirst (E elemento);
	
	Position<E> addLast (E elemento);
	
	Position<E> addAfter (Position<E> pos, E elemento) throws RuntimeException;
	
	Position<E> addBefore (Position<E> pos, E elemento) throws RuntimeException;
	
	E remove (Position<E> pos) throws RuntimeException;
	
	E set (Position<E> pos, E elemento) throws RuntimeException;

}
