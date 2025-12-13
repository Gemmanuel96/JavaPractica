/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.List;
import logica.Usuario;

/**
 *
 * @author gonza
 */
public class ControladoraJpa {
    
    UsuarioJpaController usuario = new UsuarioJpaController();
    
    public void agregarUsuario(Usuario user){
        usuario.create(user);
    }
    
    public List<Usuario> mostrarUsuarios(){
        return usuario.findUsuarioEntities();
     }
}
