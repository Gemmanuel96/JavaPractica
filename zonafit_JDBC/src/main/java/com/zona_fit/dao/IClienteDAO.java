package com.zona_fit.dao;

import com.zona_fit.modelo.Cliente;

import java.util.List;

public interface IClienteDAO {

    public List<Cliente> listarCliente();

    public boolean buscarCliente(Cliente clien);

    public boolean agregarCliente(Cliente clien);

    public boolean actualizarCliente(Cliente clien);

    public boolean eliminarCliente(Cliente cliente);

}
