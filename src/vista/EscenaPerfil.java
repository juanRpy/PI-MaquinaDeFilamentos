package vista;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class EscenaPerfil {
    private Scene escenaPerfil;
    private AnchorPane menu;
    private AnchorPane slideMenu;
    private AnchorPane anchorPane4;
    private TableColumn temperatureCol;
    private TableColumn timeCol;
    private TableColumn dateCol;
    private Label Lhora;
    private Label bienvenida;
    private Label Menu;
    private Button Bnoti;
    private Button Bconfig;
    private Button Bpower;
    private Button Bajustes;
    private Button Bperfil;
    private Button Bperfil2;
    private Button Binicio;
    private Button Btabla;
    private Button Bgrafica;
    private Button Binicio2;
    private Button Btabla2;
    private Button Bgrafica2;
    private Button Bajustes2;

    public EscenaPerfil() {
        perfilGUI();
    }
    
    public void perfilGUI(){
        anchorPane4 = new AnchorPane(); // Elimina la declaración AnchorPane
        anchorPane4.setPrefSize(800, 440);
        anchorPane4.setStyle("-fx-background-color: white;-fx-background-radius: 10");
        escenaPerfil = new Scene(anchorPane4);
        
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
        
        
        //Separador
        Separator separador2 = new Separator();
        separador2.setLayoutX(169);
        separador2.setLayoutY(9);
        separador2.setPrefSize(4, 25);
        separador2.setOrientation(Orientation.VERTICAL);
        
        //Mensaje de bienvenida
        Menu = new Label();
        Menu.setText("Gráfica");
        Menu.setLayoutX(123);
        Menu.setLayoutY(14);
        Menu.setTextFill(Color.rgb(0, 87, 145));
        
        bienvenida = new Label();
        bienvenida.setText("Observa su comportamiento");
        bienvenida.setLayoutX(182);
        bienvenida.setLayoutY(14);
        
        // Datos del usuario
        
        Label Lnombre = new Label();
        Lnombre.setText("Nombre:");
        Lnombre.setLayoutX(120);
        Lnombre.setLayoutY(100);
        Lnombre.setFont(new Font("Verdana", 14));
        
        TextField TFnombre = new TextField();
        TFnombre.setText("Nombre");
        TFnombre.setLayoutX(185);
        TFnombre.setLayoutY(95);
        TFnombre.setEditable(false);
        TFnombre.setFont(new Font("Verdana", 14));
        TFnombre.setStyle("-fx-background-color:TRANSPARENT");
        
        Label Lusuario = new Label();
        Lusuario.setText("Usuario:");
        Lusuario.setLayoutX(120);
        Lusuario.setLayoutY(160);
        Lusuario.setFont(new Font("Verdana", 14));
        
        TextField TFusuario = new TextField();
        TFusuario.setText("Nombre");
        TFusuario.setLayoutX(183);
        TFusuario.setLayoutY(155);
        TFusuario.setEditable(false);
        TFusuario.setFont(new Font("Verdana", 14));
        TFusuario.setStyle("-fx-background-color:TRANSPARENT");
        
        Label Lcontraseña = new Label();
        Lcontraseña.setText("Contraseña:");
        Lcontraseña.setLayoutX(120);
        Lcontraseña.setLayoutY(220);
        Lcontraseña.setFont(new Font("Verdana", 14));
        
        PasswordField ContraseñaPF = new PasswordField();
        ContraseñaPF.setText("Nombre");
        ContraseñaPF.setLayoutX(210);
        ContraseñaPF.setLayoutY(215);
        ContraseñaPF.setPrefSize(156, 25);
        ContraseñaPF.setFont(new Font("Verdana", 14));
        ContraseñaPF.setStyle("-fx-background-color:TRANSPARENT");
        ContraseñaPF.setEditable(false);
        
        ContraseñaPF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.contains(" ")) {
                    ContraseñaPF.setText(newValue.replace(" ", ""));
                }
            }
        });
        
        
        TextField ContraseñaTF = new TextField();
        ContraseñaTF.setText("Nombre");
        ContraseñaTF.setLayoutX(210);
        ContraseñaTF.setLayoutY(215);
        ContraseñaTF.setPrefSize(156, 25);
        ContraseñaTF.setFont(new Font("Verdana", 14));
        ContraseñaTF.setStyle("-fx-background-color:TRANSPARENT");
        ContraseñaTF.setEditable(false);
        ContraseñaTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.contains(" ")) {
                    ContraseñaTF.setText(newValue.replace(" ", ""));
                }
            }
        });
        
        
        ContraseñaTF.textProperty().bindBidirectional(ContraseñaPF.textProperty());
        
        
        ToggleButton VerContraseñaB = new ToggleButton();
        VerContraseñaB.setLayoutX(300);
        VerContraseñaB.setLayoutY(218);
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
        
        
        anchorPane4.getChildren().addAll(menu,slideMenu,Lhora,separador,Bnoti,Bconfig,Bpower,separador2,bienvenida,Menu,Lnombre,TFnombre,Lusuario,TFusuario,Lcontraseña,ContraseñaPF,ContraseñaTF,VerContraseñaB);
        
        
    }

    public AnchorPane getAnchorPane4() {
        return anchorPane4;
    }
    
    public Scene getEscenaPerfil() {
        return escenaPerfil;
    }   
    
    public AnchorPane getMenuPane() {
        return menu;
    }
    
    public AnchorPane getSlideMenu() {
        return slideMenu;
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
}
