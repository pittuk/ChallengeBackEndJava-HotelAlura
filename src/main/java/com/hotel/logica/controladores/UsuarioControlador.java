package com.hotel.logica.controladores;

import com.hotel.logica.modelo.Usuario;
import com.hotel.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioControlador {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearUsuario(Usuario usuario) {
        controlPersis.crearUsuario(usuario);

    }

    public ArrayList<Usuario> listarUsuarios() {
        return controlPersis.listarUsuarios();
    }
}
