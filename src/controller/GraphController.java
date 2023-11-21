package controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class GraphController implements Initializable {
	
		

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
		
	}
	
	
	public void switchToMenu (ActionEvent event) throws IOException {
		   AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/application/MenuScene.fxml"));
	       anchorPane.getChildren().setAll(a);
	   }

	public void switchToTable (ActionEvent event) throws IOException {
		AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/application/TableScene.fxml"));
        anchorPane.getChildren().setAll(a);
		 
	   }
	
    
}