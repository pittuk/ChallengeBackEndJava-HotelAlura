package com.hotel.logica.servicios;

import com.hotel.logica.controladores.ReservaControlador;
import com.hotel.logica.modelo.Reserva;
import com.hotel.persistencia.exceptions.NonexistentEntityException;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ReservaServicio {

    ReservaControlador reservaControlador = new ReservaControlador();

    public Reserva crearReserva(JDateChooser fechaIngreso, JDateChooser fechaSalida, String formaPago) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        //instanciamos una reserva y le seteamos los valores
        Reserva reserva = new Reserva();
        if (fechaIngreso.getDate() != null && fechaSalida.getDate() != null) {
            //calculamos el valor de la reserva segun los días
//            Double precioReserva = calcularPrecioReserva(fechaIngreso, fechaSalida);
            //obtenemos las fechas
            Date ingreso = formato.parse(((JTextField) fechaIngreso.getDateEditor().getUiComponent()).getText());
            Date salida = formato.parse(((JTextField) fechaSalida.getDateEditor().getUiComponent()).getText());
            //calculamos el valor de la reserva segun los días
            Double precioReserva = calcularPrecioReserva(ingreso, salida);
            //seteamos los valores
            reserva.setFechaIngreso(ingreso);
            reserva.setFechaSalida(salida);
            reserva.setValor(precioReserva);
            reserva.setFormaPago(formaPago);

            System.out.println("se creo la siguiente reserva " + reserva);
            return reserva;

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar las fechas", "", JOptionPane.ERROR_MESSAGE);
            System.out.println(reserva);
            return reserva = null;

        }

    }

    public Double calcularPrecioReserva(Date fechaIngreso, Date fechaSalida) {
        //fijamos el valor del precio diario
        Double precioDia = 20000.00;

        long fecha1 = fechaIngreso.getTime();
        long fecha2 = fechaSalida.getTime();
        long diferencia = fecha2 - fecha1;
        Double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));

        Double precioReserva = dias * precioDia;
        return precioReserva;
    }

    public ArrayList<Reserva> listarReservas() {
        ArrayList<Reserva> listaReservas = reservaControlador.listarReservas();
        return listaReservas;
    }

    public Boolean actualizarReserva(Long id, Date fechaIngreso, Date fechaSalida, String formaPago) throws Exception {
        Boolean estado = false;
        if (formaPago.equals(" ") || formaPago.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La forma de pago no puede estar vacía", "", JOptionPane.ERROR_MESSAGE);
            return estado;
        } else {
            Reserva reserva = reservaControlador.busReserva(id);
            reserva.setFechaIngreso(fechaIngreso);
            reserva.setFechaSalida(fechaSalida);
            reserva.setValor(calcularPrecioReserva(fechaIngreso, fechaSalida));
            reserva.setFormaPago(formaPago);
            Object[] opciones = {"Si", "No"};
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Editar reserva número " + reserva.getNumeroReserva() + " ?",
                    "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if (confirmacion == 1 || confirmacion == 2) {
                return estado;

            } else {
                reservaControlador.actualizarReserva(reserva);
                estado = true;
                return estado;
            }

        }

    }

    public Boolean eliminarReserva(Long id) throws NonexistentEntityException {
        Boolean estado = false;
        Reserva reserva = reservaControlador.busReserva(id);
        Object[] opciones = {"Si", "No"};
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Eliminar reserva número " + reserva.getNumeroReserva() + " ?",
                    "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if (confirmacion == 1 || confirmacion == 2) {
                return estado;

            } else {
                reservaControlador.eliminarReserva(id);
                estado = true;
                return estado;
            }
        

    }
}
