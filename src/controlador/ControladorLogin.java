/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javafx.scene.control.Button;
import vista.EscenaLogin;
import Modelo.CargarRegistros;
import Modelo.Registros;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

/**
 *
 * @author josec
 */
public class ControladorLogin {
    ControladorMenu cMenu;
    EscenaLogin escenaLogin;
    CargarRegistros cargarRegistros;
    Registros registros;
    
    public ControladorLogin(EscenaLogin escenaLogin, ControladorMenu cMenu) {
        this.escenaLogin = escenaLogin;
        this.cMenu = cMenu;
    }
    
    public void eventoLogin(){
        
        Button BLogin = escenaLogin.getBLogin();
        BLogin.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaPrincipal());
        });
        
        Button BRegistrarse = escenaLogin.getBRegistrarse();
        BRegistrarse.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaRegistro());
        });
        
        TextField UsuarioTF = escenaLogin.getUsuarioTF();
        UsuarioTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.contains(" ")) {
                    UsuarioTF.setText(newValue.replace(" ", ""));
                }
            }
        });
        
        PasswordField ContraseñaPF = escenaLogin.getContraseñaPF();
        ContraseñaPF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.contains(" ")) {
                    ContraseñaPF.setText(newValue.replace(" ", ""));
                }
            }
        });
        
        TextField ContraseñaTF = escenaLogin.getContraseñaTF();
        ContraseñaTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.contains(" ")) {
                    ContraseñaTF.setText(newValue.replace(" ", ""));
                }
            }
        });
        
        ContraseñaTF.textProperty().bindBidirectional(ContraseñaPF.textProperty()); //Sincronizar textfield con passwordfield
        
        
        ToggleButton VerContraseñaB = escenaLogin.getVerContraseñaB();
        FontAwesomeIconView VerContraseñaFA = escenaLogin.getVerContraseñaFA();
        FontAwesomeIconView VerContraseñaFA2 = escenaLogin.getVerContraseñaFA2();
        VerContraseñaB.selectedProperty().addListener((obs,oldVal,newVal) -> {
            if(newVal){
               VerContraseñaB.setGraphic(VerContraseñaFA);
               ContraseñaTF.setManaged(true);
               ContraseñaTF.setVisible(true);
               ContraseñaPF.setManaged(false);
               ContraseñaPF.setVisible(false);
            }
            else{
               VerContraseñaB.setGraphic(VerContraseñaFA2);
               ContraseñaTF.setManaged(false);
               ContraseñaTF.setVisible(false);
               ContraseñaPF.setManaged(true);
               ContraseñaPF.setVisible(true);
            }
        });
        
        
        
        Button IngresarB = escenaLogin.getIngresarB();
        IngresarB.setOnMousePressed(event -> {
            this.registros = new Registros();
            this.cargarRegistros = new CargarRegistros();
            String usuario = escenaLogin.getUsuarioTFT();
            registros.setUsuario(usuario);
            if (cargarRegistros.login(registros.getUsuario(),escenaLogin.getContraseñaTFT())) {
            // Login successful, proceed to the next scene or functionality
                cMenu.cambioDeEscena(cMenu.getEscenaPrincipal());
                
            // Here you can navigate to the next scene or enable functionality
            } else {
                showInformationDialog("Error de ingreso", "Revisa los datos e intentalo de nuevo, si no tienes una cuenta, registrate.");
                // Login failed, show an error message
            }
        });
        
    }
    
    private void showInformationDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }    
}
