package miPrincipal.modelo;
public abstract class Producto{
    private int idProducto;
    private String nombre;
    private double precio;

    public Producto(){
        this.idProducto = 0;
        this.nombre = "No Definido";
        this.precio = 0.0;
    }

    public Producto(int idProducto, String nombre, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método abstracto que debe ser implementado por las subclases
    public abstract String getCategoria();

}