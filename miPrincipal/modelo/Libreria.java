package miPrincipal.modelo;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeSet;

import miPrincipal.servicio.ServicioDatos;
import java.util.Scanner;

public class Libreria{
    //Declare variables de instancia que
    //se utilizaran para gestionar diferentes
    //aspectos de la libreria
    /*
     * dataService: Una instancia de la clase ServicioDatos que maneja las operaciones de datos.
        listaLibros: Una lista enlazada (LinkedList) que contiene los libros de la librería.
        listaLibrosDisponibles: Una lista (ArrayList) que contiene los libros disponibles para préstamo.
        colaLibros: Una cola (Queue) que se utiliza para gestionar la reserva de libros.
        pilaLibrosEliminados: Una pila (Stack) que almacena los libros eliminados, permitiendo deshacer eliminaciones.
        scanner: Un objeto Scanner para leer la entrada del usuario.
        proveedores: Un HashMap que asocia identificadores de proveedores (String) con instancias de la clase Proveedor.
        usuarios: Un TreeSet que contiene instancias de la clase Usuario, asegurando que los usuarios estén ordenados y no se repitan.
        prestamos: Un HashMap que asocia instancias de la clase Usuario con instancias de la clase Libro, gestionando los préstamos de libros a usuarios.
     */
  

    public Libreria(){
       //inicialice las variables de instancia que 
       //se utilizaran para gestionar la libreria

    }

    public boolean agregarLibro(Libro libro){
        
           return (dataService.agregarLibro(libro) &&  dataService.agregarLibroDisponibles(libro));
           
    }

    public boolean agregarLibrosDisponibles(Libro libro){
        
       return  dataService.agregarLibroDisponibles(libro);
       
    }

    public List<Libro> obtenerLibros(){
      
        return dataService.obtenerListaLibros();

    }

    public List<Libro> obtenerLibrosDisponibles(){
        
        return dataService.obtenerListaLibrosDisponibles();

    }


    public boolean agregarLibroCola(Libro libro){
        
        return dataService.agregarLibroCola(libro);
        
    }

    public Libro obtenerLibroCola(){

        return dataService.eliminarLibroCola();
        

    }

    public Queue<Libro> mostrarReservaLibros(){
       
        return dataService.obtenerColaLibros();

    
    }

    public Libro crearLibro(String titulo, String autor, String isbn){
        Libro libro = new Libro(titulo,autor,isbn);
        return libro;
    }

    public Pedido crearPedido(Libro libro, Date fecha){
        Pedido pedido = new Pedido(libro,new Date());
        return pedido;

    }
    public Pedido crearPedido(int id,  Date fecha, List<Producto> productos, Proveedor proveedor){
        Pedido pedido = new Pedido(id, new Date(), productos,proveedor);

        return pedido;

    }

     // Método para eliminar el último libro de la lista
     public Libro eliminarUltimoLibro() {
        return dataService.eliminarUltimoLibro();
        
    }

    // Método para deshacer la eliminación del último libro
    public Libro deshacerEliminarLibro() {
        return dataService.deshacerEliminarLibro();
    }


    public Libro buscarLibro(String isbn){
        return dataService.buscarLibro(isbn);
        

    }

    public Proveedor crearProveedor(String id, String nombre, String direccion, String telefono){
       
         return dataService.agregarProveedor(new Proveedor(id, nombre, direccion, telefono));

    }

    //Metodo para crear un usuario
    public Usuario crearUsuario(int id, String nombre, String direccion, String telefono){
        Usuario usuario = new Usuario(id, nombre, direccion, telefono);
        if (agregarUsuario(usuario))
            return usuario;
        else 
           return null;
       
    }

     // Método para agregar un usuario
     public boolean agregarUsuario(Usuario usuario) {
        
        if (dataService.agregarUsuario(usuario) == null) {
            return false;
        } else {
            
            return true;
        }
    }

    // Método para buscar un usuario por ID
    public Usuario buscarUsuario(int idUsuario) {
        return dataService.buscarUsuario(idUsuario);
        
    }

    // Método para eliminar un usuario por ID
    public boolean eliminarUsuario(int idUsuario) {
        return dataService.eliminarUsuario(idUsuario);
    }

    // Método para actualizar un usuario
    public boolean actualizarUsuario(int id, String nombre, String direccion, String telefono) {
       return dataService.actualizarUsuario(id, nombre, direccion, telefono);
    }

     // Método para listar todos los usuarios
     public TreeSet<Usuario> listarUsuarios() {
        return dataService.obtenerUsuarios();
        
    }

    public boolean prestarLibro(Usuario usuario, Libro libro) {
        return (dataService.prestarLibro(usuario, libro));
        
    }

    public boolean devolverLibro(Usuario usuario, Libro libro) {
        return (dataService.devolverLibro(usuario,libro));
        
    }


    // Método para obtener los libros prestados y sus prestatarios
    public HashMap<Libro, Usuario> obtenerLibrosPrestados() {
        return dataService.obtenerPrestamos();
    }

    


}