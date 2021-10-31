package ejercicios_tema_2;
import java.util.*;

public class PosOrderIterator<E> implements Iterator<Position<E>> {
	
	//ATRIBUTOS DEL ITERADOR
	
	//CLASE PRIVADA
	private class MarcaPos<T>{
		//Estructura auxiliar
		//Dice si hemos recorrido una pos del arbol
		//Durante el postorden
		
		private boolean marcado;
		private T elemento;
		
		//CONSTRUCTOR CLASE PRIVADA
		public MarcaPos(T t) {
			marcado = false;
			elemento = t;
		}
		
		//METODOS CLASE PRIVADA
		public void marcar() {
			this.marcado = true;
		}
		
		public boolean isMarcado() {
			return marcado;
		}
		
		public T getElement() {
			return this.elemento;
		}
		
	}
	
	//Nodos para recorrer
	Stack<MarcaPos<Position<E>>> porRecorrer = new Stack<>();
	
	Stack <Position<E>> procesaEsto = new Stack<>();
	
	Tree<E> recorreEsto;
	
	public PosOrderIterator(Tree<E> tree) {
		recorreEsto = tree;
		porRecorrer.add(new MarcaPos<>(tree.root()));
	}
	

	@Override
	public boolean hasNext() {
		return !porRecorrer.isEmpty();
	}

	@Override
	public Position<E> next() {
		MarcaPos<Position<E>> pMarca = porRecorrer.peek();
		
		if (pMarca.isMarcado()) {
			return porRecorrer.pop().getElement();
		}
		
		while (recorreEsto.children(pMarca.getElement()).iterator().hasNext()) {
			pMarca.marcar();
			
			for (Position<E> pos: recorreEsto.children(pMarca.getElement())) {
				procesaEsto.add(pos);
			}
			
			while (!procesaEsto.isEmpty()) {
				porRecorrer.add(new MarcaPos<>(procesaEsto.pop()));
			}
			
			pMarca = porRecorrer.peek();
		}
		return porRecorrer.pop().getElement();
	}

}
