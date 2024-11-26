package miPrincipal.iu;

import miPrincipal.modelo.Libro;
import miPrincipal.modelo.Pedido;
import miPrincipal.modelo.Libreria;
import miPrincipal.modelo.Proveedor;
import miPrincipal.modelo.Usuario;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MenuOpciones{
    static Scanner scanner = new  Scanner(System.in);
    static private Libreria libreria = new Libreria();

    public static void agregarLibro(){
       
        System.out.print("Ingrese el título del libro:");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro:");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro:");
        String isbn = scanner.nextLine();
        Libro libro = new Libro(titulo, autor, isbn);
        if (libreria.agregarLibro(libro))
            System.out.println("libro se agrego exitosamente a la lista: "+libro);

        else
            System.out.println("Error: no fue posible agregar Libro a la lista");
    }

    public static void prestarLibros(){
        System.out.print("Ingrese ID de usuario a quien se hara prestamo:");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Consumir el carácter de nueva línea restante
        Usuario usuario =libreria.buscarUsuario(idUsuario);
        if (usuario ==null){
            System.out.println("Error: Usuario no existe");
            return;
        }else{
            System.out.println("Datos de Usuario: "+usuario);
        }
        System.out.print("Ingrese el ISBN del libro:");
        String isbn = scanner.nextLine();
        Libro libro = libreria.buscarLibro(isbn);
        if(libro ==null){
            System.out.println("Error: Usuario no existe");
            return;

        }else{
            System.out.println("Datos de Libro: "+libro);
        }
        System.out.println("Titulo del libro :"+libro.getTitulo());   
        System.out.println("Autor del libro: "+libro.getAutor());
         
        if(libreria.prestarLibro(usuario, libro))
            System.out.println("libro se presto exitosamente al usuario");

        else
            System.out.println("Error: no fue posible prestar el libro");
   
    }

    public static void mostrarLibros(){

        List<Libro> listaLibros=libreria.obtenerLibros();
        if (listaLibros.isEmpty()) {
            System.out.println("La lista de libros esta vacia.");
        } else {
            System.out.println("Lista de libros:");
            for (Libro libro1 : listaLibros) {
                System.out.println(libro1);
            }
        }

    }

    public static void mostrarLibrosDisponibles(){

        List<Libro> listaLibros=libreria.obtenerLibrosDisponibles();
        if (listaLibros.isEmpty()) {
            System.out.println("La lista de libros esta vacia.");
        } else {
            System.out.println("Lista de libros:");
            for (Libro libro1 : listaLibros) {
                System.out.println(libro1);
            }
        }

    }

    public static void mostrarLibrosPrestados() {
       
        HashMap<Libro, Usuario> prestamos = libreria.obtenerLibrosPrestados();
        if (prestamos.isEmpty()) {
            System.out.println("No hay libros prestados.");
        } else {
            for (Map.Entry<Libro, Usuario> entry : prestamos.entrySet()) {
                Libro libro = entry.getKey();
                Usuario usuario = entry.getValue();
                System.out.println("Libro: " + libro.getTitulo() + " prestado a: " + usuario.getNombre());
            }
        }
        
    }

    public static void agregarLibroCola(){
        
        System.out.print("Ingrese el titulo del libro:");
        String tituloCola = scanner.nextLine();
        System.out.print("Ingrese el autor del libro:");
        String autorCola = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro:");
        String isbnCola = scanner.nextLine();
        Libro libroCola = new Libro(tituloCola, autorCola, isbnCola);
        if (libreria.agregarLibroCola(libroCola))
            System.out.println("libro se agrego exitosamente a la cola");
        else
            System.out.println("Error: no fue posible agregar Libro a la cola");
        
    }

    public static Libro obtenerLibroCola(){

        Libro libro = libreria.obtenerLibroCola();
        if (libro != null){
            System.out.println("El siguiente libro disponible sera: "+libro);
            return libro;
        }
        else{
            System.out.println("No existen libros prestados");
            return null;
        }
     
    }

    public static void mostrarReservaLibros(){
        Queue<Libro> listaLibrosReserva = libreria.mostrarReservaLibros();
        if (listaLibrosReserva.isEmpty()) {
            System.out.println("La lista de reservas esta vacia.");
        } else {
            System.out.println("Lista de libros:");
            for (Libro libro1 : listaLibrosReserva) {
                System.out.println(libro1);
            }
        }
    }

    public static void crearPedido(){
        System.out.print("Ingrese el título del libro para el pedido:");
        String tituloPedido = scanner.nextLine();
        System.out.print("Ingrese el autor del libro para el pedido:");
        String autorPedido = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro para el pedido:");
        String isbnPedido = scanner.nextLine();
        Libro libroPedido = libreria.crearLibro(tituloPedido, autorPedido, isbnPedido);
        Pedido pedido=null;
        if (libroPedido!=null){
            pedido = libreria.crearPedido(libroPedido, new Date());
            if (pedido !=null)
                System.out.println("Pedido creado exitosamente: "+pedido);
            else
                System.out.println("No fue posible crear el pedido");
        }else{
            System.out.println("Error: no fue posible crear el Libro");
        }
       
    }

    public static void devolverLibro(){
        System.out.print("Ingrese el ISBN del libro a devolver: ");
        String isbnDevolver = scanner.nextLine();
        Libro libroDevolver = libreria.buscarLibro(isbnDevolver);
        if (libroDevolver == null) {
            System.out.println("Error: no existe ningún libro con esas características");
            return;
        }

        System.out.println("Título del libro a devolver: " + libroDevolver.getTitulo());
        System.out.println("Autor del libro a devolver: " + libroDevolver.getAutor());

        System.out.print("Ingrese el ID del usuario que tiene el libro prestado: ");
        int idUsuario = scanner.nextInt();
        
        Usuario usuario = libreria.buscarUsuario(idUsuario);
        if (usuario == null) {
            System.out.println("Error: no existe ningún usuario con ese nombre");
            return;
        }

        // Devolver el libro y eliminarlo del TreeMap de préstamos
        if (libreria.devolverLibro(usuario,libroDevolver)) {
            System.out.println("Libro devuelto a la lista: " + libroDevolver);
        } else {
            System.out.println("Error: el libro no está prestado a este usuario.");
        }
        
    }

    public static Libro eliminarUltimoLibro(){
        Libro libroEliminado = libreria.eliminarUltimoLibro();
        if (libroEliminado != null){
            System.out.println("Libro eliminado de la lista y agregado a la pila: " + libroEliminado);
            return libroEliminado;
        } 
        else{
            System.out.println("Error: no se pudo eliminar ultimo libro");
            return null;
        }

    }

    public static void deshacerEliminarLibro(){
        Libro libroRestaurado = libreria.deshacerEliminarLibro();
        if(libroRestaurado !=null)
            System.out.println("Libro restaurado a la lista: " + libroRestaurado);
        else
            System.out.println("No hay libros para deshacer la eliminación.");
       
    }

    public static void crearProveedor(){
        System.out.print("Ingrese ID del Proveedor:");
        String idProveedor = scanner.nextLine();
        System.out.print("Ingrese Nombre Proveedor:");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese Direccion del Proveedor:");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese Telefono del Proveedor:");
        String telefono = scanner.nextLine();
        Proveedor proveedor =libreria.crearProveedor(idProveedor,nombre,direccion,telefono);
        if (proveedor==null)
            System.out.println("El proveedor con ID " + idProveedor + " ya existe.");
        else
            System.out.println("Se creo exitosamente el proveedor :"+proveedor);

    }

    public static void agregarUsuario(){
        System.out.print("Ingrese ID del Usuario:");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Consumir el carácter de nueva línea restante
        System.out.print("Ingrese Nombre Usuario:");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese Direccion del Usuario:");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese Telefono del Usuario:");
        String telefono = scanner.nextLine();
        Usuario usuario =libreria.crearUsuario(idUsuario,nombre,direccion,telefono);
        if (usuario==null)
        System.out.println("El Usuario con ID " + idUsuario + " ya existe.");
        else
            System.out.println("Se creo exitosamente el usuario :"+usuario);

    }

    public static void eliminarUsuario(){
        System.out.print("Ingrese ID del Usuario:");
        int idUsuario = scanner.nextInt();
        Usuario usuario = libreria.buscarUsuario(idUsuario);
        if (usuario == null){
            System.out.println("El usuario con ID " + idUsuario + " no existe.");
            return;

        }else {
             if (libreria.eliminarUsuario(idUsuario)){
                System.out.print("Nombre Usuario: "+usuario.getNombre());
                System.out.print("Direccion del Usuario: "+usuario.getDireccion());
                System.out.print("Telefono del Usuario: "+usuario.getTelefono());
                return;
             }
        } 

    }

    public static void actualizarUsuario(){
        System.out.print("Ingrese ID del Usuario:");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Consumir el carácter de nueva línea restante
        Usuario usuario = libreria.buscarUsuario(idUsuario);
        if (usuario == null){
            System.out.println("El usuario con ID " + idUsuario + " no existe.");
            return;
        }else {
            
            System.out.println("Nombre Usuario: "+usuario.getNombre());
            System.out.println("Direccion del Usuario: "+usuario.getDireccion());
            System.out.println("Telefono del Usuario: "+usuario.getTelefono());
            System.out.println("Ingrese Nombre Usuario:");
            System.out.println("NUEVOS DATOS DE USUARIO:");
            System.out.print("Nombre Usuario: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese Direccion del Usuario:");
            String direccion = scanner.nextLine();
            System.out.print("Ingrese Telefono del Usuario:");
            String telefono = scanner.nextLine();

            if (libreria.actualizarUsuario(idUsuario,nombre,direccion,telefono)){
                System.out.println("Usuario, actualizado exitosamente");
                return;
            }else{
                System.out.println("Error: no se ha podido actualizar usuario");
            }


                
            
       } 

    }
    

    

    public static void mostrarUsuarios(){
        TreeSet<Usuario> arbolUsuarios = libreria.listarUsuarios();
        for (Usuario usuario : arbolUsuarios) {
            System.out.println(usuario);
        }

        

    }


	
}
