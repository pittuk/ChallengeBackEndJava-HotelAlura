

package com.hotel.logica.controladores;

import com.hotel.logica.modelo.Huesped;
import com.hotel.persistencia.ControladoraPersistencia;
import com.hotel.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;



public class HuespedControlador {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearHuesped(Huesped huesped) {
        controlPersis.crearHuesped(huesped);
        
    }
    
    public ArrayList<Huesped> listarHuespedes(){
    return controlPersis.listarHuespedes();
    
    }
    public void actualizarHuesped(Huesped huesped) throws Exception{
    controlPersis.actualizarHuesped(huesped);
    
    }
    
    public Huesped buscarHuesped(Long id){
    return controlPersis.buscarHuesped(id);
    }
    
    public void eliminarHuesped(Long id) throws NonexistentEntityException{
    controlPersis.eliminarHuesped(id);
    }

}
