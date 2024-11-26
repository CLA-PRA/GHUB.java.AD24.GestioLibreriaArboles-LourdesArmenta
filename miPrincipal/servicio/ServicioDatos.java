package miPrincipal.servicio;


import miPrincipal.modelo.Libro;
import miPrincipal.modelo.Usuario;
import miPrincipal.modelo.Proveedor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

public class ServicioDatos {
    private List<Libro> listaLibros;
    private Queue<Libro> colaLibros;
    private Stack<Libro> pilaLibrosEliminados;
    private ArrayList<Libro> listaLibrosDisponibles;
    private HashMap<String, Proveedor> proveedores;
    private TreeSet<Usuario> usuarios;
    private HashMap<Libro, Usuario> prestamos;

    public ServicioDatos() {
        listaLibros = new LinkedList<>();
        colaLibros = new LinkedList<>();
        pilaLibrosEliminados = new Stack<>();
        listaLibrosDisponibles = new ArrayList<>();
        proveedores = new HashMap<>();
        usuarios = new TreeSet<>();
        prestamos = new HashMap<>();
    }

    // Métodos para la lista de libros
    public boolean agregarLibro(Libro libro) {
        listaLibros.add(libro);
       
        return true;
    }

    public boolean eliminarLibro(Libro libro) {
        return listaLibros.remove(libro);
    }

    public Libro buscarLibro(String isbn){
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null; // Si no se encuentra el libro, devuelve null

    }

    public List<Libro> obtenerListaLibros() {
        return listaLibros;
    }

    public Libro eliminarUltimoLibro() {
        if (listaLibros.isEmpty()) {
            return null;
        } else {
            // Obtener el último libro de la lista de libros
            Libro libroEliminado = listaLibros.get(listaLibros.size() - 1);
            
            // Verificar si el libro está prestado
            if (prestamos.containsKey(libroEliminado)) {
                System.out.println("El libro no puede ser eliminado porque está prestado a: " + prestamos.get(libroEliminado).getNombre());
                return null;
            } else {
                // Eliminar el último libro de la lista de libros
                listaLibros.remove(listaLibros.size() - 1);
                
                // Agregar el libro eliminado a la pila de libros eliminados
                pilaLibrosEliminados.push(libroEliminado);
                return libroEliminado;
            }
        }
    }

    public Libro deshacerEliminarLibro() {
        if (pilaLibrosEliminados.isEmpty()) {
            return null;
        } else {
            // Restaurar el último libro eliminado
            Libro libroRestaurado = pilaLibrosEliminados.pop();
            listaLibros.add(libroRestaurado);
            return libroRestaurado;
        }
    }


    // Métodos para la lista de libros disponibles
    public boolean agregarLibroDisponibles(Libro libro) {
        listaLibrosDisponibles.add(libro);
        return true;
    }

    public boolean eliminarLibroDisponible(Libro libro) {
        return listaLibrosDisponibles.remove(libro);
    }

    public ArrayList<Libro> obtenerListaLibrosDisponibles() {
        return listaLibrosDisponibles;
    }

    // Métodos para la cola de libros
    public boolean agregarLibroCola(Libro libro) {
        colaLibros.add(libro);
        return true;
    }

    public Libro eliminarLibroCola() {
        return colaLibros.poll();
    }

    public Queue<Libro> obtenerColaLibros() {
        return colaLibros;
    }

    // Métodos para la pila de libros eliminados
    public boolean agregarLibroPila(Libro libro) {
        pilaLibrosEliminados.push(libro);
        return true;
    }

    public Libro eliminarLibroPila() {
        if (!pilaLibrosEliminados.isEmpty()) {
            return pilaLibrosEliminados.pop();
        }
        return null;
    }

    public Stack<Libro> obtenerPilaLibrosEliminados() {
        return pilaLibrosEliminados;
    }

    // Métodos para los proveedores
    public Proveedor agregarProveedor(Proveedor proveedor) {
        if (!proveedores.containsKey(proveedor.getIdProveedor())) {
           
            proveedores.put(proveedor.getIdProveedor(), proveedor);
            return proveedor;
        } else {
            return null;
        }
    }

    public boolean eliminarProveedor(String idProveedor) {
        return proveedores.remove(idProveedor) != null;
    }

    public Proveedor buscarProveedor(String idProveedor) {
        return proveedores.get(idProveedor);
    }

    public HashMap<String, Proveedor> obtenerProveedores() {
        return proveedores;
    }

    // Métodos para los usuarios
    public Usuario agregarUsuario(Usuario usuario) {
        if (buscarUsuario(usuario.getIdUsuario()) != null) {
            
            return null;
        } else {
            usuarios.add(usuario);
            return usuario;
        }
    }

    public boolean eliminarUsuario(int idUsuario) {
        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario != null) {
            return usuarios.remove(usuario);
        } else {
           
            return false;
        }
    }

    public Usuario buscarUsuario(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }

    public boolean actualizarUsuario(int id, String nombre, String direccion, String telefono) {
        Usuario usuario = buscarUsuario(id);
        if (usuario != null) {
            usuario.setNombre(nombre);
            usuario.setDireccion(direccion);
            usuario.setTelefono(telefono);
            return true;
        } else {
            return false;
        }
    }

    public TreeSet<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    // Métodos para los préstamos
    public boolean prestarLibro(Usuario usuario,Libro libro) {
        //prestamos.put(libro, usuario);
        if (listaLibrosDisponibles.contains(libro) && !prestamos.containsKey(libro)) {
            listaLibrosDisponibles.remove(libro);
            prestamos.put(libro, usuario);
            //System.out.println("Libro prestado a: " + usuario.getNombre());
            return true;
        } else {
            //System.out.println("El libro no está disponible o ya está prestado.");
            return false;
        }
    }

    public boolean devolverLibro(Usuario usuario, Libro libro) {
        //return prestamos.remove(libro) != null;
        if (prestamos.containsKey(libro) && prestamos.get(libro).equals(usuario)) {
            listaLibrosDisponibles.add(libro);
            prestamos.remove(libro);
            //System.out.println("Libro devuelto por: " + usuario.getNombre());
            return true;
        } else {
            //System.out.println("El libro no está prestado a este usuario.");
            return false;
        }
    }

    public Usuario buscarPrestamo(Libro libro) {
        return prestamos.get(libro);
    }

    public HashMap<Libro, Usuario> obtenerPrestamos() {
        return prestamos;
    }
}
