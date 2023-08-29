package com.hotel.logica.servicios;

import com.hotel.igu.PantallaUsuario;
import com.hotel.logica.controladores.HuespedControlador;
import com.hotel.logica.controladores.ReservaControlador;
import com.hotel.logica.modelo.Huesped;
import com.hotel.logica.modelo.Reserva;
import com.hotel.persistencia.exceptions.NonexistentEntityException;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class HuespedServicio {

    ReservaControlador reservaControlador = new ReservaControlador();
    HuespedControlador huespedControlador = new HuespedControlador();

    public Boolean crearHuesped(Reserva reserva, String nombre, String apellido, JDateChooser fechaNacimiento, String nacionalidad, String telefono) throws ParseException {
        Boolean estado = false;

        if (nombre.length() < 3 || nombre.equals(" ") || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre", "", JOptionPane.ERROR_MESSAGE);
            return estado;
        } else if (apellido.length() < 3 || apellido.equals(" ") || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un apellido", "", JOptionPane.ERROR_MESSAGE);
            return estado;
        } else if (fechaNacimiento.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una fecha de nacimiento", "", JOptionPane.ERROR_MESSAGE);
            return estado;
        } else if (telefono.length() < 7 || telefono.equals(" ") || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un telefono", "", JOptionPane.ERROR_MESSAGE);
            return estado;
        } else {
            //formatemos la fecha
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            //obtenemos las fechas
            Date fNacimiento = formato.parse(((JTextField) fechaNacimiento.getDateEditor().getUiComponent()).getText());
            //1ro persistimos la reserva

            reservaControlador.crearReserva(reserva);
            System.out.println("se guardo la siguiente reserva " + reserva);
            //instanciamos un huesped
            Huesped huesped = new Huesped(nombre, apellido, fNacimiento, nacionalidad, telefono, reserva);
            System.out.println("se creo el huesped " + huesped);

            huespedControlador.crearHuesped(huesped);
            JOptionPane.showMessageDialog(null, "La reserva ha sido creada con exito");
            //
            estado = true;
            return estado;
        }

    }

    public Huesped precargarReservaAHuesped(Reserva reserva) {
        Huesped huesped = new Huesped();
        huesped.setReserva(reserva);
        return huesped;
    }

    public ArrayList<Huesped> listarHuespedes() {
        ArrayList<Huesped> listaHuespedes = huespedControlador.listarHuespedes();
        return listaHuespedes;
    }

    public Boolean actualizarHuesped(Long id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono) throws Exception {

        Boolean estado = false;

        if (nombre.length() < 3 || nombre.equals(" ") || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre", "", JOptionPane.ERROR_MESSAGE);
            return estado;
        } else if (apellido.length() < 3 || apellido.equals(" ") || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un apellido", "", JOptionPane.ERROR_MESSAGE);
            return estado;
        } else if (nacionalidad.length() < 7 || nacionalidad.equals(" ") || nacionalidad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una nacionalidad", "", JOptionPane.ERROR_MESSAGE);
            return estado;
        } else if (telefono.length() < 7 || telefono.equals(" ") || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un telefono", "", JOptionPane.ERROR_MESSAGE);
            return estado;
        } else {
            
            Huesped huesped=huespedControlador.buscarHuesped(id);
            huesped.setNombre(nombre);
            huesped.setApellido(apellido);
            huesped.setFechaNacimiento(fechaNacimiento);
            huesped.setNacionalidad(nacionalidad);
            huesped.setTelefono(telefono);
            
            
            Object[] opciones = {"Si", "No"};
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Editar huesped número " + huesped.getId()+ " ?",
                    "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if (confirmacion == 1 || confirmacion == 2) {
                return estado;

            } else {
                huespedControlador.actualizarHuesped(huesped);
                estado = true;
                return estado;
            }

        }
    }


    public Boolean eliminarHuesped(Long id) throws NonexistentEntityException{
    Boolean estado = false;
        Huesped huesped= huespedControlador.buscarHuesped(id);
        Object[] opciones = {"Si", "No"};
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Al eliminar el huesped número " + huesped.getId() + " ? también se elminara su reserva asociada, número "+huesped.getReserva().getNumeroReserva(),
                    "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if (confirmacion == 1 || confirmacion == 2) {
                return estado;

            } else {
                huespedControlador.eliminarHuesped(id);
                reservaControlador.eliminarReserva(huesped.getReserva().getId());
                estado = true;
                return estado;
            }
    
    
    
    
    }
}
