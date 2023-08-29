package com.hotel.logica.servicios;

import com.hotel.logica.controladores.UsuarioControlador;
import com.hotel.logica.modelo.Usuario;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioServicio {

    UsuarioControlador usuarioControlador = new UsuarioControlador();

    public Boolean validarUsuario(Usuario usuario) {
        ArrayList<Usuario> lista = usuarioControlador.listarUsuarios();
        Boolean estado = false;
        //COMPROBACIÓN DE CONTRASEÑA
        for (Usuario usu : lista) {
            if (BCrypt.checkpw(usuario.getClave(), usu.getClave()) && usuario.getUsuario().equals(usu.getUsuario())) {
                estado = true;
            }
        }

        return estado;
    }

}
