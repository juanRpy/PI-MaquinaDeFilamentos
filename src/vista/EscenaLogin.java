/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import Modelo.CargarRegistros;
import Modelo.Registros;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import controlador.ControladorMenu;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.time.LocalDateTime;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author josec
 */
public class EscenaLogin {
    private Scene escenaLogin;
    private Button BLogin;
    private Button BRegistrarse;
    private TextField UsuarioTF;
    private TextField ContraseñaTF;
    private PasswordField ContraseñaPF;
    private Scene escenaPrincipal;
    MenuPrincipal menuPrincipal;
    ControladorMenu controladorMenu;
    EscenaRegistro escenaRegistro;
    CargarRegistros cargarRegistros;
    Registros registros;
    
    public EscenaLogin(ControladorMenu controladorMenu) {
        this.controladorMenu = controladorMenu;
        loginGUI();
    }
    
    public void loginGUI(){
        AnchorPane anchorPaneLogin = new AnchorPane();
        anchorPaneLogin.setPrefSize(800, 440);
        anchorPaneLogin.setStyle("-fx-background-color: white;-fx-background-radius: 10");
        escenaLogin = new Scene(anchorPaneLogin);
        
        BLogin = new Button();
        BLogin.setLayoutX(6);
        BLogin.setLayoutY(343);
        BLogin.setPrefSize(40, 27);
        
        
        BLogin.setOnMousePressed(event -> {
            controladorMenu.cambioDeEscena(controladorMenu.getEscenaPrincipal());
        });
        
        BRegistrarse = new Button("Registrarse");
        BRegistrarse.setLayoutX(96);
        BRegistrarse.setLayoutY(350);
        BRegistrarse.setPrefSize(80, 27);
        
        
        BRegistrarse.setOnMousePressed(event -> {
            controladorMenu.cambioDeEscena(controladorMenu.getEscenaRegistro());
        });
        
        Label IniciarSL = new Label("INICIAR SESIÓN");
        IniciarSL.setLayoutX(111);
        IniciarSL.setLayoutY(64);
        IniciarSL.setFont(Font.font("Verdana",25));
        
        Label UsuarioL = new Label("Usuario");
        UsuarioL.setLayoutX(55);
        UsuarioL.setLayoutY(161);
        UsuarioL.setFont(Font.font("Verdana",15));
        
        UsuarioTF = new TextField();
        UsuarioTF.setLayoutX(55);
        UsuarioTF.setLayoutY(189);
        UsuarioTF.setPrefSize(156, 25);
        
        UsuarioTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.contains(" ")) {
                    UsuarioTF.setText(newValue.replace(" ", ""));
                }
            }
        });
        
        
        Label ContraseñaL = new Label("Contraseña");
        ContraseñaL.setLayoutX(55);
        ContraseñaL.setLayoutY(228);
        ContraseñaL.setFont(Font.font("Verdana",15));
        
        ContraseñaPF = new PasswordField();
        ContraseñaPF.setLayoutX(55);
        ContraseñaPF.setLayoutY(255);
        ContraseñaPF.setPrefSize(156, 25);
        
        ContraseñaPF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.contains(" ")) {
                    ContraseñaPF.setText(newValue.replace(" ", ""));
                }
            }
        });
        
        
        ContraseñaTF = new TextField();
        ContraseñaTF.setLayoutX(55);
        ContraseñaTF.setLayoutY(255);
        ContraseñaTF.setPrefSize(156, 25);
        
        ContraseñaTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.contains(" ")) {
                    ContraseñaTF.setText(newValue.replace(" ", ""));
                }
            }
        });
        
        
        
        
        ContraseñaTF.textProperty().bindBidirectional(ContraseñaPF.textProperty()); //Sincronizar textfield con passwordfield
        
        
        
        
        
        Pane PaneImg = new Pane();
        PaneImg.setLayoutX(430);
        PaneImg.setLayoutY(0);
        PaneImg.setPrefSize(370, 440);
        PaneImg.setStyle("-fx-background-color: darkblue;");
        
        
        Button IngresarB = new Button("Ingresar");
        IngresarB.setLayoutX(100);
        IngresarB.setLayoutY(312);
        IngresarB.setPrefSize(71, 25);
        
        IngresarB.setOnMousePressed(event -> {
            eliminar();
        });
        
        
        ToggleButton VerContraseñaB = new ToggleButton();
        VerContraseñaB.setLayoutX(183);
        VerContraseñaB.setLayoutY(256);
        VerContraseñaB.setStyle("-fx-background-color:  TRANSPARENT;");
        VerContraseñaB.setCursor(Cursor.HAND);
        
        FontAwesomeIconView VerContraseñaFA = new FontAwesomeIconView();
        VerContraseñaFA.setFill(Color.rgb(0, 0, 0));
        VerContraseñaFA.setGlyphName("EYE");
        VerContraseñaFA.setSize("12");
        VerContraseñaB.setGraphic(VerContraseñaFA);
        
        FontAwesomeIconView VerContraseñaFA2 = new FontAwesomeIconView();
        VerContraseñaFA2.setFill(Color.rgb(0, 0, 0));
        VerContraseñaFA2.setGlyphName("EYE_SLASH");
        VerContraseñaFA2.setSize("12");
        
        
        //Ver contraseña u Ocultar
        VerContraseñaB.setGraphic(VerContraseñaFA2);
        ContraseñaTF.setManaged(false);
        ContraseñaTF.setVisible(false);
        ContraseñaPF.setManaged(true);
        ContraseñaPF.setVisible(true);
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
        
        
        anchorPaneLogin.getChildren().addAll(BLogin,BRegistrarse,IniciarSL,UsuarioL,UsuarioTF,ContraseñaL,ContraseñaPF,ContraseñaTF,VerContraseñaB,PaneImg,IngresarB);
    }
    
    public void eliminar(){
        cargarRegistros = new CargarRegistros();
        registros = new Registros();
        cargarRegistros = new CargarRegistros();
        String usuario = getUsuarioTF();
        registros.setUsuario(usuario);
        cargarRegistros.eliminar(registros);
    }
    
    public String getUsuarioTF() {
        return UsuarioTF.getText();
    }
    
    public Scene getEscenaLogin() {
        return escenaLogin;
    }   
}
