package vista;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;

public class MenuPrincipal {
    
    private Stage primaryStage;
    private Scene escenaPrincipal;
    private Label bienvenida;
    private Label Menu;
    private ToggleButton Bnoti;
    private FontAwesomeIconView BnotiIcon;
    private ImageView BnotiI_2;
    private ImageView BnotiI;
    private Pane Pnotificaciones;
    private Button Bconfig;
    private ToggleButton Bpower;
    private Button Binicio;
    private Button Btabla;
    private Button Bgrafica;
    private Button Binicio2;
    private Button Btabla2;
    private Button Bgrafica2;
    private Button Bajustes;
    private Button Bajustes2;
    private Button Bperfil;
    private Button Bperfil2;
    private Button BLogin;
    private Button BCambioDePerfil;
    private AnchorPane slideMenu;
    private AnchorPane menu;
    private Label label;
    private Label label2;
    private Label Lhora;
    private Label Ltemp;
    private Label Ltemp2;
    private Label Ltiempo;
    private Label Ltiempo2;
    private Label LSmotor;
    private Label LStemp;
    private Label LSVventilador;
    private Slider Smotor;
    private Slider Stemp;
    private Slider SVventilador;
    private ComboBox CambioDePerfil;
    
    static final int DATA_SERIES_SIZE = 100; // Número máximo de puntos en la serie de datos
    static final int MIN_Y_VALUE = 20;
    static  int MAX_Y_VALUE = 50;
   
    
    private XYChart.Series<Number, Number> dataSeries = new XYChart.Series<>();
    private XYChart.Series<Number, Number> dataSeries2 = new XYChart.Series<>();
    private XYChart.Series<Number, Number> dataSeries3 = new XYChart.Series<>();
    private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();
    private LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
    
    AnchorPane anchorPane = new AnchorPane();
    
    public MenuPrincipal(Stage primaryStage){
        this.primaryStage = primaryStage;
        menuGUI();
    }
    
    public void menuGUI(){
        anchorPane.setPrefSize(800, 440);
        anchorPane.setStyle("-fx-background-color: white;-fx-background-radius: 10");
        escenaPrincipal = new Scene(anchorPane, 800, 440);
        
        //Label de hora
        Lhora = new Label();
        Lhora.setLayoutX(46);
        Lhora.setLayoutY(17);
        
        
        //Separador
        Separator separador = new Separator();
        separador.setLayoutX(122);
        separador.setLayoutY(15);
        separador.setPrefSize(4, 25);
        separador.setOrientation(Orientation.VERTICAL);

        //Botones superiores

        //Botón de notificación
        Bnoti = new ToggleButton();
        Bnoti.setLayoutX(128);
        Bnoti.setLayoutY(13);
        Bnoti.setStyle("-fx-background-color: white;");
        Bnoti.setCursor(Cursor.HAND);

        
        Image BnotiI1 = new Image("Imagenes/Noti_1.png");
        BnotiI = new ImageView();
        BnotiI.setImage(BnotiI1);
        Bnoti.setGraphic(BnotiI);
        
        Image BnotiI2 = new Image("Imagenes/Noti_2.png");
        BnotiI_2 = new ImageView();
        BnotiI_2.setImage(BnotiI2);
        
        /*
        BnotiIcon = new FontAwesomeIconView();
        BnotiIcon.setFill(Color.rgb(0, 0, 0));
        BnotiIcon.setGlyphName("BELL_ALT");
        BnotiIcon.setSize("20"); 
        Bnoti.setGraphic(BnotiIcon);
        */
        Pnotificaciones = new Pane();
        Pnotificaciones.setLayoutX(473);
        Pnotificaciones.setLayoutY(-200);
        Pnotificaciones.setPrefSize(200, 180);
        Pnotificaciones.setStyle("-fx-background-color:  WHITE; -fx-background-radius: 10; -fx-border-radius: 10;");


        //Botón de configuración
        Bconfig = new Button();
        Bconfig.setLayoutX(165);
        Bconfig.setLayoutY(13);
        Bconfig.setStyle("-fx-background-color: white;");
        Bconfig.setCursor(Cursor.HAND);

        FontAwesomeIconView BconfigIcon = new FontAwesomeIconView();
        BconfigIcon.setFill(Color.rgb(0, 0, 0));
        BconfigIcon.setGlyphName("GEAR");
        BconfigIcon.setSize("20");
        Bconfig.setGraphic(BconfigIcon);


        //Botón de encendido
        Bpower = new ToggleButton();
        Bpower.setLayoutX(200);
        Bpower.setLayoutY(13);
        Bpower.setStyle("-fx-background-color: white;");
        Bpower.setCursor(Cursor.HAND);

        FontAwesomeIconView BpowerIcon = new FontAwesomeIconView();
        BpowerIcon.setFill(Color.rgb(0, 0, 0));
        BpowerIcon.setGlyphName("POWER_OFF");
        BpowerIcon.setSize("20");
        
        FontAwesomeIconView BpowerIcon2 = new FontAwesomeIconView();
        BpowerIcon2.setFill(Color.rgb(255, 0, 0));
        BpowerIcon2.setGlyphName("POWER_OFF");
        BpowerIcon2.setSize("20");
        Bpower.setGraphic(BpowerIcon);
        
        Bpower.selectedProperty().addListener((obs,oldVal,newVal) -> {
            if(newVal){
               Bpower.setGraphic(BpowerIcon2); 
            }
            else{
               Bpower.setGraphic(BpowerIcon);
            }
        });


        Pane pane = new Pane();
        pane.setLayoutX(546);
        pane.setLayoutY(-10);
        pane.setPrefSize(253, 626);
        pane.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-radius: 10;");

        Pane Vmotor = new Pane();
        Vmotor.setLayoutX(18);
        Vmotor.setLayoutY(201);
        Vmotor.setPrefSize(215, 67);
        Vmotor.setStyle("-fx-background-color:  #331940; -fx-background-radius: 10; -fx-border-radius: 10;");

        Image VmotorI = new Image("Imagenes/VmotorI.png");
        ImageView VmotorImage = new ImageView();
        VmotorImage.setImage(VmotorI);
        VmotorImage.setLayoutX(10);
        VmotorImage.setLayoutY(15);
        VmotorImage.setFitWidth(40);
        VmotorImage.setFitHeight(35);

        Image VmotorI2 = new Image("Imagenes/VmotorI2.png");
        ImageView VmotorImage2 = new ImageView();
        VmotorImage2.setImage(VmotorI2);
        VmotorImage2.setLayoutX(165);
        VmotorImage2.setLayoutY(15);
        VmotorImage2.setFitWidth(40);
        VmotorImage2.setFitHeight(35);

        Smotor = new Slider();
        Smotor.setLayoutX(52);
        Smotor.setLayoutY(27);
        Smotor.setPrefSize(110, 10);
        Smotor.setCursor(Cursor.HAND);
        
        LSmotor = new Label(""+Smotor.getValue());
        LSmotor.setLayoutX(92);
        LSmotor.setLayoutY(10);
        LSmotor.setPrefSize(110, 10);
        LSmotor.setTextFill(Color.WHITE);
        

        Vmotor.getChildren().addAll(VmotorImage,VmotorImage2,Smotor,LSmotor);

        Pane Ctemp = new Pane();
        Ctemp.setLayoutX(18);
        Ctemp.setLayoutY(278);
        Ctemp.setPrefSize(215, 67);
        Ctemp.setStyle("-fx-background-color:  #ff5722; -fx-background-radius: 10; -fx-border-radius: 10;");

        Image CtempI = new Image("Imagenes/CtempI.png");
        ImageView CtempImage = new ImageView();
        CtempImage.setImage(CtempI);
        CtempImage.setLayoutX(10);
        CtempImage.setLayoutY(15);
        CtempImage.setFitWidth(40);
        CtempImage.setFitHeight(35);

        Image CtempI2 = new Image("Imagenes/CtempI2.png");
        ImageView CtempImage2 = new ImageView();
        CtempImage2.setImage(CtempI2);
        CtempImage2.setLayoutX(165);
        CtempImage2.setLayoutY(15);
        CtempImage2.setFitWidth(40);
        CtempImage2.setFitHeight(35);

        Stemp = new Slider();
        Stemp.setMax(400);
        Stemp.setLayoutX(52);
        Stemp.setLayoutY(27);
        Stemp.setPrefSize(110, 10);
        Stemp.setCursor(Cursor.HAND);
        
        LStemp = new Label(""+Smotor.getValue());
        LStemp.setLayoutX(92);
        LStemp.setLayoutY(10);
        LStemp.setPrefSize(110, 10);
        LStemp.setTextFill(Color.WHITE);

        Ctemp.getChildren().addAll(CtempImage,CtempImage2,Stemp,LStemp);
        
        
        Pane Vventilador = new Pane();
        Vventilador.setLayoutX(18);
        Vventilador.setLayoutY(357);
        Vventilador.setPrefSize(215, 67);
        Vventilador.setStyle("-fx-background-color:  #f9b248; -fx-background-radius: 10; -fx-border-radius: 10;");

        Image VventiladorI = new Image("Imagenes/Vventilador2.png");
        ImageView VventiladorImage = new ImageView();
        VventiladorImage.setImage(VventiladorI);
        VventiladorImage.setLayoutX(10);
        VventiladorImage.setLayoutY(15);
        VventiladorImage.setFitWidth(40);
        VventiladorImage.setFitHeight(35);

        Image VventiladorI2 = new Image("Imagenes/Vventilador.png");
        ImageView VventiladorI2Image2 = new ImageView();
        VventiladorI2Image2.setImage(VventiladorI2);
        VventiladorI2Image2.setLayoutX(165);
        VventiladorI2Image2.setLayoutY(15);
        VventiladorI2Image2.setFitWidth(40);
        VventiladorI2Image2.setFitHeight(35);

        SVventilador = new Slider();
        SVventilador.setLayoutX(52);
        SVventilador.setLayoutY(27);
        SVventilador.setPrefSize(110, 10);
        SVventilador.setCursor(Cursor.HAND);
        
        LSVventilador = new Label(""+Smotor.getValue());
        LSVventilador.setLayoutX(92);
        LSVventilador.setLayoutY(10);
        LSVventilador.setPrefSize(110, 10);
        LSVventilador.setTextFill(Color.WHITE);

        Vventilador.getChildren().addAll(VventiladorImage,VventiladorI2Image2,SVventilador,LSVventilador);

        pane.getChildren().addAll(Vmotor,Ctemp,Vventilador, Bnoti, Bconfig, Bpower,Lhora,separador);
        
        //Sector Central
        Pane Ptemp = new Pane();
        Ptemp.setLayoutX(108);
        Ptemp.setLayoutY(95);
        Ptemp.setPrefSize(173, 119);
        Ptemp.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-radius: 10;");
        
        label = new Label();
        label.setLayoutX(46);
        label.setLayoutY(20);
        label.setText("Temperatura");
        label.setFont(Font.font("Roboto Bold", 14));
        
        Ltemp = new Label();
        Ltemp.setLayoutX(40);
        Ltemp.setLayoutY(50);
        Ltemp.setPrefSize(75, 50);
        Ltemp.setText("");
        Ltemp.setFont(Font.font("Roboto Bold", 24));
        
        Ltemp2 = new Label();
        Ltemp2.setLayoutX(118);
        Ltemp2.setLayoutY(52);
        Ltemp2.setPrefSize(65, 42);
        Ltemp2.setText("°C");
        Ltemp2.setFont(Font.font("Roboto Bold", 24));
        
        Ptemp.getChildren().addAll(Ltemp,Ltemp2,label);

        Pane Ptiempo = new Pane();
        Ptiempo.setLayoutX(304);
        Ptiempo.setLayoutY(95);
        Ptiempo.setPrefSize(173, 119);
        Ptiempo.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-radius: 10;");
        
        Ltiempo = new Label();
        Ltiempo.setLayoutX(20);
        Ltiempo.setLayoutY(50);
        Ltiempo.setPrefSize(70, 42);
        Ltiempo.setText("");
        Ltiempo.setAlignment(Pos.CENTER_RIGHT);
        Ltiempo.setFont(Font.font("Roboto Bold", 24));
        
        Ltiempo2 = new Label();
        Ltiempo2.setLayoutX(95);
        Ltiempo2.setLayoutY(50);
        Ltiempo2.setPrefSize(65, 42);
        Ltiempo2.setText("s");
        Ltiempo2.setFont(Font.font("Roboto Bold", 24));
        
        label2 = new Label();
        label2.setLayoutX(46);
        label2.setLayoutY(20);
        label2.setText("Tiempo");
        label2.setFont(Font.font("Roboto Bold", 14));
        
        Ptiempo.getChildren().addAll(Ltiempo,Ltiempo2,label2);

        Menu = new Label();
        Menu.setText("Inicio");
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
        bienvenida.setText("Hola usuario, bienvenido de nuevo!");
        bienvenida.setLayoutX(182);
        bienvenida.setLayoutY(14);

        // Crear la grafica
        xAxis.setLabel("Tiempo");
        yAxis.setLabel("Temperatura");

        lineChart.setTitle("Temperatura vs Tiempo");

        lineChart.setLayoutX(108);
        lineChart.setLayoutY(222);
        lineChart.setPrefSize(420, 200);
        lineChart.setCreateSymbols(false);
        lineChart.setAnimated(false);
        lineChart.setHorizontalGridLinesVisible(false);
        lineChart.setVerticalGridLinesVisible(false);
        lineChart.setStyle("-fx-background-color: white;-fx-background-radius: 10");

        yAxis.setAnimated(false);
        yAxis.setAutoRanging(false);
        yAxis.setTickUnit(25);
        yAxis.setLowerBound(25);
        yAxis.setUpperBound(400);
        xAxis.setAnimated(false);
        xAxis.setAutoRanging(false);
        xAxis.setTickUnit(1);
        xAxis.setLowerBound(0);
        xAxis.setUpperBound(DATA_SERIES_SIZE - 1);
        lineChart.getData().add(dataSeries);
        
        CambioDePerfil = new ComboBox();
        CambioDePerfil.setLayoutX(440);
        CambioDePerfil.setLayoutY(10);
        CambioDePerfil.setPromptText("Perfiles");
        CambioDePerfil.setStyle("-fx-background-color: white;-fx-border-color: black;-fx-border-radius: 7;");
        
        
        CambioDePerfil.getItems().add(0,"Perfil 1");
        CambioDePerfil.getItems().add(1,"Perfil 2");
        CambioDePerfil.getItems().add(2,"Perfil 3");
        
        BCambioDePerfil = new Button();
        BCambioDePerfil.setLayoutX(450);
        BCambioDePerfil.setLayoutY(40);
        BCambioDePerfil.setPrefSize(65, 20);
        BCambioDePerfil.setText("Cambiar");
        BCambioDePerfil.setTextFill(Color.WHITE);
        BCambioDePerfil.setStyle("-fx-background-color: #005792;");
        BCambioDePerfil.setCursor(Cursor.HAND);
        
        

        anchorPane.getChildren().addAll(Ptiempo,Ptemp,bienvenida,Menu,separador2,CambioDePerfil, BCambioDePerfil);

        //Sector Izquierdo
        slideMenu = new AnchorPane();
        slideMenu.setStyle("-fx-background-color: #005792;");
        slideMenu.setPrefSize(141,440.0);
        slideMenu.setLayoutX(-124);
        slideMenu.setViewOrder(1);

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
        
        BLogin = new Button();
        BLogin.setLayoutX(6);
        BLogin.setLayoutY(373);
        BLogin.setPrefSize(30, 27);

        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setHeight(22.47);
        dropShadow1.setWidth(22.47);
        dropShadow1.setOffsetY(8);
        dropShadow1.setRadius(10.8675);
        dropShadow1.setColor(new Color(0, 0, 0, 0.2862595319747925));
        Ptemp.setEffect(dropShadow1);
        Ptiempo.setEffect(dropShadow1);
        lineChart.setEffect(dropShadow1);
        Vmotor.setEffect(dropShadow1);
        Ctemp.setEffect(dropShadow1);
        Vventilador.setEffect(dropShadow1);
        Pnotificaciones.setEffect(dropShadow1);

        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setHeight(22.47);
        dropShadow2.setOffsetY(8);
        dropShadow2.setColor(new Color(0, 0, 0, 0.2862595319747925));
        pane.setEffect(dropShadow2);

        FontAwesomeIconView fontAwesomeIconView1 = new FontAwesomeIconView();
        fontAwesomeIconView1.setFill(Color.rgb(0, 87, 146));
        fontAwesomeIconView1.setGlyphName("HOURGLASS");
        fontAwesomeIconView1.setSize("20");
        fontAwesomeIconView1.setLayoutX(22);
        fontAwesomeIconView1.setLayoutY(36);

        FontAwesomeIconView fontAwesomeIconView2 = new FontAwesomeIconView();
        fontAwesomeIconView2.setFill(Color.rgb(233, 72, 34));
        fontAwesomeIconView2.setGlyphName("THERMOMETER");
        fontAwesomeIconView2.setSize("30");
        fontAwesomeIconView2.setLayoutX(22);
        fontAwesomeIconView2.setLayoutY(40);
        

      
        Ptiempo.getChildren().addAll(fontAwesomeIconView1);
        Ptemp.getChildren().addAll(fontAwesomeIconView2);

        anchorPane.getChildren().addAll(menu,slideMenu, lineChart, pane,Pnotificaciones,BLogin);
    }
    

    public Label getLabel() {
        return label;
    }

    public Label getLabel2() {
        return label2;
    }
    
    public Label getBienvenida() {
        return bienvenida;
    }

    public Label getMenu() {
        return Menu;
    }

    public Label getLtemp() {
        return Ltemp;
    }

    public Label getLtemp2() {
        return Ltemp2;
    }

    public Label getLtiempo() {
        return Ltiempo;
    }

    public Label getLtiempo2() {
        return Ltiempo2;
    }

    public Label getLhora() {
        return Lhora;
    }
    
    public Label getLstemp(){
        return LStemp;
    }
    
    public Label getLsmotor(){
        return LSmotor;
    }
    
    public Label getLsVventilador(){
        return LSVventilador;
    }
    
    public ToggleButton getBnoti() {
        return Bnoti;
    }
    
    public FontAwesomeIconView getBnotiIcon() {
        return BnotiIcon;
    }
    
    public ImageView getBnotiI_2() {
        return BnotiI_2;
    }
    
    public ImageView getBnotiI() {
        return BnotiI;
    }
    
    public Pane getPnotificaciones() {
        return Pnotificaciones;
    }
    
    public Button getBconfig() {
        return Bconfig;
    }
    
    public Button getBLogin() {
        return BLogin;
    }
    
    public ToggleButton getBpower() {
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

    public Button getBinicio2() {
        return Binicio2;
    }

    public Button getBtabla2() {
        return Btabla2;
    }

    public Button getBgrafica2() {
        return Bgrafica2;
    }
    
    public Button getBajustes() {
        return Bajustes;
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
    
    public Button getBCambioDePerfil() {
        return BCambioDePerfil;
    }

    public ComboBox getCambioDePerfil() {
        return CambioDePerfil;
    }
    
    public AnchorPane getSlideMenu() {
        return slideMenu;
    }
    public AnchorPane getMenu2() {
        return menu;
    }
    public void setLhora(Label Lhora) {
        this.Lhora = Lhora;
    }
    
    public Slider sMotor(){
        return Smotor;
    }
    
    public Slider sTemp(){
        return Stemp;
    }
    
    public Slider sVventilador(){
        return SVventilador;
    }
    
    public XYChart.Series<Number, Number> getDataSeries() {
        return dataSeries;
    }
    
    public XYChart.Series<Number, Number> getDataSeries2() {
        return dataSeries2;
    }

    public XYChart.Series<Number, Number> getDataSeries3() {
        return dataSeries3;
    }

    public NumberAxis getxAxis() {
        return xAxis;
    }

    public NumberAxis getyAxis() {
        return yAxis;
    }
    public LineChart<Number, Number> getLineChart() {
        return lineChart;
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public Scene getEscenaPrincipal() {
        return escenaPrincipal;
    }
}
