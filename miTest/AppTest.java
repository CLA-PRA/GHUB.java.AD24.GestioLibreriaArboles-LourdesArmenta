package miTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import miPrincipal.modelo.Libreria;
import miPrincipal.modelo.Libro;
import miPrincipal.modelo.Pedido;
import miPrincipal.modelo.Usuario;

import java.util.Date;

public class AppTest {
    private Libreria libreria;
    private Libro libro1;
    private Libro libro2;
    private Libro libro3;
    private Libro libro4;
    private Libro libro5;
    private Usuario usuario1;
    private Usuario usuario2;

    @Before
    public void setUp() {
        libreria = new Libreria();
        libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "978-3-16-148410-0");
        libro2 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "978-0-14-243723-0");
        libro3 = new Libro("Orgullo y prejuicio", "Jane Austen", "978-0-19-953556-9");
        libro4 = new Libro("1984", "George Orwell", "978-0-452-28423-4");
        libro5 = new Libro("Matar a un ruiseñor", "Harper Lee", "978-0-06-112008-4");

       
        usuario1 = new Usuario(1, "Juan Perez", "Calle Falsa 123", "123456789");
        usuario2 = new Usuario(2, "Maria Lopez", "Avenida Siempre Viva 742", "987654321");
    }


    @Test
    public void testAgregarLibro() {
        libreria.agregarLibro(libro1);
        assertTrue(libreria.obtenerLibros().contains(libro1));
        assertTrue(libreria.obtenerLibrosDisponibles().contains(libro1));
    }

    @Test
    public void testMostrarLibrosLista() {
        libreria.agregarLibro(libro1);
        libreria.agregarLibro(libro2);
        assertEquals(2, libreria.obtenerLibros().size());
    }

    @Test
    public void testAgregarLibroCola() {
       
        assertTrue(libreria.agregarLibroCola(libro1));
        
     
    }

    @Test
    public void testObtenerLibroCola() {
        
        libreria.agregarLibroCola(libro1);
        libreria.agregarLibroCola(libro2);
        assertEquals(libro1, libreria.obtenerLibroCola());
    }

    @Test
    public void testEliminarUltimoLibro() {
        // Agregar libros a la librería
        libreria.agregarLibro(libro1);
        libreria.agregarLibro(libro2);

        // Eliminar el último libro (libro2) y verificar que se ha eliminado
        assertEquals(libro2, libreria.eliminarUltimoLibro());
        assertFalse(libreria.obtenerLibros().contains(libro2));

        // Agregar libro2 de nuevo y prestarlo al usuario
        libreria.agregarLibro(libro2);
        libreria.prestarLibro(usuario1, libro2);

        // Intentar eliminar el último libro (libro2) que está prestado
        assertNull(libreria.eliminarUltimoLibro());
        assertTrue(libreria.obtenerLibros().contains(libro2));
        assertTrue(libreria.obtenerLibrosPrestados().containsKey(libro2));
        
    }
    

    @Test
    public void testDeshacerEliminarLibro() {
        // Agregar libro a la librería
        libreria.agregarLibro(libro1);
        
        // Eliminar el último libro
        libreria.eliminarUltimoLibro();
        
        // Deshacer la eliminación del libro
        assertEquals(libro1, libreria.deshacerEliminarLibro());
        
        // Verificar que el libro ha sido devuelto a la lista de libros disponibles
        assertTrue(libreria.obtenerLibros().contains(libro1));
    }

    @Test
    public void testDevolverLibro() {
        // Crear y agregar un usuario
        Usuario usuario = new Usuario(1, "Juan Perez", "Calle Falsa 123", "123456789");
        libreria.agregarUsuario(usuario);

        // Agregar un libro y prestarlo al usuario
        libreria.agregarLibro(libro1);
        
        libreria.prestarLibro(usuario, libro1);

        // Devolver el libro
        assertTrue(libreria.devolverLibro(usuario, libro1));

        // Verificar que el libro ha sido devuelto a la lista de libros disponibles
        assertTrue(libreria.obtenerLibros().contains(libro1));
        }

    @Test
    public void testCrearPedido() {
        libreria.agregarLibro(libro1);
        Pedido pedido = libreria.crearPedido(libro1, new Date());
        assertNotNull(pedido);
        assertTrue(pedido.getProductos().contains(libro1));
       
    }
    @Test
    public void testGestionUsuarios() {
        // Agregar usuarios a la librería
        assertTrue(libreria.agregarUsuario(usuario1));
        assertTrue(libreria.agregarUsuario(usuario2));

        // Verificar que los usuarios han sido agregados
        assertTrue(libreria.listarUsuarios().contains(usuario1));
        assertTrue(libreria.listarUsuarios().contains(usuario2));

        // Modificar el usuario1
        assertTrue(libreria.actualizarUsuario(usuario1.getIdUsuario(), "Juan Perez Modificado", "Nueva Dirección", "111222333"));

        // Verificar que el usuario1 ha sido modificado
        Usuario usuarioModificado = libreria.buscarUsuario(usuario1.getIdUsuario());
        assertEquals("Juan Perez Modificado", usuarioModificado.getNombre());
        assertEquals("Nueva Dirección", usuarioModificado.getDireccion());
        assertEquals("111222333", usuarioModificado.getTelefono());

        // Eliminar el usuario1
        assertTrue(libreria.eliminarUsuario(usuario1.getIdUsuario()));

        // Verificar que el usuario1 ha sido eliminado
        assertFalse(libreria.listarUsuarios().contains(usuario1));
        assertTrue(libreria.listarUsuarios().contains(usuario2));

        // Verificar que la lista de usuarios contiene el número esperado de usuarios
        assertEquals(1, libreria.listarUsuarios().size());
    }

   

   
}