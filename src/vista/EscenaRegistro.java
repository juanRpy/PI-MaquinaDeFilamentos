/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import controlador.ControladorMenu;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
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
import javax.swing.JOptionPane;
import Modelo.CargarRegistros;
import Modelo.Registros;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author josec
 */
public class EscenaRegistro {
    private Scene escenaRegistro;
    private Button BLogin;
    private TextField UsuarioTF;
    private TextField NombreTF;
    private TextField ContraseñaTF;
    private PasswordField ContraseñaPF;
    private Scene escenaPrincipal;
    CargarRegistros cargarRegistros;
    Registros registros;
    MenuPrincipal menuPrincipal;
    ControladorMenu controladorMenu;
    
    public EscenaRegistro() {
        loginGUI();
    }
    
    public void loginGUI(){
        AnchorPane anchorPaneRegistro = new AnchorPane();
        anchorPaneRegistro.setPrefSize(800, 440);
        anchorPaneRegistro.setStyle("-fx-background-color: white;-fx-background-radius: 10");
        escenaRegistro = new Scene(anchorPaneRegistro);
        
        BLogin = new Button("Volver");
        BLogin.setLayoutX(185);
        BLogin.setLayoutY(383);
        BLogin.setPrefSize(70, 27);
        
        Image LogoI = new Image("Imagenes/LOGO.png");
        ImageView LogoImage = new ImageView();
        LogoImage.setImage(LogoI);
        LogoImage.setLayoutX(100);
        LogoImage.setLayoutY(140);
        LogoImage.setFitWidth(180);
        LogoImage.setFitHeight(180);
        
        
        Label IniciarSL = new Label("REGISTRARSE");
        IniciarSL.setLayoutX(123);
        IniciarSL.setLayoutY(54);
        IniciarSL.setFont(Font.font("Verdana",25));
        
        Label NombreL = new Label("Nombre:");
        NombreL.setLayoutX(135);
        NombreL.setLayoutY(124);
        NombreL.setFont(Font.font("Verdana",15));
        
        NombreTF = new TextField();
        NombreTF.setLayoutX(135);
        NombreTF.setLayoutY(152);
        NombreTF.setPrefSize(156, 25);
        
        Label UsuarioL = new Label("Usuario:");
        UsuarioL.setLayoutX(135);
        UsuarioL.setLayoutY(191);
        UsuarioL.setFont(Font.font("Verdana",15));
        
        UsuarioTF = new TextField();
        UsuarioTF.setLayoutX(135);
        UsuarioTF.setLayoutY(219);
        UsuarioTF.setPrefSize(156, 25);
        
        UsuarioTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.contains(" ")) {
                    UsuarioTF.setText(newValue.replace(" ", ""));
                }
            }
        });
        
        
        
        
        Label ContraseñaL = new Label("Contraseña:");
        ContraseñaL.setLayoutX(135);
        ContraseñaL.setLayoutY(258);
        ContraseñaL.setFont(Font.font("Verdana",15));
        
        ContraseñaPF = new PasswordField();
        ContraseñaPF.setLayoutX(135);
        ContraseñaPF.setLayoutY(285);
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
        ContraseñaTF.setLayoutX(135);
        ContraseñaTF.setLayoutY(285);
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
        
        
        PaneImg.getChildren().addAll(LogoImage);
        
        Button RegistrarseB = new Button("Registrarse");
        RegistrarseB.setLayoutX(174);
        RegistrarseB.setLayoutY(342);
        RegistrarseB.setPrefSize(91, 25);
        
        RegistrarseB.setOnMousePressed((t) -> {
            fill();
        });
        
        ToggleButton VerContraseñaB = new ToggleButton();
        VerContraseñaB.setLayoutX(263);
        VerContraseñaB.setLayoutY(286);
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
        
        
        anchorPaneRegistro.getChildren().addAll(BLogin,IniciarSL,UsuarioL,UsuarioTF,ContraseñaL,ContraseñaPF,ContraseñaTF,VerContraseñaB,PaneImg,RegistrarseB,NombreL,NombreTF);
    }
    
    public void fill() {
        cargarRegistros = new CargarRegistros();
        registros = new Registros();
        
        String nombre = getNombreTF();
        String usuario = getUsuarioTF();
        String pin = getContraseñaTF();
        LocalDateTime fecha = registros.getFecha(); 

        if (!nombre.isEmpty() && !usuario.isEmpty() && !pin.isEmpty()) {
            try {
                registros.setNombre(nombre);
                registros.setUsuario(usuario);
                registros.setPin(pin);
                registros.setFecha(fecha);
                cargarRegistros.crear(registros);
                NombreTF.setText("");
                UsuarioTF.setText("");
                ContraseñaTF.setText("");
                ContraseñaPF.setText("");
            } catch (NumberFormatException e) {
                e.printStackTrace(); 
            }
        } else {
            showErrorDialog("Datos incompletos", "Ingresa todos los datos para crear tu cuenta");
            // Manejar el caso en que una de las cadenas está vacía
        }
    }
    
    
    
    private void showErrorDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    } 
    
    public String getNombreTF() {
        return NombreTF.getText();
    }
    
    public String getUsuarioTF() {
        return UsuarioTF.getText();
    }
    
    public String getContraseñaTF() {
        return ContraseñaTF.getText();
    }
    
    public Button getBLogin(){
        return BLogin;
    }
    
    
    
    public Scene getEscenaRegistro() {
        return escenaRegistro;
    }   
}

