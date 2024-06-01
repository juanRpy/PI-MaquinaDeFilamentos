package vista;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.controlsfx.control.ToggleSwitch;


public class EscenaAjustes {
    
    private Scene escenaAjustes;
    private AnchorPane anchorPane4;
    private Scene EscenaPrincipal;
    private Scene EscenaTabla;
    private EscenaTabla escena_Tabla;
    private Label Lhora;
    private Label LModoNoche;
    private Label bienvenida;
    private Label Menu;
    private AnchorPane menu;
    private AnchorPane slideMenu;
    private ComboBox EscalaTemp;
    private Label LEscalaTemp;
    private Label LCambioIdiomas;
    private ComboBox CambioIdiomas;
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
    private Button BGuardarAjustes;
    private ToggleSwitch ModoNoche;
    
    public EscenaAjustes(){
        ajustesGUI();
    }
    
    public void ajustesGUI(){
        
        anchorPane4 = new AnchorPane();
        anchorPane4.setPrefSize(800, 440);
        anchorPane4.setStyle("-fx-background-color: white;-fx-background-radius: 10");
        escenaAjustes = new Scene(anchorPane4);
        
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
        
        Menu = new Label();
        Menu.setText("Ajustes");
        Menu.setLayoutX(122);
        Menu.setLayoutY(14);
        Menu.setTextFill(Color.rgb(0, 87, 145));
        
        //Separador
        Separator separador2 = new Separator();
        separador2.setLayoutX(169);
        separador2.setLayoutY(9);
        separador2.setPrefSize(4, 25);
        separador2.setOrientation(Orientation.VERTICAL);
        
        bienvenida = new Label();
        bienvenida.setText("¿Que hay para cambiar?");
        bienvenida.setLayoutX(182);
        bienvenida.setLayoutY(14);
        
        //Cambiar Medida de Temperatura
        LEscalaTemp = new Label();
        LEscalaTemp.setLayoutX(110);
        LEscalaTemp.setLayoutY(150);
        LEscalaTemp.setPrefSize(200, 27);
        LEscalaTemp.setText("Escalas de temperatura");
        LEscalaTemp.setFont(new Font("Verdana", 14));
        
        
        EscalaTemp = new ComboBox();
        EscalaTemp.setLayoutX(300);
        EscalaTemp.setLayoutY(152);
        EscalaTemp.setPromptText("Escalas");
        
        EscalaTemp.getItems().add(0,"Celsius");
        EscalaTemp.getItems().add(1,"Fahrenheit");
        EscalaTemp.getItems().add(2,"Kelvin");
        
        
        
        //Cambiar Idioma
        LCambioIdiomas = new Label();
        LCambioIdiomas.setLayoutX(110);
        LCambioIdiomas.setLayoutY(220);
        LCambioIdiomas.setPrefSize(200, 27);
        LCambioIdiomas.setText("Cambiar idioma");
        LCambioIdiomas.setFont(new Font("Verdana", 14));
        
        
        CambioIdiomas = new ComboBox();
        CambioIdiomas.setLayoutX(300);
        CambioIdiomas.setLayoutY(222);
        CambioIdiomas.setPromptText("Idiomas");
        
        CambioIdiomas.getItems().add(0,"Español");
        CambioIdiomas.getItems().add(1,"English");
        CambioIdiomas.getItems().add(2,"Portuguese");
        
        
        //Modo Noche
        LModoNoche = new Label();
        LModoNoche.setLayoutX(110);
        LModoNoche.setLayoutY(290);
        LModoNoche.setPrefSize(150, 27);
        LModoNoche.setText("Modo noche");
        LModoNoche.setFont(new Font("Verdana", 14));
        
        ModoNoche = new ToggleSwitch();
        ModoNoche.setLayoutX(300);
        ModoNoche.setLayoutY(295);
        
        
        BGuardarAjustes = new Button();
        BGuardarAjustes.setLayoutX(110);
        BGuardarAjustes.setLayoutY(380);
        BGuardarAjustes.setPrefSize(150, 27);
        BGuardarAjustes.setText("GUARDAR AJUSTES");
        BGuardarAjustes.setTextFill(Color.WHITE);
        BGuardarAjustes.setStyle("-fx-background-color: #005792;");
        BGuardarAjustes.setCursor(Cursor.HAND);
        
        anchorPane4.getChildren().addAll(menu,slideMenu,Lhora,separador,Bnoti,Bconfig,Bpower,Menu,separador2,bienvenida,BGuardarAjustes,LModoNoche,LEscalaTemp,EscalaTemp,LCambioIdiomas,CambioIdiomas,ModoNoche);
    }
    
    public AnchorPane getanchorPane4() {
        return anchorPane4;
    }
    
    public AnchorPane getmenu() {
        return menu;
    }
    
    public AnchorPane getslideMenu() {
        return slideMenu;
    }

    public Label getLModoNoche() {
        return LModoNoche;
    }
    
    public ToggleSwitch getModoNoche() {
        return ModoNoche;
    }

    public Label getLEscalaTemp() {
        return LEscalaTemp;
    }

    public Label getLCambioIdiomas() {
        return LCambioIdiomas;
    }
    
    public Label getbienvenida() {
        return bienvenida;
    }

    public ComboBox getEscalaTemp() {
        return EscalaTemp;
    }

    public ComboBox getCambioIdiomas() {
        return CambioIdiomas;
    }

    public Button getBGuardarAjustes() {
        return BGuardarAjustes;
    }
    
    public AnchorPane getAnchorPane4() {
        return anchorPane4;
    }
    
    public Scene getEscenaAjustes() {
        return escenaAjustes;
    }   
    
    public AnchorPane getMenuPane() {
        return menu;
    }
    
    public AnchorPane getSlideMenu() {
        return slideMenu;
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

    public Button getBinicio() {
        return Binicio;
    }

    public Button getBtabla() {
        return Btabla;
    }

    public Button getBgrafica() {
        return Bgrafica;
    }
    
    public Button getBajustes(){
        return Bajustes;
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
