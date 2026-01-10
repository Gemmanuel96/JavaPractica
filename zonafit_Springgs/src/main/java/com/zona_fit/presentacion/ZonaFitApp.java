package com.zona_fit.presentacion;

import com.zona_fit.dao.ClienteDAO;
import com.zona_fit.dao.IClienteDAO;
import com.zona_fit.modelo.Cliente;

import java.util.List;
import java.util.Scanner;

public class ZonaFitApp {

    public static void main(String[] args) {
        zonaFitApp();
    }

    //Metodos a utilizar

    public static void zonaFitApp() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        IClienteDAO clienteDao = new ClienteDAO();

        while (!exit) {
            try {

                var opcion = mostrarMenu(scanner);

                exit = ejecutarOpciones(scanner, opcion, clienteDao);
            } catch (Exception e) {
                System.out.println("Error la aplicacion no pudo ejecutarse: " + e.getMessage());
            }


        }
    }

    public static int mostrarMenu(Scanner scanner) {
        System.out.println("""
                Zona Fit (GYM)
                1. Listar Clientes
                2. Buscar  Cliente
                3. Agregar Cliente
                4. Modificar Cliente
                5. Eliminar Cliente
                6. Salir
                
                Seleccione una opcion:  
                """);
        int opcion = Integer.parseInt(scanner.nextLine());
        return opcion;
    }

    public static boolean ejecutarOpciones(Scanner scanner, int opcion, IClienteDAO clienteDao) {
        boolean salir = false;
        switch (opcion) {
            case 1 -> {
                System.out.println("Listado de Clientes: ");
                List<Cliente> listaCliente = clienteDao.listarCliente();
                if (listaCliente.isEmpty()) {
                    System.out.println("\sNo hay clientes registrados\s");
                } else {
                    listaCliente.forEach(System.out::println);
                }
            }

            case 2 -> {
                System.out.println("Buscar Cliente: ");
                System.out.println("ID:");
                int id = Integer.parseInt(scanner.nextLine());
                Cliente c = new Cliente(id);

                //Nos devolvera el usuario guardado en la  base de datos!
                boolean a = clienteDao.buscarCliente(c);

                if (a) {
                    System.out.println("Cliente encontrado");
                    //nos imprime el cliente de la base de datos
                    System.out.println(c);
                } else {
                    System.out.println("Cliente no eliminado");
                }


            }

            case 3 -> {
                System.out.println("Agregar Cliente: ");
                Cliente c = new Cliente();

                System.out.print("Nombre");
                String nombre = scanner.nextLine();

                System.out.print("Apellido:");
                String apellido = scanner.nextLine();

                System.out.println("Menbresia: ");
                int membresia = Integer.parseInt(scanner.nextLine());

                c.setNombre(nombre);
                c.setApellido(apellido);
                c.setMembrecia(membresia);

                boolean agregar = clienteDao.agregarCliente(c);

                if (agregar) {
                    System.out.println("Cliente agregado exitosamente");
                } else {
                    System.out.println("Error al agregar Cliente");
                }
            }

            case 4 -> {
                System.out.println("Modificar Cliente: ");
                System.out.println("ID:");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Nombre:");
                String nombre = scanner.nextLine();
                System.out.println("Apellido: ");
                String apellido = scanner.nextLine();
                System.out.println("Menbresia: ");
                int membresia = Integer.parseInt(scanner.nextLine());

                Cliente c = new Cliente(id, nombre, apellido, membresia);

                var cliente = clienteDao.actualizarCliente(c);

                if (cliente) {
                    System.out.println("El cliente fue modificado exitosamente");
                } else {
                    System.out.println("Error al modificar Cliente");
                }


            }

            case 5 -> {
                System.out.println("Eliminar Cliente: ");
                System.out.println("ID:");
                int id = Integer.parseInt(scanner.nextLine());

                Cliente c = new Cliente(id);
                boolean eliminar = clienteDao.eliminarCliente(c);

                if (eliminar) {
                    System.out.println("El cliente fue eliminado correctamente");
                } else {
                    System.out.println("Error al eliminar Cliente");
                }


            }

            case 6 -> {
                salir = true;
            }

        }
        return salir;
    }
}
