package controller;


import java.io.IOException;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javafx.util.Duration;
import model.LoadSections;
import model.Measures;


public class TableController implements Initializable{
	
	private Thread tableThread;
	
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
	private AnchorPane slideMenu;
	
	@FXML
	private AnchorPane anchorPane;
    
    @FXML
    private TableView<Measures> measurementTable;
    
    @FXML
    private TableColumn<Measures, Double> temperatureCol;
    
    @FXML
    private TableColumn<Measures, Double> timeCol;
    
    @FXML
    private TableColumn<Measures, Date> dateCol;
   
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
	    
	    loadColumn();
	    
	    /*Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> loadColumn()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();*/
   
	}
    
    private void loadColumn() {
        tableThread = new Thread(() -> {
        	temperatureCol.setCellValueFactory(new PropertyValueFactory<>("temperature"));
            timeCol.setCellValueFactory(new PropertyValueFactory<>("times"));
            dateCol.setCellValueFactory(new PropertyValueFactory<>("date_time"));

            // Cargar los datos desde la base de datos y agregarlos a la tabla
            LoadSections loadSections = new LoadSections();

            while (true) {  // Esto mantiene el hilo en ejecución continuamente
                ObservableList<Measures> data = loadSections.read();

                Platform.runLater(() -> {
                    measurementTable.setItems(data);
                });

                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        tableThread.setDaemon(true);
        tableThread.start();
    }

    
   public void switchToMenu (ActionEvent event) throws IOException {
	   AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/application/MenuScene.fxml"));
       anchorPane.getChildren().setAll(a);
   }
   
   public void switchToGraph (ActionEvent event) throws IOException {
	   AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/application/GraphScene.fxml"));
       anchorPane.getChildren().setAll(a);
   }
}
