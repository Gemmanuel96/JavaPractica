package com.trenvios.trabajoenvios.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private LocalDate fecha;
    private String clienteNombre;

    private EstadoDePedido estado;

    @OneToOne
    @JoinColumn(name = "id")
    private Envio envio;
    private double total;
    private boolean eliminado;

    public Pedido() {
        this.estado = EstadoDePedido.NUEVO;
        this.fecha = LocalDate.now();
    }

    public Pedido(Long id, String numero, LocalDate fecha, String clienteNombre, EstadoDePedido estado, Envio envio, double total, boolean eliminado) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.clienteNombre = clienteNombre;
        this.estado = estado;
        this.envio = envio;
        this.total = total;
        this.eliminado = eliminado;
    }
}
