package Entities;

import java.time.LocalDate;
import java.util.*;

public class Pedido extends Base implements ICalcularTotal{

    private LocalDate fecha;
    private Estado estado;
    private double total;
    private FormaPago formaPago;
    private Set<DetallePedido> detallePedido;

    public Pedido(Long id, FormaPago formaPago) {
        super(id);
        this.fecha = LocalDate.now();
        this.total = 0.0;
        this.estado = Estado.PENDIENTE;
        this.formaPago = formaPago;
        this.detallePedido = new HashSet<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Set<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(Set<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public void mostrarDetallePedido(){
        for (DetallePedido detallePedido : detallePedido) {
            System.out.println(detallePedido.toString());
        }
    }

    public void addDetallePedido(DetallePedido det){
        this.detallePedido.add(det);
    }

    public int totalProducto() {
        return detallePedido.size();
    }

    //Mostrara por pantalla el producto que esta dentro del Arrayd e detalle
    public DetallePedido findDetallePedidoByProducto(Producto producto){
        for(DetallePedido det:detallePedido) {
            if (det.getProducto().equals(producto)) {
                return det;
            }
        }
        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto){
        DetallePedido detallePedido1 = findDetallePedidoByProducto(producto);
        if (detallePedido1 != null) {
            this.detallePedido.remove(detallePedido1);
            System.out.println("Detalle Pedido eliminado");
        }else{
            System.out.println("No se encontro el detalle de pedido");
        }
    }

    @Override
    public void calcularTotal() {
        for (DetallePedido det:detallePedido) {
            this.total += det.getSubtotal();
        }
        System.out.println("Total: " + this.total);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Pedido pedido = (Pedido) o;
//        Objects.equals(getId(), pedido.getId()) → compara los id de ambos pedidos.
//        Si los id son iguales, considera que los dos pedidos son el mismo.
//        Esto es lo más robusto, porque el id es único y no cambia aunque el pedido se modifique.
        return Objects.equals(getId(), pedido.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fecha, estado, total, formaPago);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "fecha=" + fecha +
                ", estado=" + estado +
                ", total=" + total +
                ", formaPago=" + formaPago +
                ", detallePedido=" + detallePedido +
                '}';
    }
}