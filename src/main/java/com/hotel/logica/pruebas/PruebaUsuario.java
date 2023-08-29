package com.hotel.logica.pruebas;

import com.hotel.logica.controladores.UsuarioControlador;
import com.hotel.logica.modelo.Usuario;
import com.hotel.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;

public class PruebaUsuario {

    public static void main(String[] args) {

        UsuarioControlador usuarioControlador = new UsuarioControlador();
        //CREACION DE USUARIO      
//        Usuario usuario=new Usuario();
//        usuario.setUsuario("pittuk");
//        usuario.setClave("654321");
//        
//        usuarioControlador.crearUsuario(usuario);
        


ArrayList<Usuario>lista= usuarioControlador.listarUsuarios();
        for (Usuario usuario : lista) {
            System.out.println(usuario.getUsuario());
        }


    }

}
