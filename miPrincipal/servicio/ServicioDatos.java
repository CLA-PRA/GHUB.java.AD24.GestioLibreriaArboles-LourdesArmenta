package miPrincipal.servicio;


import miPrincipal.modelo.Libro;
import miPrincipal.modelo.Usuario;
import miPrincipal.modelo.Proveedor;

//Este fragmento de código en la clase ServicioDatos 
//importa varias clases de las colecciones de Java (java.util).
// Estas clases se utilizan para gestionar diferentes estructuras de datos en la aplicación:
/*
 * ArrayList: Una lista que permite acceso rápido a elementos por índice.
    HashMap: Un mapa que asocia claves con valores, permitiendo búsquedas rápidas.
    LinkedList: Una lista enlazada que permite inserciones y eliminaciones rápidas.
    List: Una interfaz que representa una lista de elementos.
    Queue: Una interfaz que representa una cola de elementos, donde los elementos se procesan en orden FIFO (First In, First Out).
    Stack: Una pila que permite acceso LIFO (Last In, First Out).
    TreeSet: Un conjunto ordenado que no permite elementos duplicados y mantiene los elementos en orden natura
 */

public class ServicioDatos {
    //declara las variables de instancia que se
    //utilizaran para gestionar diferentes aspectos de la aplicacion
   /*
    * listaLibros: Una lista (List<Libro>) que contiene los libros de la aplicación.
    colaLibros: Una cola (Queue<Libro>) que se utiliza para gestionar la reserva de libros.
    pilaLibrosEliminados: Una pila (Stack<Libro>) que almacena los libros eliminados, permitiendo deshacer eliminaciones.
    listaLibrosDisponibles: Una lista (ArrayList<Libro>) que contiene los libros disponibles para préstamo.
    proveedores: Un mapa (HashMap<String, Proveedor>) que asocia identificadores de proveedores (String) con instancias de la clase Proveedor.
    usuarios: Un conjunto ordenado (TreeSet<Usuario>) que contiene instancias de la clase Usuario, asegurando que los usuarios estén ordenados y no se repitan.
    prestamos: Un mapa (HashMap<Libro, Usuario>) que asocia instancias de la clase Libro con instancias de la clase Usuario, gestionando los préstamos de libros a usuarios.
    */

    public ServicioDatos() {
        //inicialice las variables de instancia
    }

    // Métodos para la lista de libros
    /**
     * Agrega un libro a la lista de libros
     * @param libro
     * @return true
     */
    public  agregarLibro() {
        
    }

    /**
     * elimina un libro de la lista de libros
     * @param libro
     * @return true
     */


    public boolean eliminarLibro() {
        
    }

   /**
    *  busca un libro en la lista de libros (listaLibros) utilizando el ISBN proporcionado.

        Parámetro: Recibe un String llamado isbn que representa el ISBN del libro que se desea buscar.
        Retorno: Devuelve el objeto Libro que coincide con el ISBN proporcionado. 
        Si no se encuentra ningún libro con ese ISBN, devuelve null.
    */

    public  buscarLibro(){
        
        
    }

    /**
     *  devuelve la lista de libros (listaLibros) que contiene todos los libros de la aplicación.
     * @return Devuelve una lista (List<Libro>) que contiene todos los libros.
     */

    public obtenerListaLibros() {
       
    }

    /**
     * elimina el último libro de la lista de libros (listaLibros) y lo agrega a la pila de libros eliminados (pilaLibrosEliminados), siempre y cuando el libro no esté prestado.

       Retorno: Devuelve el objeto Libro que fue eliminado. 
       Si la lista de libros está vacía o el libro está prestado, devuelve null.  
       
       Descripción paso a paso:
        Verifica si la lista de libros está vacía:

        Si listaLibros está vacía, devuelve null.
        Obtiene el último libro de la lista:

        Si la lista no está vacía, obtiene el último libro de la lista (libroEliminado).
        Verifica si el libro está prestado:

        Si el libro está prestado (es decir, está en el mapa prestamos), imprime un mensaje indicando que el libro no puede ser eliminado y devuelve null.
        Elimina el libro de la lista y lo agrega a la pila de libros eliminados:

        Si el libro no está prestado, lo elimina de la lista de libros (listaLibros) y lo agrega a la pila de libros eliminados (pilaLibrosEliminados).
        Devuelve el libro eliminado.
     */


    public  eliminarUltimoLibro() {
        
    }
    //  AQUI ME QUEDE
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
