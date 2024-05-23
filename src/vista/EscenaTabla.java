package vista;

import Modelo.Medidas;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.util.Date;
import javafx.animation.TranslateTransition;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import vista.MenuPrincipal;

public class EscenaTabla {
    
    private Scene escenaTabla;
    private AnchorPane menu;
    private AnchorPane slideMenu;
    private AnchorPane anchorPane2;
    private Thread tableThread;
    private TableView<Medidas> TablaDeDatos;
    private TableColumn<Medidas, Double> temperatureCol;
    private TableColumn <Medidas, Double> timeCol;
    private TableColumn <Medidas, Date> dateCol;
    private Label Lhora;
    private Label bienvenida;
    private Label Menu;
    private Button Bnoti;
    private Button Bconfig;
    private Button Bpower;
    private Button Bajustes;
    private Button Binicio;
    private Button Btabla;
    private Button Bgrafica;
    private Button Binicio2;
    private Button Btabla2;
    private Button Bgrafica2;
    private Button Bajustes2;
    private Button Bperfil;
    private Button Bperfil2;
    private Button Bdescargar;

    public EscenaTabla() {
        tablaGUI();
    }
    
    public void tablaGUI(){
        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setPrefSize(800, 440);
        anchorPane2.setStyle("-fx-background-color: white;-fx-background-radius: 10");
        escenaTabla = new Scene(anchorPane2);
        
        slideMenu = new AnchorPane();

        menu = new AnchorPane();
        menu.setPrefSize(38.0,440.0);
        menu.setLayoutX(0);
        menu.setLayoutY(0);
        menu.setStyle("-fx-background-color: #005792;");
        
        //Botones Slidemenu
        Binicio2 = new Button();
        Binicio2.setLayoutX(100);
        Binicio2.setLayoutY(83);
        Binicio2.setPrefSize(55, 27);
        Binicio2.setText("INICIO");
        Binicio2.setTextFill(Color.WHITE);
        Binicio2.setStyle("-fx-background-color: #005792;");
        Binicio2.setCursor(Cursor.HAND);


        Btabla2 = new Button();
        Btabla2.setLayoutX(100);
        Btabla2.setLayoutY(143);
        Btabla2.setPrefSize(55, 28);
        Btabla2.setText("TABLA");
        Btabla2.setTextFill(Color.WHITE);
        Btabla2.setStyle("-fx-background-color: #005792;");
        Btabla2.setCursor(Cursor.HAND);


        Bgrafica2 = new Button();
        Bgrafica2.setLayoutX(95);
        Bgrafica2.setLayoutY(203);
        Bgrafica2.setText("GRAFICA");
        Bgrafica2.setPrefSize(65, 28);
        Bgrafica2.setTextFill(Color.WHITE);
        Bgrafica2.setStyle("-fx-background-color: #005792;");
        Bgrafica2.setCursor(Cursor.HAND);
        
        Bajustes2 = new Button();
        Bajustes2.setLayoutX(95);
        Bajustes2.setLayoutY(263);
        Bajustes2.setText("AJUSTES");
        Bajustes2.setPrefSize(70, 28);
        Bajustes2.setTextFill(Color.WHITE);
        Bajustes2.setStyle("-fx-background-color: #005792;");
        Bajustes2.setCursor(Cursor.HAND);
        
        Bperfil2 = new Button();
        Bperfil2.setLayoutX(95);
        Bperfil2.setLayoutY(323);
        Bperfil2.setText("PERFIL");
        Bperfil2.setPrefSize(70, 28);
        Bperfil2.setTextFill(Color.WHITE);
        Bperfil2.setStyle("-fx-background-color: #005792;");
        Bperfil2.setCursor(Cursor.HAND);

        slideMenu.getChildren().addAll(Binicio2,Btabla2, Bgrafica2, Bajustes2,Bperfil2);
        
        
        //Botones menu
        Binicio = new Button();
        Binicio.setLayoutX(0);
        Binicio.setLayoutY(83);
        Binicio.setPrefSize(40, 27);
        Binicio.setStyle("-fx-background-color: #005792;");
        Binicio.setCursor(Cursor.HAND);

        FontAwesomeIconView BinicioIcon = new FontAwesomeIconView();
        BinicioIcon.setFill(Color.WHITE);
        BinicioIcon.setStyle("-fx-background-radius: 0;");
        BinicioIcon.setGlyphName("HOME");
        BinicioIcon.setSize("20");

        Binicio.setGraphic(BinicioIcon);


        Btabla = new Button();
        Btabla.setLayoutX(0);
        Btabla.setLayoutY(143);
        Btabla.setPrefSize(40, 27);
        Btabla.setStyle("-fx-background-color: #005792;");
        Btabla.setCursor(Cursor.HAND);

        FontAwesomeIconView BtablaIcon = new FontAwesomeIconView();
        BtablaIcon.setFill(Color.WHITE);
        BtablaIcon.setGlyphName("DATABASE");
        BtablaIcon.setSize("20");
        Btabla.setGraphic(BtablaIcon);


        Bgrafica = new Button();
        Bgrafica.setLayoutX(0);
        Bgrafica.setLayoutY(203);
        Bgrafica.setPrefSize(40, 27);
        Bgrafica.setStyle("-fx-background-color: #005792;");
        Bgrafica.setCursor(Cursor.HAND);

        FontAwesomeIconView BgraficaIcon = new FontAwesomeIconView();
        BgraficaIcon.setFill(Color.WHITE);
        BgraficaIcon.setGlyphName("LINE_CHART");
        BgraficaIcon.setSize("20");
        Bgrafica.setGraphic(BgraficaIcon);
        
        Bajustes = new Button();
        Bajustes.setLayoutX(0);
        Bajustes.setLayoutY(263);
        Bajustes.setPrefSize(40, 27);
        Bajustes.setStyle("-fx-background-color: #005792;");
        Bajustes.setCursor(Cursor.HAND);
        
        FontAwesomeIconView BajustesIcon = new FontAwesomeIconView();
        BajustesIcon.setFill(Color.WHITE);
        BajustesIcon.setGlyphName("GEAR");
        BajustesIcon.setSize("20");
        Bajustes.setGraphic(BajustesIcon);
        
        
        Bperfil = new Button();
        Bperfil.setLayoutX(0);
        Bperfil.setLayoutY(323);
        Bperfil.setPrefSize(40, 27);
        Bperfil.setStyle("-fx-background-color: #005792;");
        Bperfil.setCursor(Cursor.HAND);
        
        FontAwesomeIconView BperfilIcon = new FontAwesomeIconView();
        BperfilIcon.setFill(Color.WHITE);
        BperfilIcon.setGlyphName("USER");
        BperfilIcon.setSize("20");
        Bperfil.setGraphic(BperfilIcon);

        menu.getChildren().addAll(Binicio,Btabla, Bgrafica,Bajustes,Bperfil);
        
        
        //Sector Central
        
        //Tabla
        TablaDeDatos = new TableView();
        TablaDeDatos.setLayoutX(139);
        TablaDeDatos.setLayoutY(106);
        TablaDeDatos.setPrefSize(605, 306);
        
        
        //Opciones de la tabla
        AnchorPane opcionesTabla = new AnchorPane();
        opcionesTabla.setLayoutX(751);
        opcionesTabla.setLayoutY(187);
        opcionesTabla.setPrefSize(39, 143);
        opcionesTabla.setStyle("-fx-background-color: white; -fx-background-radius: 3");
        
        
        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setHeight(22.47);
        dropShadow1.setWidth(22.47);
        dropShadow1.setOffsetY(8);
        dropShadow1.setRadius(10.8675);
        dropShadow1.setColor(new Color(0, 0, 0, 0.2862595319747925));
        TablaDeDatos.setEffect(dropShadow1);
        opcionesTabla.setEffect(dropShadow1);
        
        Bdescargar = new Button();
        Bdescargar.setLayoutX(2);
        Bdescargar.setLayoutY(12);
        Bdescargar.setStyle("-fx-background-color: white;");
        Bdescargar.setCursor(Cursor.HAND);
        
        FontAwesomeIconView BdescargarIcon = new FontAwesomeIconView();
        BdescargarIcon.setFill(Color.rgb(0, 0, 0));
        BdescargarIcon.setGlyphName("DOWNLOAD");
        BdescargarIcon.setSize("20");
        
        Bdescargar.setGraphic(BdescargarIcon);
        
        opcionesTabla.getChildren().addAll(Bdescargar);
        
        
        //Hora
        Lhora = new Label();
        Lhora.setLayoutX(592);
        Lhora.setLayoutY(7);
            
        //Separador
        Separator separador = new Separator();
        separador.setLayoutX(668);
        separador.setLayoutY(5);
        separador.setPrefSize(4, 25);
        separador.setOrientation(Orientation.VERTICAL);
        
        
        
        //Botones Sector Superior Derecho
        //Botón de notificación
        Bnoti = new Button();
        Bnoti.setLayoutX(674);
        Bnoti.setLayoutY(3);
        Bnoti.setStyle("-fx-background-color: white;");
        Bnoti.setCursor(Cursor.HAND);
        
        FontAwesomeIconView BnotiIcon = new FontAwesomeIconView();
        BnotiIcon.setFill(Color.rgb(0, 0, 0));
        BnotiIcon.setGlyphName("BELL");
        BnotiIcon.setSize("20");
        
        Bnoti.setGraphic(BnotiIcon);
        
        
        //Botón de configuración
        Bconfig = new Button();
        Bconfig.setLayoutX(711);
        Bconfig.setLayoutY(3);
        Bconfig.setStyle("-fx-background-color: white;");
        Bconfig.setCursor(Cursor.HAND);
        
        FontAwesomeIconView BconfigIcon = new FontAwesomeIconView();
        BconfigIcon.setFill(Color.rgb(0, 0, 0));
        BconfigIcon.setGlyphName("GEAR");
        BconfigIcon.setSize("20");
       
        Bconfig.setGraphic(BconfigIcon);
        
        
        //Botón de encendido
        Bpower = new Button();
        Bpower.setLayoutX(746);
        Bpower.setLayoutY(3);
        Bpower.setStyle("-fx-background-color: white;");
        Bpower.setCursor(Cursor.HAND);
        
        FontAwesomeIconView BpowerIcon = new FontAwesomeIconView();
        BpowerIcon.setFill(Color.rgb(255, 0, 0));
        BpowerIcon.setGlyphName("POWER_OFF");
        BpowerIcon.setSize("20");

        Bpower.setGraphic(BpowerIcon);
        
        
        //Mensaje de bienvenida
        Menu = new Label();
        Menu.setText("Tabla");
        Menu.setLayoutX(130);
        Menu.setLayoutY(14);
        Menu.setTextFill(Color.rgb(0, 87, 145));
        
        //Separador
        Separator separador2 = new Separator();
        separador2.setLayoutX(169);
        separador2.setLayoutY(9);
        separador2.setPrefSize(4, 25);
        separador2.setOrientation(Orientation.VERTICAL);
        
        bienvenida = new Label();
        bienvenida.setText("Recuerda guardar los datos!");
        bienvenida.setLayoutX(182);
        bienvenida.setLayoutY(14);
        
        temperatureCol = new TableColumn<>("Temperatura");
        temperatureCol.prefWidthProperty().bind(TablaDeDatos.widthProperty().multiply(0.34)); // Columna con un tercio del ancho de la tabla
        timeCol = new TableColumn<>("Tiempo");
        timeCol.prefWidthProperty().bind(TablaDeDatos.widthProperty().multiply(0.34)); // Columna con un tercio del ancho de la tabla
        dateCol = new TableColumn<>("Fecha");
        dateCol.prefWidthProperty().bind(TablaDeDatos.widthProperty().multiply(0.34));
        
        // Configurar las propiedades de las columnas, como el ancho, el tipo de dato, etc., si es necesario
        
        // Agregar las columnas a la TableView
        TablaDeDatos.getColumns().addAll(temperatureCol, timeCol, dateCol);
        
        //Cambios de Escenas
        
        anchorPane2.getChildren().addAll(menu,slideMenu,TablaDeDatos,opcionesTabla,Bnoti,Bconfig,Bpower,Menu,bienvenida,separador,separador2,Lhora);
        
        
    }

    public Scene getEscenaTabla() {
        return escenaTabla;
    }   

    public AnchorPane getAnchorPane2() {
        return anchorPane2;
    }
    
    public AnchorPane getMenuPane() {
        return menu;
    }
    
    public AnchorPane getSlideMenu() {
        return slideMenu;
    }

    public Thread getTableThread() {
        return tableThread;
    }

    public TableView getTablaDeDatos() {
        return TablaDeDatos;
    }

    public TableColumn getTemperatureCol() {
        return temperatureCol;
    }

    public TableColumn getTimeCol() {
        return timeCol;
    }

    public TableColumn getDateCol() {
        return dateCol;
    }

    public Label getLhora() {
        return Lhora;
    }

    public Label getBienvenida() {
        return bienvenida;
    }

    public Label getMenu() {
        return Menu;
    }
    public Button getBnoti() {
        return Bnoti;
    }

    public Button getBconfig() {
        return Bconfig;
    }

    public Button getBpower() {
        return Bpower;
    }

    public Button getBajustes() {
        return Bajustes;
    }

    public Button getBinicio() {
        return Binicio;
    }

    public Button getBtabla() {
        return Btabla;
    }

    public Button getBgrafica() {
        return Bgrafica;
    }

    public Button getBdescargar() {
        return Bdescargar;
    }

    public Button getBinicio2() {
        return Binicio2;
    }

    public Button getBtabla2() {
        return Btabla2;
    }

    public Button getBgrafica2() {
        return Bgrafica2;
    }

    public Button getBajustes2() {
        return Bajustes2;
    }
    
    public Button getBperfil() {
        return Bperfil;
    }

    public Button getBperfil2() {
        return Bperfil2;
    }
}
