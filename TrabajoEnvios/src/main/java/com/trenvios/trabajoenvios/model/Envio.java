package com.trenvios.trabajoenvios.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tracking;
    private EmpresaEnvio empresaEnvio;
    private TipoDeEnvio tipoEnvio;

    private double costo;
    private LocalDate fechaDespacho;
    private LocalDate fechaEstimada;
    private EstadoDeEnvio estado;

    public Envio() {
    }

    public Envio(Long id, String tracking, EmpresaEnvio empresa, TipoDeEnvio tipo, double costo, LocalDate fechaDespacho, LocalDate fechaEstimada, EstadoDeEnvio estado) {
        this.id = id;
        this.tracking = tracking;
        this.empresaEnvio = empresa;
        this.tipoEnvio = tipo;
        this.costo = costo;
        this.fechaDespacho = fechaDespacho;
        this.fechaEstimada = fechaEstimada;
        this.estado = estado;
    }
}
