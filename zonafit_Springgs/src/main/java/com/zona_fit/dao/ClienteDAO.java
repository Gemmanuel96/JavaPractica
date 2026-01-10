package com.zona_fit.dao;

import com.zona_fit.modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.zona_fit.conexion.Conexion.getConnection;

public class ClienteDAO implements IClienteDAO {

    @Override
    public List<Cliente> listarCliente() {
        //Creamos la lista de Clintes
        List<Cliente> listaClientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "Select * from cliente order by id";

        try {
            //Con prepareStatement hacemos la consulta a la base de datos
            ps = con.prepareStatement(sql);
            //Con resultSet obtenemos el resultado de la base de datos
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("id"));
                cl.setNombre(rs.getString("nombre"));
                cl.setApellido(rs.getString("apellido"));
                cl.setMembrecia(rs.getInt("membresia"));

                listaClientes.add(cl);
            }
        } catch (Exception e) {
            System.out.println("Error al listar clientes " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conecxion " + e.getMessage());
            }
            return listaClientes;
        }
    }

    @Override
    public boolean buscarCliente(Cliente clien) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "SELECT * FROM CLIENTE WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, clien.getId());
            rs = ps.executeQuery();
            ;
            if (rs.next()) {
                //Agregamos resultado de la base de datos
                clien.setNombre(rs.getString("nombre"));
                clien.setApellido(rs.getString("apellido"));
                clien.setMembrecia(rs.getInt("membresia"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error el buscar cliente");
        } finally { //En esta parte de finally cerramos la sesion

            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error a cerrar la conexion " + e.getMessage());
            }
        }

        return false;
    }

    @Override
    public boolean agregarCliente(Cliente clien) {

        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "INSERT INTO cliente (nombre,apellido,membresia) Values (?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clien.getNombre());
            ps.setString(2, clien.getApellido());
            ps.setInt(3, clien.getMembrecia());

            //ejecutamos la sentencia de ps
            ps.execute();

            return true;

        } catch (Exception e) {
            System.out.println("Error al guardar cliente");

        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la coneccion " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean actualizarCliente(Cliente clien) {
        PreparedStatement ps;

        Connection con = getConnection();
        String sql = "UPDATE cliente set nombre = ?, apellido = ? , membresia = ? " + " WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, clien.getNombre());
            ps.setString(2, clien.getApellido());
            ps.setInt(3, clien.getMembrecia());
            ps.setInt(4, clien.getId());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error al modificar el cliente");
        } finally {
            try { //Cerramos la conexion
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "DELETE FROM cliente WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());

            int fila = ps.executeUpdate();

            if (fila > 0) {
                System.out.println("El registro fue eliminado");

            } else {
                System.out.println("El registro no se encuentra en la base de datos");
            }

        } catch (Exception e) {
            System.out.println("Error al eliminar el registro " + e.getMessage());

        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error, no se puedo cerrar la coneccion");
            }

        }

        return false;
    }

    public static void main(String[] args) {
        //Listamos Clientes
//        System.out.println("Lista Clientes");
        IClienteDAO clienteDAO = new ClienteDAO();
//
        var lista = clienteDAO.listarCliente();

//        lista.forEach(System.out::println);

//        Cliente c = new Cliente(2);
//        var a = clienteDAO.buscarCliente(c);
//
//        if (a) {
//            System.out.println("El cliente fue encontrado");
//        } else {
//            System.out.println("El cliente no fue encontrado");
//        }

        //Agregamos un nuevo cliente
//        Cliente cl = new Cliente("Gonzalo", "Nuñez", 1534);
//
//        boolean agredado = clienteDAO.agregarCliente(cl);
//
//        if (agredado) {
//            System.out.println("El usuario fue creado correctamente");
//        }

//        var modificarcliente = new Cliente(4, "Emmanuel", "Ramirez", 1515151);
//        var madificar = clienteDAO.actualizarCliente(modificarcliente);

        lista.forEach(System.out::println);
        Cliente c = new Cliente();

        c.setId(1);

        clienteDAO.eliminarCliente(c);
    }
}
