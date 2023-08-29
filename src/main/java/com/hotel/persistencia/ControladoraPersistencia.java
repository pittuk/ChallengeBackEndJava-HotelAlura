package com.hotel.persistencia;

import com.hotel.logica.modelo.Huesped;
import com.hotel.logica.modelo.Reserva;
import com.hotel.logica.modelo.Usuario;
import com.hotel.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class ControladoraPersistencia {
    
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    
    ReservaJpaController reservaJpa = new ReservaJpaController();
    
    HuespedJpaController huespedJpa = new HuespedJpaController();

    //CONTROL USUARIOS
    //crear usuario
    public void crearUsuario(Usuario usuario) {
        //encriptamos la clave antes de guardar el usuario
        String hashClave = BCrypt.hashpw(usuario.getClave(), BCrypt.gensalt());
        usuario.setClave(hashClave);
        //persistimos el usuario
        usuarioJpa.create(usuario);
        
    }

    //listar usuarioS
    public ArrayList<Usuario> listarUsuarios() {
        List<Usuario> lista = usuarioJpa.findUsuarioEntities();
        return new ArrayList<Usuario>(lista);
    }

    //CONTROL RESERVA
    //crear reserva
    public void crearReserva(Reserva reserva) {
        reservaJpa.create(reserva);
        
    }

    //Listar reservas
    public ArrayList<Reserva> listarReservas() {
        List<Reserva> lista = reservaJpa.findReservaEntities();
        return new ArrayList<Reserva>(lista);
        
    }

    //actualizar reserva
    public void actualizarReserva(Reserva reserva) throws Exception {
        reservaJpa.edit(reserva);
        
    }
    //buscar reserva
    public Reserva buscarReserva(Long id){
    return reservaJpa.findReserva(id);
    }
    
    //eliminar reserva
    public void eliminarReserva(Long id) throws NonexistentEntityException{
    reservaJpa.destroy(id);
    }

    //CONTROL HUESPED
    //crear huesped
    public void crearHuesped(Huesped huesped) {
        huespedJpa.create(huesped);
        
    }

    //listar huespedes
    public ArrayList<Huesped> listarHuespedes() {
        List<Huesped> lista = huespedJpa.findHuespedEntities();
        return new ArrayList<Huesped>(lista);
    }

    //actualizar huesped
    public void actualizarHuesped(Huesped huesped) throws Exception {
        huespedJpa.edit(huesped);
    }
    //buscar huesped
    public Huesped buscarHuesped(Long id){
    return huespedJpa.findHuesped(id);
    }
    
    //eliminar huesped
    public void eliminarHuesped(Long id) throws NonexistentEntityException{
    huespedJpa.destroy(id);
    }
    
}
