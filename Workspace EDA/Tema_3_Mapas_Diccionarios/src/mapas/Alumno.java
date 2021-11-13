package mapas;

public class Alumno {
	private String nombre;
	private String dni;
	//private int edad;
	
	//EJERCICIO 1 - IMPLEMENTAR HASHCODE E EQUALS
	//HAY QUE SOBREESCRIBIR LOS METODOS DE LA CLASE
	
	@Override
	public int hashCode() {
		
		int aux1 = 0;
		int aux3 = 0;
		String aux2 = this.dni.substring(0, dni.length()-2);
		
		for (int i = 0; i <= aux2.length(); i++ ) {
			aux3 += aux2.charAt(i);
		}
		
		for(int i = 0; i <= nombre.length(); i++) {
			aux1 += (int) this.nombre.charAt(i);
		}
		
		return (aux1 ^ aux3);
	}
	
	@Override
	public boolean equals (Object obj) {
		
		boolean iguales = false;

        if (obj instanceof Alumno) {
        	Alumno alumno = (Alumno) obj;
        	iguales = (this.nombre == alumno.nombre) && (this.dni == alumno.dni);
        } 
        
        return iguales;
    }
}