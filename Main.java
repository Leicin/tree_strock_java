import java.util.Scanner;

/**
 * Clase Main: Punto de entrada de la aplicación.
 * Maneja el flujo del menú interactivo.
 */
public class Main {
    public static void main(String[] args) {
        ArbolInventario inventario = new ArbolInventario();
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n===============================");
            System.out.println("   GESTIÓN DE INVENTARIO BST   ");
            System.out.println("===============================");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario (Ordenado)");
            System.out.println("3. Buscar Producto por ID");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
                
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese ID único (Entero): ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Ingrese nombre del producto: ");
                        String nombre = sc.nextLine();
                        inventario.insertar(id, nombre);
                        System.out.println("¡Producto registrado exitosamente!");
                        break;

                    case 2:
                        System.out.println("\nLISTADO DE INVENTARIO:");
                        if (inventario.getRaiz() == null) {
                            System.out.println("El inventario está vacío.");
                        } else {
                            inventario.recorridoInorden(inventario.getRaiz());
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese el ID a buscar: ");
                        int busqueda = Integer.parseInt(sc.nextLine());
                        if (inventario.buscar(busqueda)) {
                            System.out.println("ESTADO: El producto con ID " + busqueda + " EXISTE.");
                        } else {
                            System.out.println("ESTADO: Producto no encontrado.");
                        }
                        break;

                    case 0:
                        System.out.println("Cerrando sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
            }
        }
        sc.close();
    }
}