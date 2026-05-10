import Entities.*;

import java.sql.SQLOutput;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Iniciamos creando las catogorias y productos
        //Categoria
        Categoria categoria1 = new Categoria(1L,"Pizzas", "Pizzas y toda su variedad");
        Categoria categoria2 = new Categoria(2L,"Empanadas", "Empanadas y toda su variedad");
        Categoria categoria3 = new Categoria(3L,"Sanguches", "Sanguches y toda su variedad");

        //Cremos Productos

        Producto producto1 = new Producto(1L, "Pizza Muzzarella", 1500.0, "Queso y salsa", 5, categoria1);
        Producto producto2 = new Producto(2L, "Pizza Napolitana", 1700.0, "Tomate, ajo y mozzarella", 8, categoria1);
        Producto producto3 = new Producto(3L, "Pizza Fugazzeta", 1800.0, "Cebolla y queso", 6, categoria1);
        Producto producto4 = new Producto(4L, "Empanada de Carne", 600.0, "Carne cortada a cuchillo", 15, categoria2);
        Producto producto5 = new Producto(5L, "Empanada de Pollo", 550.0, "Pollo con cebolla y morrón", 12, categoria2);
        Producto producto6 = new Producto(6L, "Empanada Caprese", 580.0, "Tomate, albahaca y mozzarella", 10, categoria2);
        Producto producto7 = new Producto(7L, "Sanguche de Vacio", 2500.0, "Vacio con lechuga y tomate", 10,  categoria3);
        Producto producto8 = new Producto(8L, "Sanguche de Milanesa", 2200.0, "Milanesa con jamón y queso", 7,  categoria3);
        Producto producto9 = new Producto(9L, "Sanguche de Lomito", 2400.0, "Lomito completo con huevo y jamón", 9, categoria3);
        Producto producto10 = new Producto(10L, "Sanguche Vegetariano", 2000.0, "Verduras grilladas y queso", 11,  categoria3);


        //
        //Creamos usuarios
        Usuario user2 = new Usuario(2L,"Leandro","Gimenez","1532818181","Leandro@gmail.com","1234545", Rol.USUARIO);
        Usuario user1 = new Usuario(1L,"Ayelen","Rosario","18548458","Rosario@gmail.com","6546514", Rol.USUARIO);

        //Creamos Pedidos y se los asignamos a los usuarios

        Pedido pedido1 = new Pedido(1L,FormaPago.TARJETA);
        pedido1.addDetallePedido(new DetallePedido(1L,5,producto1));
        pedido1.addDetallePedido(new DetallePedido(2L,3,producto2));
        pedido1.addDetallePedido(new DetallePedido(3L,4,producto3));

        Pedido pedido2 = new Pedido(2L,FormaPago.EFECTIVO);
        pedido2.addDetallePedido(new DetallePedido(1L,5,producto4));
        pedido2.addDetallePedido(new DetallePedido(2L,6,producto5));
        pedido2.addDetallePedido(new DetallePedido(3L,7,producto6));
        //Como hay un producto similar, no lo agregara el Set
        pedido2.addDetallePedido(new DetallePedido(3L,7,producto6));



        user1.addPedido(pedido1);
        user1.addPedido(pedido2);

        Pedido pedido3 = new Pedido(3L,FormaPago.TRANSFERENCIA);
        pedido3.addDetallePedido(new DetallePedido(1L,5,producto7));
        pedido3.addDetallePedido(new DetallePedido(2L,6,producto8));
        pedido3.addDetallePedido(new DetallePedido(3L,8,producto9));


        user2.addPedido(pedido3);


        System.out.println("\nMostramos toString() de productos: ");
        System.out.println(producto3.toString());
        System.out.println(user1.toString());

        System.out.println("\nMostramos toString() de productos en Pedidos: ");
        pedido1.mostrarDetallePedido();

        System.out.println("\nMostramos toString() de productos en Pedidos 2: ");
        pedido2.mostrarDetallePedido();


        List<Usuario> listaUsuario = new ArrayList<>();

        listaUsuario.add(user2);
        listaUsuario.add(user1);


        //Hacemos la logica para mostrar que usuario tiene mas peiddos
        Usuario usuarioMaxPedido = null;
        int maxPedido = 0;

        for (Usuario usuario : listaUsuario) {
            if(usuario.getPedidos().size() > maxPedido) {
                maxPedido = usuario.getPedidos().size();
                usuarioMaxPedido = usuario;
            }
        }

        System.out.println("\nUsuario con mas Pedidos: " + usuarioMaxPedido.toString() + " con "+ maxPedido +" pedidos.");


        //Instanciamos un nuevo producto y comprobamos si existe un producto igual

        //Creamos la coleccion de productos y los agregamos
        Set<Producto> listaProducto = new HashSet<>();
        listaProducto.add(producto1);
        listaProducto.add(producto2);
        listaProducto.add(producto3);
        listaProducto.add(producto4);
        listaProducto.add(producto5);
        listaProducto.add(producto6);
        listaProducto.add(producto7);
        listaProducto.add(producto8);
        listaProducto.add(producto9);
        listaProducto.add(producto10);


        //Con la funcion comparamos y mostramos por pantalla si existe un producto similar
        Producto producto11 = new Producto(11L, "Pizza Muzzarella", 1500.0, "Queso y salsa", 5, categoria1);

        mostrarCoincidencia(listaProducto,producto11);



    }

    public static void  mostrarCoincidencia(Set<Producto> listaProducto, Producto producto) {
        boolean encontrado = false;
        Producto productoEncontrado = null;

        for (Producto p : listaProducto) {
            if (p.equals(producto)) {
                encontrado = true;
                productoEncontrado = p;
            }
        }
        if (encontrado) {
            System.out.println("Coincidencia encontrada con: " + productoEncontrado.toString());
        }else{
            System.out.println("No existe ninguna coincidencia con: " + producto.toString());
        }
    }
}