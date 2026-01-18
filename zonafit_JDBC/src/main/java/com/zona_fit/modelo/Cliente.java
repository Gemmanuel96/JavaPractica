package com.zona_fit.modelo;

import java.util.Objects;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private int membrecia;

    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(String nombre, String apellido, int membrecia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.membrecia = membrecia;
    }

    public Cliente(int id, String nombre, String apellido, int membrecia) {
        this(nombre,apellido,membrecia);
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getMembrecia() {
        return membrecia;
    }

    public void setMembrecia(int membrecia) {
        this.membrecia = membrecia;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", membrecia=" + membrecia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && membrecia == cliente.membrecia && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, membrecia);
    }
}
