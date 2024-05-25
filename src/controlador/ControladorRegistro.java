/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javafx.scene.control.Button;
import vista.EscenaRegistro;

/**
 *
 * @author josec
 */
public class ControladorRegistro {
    ControladorMenu cMenu;
    EscenaRegistro escenaRegistro;
    
    public ControladorRegistro(EscenaRegistro escenaRegistro, ControladorMenu cMenu) {
        this.escenaRegistro = escenaRegistro;
        this.cMenu = cMenu;
    }
    
    public void eventoRegistro(){
        
        Button BLogin = escenaRegistro.getBLogin();
        BLogin.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaLogin());
        });
    }
}
