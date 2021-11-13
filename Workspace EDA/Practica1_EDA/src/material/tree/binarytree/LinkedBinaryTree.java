
package material.tree.binarytree;

import java.util.Iterator;
import material.Position;

/**
 *
 * @author mayte
 * @param <T>
 */
public class LinkedBinaryTree<T> implements BinaryTree<T> {

    //El arbol se compone de un nodo raiz
    private BTNode<T> root;

    private class BTNode<T> implements Position<T>{
        private T element;
        private BTNode<T> hijoDer;
        private BTNode<T> hijoIzq;
        private BTNode<T> padre;

        public BTNode (T elem) {
            element = elem;
        }

        @Override
        public T getElement() {
            return this.element;
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
    public Position<T> left(Position<T> v) {
          BTNode<T> nodo = checkPosition(v);
          return nodo.getIzq();
    }

    @Override
    public Position<T> right(Position<T> v) {
        BTNode<T> nodo = checkPosition(v);
        return nodo.getDer();
    }

    @Override
    public boolean hasLeft(Position<T> v) {
         BTNode<T> nodo = checkPosition(v);
         return nodo.getIzq() == null;
    }

    @Override
    public boolean hasRight(Position<T> v) {
        BTNode<T> nodo = checkPosition(v);
        return nodo.getDer() == null;
    }

    @Override
    public boolean isInternal(Position<T> v) {
        return !(isLeaf(v));
    }

    @Override
    public boolean isLeaf(Position<T> p) {
      BTNode<T> nodo = checkPosition(p);
      boolean hi = !(nodo.getIzq() == null);
      boolean hd = !(nodo.getDer() == null);
      return hi && hd;
    }

    @Override
    public boolean isRoot(Position<T> p) {
        BTNode<T> nodo = checkPosition(p);
        return nodo.getParent() == null;
    }

    @Override
    public Position<T> root() {
      return this.root;
    }

    @Override
    public T replace(Position<T> p, T e) {
        BTNode<T> nodo = checkPosition(p);
        T aux = nodo.getElement();
        nodo.setElement(e);
        return aux;
    }

    @Override
    public Position<T> sibling(Position<T> p) {
      BTNode<T> nodo = checkPosition(p);
      if (isRoot(nodo)){
          throw new RuntimeException("That is the root");
      }
      BTNode<T> padre = nodo.getParent();
      BTNode<T> hermano = null;

      if (padre.getDer() == nodo){
          hermano = padre.getIzq();
      }
      else{
          hermano = padre.getDer();
      }
      return hermano;
    }

    @Override
    public Position<T> addRoot(T e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<T> insertLeft(Position<T> p, T e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<T> insertRight(Position<T> p, T e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remove(Position<T> p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void swap(Position<T> p1, Position<T> p2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<T> parent(Position<T> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<? extends Position<T>> children(Position<T> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position<T>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attachLeft(Position<T> h, BinaryTree<T> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attachRight(Position<T> h, BinaryTree<T> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BinaryTree<T> subTree(Position<T> h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private BTNode<T> checkPosition (Position<T> pos){
        if (pos == null || !(pos instanceof BTNode)) {
            throw new RuntimeException ("That is not a node");
        }

        else {
            return (BTNode<T>) pos;
        }
    }
    
}
