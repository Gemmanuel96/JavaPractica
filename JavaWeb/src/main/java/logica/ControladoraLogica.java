/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.List;
import persistencia.ControladoraJpa;

/**
 *
 * @author gonza
 */
public class ControladoraLogica {
    
    ControladoraJpa control = new ControladoraJpa();
    
    public void agregarUsuario(Usuario user){
        control.agregarUsuario(user);
    }
    
    public List<Usuario> mostrarUsuarios(){
        return control.mostrarUsuarios();
    }
}
