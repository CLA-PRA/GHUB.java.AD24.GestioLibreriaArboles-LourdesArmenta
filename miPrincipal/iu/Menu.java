package miPrincipal.iu;
import java.util.Scanner;
public class Menu{
    static Scanner scanner = new  Scanner(System.in);
	
		
	public void lectura() {
			
		imprimirMenu();	
				
	}
    private static void imprimirMenu() {
        int opcion;
       
        do {
            System.out.println("Menú:");
            System.out.println(" 1. Agregar libro al catalogo y al inventario ");
            System.out.println(" 2. Mostrar catalogo de libros");
            System.out.println(" 3. Mostrar libros disponibles");
            System.out.println(" 4. Prestar libros");
            System.out.println(" 5. Mostrar libros prestados");
            System.out.println(" 6. Agregar libro a la cola (Reserva de  libros)");
            System.out.println(" 7. Obtener libro de la cola (Siguiente libro para prestamo)");
            System.out.println(" 8. Mostrar cola de libros en reserva");
            System.out.println(" 9. Agregar proveedores");
            System.out.println("10. Elaborar pedido");
            System.out.println("11. Devolver libro prestado");
            System.out.println("12. Eliminar ultimo libro");
            System.out.println("13. Deshacer eliminacion de libro (Restaura operacion de eliminar ultimo libro)");
            System.out.println("14. Agregar usuarios");
            System.out.println("15. Eliminar usuarios");
            System.out.println("16. Modificar usuarios");
            System.out.println("17. Mostrar usuarios");

            System.out.println("0. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcion) {
                case 1:
                    MenuOpciones.agregarLibro();
                    break;
                case 2:
                    MenuOpciones.mostrarLibros();
                    break;
                case 3:
                    MenuOpciones.mostrarLibrosDisponibles();
                    break;
                case 4:
                    MenuOpciones.prestarLibros();
                    break;
                   
                case 5:
                    MenuOpciones.mostrarLibrosPrestados();
                    break;
                case 6:
                    
                    MenuOpciones.agregarLibroCola();
                    break;
                case 7:
                    
                    MenuOpciones.obtenerLibroCola();
                    break;
                case 8:
                   
                    MenuOpciones.mostrarReservaLibros();
                    break;
                case 9:
                    MenuOpciones.crearProveedor();
                    break;
                case 10:
                   
                    MenuOpciones.crearPedido();
                    break;
                case 11:
                  
                    MenuOpciones.devolverLibro();
                    break;
                case 12:
                    
                    MenuOpciones.eliminarUltimoLibro();
                    break;
                case 13:
                   
                    MenuOpciones.deshacerEliminarLibro();
                    break;
                case 14:
                    MenuOpciones.agregarUsuario();
                    break;
                case 15:
                    MenuOpciones.eliminarUsuario();
                   break;
                case 16:
                    MenuOpciones.actualizarUsuario();
                   break;
                case 17:
                   MenuOpciones.mostrarUsuarios();
                   break;
                 
                case 0:
                    salir();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);

        scanner.close();
    }
    private static void salir() {
		System.out.println("Sesion Finalizada");
		System.out.println("Adios!");
		System.exit(0);
	}

}