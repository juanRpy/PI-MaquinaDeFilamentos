package measurementcontrol;

import Modelo.CargarSecciones;
import com.mysql.cj.protocol.SocketConnection;
import controlador.ConexionSocket;
import controlador.ControladorAjustes;
import controlador.ControladorGrafica;
import javafx.application.Application;
import javafx.stage.Stage;
import vista.MenuPrincipal;
import vista.EscenaTabla;
import controlador.ControladorMenu;
import controlador.ControladorTabla;
import controlador.ControladorPerfil;
import controlador.ControladorLogin;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import vista.EscenaAjustes;
import vista.EscenaGrafica;
import vista.EscenaPerfil;
import vista.EscenaLogin;
import vista.EscenaRegistro;
import Modelo.Notificaciones;
import controlador.ControladorLogin;
import controlador.ControladorRegistro;
import javafx.application.Platform;

public class ControlDeMedidas extends Application{
    
    private static ConexionSocket conexionSocket;
    private CargarSecciones loadSection;
    public static String mensaje;
    
    @Override
    public void start(Stage escena) throws Exception{
        Image icon = new Image(getClass().getResourceAsStream("/imagenes/LogoPrincipal.jpeg"));
        escena.getIcons().add(icon);
        
        MenuPrincipal menu = new MenuPrincipal(escena);
        EscenaTabla escenaTabla = new EscenaTabla();
        EscenaGrafica escenaGrafica = new EscenaGrafica();
        EscenaAjustes escenaAjustes = new EscenaAjustes();
        EscenaPerfil escenaPerfil = new EscenaPerfil();
        EscenaLogin escenaLogin = new EscenaLogin();
        EscenaRegistro escenaRegistro = new EscenaRegistro();
        
        conexionSocket =  new ConexionSocket();
        loadSection = new CargarSecciones();

        ControladorMenu cMenu = new ControladorMenu(menu);
        ControladorGrafica cGrafica = new ControladorGrafica(escenaGrafica, cMenu);
        ControladorTabla cTabla = new ControladorTabla(escenaTabla, cMenu); 
        ControladorAjustes cAjustes = new ControladorAjustes(escenaAjustes, cMenu, cTabla,cGrafica);
        ControladorPerfil cPerfil = new ControladorPerfil(escenaPerfil, cMenu);
        ControladorLogin cLogin = new ControladorLogin(escenaLogin,cMenu);
        ControladorRegistro cRegistro = new ControladorRegistro(escenaRegistro,cMenu);
        
        cMenu.inicializarEscenaTabla(escenaTabla.getEscenaTabla());
        cMenu.inicializarEscenaPrincipal(menu.getEscenaPrincipal());
        cMenu.inicializarEscenaGrafica(escenaGrafica.getEscenaGrafica());
        cMenu.inicializarEscenaAjustes(escenaAjustes.getEscenaAjustes());
        cMenu.inicializarEscenaPerfil(escenaPerfil.getEscenaPerfil());
        cMenu.inicializarEscenaLogin(escenaLogin.getEscenaLogin());
        cMenu.inicializarEscenaRegistro(escenaRegistro.getEscenaRegistro());

        cMenu.eventoMenu();
        cTabla.eventoTabla(); 
        cGrafica.eventoGrafica();
        cAjustes.eventoAjustes();
        cPerfil.eventoPerfil();
        cLogin.eventoLogin();
        cRegistro.eventoRegistro();
        

        escena.setScene(escenaLogin.getEscenaLogin());
        escena.setTitle("Estación de monitoreo y control");
        escena.setOnCloseRequest(event -> {
            handleExit();
        });
        escena.show(); 
    }
    
    private void handleExit() {

        // Ensure JavaFX application exits
        Platform.exit();
        
        // Exit the JVM
        System.exit(0);
    }
    
     @Override
    public void stop() throws Exception {
        if (conexionSocket != null) {
            conexionSocket.stop();
        }
        if (loadSection != null) {
        loadSection.delate();
    }
    }

    public static ConexionSocket getSocketConnection() {
        return conexionSocket;
    }
    

    public static void main(String[] args) {
        launch(args);
    }
    
}
