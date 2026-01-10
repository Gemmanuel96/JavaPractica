package com.trenvios.trabajoenvios.service;

import com.trenvios.trabajoenvios.model.Envio;
import com.trenvios.trabajoenvios.model.Pedido;

import java.util.List;

public interface IPedidoService {

    public void save(Pedido pedido);
    public List<Pedido> findAllPedidos();
    public Pedido findById(Long id);
    public void delete(Pedido pedido);
    public void update(Pedido pedido);
    public void crearPedidoConEnvio(Pedido pedido, Envio envio);
    public Double calcularValorTotalPedido(Pedido pedido);
    public List<Pedido> pedidosActivos();
}
