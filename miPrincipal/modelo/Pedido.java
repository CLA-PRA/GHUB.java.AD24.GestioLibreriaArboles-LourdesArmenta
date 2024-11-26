package miPrincipal.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int idPedido;
    private Date fecha;
    private List<Producto> productos;
    private Proveedor proveedor;

    public Pedido(Producto producto, Date fecha){
        this.idPedido = 0;
        this.fecha = fecha;
        this.productos = new ArrayList<>();
        this.productos.add(producto);
        this.proveedor = new Proveedor("ND", "No Definido", "No Definido", "No Definido");

    }

    public Pedido(int idPedido, Date fecha, List<Producto> productos, Proveedor proveedor) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.productos = productos;
        this.proveedor = proveedor;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }
    

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", fecha='" + fecha + '\'' +
                ", productos=" + productos +
                ", proveedor=" + proveedor +
                '}';
    }
}