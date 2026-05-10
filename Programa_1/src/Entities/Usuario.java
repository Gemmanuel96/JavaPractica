package Entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Usuario extends Base{
    private String nombre;
    private String apellido;
    private String email;
    private String celular;
    private String contrasenia;
    private Rol rol;
    private Set<Pedido> pedidos;

    public Usuario(Long id, String nombre, String apellido, String celular, String email, String contrasenia, Rol rol) {
        super(id);
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.pedidos = new HashSet<>();
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        System.out.println("Pedido agregado correctamente");
    }


    @Override
    public boolean equals(Object o) {
        if (this  == o) return true;
        if (!super.equals(o)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(apellido, usuario.apellido) && Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nombre, apellido, email);
    }

    @Override
    public String toString() {
        return  "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", rol=" + rol+
                '}';
    }
}
