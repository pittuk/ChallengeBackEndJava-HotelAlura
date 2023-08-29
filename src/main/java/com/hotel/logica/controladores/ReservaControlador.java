package com.hotel.logica.controladores;

import com.hotel.logica.modelo.Reserva;
import com.hotel.persistencia.ControladoraPersistencia;
import com.hotel.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;

public class ReservaControlador {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearReserva(Reserva reserva) {
        controlPersis.crearReserva(reserva);
        
    }
    
    public ArrayList<Reserva> listarReservas(){
     return controlPersis.listarReservas();
    
    }
    
    public void actualizarReserva(Reserva reserva) throws Exception{
    controlPersis.actualizarReserva(reserva);
    
    }
    
    public Reserva busReserva(Long id){
    return controlPersis.buscarReserva(id);
    }
    
    public void eliminarReserva(Long id) throws NonexistentEntityException{
    controlPersis.eliminarReserva(id);
    
    }
    
}
