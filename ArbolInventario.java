/**
 * Clase ArbolInventario: Contiene la lógica de manipulación del BST.
 */
public class ArbolInventario {
    private Producto raiz;

    public ArbolInventario() {
        this.raiz = null;
    }

    // Retorna la raíz para que el Main pueda iniciar los recorridos
    public Producto getRaiz() {
        return raiz;
    }

    /**
     * MÉTODO INSERTAR (Recursivo)
     * Determina la posición del nuevo producto según su ID.
     */
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        // Si el puntero es null, hemos encontrado el lugar para el nuevo objeto
        if (actual == null) {
            return new Producto(id, nombre);
        }

        // Lógica de búsqueda de posición: menores a la izquierda, mayores a la derecha
        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } else if (id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        }
        return actual;
    }

    /**
     * MÉTODO RECORRIDO INORDEN
     * Visita: Izquierda -> Raíz -> Derecha (Muestra los datos ordenados por ID).
     */
    public void recorridoInorden(Producto nodo) {
        if (nodo != null) {
            recorridoInorden(nodo.izquierdo); // Visita rama izquierda
            System.out.println(" > [ID: " + nodo.id + "] Nombre: " + nodo.nombre);
            recorridoInorden(nodo.derecho);   // Visita rama derecha
        }
    }

    /**
     * MÉTODO BUSCAR
     * Busca un ID comparando niveles del árbol para optimizar tiempo.
     */
    public boolean buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private boolean buscarRecursivo(Producto actual, int id) {
        if (actual == null) return false; // ID no encontrado
        if (id == actual.id) return true; // ID encontrado

        // Navegación binaria
        return id < actual.id 
            ? buscarRecursivo(actual.izquierdo, id) 
            : buscarRecursivo(actual.derecho, id);
    }
}