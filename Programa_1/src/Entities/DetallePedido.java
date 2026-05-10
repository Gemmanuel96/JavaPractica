package Entities;

import java.util.*;

public class DetallePedido extends Base{
    private Integer cantidad;
    private double subtotal;
    private Producto producto;

    public DetallePedido(Long id, Integer cantidad, Producto producto) {
        super(id);
        this.cantidad = cantidad;
        this.subtotal = cantidad* producto.getPrecio();
        this.producto = producto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (!super.equals(o)) return false;
        DetallePedido that = (DetallePedido) o;
        return Double.compare(subtotal, that.subtotal) == 0 && Objects.equals(cantidad, that.cantidad) && Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cantidad, subtotal, producto);
    }

    @Override
    public String toString() {
        return super.toString() + " DetallePedido{" +
                "producto=" + producto.getNombre() +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                '}';
    }
}
