
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class EscenaLogin {
    private Scene escenaLogin;
    private Stage primaryStage;
    private Button BLogin;
    private Button BRegistrarse;
    private Button IngresarB;
    private TextField UsuarioTF;
    private TextField ContraseñaTF;
    private PasswordField ContraseñaPF;
    private ToggleButton VerContraseñaB;
    private FontAwesomeIconView VerContraseñaFA;
    private FontAwesomeIconView VerContraseñaFA2;
    private Scene escenaPrincipal;
    MenuPrincipal menuPrincipal;
    ControladorMenu controladorMenu;
    EscenaRegistro escenaRegistro;
    CargarRegistros cargarRegistros;
    Registros registros;
    
    
    public EscenaLogin() {
        
        loginGUI();
    }
    
    public void loginGUI(){
        AnchorPane anchorPaneLogin = new AnchorPane();
        anchorPaneLogin.setPrefSize(800, 440);
        anchorPaneLogin.setStyle("-fx-background-color: white;-fx-background-radius: 10");
        escenaLogin = new Scene(anchorPaneLogin);
        
        Image LogoI = new Image("Imagenes/LOGO.png");
        ImageView LogoImage = new ImageView();
        LogoImage.setImage(LogoI);
        LogoImage.setLayoutX(100);
        LogoImage.setLayoutY(140);
        LogoImage.setFitWidth(180);
        LogoImage.setFitHeight(180);
        
        BLogin = new Button();
        BLogin.setLayoutX(6);
        BLogin.setLayoutY(343);
        BLogin.setPrefSize(40, 27);
        
        
        BRegistrarse = new Button("Registrarse");
        BRegistrarse.setLayoutX(176);
        BRegistrarse.setLayoutY(350);
        BRegistrarse.setPrefSize(80, 27);
        
        
        
        Label IniciarSL = new Label("INICIAR SESIÓN");
        IniciarSL.setLayoutX(111);
        IniciarSL.setLayoutY(64);
        IniciarSL.setFont(Font.font("Verdana",25));
        
        Label UsuarioL = new Label("Usuario");
        UsuarioL.setLayoutX(135);
        UsuarioL.setLayoutY(161);
        UsuarioL.setFont(Font.font("Verdana",15));
        
        UsuarioTF = new TextField();
        UsuarioTF.setLayoutX(135);
        UsuarioTF.setLayoutY(189);
        UsuarioTF.setPrefSize(156, 25);
        
        
        Label ContraseñaL = new Label("Contraseña");
        ContraseñaL.setLayoutX(135);
        ContraseñaL.setLayoutY(228);
        ContraseñaL.setFont(Font.font("Verdana",15));
        
        ContraseñaPF = new PasswordField();
        ContraseñaPF.setLayoutX(135);
        ContraseñaPF.setLayoutY(255);
        ContraseñaPF.setPrefSize(156, 25);
        
        
        ContraseñaTF = new TextField();
        ContraseñaTF.setLayoutX(135);
        ContraseñaTF.setLayoutY(255);
        ContraseñaTF.setPrefSize(156, 25);
        
        
        Pane PaneImg = new Pane();
        PaneImg.setLayoutX(430);
        PaneImg.setLayoutY(0);
        PaneImg.setPrefSize(370, 440);
        PaneImg.setStyle("-fx-background-color: darkblue;");
        
        PaneImg.getChildren().addAll(LogoImage);
                
                
        IngresarB = new Button("Ingresar");
        IngresarB.setLayoutX(180);
        IngresarB.setLayoutY(312);
        IngresarB.setPrefSize(71, 25);
        
        
        VerContraseñaB = new ToggleButton();
        VerContraseñaB.setLayoutX(263);
        VerContraseñaB.setLayoutY(256);
        VerContraseñaB.setStyle("-fx-background-color:  TRANSPARENT;");
        VerContraseñaB.setCursor(Cursor.HAND);
        
        VerContraseñaFA = new FontAwesomeIconView();
        VerContraseñaFA.setFill(Color.rgb(0, 0, 0));
        VerContraseñaFA.setGlyphName("EYE");
        VerContraseñaFA.setSize("12");
        VerContraseñaB.setGraphic(VerContraseñaFA);
        
        VerContraseñaFA2 = new FontAwesomeIconView();
        VerContraseñaFA2.setFill(Color.rgb(0, 0, 0));
        VerContraseñaFA2.setGlyphName("EYE_SLASH");
        VerContraseñaFA2.setSize("12");
        
        
        //Ver contraseña u Ocultar
        VerContraseñaB.setGraphic(VerContraseñaFA2);
        ContraseñaTF.setManaged(false);
        ContraseñaTF.setVisible(false);
        ContraseñaPF.setManaged(true);
        ContraseñaPF.setVisible(true);
        
        
        
        anchorPaneLogin.getChildren().addAll(BRegistrarse,IniciarSL,UsuarioL,UsuarioTF,ContraseñaL,ContraseñaPF,ContraseñaTF,VerContraseñaB,PaneImg,IngresarB);
    }
    
    public void eliminar(){
        registros = new Registros();
        cargarRegistros = new CargarRegistros();
        String usuario = getUsuarioTFT();
        registros.setUsuario(usuario);
        cargarRegistros.eliminar(registros);
    }
    
    
    
    public String getUsuarioTFT() {
        return UsuarioTF.getText();
    }
    
    public TextField getUsuarioTF() {
        return UsuarioTF;
    }
    
    public String getContraseñaTFT(){
        return ContraseñaTF.getText();
    }
    
    public TextField getContraseñaTF(){
        return ContraseñaTF;
    }
    
    public PasswordField getContraseñaPF(){
        return ContraseñaPF;
    }
    
    public Scene getEscenaLogin() {
        return escenaLogin;
    }   
    
    public Button getBLogin(){
        return BLogin;
    }
    
    public Button getIngresarB(){
        return IngresarB;
    }
    
    public Button getBRegistrarse(){
        return BRegistrarse;
    }
    
    public ToggleButton getVerContraseñaB(){
        return VerContraseñaB;
    }
    
    public FontAwesomeIconView getVerContraseñaFA(){
        return VerContraseñaFA;
    }
    
    public FontAwesomeIconView getVerContraseñaFA2(){
        return VerContraseñaFA2;
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
