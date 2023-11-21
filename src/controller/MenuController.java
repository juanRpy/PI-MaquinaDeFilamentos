package controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import main.Main;
import model.LoadSections;
import model.Measures;

public class MenuController implements Initializable  {
	
	
	private Measures measure;
	private LoadSections loadSection;
	
	@FXML
    private Label temperatureLabel;

    @FXML
    private Label timeLabel;
    
    @FXML
    private Label clockLabel;
    
    @FXML
    private Button powerButton;
    
    @FXML
	private Button hButton;
    
	@FXML
	private Button hButton2;
	
	@FXML
	private Button tButton;

	@FXML
	private Button tButton2;
	
	@FXML
	private Button gButton;
    
	@FXML
	private Button gButton2;
	
	@FXML
	private AnchorPane menu;

	@FXML
	private LineChart<Number, Number> grafica;
	@FXML
	private AnchorPane slideMenu;
	
	@FXML
	private AnchorPane anchorPane;
	
	@FXML
    private NumberAxis xAxis;
	
    @FXML
    private NumberAxis yAxis;
	
    @FXML
    private LineChart<Number, Number> lineChart;

	private Thread serverThread;
    private AtomicReference<SocketConnection> socketConnectionRef = new AtomicReference<>();
    private static final int DATA_SERIES_SIZE = 10; // Número máximo de puntos en la serie de datos
    private static final int MIN_Y_VALUE = 20;
    private static final int MAX_Y_VALUE = 50;
    private XYChart.Series<Number, Number> dataSeries = new XYChart.Series<>();
    private int time = 0;
    
	


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	hButton.setOnMouseEntered(event -> {
	    	hButton.setStyle("-fx-background-color: #004781;");
	    	hButton2.setStyle("-fx-background-color: #004781;");
	    });

	    hButton.setOnMouseExited(event -> {
	    	hButton.setStyle("-fx-background-color: #005792;");
	    	hButton2.setStyle("-fx-background-color: #005792;");
	    });
	    hButton2.setOnMouseEntered(event -> {
	    	hButton.setStyle("-fx-background-color: #004781;");
	    	hButton2.setStyle("-fx-background-color: #004781;");
	    });

	    hButton2.setOnMouseExited(event -> {
	    	hButton.setStyle("-fx-background-color: #005792;");
	    	hButton2.setStyle("-fx-background-color: #005792;");
	    });
	    
	    tButton.setOnMouseEntered(event -> {
	    	tButton.setStyle("-fx-background-color: #004781;");
	    	tButton2.setStyle("-fx-background-color: #004781;");
	    });

	    tButton.setOnMouseExited(event -> {
	    	tButton.setStyle("-fx-background-color: #005792;");
	    	tButton2.setStyle("-fx-background-color: #005792;");
	    });
	    
	    tButton2.setOnMouseEntered(event -> {
	    	tButton.setStyle("-fx-background-color: #004781;");
	    	tButton2.setStyle("-fx-background-color: #004781;");
	    });

	    tButton2.setOnMouseExited(event -> {
	    	tButton.setStyle("-fx-background-color: #005792;");
	    	tButton2.setStyle("-fx-background-color: #005792;");
	    });
	    
	    gButton.setOnMouseEntered(event -> {
	    	gButton.setStyle("-fx-background-color: #004781;");
	    	gButton2.setStyle("-fx-background-color: #004781;");
	    });

	    gButton.setOnMouseExited(event -> {
	    	gButton.setStyle("-fx-background-color: #005792;");
	    	gButton2.setStyle("-fx-background-color: #005792;");
	    });
	    
	    gButton2.setOnMouseEntered(event -> {
	    	gButton.setStyle("-fx-background-color: #004781;");
	    	gButton2.setStyle("-fx-background-color: #004781;");
	    });

	    gButton2.setOnMouseExited(event -> {
	    	gButton.setStyle("-fx-background-color: #005792;");
	    	gButton2.setStyle("-fx-background-color: #005792;");
	    });
	    
	    
	    slideMenu.setOnMouseExited(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slideMenu);

            slide.setToX(0);
            slide.play();

            slideMenu.setTranslateX(81);

            
        });
	    
	    menu.setOnMouseEntered(event -> {
	    	TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slideMenu);

            slide.setToX(81);
            slide.play();

            slideMenu.setTranslateX(0);

            
	    });
	    
	    loadData();
	  
	    
	    Timeline clockTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
	        updateClock();
	    }));
	    clockTimeline.setCycleCount(Timeline.INDEFINITE);
	    clockTimeline.play();
	    
	    /*xAxis.setLowerBound(0);
        xAxis.setUpperBound(DATA_SERIES_SIZE - 1);
        lineChart.getData().add(dataSeries);

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(this::updateData, 0, 1, TimeUnit.SECONDS);*/
	    
	}
    
    
    public void loadData() {

    	socketConnectionRef = new AtomicReference<>(Main.getSocketConnection());
    	
    	serverThread = new Thread(() -> {
	    	
	    	powerButton.setOnAction(event -> {
                String packageData = "PULSO";
                socketConnectionRef.get().sendPackage(packageData);
            });
	    	
	        while (true) {
	        	socketConnectionRef.get().Data();
                String message = socketConnectionRef.get().getMsg();
	            if (message != null) {
	                String[] data = message.split(",");
	                final String temperature = data[0];
	                final String time = data[1];
	                
	                fill();
	                
	                Platform.runLater(() -> {
	                    temperatureLabel.setText(temperature);
	                    timeLabel.setText(time);
	                });
	            } else {
	            }
	            
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    });
		
	    serverThread.setDaemon(true);
	    serverThread.start();
    }
    
    
    public void fill() {
    	loadSection = new LoadSections();
    	measure = new Measures();
    	
		LocalDateTime date = measure.getDate_time(); 
		String temperature = temperatureLabel.getText();
		String time = timeLabel.getText();
		//double randomValue = 1 + Math.random() * (1 - 100);
		
		if (!temperature.isEmpty() && !time.isEmpty()) {
		    try {
		        measure.setTemperature(Double.parseDouble(temperature));
		        measure.setTimes(Double.parseDouble(time));
		        measure.setDate_time(date);
				
				loadSection.create(measure);
		    } catch (NumberFormatException e) {
		        e.printStackTrace(); 
		    }
		} else {
		    // Manejar el caso en que una de las cadenas está vacía
		}
		
			
		
	}
    
    public void updateClock() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        Date date = new Date();

        String formatedTime = timeFormat.format(date);
       clockLabel.setText(formatedTime);
    }
    
    /*private void updateData() {
        // Generar un valor aleatorio en el rango [MIN_Y_VALUE, MAX_Y_VALUE]
        double randomValue = MIN_Y_VALUE + Math.random() * (MAX_Y_VALUE - MIN_Y_VALUE);

    	//Double temperature = Double.parseDouble(temperatureLabel.getText()) ;
		//Double time = Double.parseDouble(timeLabel.getText());
        // Actualizar los valores existentes en la serie
        Platform.runLater(() -> {
            // Agregar nuevo punto de datos
            dataSeries.getData().add(new XYChart.Data<>(time, randomValue));

            // Eliminar el punto más antiguo si la serie supera el tamaño máximo permitido
            if (dataSeries.getData().size() > DATA_SERIES_SIZE) {
                dataSeries.getData().remove(0);
            }

            // Actualizar valores del eje X para que se desplace de derecha a izquierda

            xAxis.setLowerBound(time - DATA_SERIES_SIZE + 1);
            xAxis.setUpperBound(time);
            // Incrementar el tiempo
            time++;
        });
    }*/
    
	public void switchToTable (ActionEvent event) throws IOException {
		
		AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/application/TableScene.fxml"));
        anchorPane.getChildren().setAll(a);
		 
	   }
	
	public void switchToGraph (ActionEvent event) throws IOException {
		   AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/application/GraphScene.fxml"));
	       anchorPane.getChildren().setAll(a);
	   }
}
