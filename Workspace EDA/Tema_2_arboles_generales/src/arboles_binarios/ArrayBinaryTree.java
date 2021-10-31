package arboles_binarios;

import java.util.Iterator;

import ejercicios_tema_2.Position;

public class ArrayBinaryTree<E> implements BinaryTree<E> {
	
	/**
	private class nodo tendra un elem y un bool que indique que es valido


**/
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Position<E> parent(Position<E> v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<? extends Position<E>> children(Position<E> v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Position<E>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> left(Position<E> v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> right(Position<E> v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasLeft(Position<E> v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasRight(Position<E> v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInternal(Position<E> v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLeaf(Position<E> p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRoot(Position<E> p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Position<E> root() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E replace(Position<E> p, E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> sibling(Position<E> p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> addRoot(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> insertLeft(Position<E> p, E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> insertRight(Position<E> p, E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(Position<E> p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void swap(Position<E> p1, Position<E> p2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachLeft(Position<String> h, BinaryTree<String> t1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachRight(Position<String> h, BinaryTree<String> t1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BinaryTree<String> subTree(Position<String> h) {
		// TODO Auto-generated method stub
		return null;
	}

}
