package com.hotel.igu;

import com.hotel.logica.modelo.Huesped;
import com.hotel.logica.modelo.Reserva;

import com.hotel.logica.servicios.HuespedServicio;
import com.hotel.logica.servicios.ReservaServicio;
import com.hotel.persistencia.exceptions.NonexistentEntityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Busqueda extends javax.swing.JFrame {

    HuespedServicio huespedServicio = new HuespedServicio();
    ReservaServicio reservaServicio = new ReservaServicio();
    TableRowSorter<DefaultTableModel> sorterR;
    TableRowSorter<DefaultTableModel> sorterH;

    public Busqueda() {
        initComponents();
        llenarTablas();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jTabbedPaneContenedor = new javax.swing.JTabbedPane();
        reservas = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        huespedes = new javax.swing.JScrollPane();
        tablaHuespedes = new javax.swing.JTable();
        jButtonSalir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jLabelTextoResultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ha-100px.png"))); // NOI18N

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(51, 153, 255));
        jLabelTitulo.setText("BÚSQUEDA, EDICIÓN Y ELIMINACIÓN");

        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyReleased(evt);
            }
        });

        tablaReservas = new javax.swing.JTable() {
            public boolean isCellEditable(int row, int column) {
                if (column < 2 || column == 4) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "Numero de reserva", "Fecha de ingreso", "Fecha de salida", "Valor (CLP)", "Forma de pago"
                }));
        tablaReservas.getTableHeader().setReorderingAllowed(false);
        tablaReservas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaReservasKeyPressed(evt);
            }
        });
        reservas.setViewportView(tablaReservas);

        jTabbedPaneContenedor.addTab("Reservas", new javax.swing.ImageIcon(getClass().getResource("/reservado.png")),
                reservas); // NOI18N

        tablaHuespedes = new javax.swing.JTable() {
            public boolean isCellEditable(int row, int column) {
                if (column < 1 || column > 5) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        tablaHuespedes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "Nombre", "Apellido", "F. de Nacimiento", "Nacionalidad", "Teléfono", "N° de Reserva",
                        "ID Reserva"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tablaHuespedes.getTableHeader().setReorderingAllowed(false);
        huespedes.setViewportView(tablaHuespedes);

        jTabbedPaneContenedor.addTab("Huéspedes", new javax.swing.ImageIcon(getClass().getResource("/icon-buscar.png")),
                huespedes); // NOI18N

        jButtonSalir.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setForeground(new java.awt.Color(0, 51, 255));
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cerrar-sesion 32-px.png"))); // NOI18N
        jButtonSalir.setText("SALIR");
        jButtonSalir.setBorder(new javax.swing.border.MatteBorder(null));
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonEditar.setBackground(new java.awt.Color(0, 102, 204));
        jButtonEditar.setText("EDITAR");
        jButtonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditar.setPreferredSize(new java.awt.Dimension(78, 40));
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonEliminar.setBackground(new java.awt.Color(204, 0, 51));
        jButtonEliminar.setText("ELIMINAR");
        jButtonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEliminar.setPreferredSize(new java.awt.Dimension(78, 40));
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jLabelTextoResultado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTextoResultado.setForeground(new java.awt.Color(0, 51, 153));
        jLabelTextoResultado.setText("BUSCAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 16, Short.MAX_VALUE)
                                .addComponent(jTabbedPaneContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 854,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabelLogo)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelTextoResultado)
                                                .addGap(49, 49, 49))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(209, 209, 209)
                                                .addComponent(jLabelTitulo)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 571, Short.MAX_VALUE)
                                .addComponent(jButtonSalir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(jLabelTitulo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldBuscar)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(jLabelTextoResultado)))
                                                .addGap(3, 3, 3))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabelLogo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jTabbedPaneContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 283,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonSalir))
                                .addGap(47, 47, 47)));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonEliminarActionPerformed
        try {
            eliminarDato();
        } catch (Exception ex) {
            Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonEditarActionPerformed
        try {
            actualizarDatos();
        } catch (Exception ex) {
            Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSalirActionPerformed
        PantallaUsuario pantallaUsuario = new PantallaUsuario();
        pantallaUsuario.setVisible(true);
        pantallaUsuario.setResizable(false);
        pantallaUsuario.setLocationRelativeTo(null);
        dispose();
    }// GEN-LAST:event_jButtonSalirActionPerformed

    private void jTextFieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextFieldBuscarKeyReleased
        filtrar();
    }// GEN-LAST:event_jTextFieldBuscarKeyReleased

    private void tablaReservasKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_tablaReservasKeyPressed

    }// GEN-LAST:event_tablaReservasKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Busqueda().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane huespedes;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelTextoResultado;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPaneContenedor;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JScrollPane reservas;
    private javax.swing.JTable tablaHuespedes;
    private javax.swing.JTable tablaReservas;
    // End of variables declaration//GEN-END:variables

    private void llenarTablas() {
        // creamos los modelos de tabla
        DefaultTableModel modeloHuespedes = (DefaultTableModel) tablaHuespedes.getModel(); // modelo huespedes
        DefaultTableModel modeloReservas = (DefaultTableModel) tablaReservas.getModel(); // modelo reservas

        // preparamos los modelos para usar el filtro
        tablaReservas.setAutoCreateRowSorter(true);
        sorterR = new TableRowSorter<>(modeloReservas);
        tablaReservas.setRowSorter(sorterR);

        tablaHuespedes.setAutoCreateRowSorter(true);
        sorterH = new TableRowSorter<>(modeloHuespedes);
        tablaHuespedes.setRowSorter(sorterH);

        // limpiamos las tablas seteando el numero de filas de modelo a "0"
        modeloHuespedes.setNumRows(0);
        modeloReservas.setRowCount(0);

        // generamos los arraylist de huespedes y reservas
        // huespedes
        ArrayList<Huesped> listaHuespedes = huespedServicio.listarHuespedes();
        // reservas

        ArrayList<Reserva> listaReservas = reservaServicio.listarReservas();

        // recorremos las listas de huespedes y reservas y lo pasamos a los modelos
        for (Huesped huesped : listaHuespedes) {
            Object[] fila = { huesped.getId(), huesped.getNombre(), huesped.getApellido(), huesped.getFechaNacimiento(),
                    huesped.getNacionalidad(), huesped.getTelefono(), huesped.getReserva().getNumeroReserva(),
                    huesped.getReserva().getId() };
            modeloHuespedes.addRow(fila);
        }
        for (Reserva reserva : listaReservas) {
            Object[] fila = { reserva.getId(), reserva.getNumeroReserva(), reserva.getFechaIngreso(),
                    reserva.getFechaSalida(), reserva.getValor(), reserva.getFormaPago() };
            modeloReservas.addRow(fila);
        }

    }

    private void filtrar() {
        try {
            sorterR.setRowFilter(RowFilter.regexFilter(jTextFieldBuscar.getText()));
            sorterH.setRowFilter(RowFilter.regexFilter(jTextFieldBuscar.getText()));
        } catch (Exception e) {
        }

    }

    private void actualizarDatos() throws ParseException, Exception {
        Boolean estado = false;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        // obtenemos la fila seleccionada por el usuario
        int filaSeleccionada = tablaReservas.getSelectedRow();
        int filaSeleccionadaH = tablaHuespedes.getSelectedRow();

        if (filaSeleccionada > -1) {
            // si selecciona filas de reservas
            if (tablaReservas.getValueAt(filaSeleccionada, 2).toString().isEmpty()
                    || tablaReservas.getValueAt(filaSeleccionada, 2).toString().equals("")) {
                JOptionPane.showMessageDialog(null, "La fecha de ingreso no puede estar vacía", "",
                        JOptionPane.ERROR_MESSAGE);
            } else if (tablaReservas.getValueAt(filaSeleccionada, 3).toString().isEmpty()
                    || tablaReservas.getValueAt(filaSeleccionada, 3).toString().equals("")) {
                JOptionPane.showMessageDialog(null, "La fecha de salida no puede estar vacía", "",
                        JOptionPane.ERROR_MESSAGE);

            } else {

                // creamos variables de cada columna de la table
                Long id = Long.parseLong(tablaReservas.getValueAt(filaSeleccionada, 0).toString());
                Date fechaIngreso = formato.parse(tablaReservas.getValueAt(filaSeleccionada, 2).toString());
                Date fechaSalida = formato.parse(tablaReservas.getValueAt(filaSeleccionada, 3).toString());
                String formaPago = tablaReservas.getValueAt(filaSeleccionada, 5).toString();

                estado = reservaServicio.actualizarReserva(id, fechaIngreso, fechaSalida, formaPago);

            }

        } else if (filaSeleccionadaH > -1) {
            // si selecciona filas de huespedes
            // System.out.println("la fila seleccionada de tabla hueped es: " +
            // filaSeleccionadaH);
            if (tablaHuespedes.getValueAt(filaSeleccionadaH, 3).toString().isEmpty()
                    || tablaHuespedes.getValueAt(filaSeleccionadaH, 3).toString().equals("")) {
                JOptionPane.showMessageDialog(null, "La fecha de nacimiento no puede estar vacía", "",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                // creamos variables para cada columna editable de la tabla
                // pasamos el id porque se necesita para la edicion
                Long id = Long.parseLong(tablaHuespedes.getValueAt(filaSeleccionadaH, 0).toString());
                String nombre = tablaHuespedes.getValueAt(filaSeleccionadaH, 1).toString();
                String apellido = tablaHuespedes.getValueAt(filaSeleccionadaH, 2).toString();
                Date fechaNacimiento = formato.parse(tablaHuespedes.getValueAt(filaSeleccionadaH, 3).toString());
                String nacionalidad = tablaHuespedes.getValueAt(filaSeleccionadaH, 4).toString();
                String telefono = tablaHuespedes.getValueAt(filaSeleccionadaH, 5).toString();

                estado = huespedServicio.actualizarHuesped(id, nombre, apellido, fechaNacimiento, nacionalidad,
                        telefono);
                // estado = true;

            }

        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila", "", JOptionPane.ERROR_MESSAGE);

        }

        // -------------------------------------------------------
        if (estado) {

            JOptionPane.showMessageDialog(null, "La actualización se realizó con exito");
            llenarTablas();

        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización", "", JOptionPane.ERROR_MESSAGE);
            llenarTablas();
        }

    }

    private void eliminarDato() throws NonexistentEntityException {
        Boolean estado = false;
        // obtenemos la fila seleccionada por el usuario
        int filaSeleccionada = tablaReservas.getSelectedRow();
        int filaSeleccionadaH = tablaHuespedes.getSelectedRow();

        if (filaSeleccionada > -1) {
            // si selecciona filas de reservas

            // creamos variable del id de la fila seleccionada
            JOptionPane.showMessageDialog(null, "Las reservas estan asociadas a un Huesped, NO se puede eliminar", "",
                    JOptionPane.ERROR_MESSAGE);

        } else if (filaSeleccionadaH > -1) {
            // si selecciona filas de huespedes

            // creamos variable del id de la fila seleccionada
            // pasamos el id porque se necesita para la eliminacion
            Long id = Long.parseLong(tablaHuespedes.getValueAt(filaSeleccionadaH, 0).toString());
            estado = huespedServicio.eliminarHuesped(id);

        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila", "", JOptionPane.ERROR_MESSAGE);

        }

        // -------------------------------------------------------
        if (estado) {

            JOptionPane.showMessageDialog(null, "La eliminación se realizó con exito");
            llenarTablas();

        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la eliminación", "", JOptionPane.ERROR_MESSAGE);
            llenarTablas();
        }

    }

}
