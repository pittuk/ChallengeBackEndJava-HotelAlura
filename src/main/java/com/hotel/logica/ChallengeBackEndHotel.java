/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.hotel.logica;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.hotel.igu.PantallaInicio;


/**
 *
 * @author pittu
 */
public class ChallengeBackEndHotel {

    public static void main(String[] args) {
        
       
        //indicamos el tema que vamos a utilizar
        FlatMaterialLighterIJTheme.setup();
        PantallaInicio pantallaInicio = new PantallaInicio();

        //lanzamos la pantalla
        pantallaInicio.setVisible(true);
        pantallaInicio.setResizable(false);
        pantallaInicio.setLocationRelativeTo(null);
        
    }
}
