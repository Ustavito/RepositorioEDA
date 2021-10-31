package ejercicio2_listas_genericas;

//Se trata de la interfaz, sirve para implementar los tipos de lista que necesite

public interface GenericList<E> {
	
	//Devuelve el tamaño de la lista
	public int size();
	
	//Devuelve true o false si la lista esta o no vacia
	public boolean isEmpty();
	
	//Recibe un valor generico y lo añade a la lista
	public void add (E valor);
	
	//Recibe un valor entero y el lugar donde quiero insertar, se usa en listas estaticas
	public void add(int indice, E valor);
	
	//Elimina un elemento de la lista y lo devuelve
	public E remove();
	
	//Elimina un elemento de un indice concreto y lo devuelve
	public E remove(int indice);
	
	//Devuelve un elemento
	public E get();
	
	//Devuelve el elemento que este en un indice
	public E get(int indice);
	
	//Busca un elemento dado y devuelve su posicion
	public int search (E valor);
	
	//Dado un elemento dice si esta dentro de la lista
	public boolean contains (E valor);

}
