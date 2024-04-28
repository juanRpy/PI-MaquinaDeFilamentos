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
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import vista.EscenaAjustes;
import vista.EscenaGrafica;

public class ControlDeMedidas extends Application{
    
    private static ConexionSocket conexionSocket;
    private CargarSecciones loadSection;
    
    @Override
    public void start(Stage escena) {
        
        Image icon = new Image(getClass().getResourceAsStream("/imagenes/LogoPrincipal.jpeg"));
        escena.getIcons().add(icon);
        
        MenuPrincipal menu = new MenuPrincipal(escena);
        EscenaTabla escenaTabla = new EscenaTabla();
        EscenaGrafica escenaGrafica = new EscenaGrafica();
        EscenaAjustes escenaAjustes = new EscenaAjustes();
        
        conexionSocket =  new ConexionSocket();
        loadSection = new CargarSecciones();

        ControladorMenu cMenu = new ControladorMenu(menu);
        ControladorGrafica cGrafica = new ControladorGrafica(escenaGrafica, cMenu);
        ControladorTabla cTabla = new ControladorTabla(escenaTabla, cMenu); 
        ControladorAjustes cAjustes = new ControladorAjustes(escenaAjustes, cMenu, cTabla,cGrafica);

        cMenu.inicializarEscenaTabla(escenaTabla.getEscenaTabla());
        cMenu.inicializarEscenaPrincipal(menu.getEscenaPrincipal());
        cMenu.inicializarEscenaGrafica(escenaGrafica.getEscenaGrafica());
        cMenu.inicializarEscenaAjustes(escenaAjustes.getEscenaAjustes());

        cMenu.eventoMenu();
        cTabla.eventoTabla(); 
        cGrafica.eventoGrafica();
        cAjustes.eventoAjustes();
        

        escena.setScene(menu.getEscenaPrincipal());
        escena.setTitle("Estación de monitoreo y control");
        escena.show(); 
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
