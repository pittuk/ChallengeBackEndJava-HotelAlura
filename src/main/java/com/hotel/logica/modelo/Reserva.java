package com.hotel.logica.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    private Double valor;
    private String formaPago;
    private String numeroReserva= "HA-"+ String.valueOf(generadorNumeroReserva()) ;

    public Reserva(Date fechaIngreso, Date fechaSalida, Double valor, String formaPago) {

        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.valor = valor;
        this.formaPago = formaPago;
    }

    public Reserva() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(String numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    private int generadorNumeroReserva() {
        double numeroCincoDigitos = 10000 + Math.random() * 90000;
        return (int) numeroCincoDigitos;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + ", valor=" + valor + ", formaPago=" + formaPago + ", numeroReserva=" + numeroReserva + '}';
    }

}
