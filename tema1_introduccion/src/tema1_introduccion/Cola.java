package tema1_introduccion;

public interface Cola<E> {
	
	//Devuelve el tamaño de la cola
	int size();
	
	//Devuelve True o False en función de si está vacía o no
	boolean isEmpty();
	
	//Devuelve el último elemento de la cola
	E front();
	
	//Pone en la cola un elemento que le pases
	void enqueue(E elemento);
	
	//Quita de la cola un elemento y lo devuelve
	E dequeue();

}
