package vista;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class EscenaGrafica {
    private Scene escenaGrafica;
    private AnchorPane menu;
    private AnchorPane slideMenu;
    private AnchorPane anchorPane3;
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
    private Button Binicio;
    private Button Btabla;
    private Button Bgrafica;
    private Button Binicio2;
    private Button Btabla2;
    private Button Bgrafica2;
    private Button Bajustes2;
    
    static final int DATA_SERIES_SIZE = 10; // Número máximo de puntos en la serie de datos
    static final int MIN_Y_VALUE = 20;
    static  int MAX_Y_VALUE = 50;
    
    XYChart.Series<Number, Number> dataSeries = new XYChart.Series<>();
    int time = 0;
    private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();
    private LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

    public EscenaGrafica() {
        graficaGUI();
    }
    
    public void graficaGUI(){
        anchorPane3 = new AnchorPane(); // Elimina la declaración AnchorPane
        anchorPane3.setPrefSize(800, 440);
        anchorPane3.setStyle("-fx-background-color: white;-fx-background-radius: 10");
        escenaGrafica = new Scene(anchorPane3);
        
        slideMenu = new AnchorPane();
        menu = new AnchorPane();
        menu.setPrefSize(38.0,440.0);
        menu.setLayoutX(0);
        menu.setLayoutY(0);
        menu.setStyle("-fx-background-color: #005792;");
        
        //Botones Slidemenu
        Binicio2 = new Button();
        Binicio2.setLayoutX(100);
        Binicio2.setLayoutY(143);
        Binicio2.setPrefSize(55, 27);
        Binicio2.setText("INICIO");
        Binicio2.setTextFill(Color.WHITE);
        Binicio2.setStyle("-fx-background-color: #005792;");
        Binicio2.setCursor(Cursor.HAND);
        
        
        Btabla2 = new Button();
        Btabla2.setLayoutX(100);
        Btabla2.setLayoutY(203);
        Btabla2.setPrefSize(60, 28);
        Btabla2.setText("TABLA");
        Btabla2.setTextFill(Color.WHITE);
        Btabla2.setStyle("-fx-background-color: #005792;");
        Btabla2.setCursor(Cursor.HAND);
        
        
        Bgrafica2 = new Button();
        Bgrafica2.setLayoutX(95);
        Bgrafica2.setLayoutY(263);
        Bgrafica2.setText("GRAFICA");
        Bgrafica2.setPrefSize(65, 28);
        Bgrafica2.setTextFill(Color.WHITE);
        Bgrafica2.setStyle("-fx-background-color: #005792;");
        Bgrafica2.setCursor(Cursor.HAND);
        
        
        Bajustes2 = new Button();
        Bajustes2.setLayoutX(95);
        Bajustes2.setLayoutY(323);
        Bajustes2.setText("AJUSTES");
        Bajustes2.setPrefSize(70, 28);
        Bajustes2.setTextFill(Color.WHITE);
        Bajustes2.setStyle("-fx-background-color: #005792;");
        Bajustes2.setCursor(Cursor.HAND);
        
        
        slideMenu.getChildren().addAll(Binicio2,Btabla2, Bgrafica2, Bajustes2);
        
        
        //Botones menu
        Binicio = new Button();
        Binicio.setLayoutX(4.7);
        Binicio.setLayoutY(143);
        Binicio.setPrefSize(30, 27);
        Binicio.setStyle("-fx-background-color: #005792;");
        Binicio.setCursor(Cursor.HAND);
        
        FontAwesomeIconView BinicioIcon = new FontAwesomeIconView();
        BinicioIcon.setFill(Color.WHITE);
        BinicioIcon.setStyle("-fx-background-radius: 0;");
        BinicioIcon.setGlyphName("HOME");
        BinicioIcon.setSize("20");
        
        Binicio.setGraphic(BinicioIcon);
        
        
        Btabla = new Button();
        Btabla.setLayoutX(6);
        Btabla.setLayoutY(203);
        Btabla.setPrefSize(30, 27);
        Btabla.setStyle("-fx-background-color: #005792;");
        Btabla.setCursor(Cursor.HAND);
        
        FontAwesomeIconView BtablaIcon = new FontAwesomeIconView();
        BtablaIcon.setFill(Color.WHITE);
        BtablaIcon.setGlyphName("DATABASE");
        BtablaIcon.setSize("20");
        Btabla.setGraphic(BtablaIcon);
        
        
        Bgrafica = new Button();
        Bgrafica.setLayoutX(1);
        Bgrafica.setLayoutY(263);
        Bgrafica.setPrefSize(30, 27);
        Bgrafica.setStyle("-fx-background-color: #005792;");
        Bgrafica.setCursor(Cursor.HAND);
        
        FontAwesomeIconView BgraficaIcon = new FontAwesomeIconView();
        BgraficaIcon.setFill(Color.WHITE);
        BgraficaIcon.setGlyphName("LINE_CHART");
        BgraficaIcon.setSize("20");
        Bgrafica.setGraphic(BgraficaIcon);
        
        Bajustes = new Button();
        Bajustes.setLayoutX(6);
        Bajustes.setLayoutY(323);
        Bajustes.setPrefSize(30, 27);
        Bajustes.setStyle("-fx-background-color: #005792;");
        Bajustes.setCursor(Cursor.HAND);
        
        FontAwesomeIconView BajustesIcon = new FontAwesomeIconView();
        BajustesIcon.setFill(Color.WHITE);
        BajustesIcon.setGlyphName("GEAR");
        BajustesIcon.setSize("20");
        Bajustes.setGraphic(BajustesIcon);
        
        menu.getChildren().addAll(Binicio,Btabla, Bgrafica,Bajustes);
        
        
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
        
        // Crear la grafica
        xAxis.setLabel("Tiempo");
        yAxis.setLabel("Temperatura");
        
        lineChart.setTitle("Temperatura vs Tiempo");
       
        lineChart.setLayoutX(104);
        lineChart.setLayoutY(50);
        lineChart.setPrefSize(500, 200);
        lineChart.setCreateSymbols(false);
        lineChart.setAnimated(false);
        lineChart.setHorizontalGridLinesVisible(false);
        lineChart.setVerticalGridLinesVisible(false);
        lineChart.setStyle("-fx-background-color: white;-fx-background-radius: 10");
        
        yAxis.setAnimated(false);
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        xAxis.setAnimated(false);
        xAxis.setAutoRanging(false);
        xAxis.setTickUnit(1);
        xAxis.setLowerBound(0);
        xAxis.setUpperBound(DATA_SERIES_SIZE - 1);
        lineChart.getData().add(dataSeries);
        
        
        anchorPane3.getChildren().addAll(menu,slideMenu, lineChart,Lhora,separador,Bnoti,Bconfig,Bpower,separador2,bienvenida,Menu);
        
        
    }

    public AnchorPane getAnchorPane3() {
        return anchorPane3;
    }
    
    public Scene getEscenaGrafica() {
        return escenaGrafica;
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
    public XYChart.Series<Number, Number> getDataSeries() {
         return dataSeries;
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
}
