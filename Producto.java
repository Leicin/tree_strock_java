/**
 * Clase Producto: Representa el Nodo del Árbol Binario.
 * Contiene la información del objeto y las referencias a sus hijos.
 */
public class Producto {
    // Datos del producto
    int id;
    String nombre;

    // Punteros: Referencias de memoria hacia otros objetos de tipo Producto
    Producto izquierdo;
    Producto derecho;

    // Constructor para inicializar un nuevo nodo (hoja)
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null; // Inicialmente no tiene hijos
        this.derecho = null;
    }
}