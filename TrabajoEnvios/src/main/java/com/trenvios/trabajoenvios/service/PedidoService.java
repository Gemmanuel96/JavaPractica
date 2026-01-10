package com.trenvios.trabajoenvios.service;

import com.trenvios.trabajoenvios.model.Envio;
import com.trenvios.trabajoenvios.model.Pedido;
import com.trenvios.trabajoenvios.repository.IEnvioRepository;
import com.trenvios.trabajoenvios.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private IEnvioRepository envioRepository;
    @Autowired
    private IPedidoRepository pedidoRepository;


    @Override
    public void save(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> findAllPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos;
    }

    @Override
    public Pedido findById(Long id) {
        Pedido p = pedidoRepository.findById(id).orElse(null);
        return p;
    }

    @Override
    public void delete(Pedido pedido) {
        pedidoRepository.delete(pedido);
    }

    @Override
    public void update(Pedido pedido) {

    }

    @Override
    public void crearPedidoConEnvio(Pedido pedido, Envio envio) {
        pedidoRepository.save(pedido);
        envioRepository.save(envio);

    }

    @Override
    public Double calcularValorTotalPedido(Pedido pedido) {
        Double total = 0.0;
        try {
            List<Pedido> listaPedidos = this.findAllPedidos();


            for (Pedido pedi : listaPedidos) {
                total = total + pedi.getTotal();
            }

            return total;

        } catch (Exception e) {
            System.out.println("Error al calcular valor total" + e.getMessage());
        }

        return total;
    }

    @Override
    public List<Pedido> pedidosActivos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<Pedido> pedidosActivos = new ArrayList<>();

        try {

            for (Pedido pedido : pedidos) {
                if (pedido.isEliminado() == false) {
                    pedidosActivos.add(pedido);
                }
            }

            return pedidosActivos;
        } catch (RuntimeException e) {
            System.out.println("Error al calcular valor total" + e.getMessage());
        }

        return pedidosActivos;
    }
}

