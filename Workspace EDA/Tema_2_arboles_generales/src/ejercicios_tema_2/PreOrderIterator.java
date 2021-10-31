package ejercicios_tema_2;

import java.util.Iterator;
import java.util.*;

public class PreOrderIterator<E> implements Iterator<Position<E>> {
	
	List<Position<E>> lista = new LinkedList<Position<E>>();
	Tree<E> arbol;
	
	PreOrderIterator(Tree<E> arbol, Position<E> root){
		this.arbol = arbol;
		this.lista.add(root);
		
	}
	
	PreOrderIterator(Tree<E> arbol){
		this(arbol, arbol.root());
	}

	@Override
	public boolean hasNext() {
		return ! lista.isEmpty();
	}

	@Override
	public Position<E> next() {
		
		//remove sin parametros, siempre es O(1)
		Position<E> pos = lista.get(0);
		lista.remove(0);
		List<Position<E>> reverseList = new LinkedList<Position<E>>();
		
		for (Position <E> q : reverseList){
			lista.add(q);
		}
		
		
		for(Position<E> q: arbol.children(pos)) {
			lista.add(q);
			
			//Esto no es un preorden
		}
		
		return pos;
	}
	
	/* Para usar iterator:
	 * Iterator<Position<int>> iterador = arbol.iterator():
	 * while (iterador.hasNext()){
	 * 		S.O.P(iterador.next());
	 * }
	 */

}
