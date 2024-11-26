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
    /*
     * Este método deshacerEliminarLibro en la clase ServicioDatos deshace la eliminación del último libro que fue eliminado y almacenado en la pila de libros eliminados (pilaLibrosEliminados).

        Retorno: Devuelve el objeto Libro que fue restaurado. Si la pila de libros eliminados está vacía, devuelve null.
        Descripción paso a paso:
        Verifica si la pila de libros eliminados está vacía:

        Si pilaLibrosEliminados está vacía, devuelve null.
        Restaura el último libro eliminado:

        Si la pila no está vacía, extrae (pop) el último libro de la pila (libroRestaurado).
        Agrega el libro restaurado a la lista de libros (listaLibros).
        Devuelve el libro restaurado.
     */
    public  deshacerEliminarLibro() {
        
    }


    /*
     *  agrega un libro a la lista de libros disponibles 
     */
    public boolean agregarLibroDisponibles() {
        
    }

    /*
     *  elimina un libro de la lista de libros disponibles
     */

    public boolean eliminarLibroDisponible() {
        ;
    }

    /*
     * regresa la lista de libros disponibles
     */

    public  obtenerListaLibrosDisponibles() {
        
    }

    /*
     *  agrega un libro a la cola de libros reservados
     */

    public boolean agregarLibroCola( ) {

    }

    /*
     * elimina un libro de la cola de libros reservados
     */
    public Libro eliminarLibroCola() {
        return colaLibros.poll();
    }

    /*
     * devuelve la cola de libros que se utiliza
     * para gestionar la reserva de libros
     */
    public  obtenerColaLibros() {
        
    }

    // Métodos para la pila de libros eliminados
    /*
     * agrega un libro a la pila de libros eliminados
     */
    public boolean agregarLibroPila() {
        
    }

    /*
     * elimina y devuelve el último libro de la pila 
     * de libros eliminados, si no hay regresa null
     */

    public  eliminarLibroPila() {
        
    }

    /*
     * devuelve una pila que contiene los libros eliminados
     */

    public Stack<Libro> obtenerPilaLibrosEliminados() {
        return pilaLibrosEliminados;
    }

    // Métodos para los proveedores
    /*
     * agrega un proveedor a la lista de proveedores
     * primero verifica que el ID del proveedor no exista
     * depues lo agrega al mapa y devuelve el proveedor agregado
     * si ya existe, regresa null
     */
    public  agregarProveedor(Proveedor proveedor) {
        
    }
    /*
     * elimina un proveedor del mapa de proveedores
     */
    public boolean eliminarProveedor(String idProveedor) {
        
    }
    /*
     * busca por id a una provedor en el mapa d proveedores
     * y si existe lo regresa, si no regresa null
     */
    public buscarProveedor() {
        ;
    }

    public HashMap<String, Proveedor> obtenerProveedores() {
        return proveedores;
    }

    // Métodos para los usuarios
    /*
     * agrega un usuario al conjunto de usuarios primero verifica
     * que no existe otro id de usuario
     */
    public  agregarUsuario() {
        
    }

    /*
     * elimina a un usuario del conjunto de usuarios
     */

    public  eliminarUsuario() {
        
    }

    /*
     * busca un usuario en el conjunto de usuario por id
     * si no encuentra regresa el usurio sino nulo
     */

    public buscarUsuario() {
        
        
    }

    /*
     * actualiza la informacion de un usuario existente en el conjunto de usuarios
     */

    public  actualizarUsuario() {
        
    }

    /*
     * devuelde el conjunto de usuarios que 
     * contiene todas las instancias de la clase Usuario
     */
    public  obtenerUsuarios() {
       
    }

    // Métodos para los préstamos
    /*
     * gestiona el prestamos de un libro a un usuario
     * comprueba si el libro esta en la lista de libros disponibles
     * y además que el libro no la coleccion prestamos no contenga al libro
     * si el libro esta disponible y no esta prestado, se elimina el libro de la lista de disponibles
     * devuelve true para indicar que el prestamo fue exitoso 
     * si el libro no esta disponible o esta prestado devuelve false
     */
    public boolean prestarLibro(Usuario usuario,Libro libro) {
        
    }

    /*
     * gestiona la devolución de un libro prestado por un usuario.
     * comprueba si el mapa de prestamos contiene el libro y si el valor
     * asociado (el usuario que tiene el libro prestado) es igual
     * al usuario que esta devolviendo el libro
     * Si el libro esta prestado al usuario lo regresa a la lista de libros disponibles,
     *  elimina el libro del mapa de prestamos y devuelve true para indicar que fue exitoso
     *  devuelve false para indicar que la devolucion no se pudo realizar
     *  porque el libro no estaba prestdo a ese usuario
     */

    public  devolverLibro(Usuario usuario, Libro libro) {
        
    }

    /*
     * busca y devuelve el usuario que tiene prestado un libro específico.
     */
    public Usuario buscarPrestamo(Libro libro) {
        
    }

    /*
     * devuelve el mapa de préstamos (prestamos), 
     * que asocia libros con los usuarios que los tienen prestados.
     */

    public  obtenerPrestamos() {
        
    }
}
