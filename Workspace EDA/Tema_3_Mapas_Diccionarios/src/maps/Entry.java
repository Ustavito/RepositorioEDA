package maps;

/**
 * @author R. Cabido, A. Duarte, and J. Velez
 * 
*
 */
/**
 * Interface for a key-value pair entry
 *
 * @param <K> Key type
 * @param <V> value type
 *
 */

//ENTRY ES COMO EL POSITION DE LOS MAPAS
//PERO YA NO VALE CON UN POSITION, SE NECESITA LA ENTRADA COMPLETA


public interface Entry<K, V> {

    /**
     * Returns the key stored in this entry.
     *
     * @return The key
     */
    public K getKey();

    /**
     * Returns the value stored in this entry.
     *
     * @return The value
     */
    public V getValue();
}
