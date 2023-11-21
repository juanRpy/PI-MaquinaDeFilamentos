package main;

import controller.SocketConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.LoadSections;

public class Main extends Application {
	
	private static SocketConnection socketConnection;
	private LoadSections loadSection;
	
	@Override
	public void start(Stage Stage) throws Exception {
		socketConnection = new SocketConnection();
		loadSection = new LoadSections();
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        @Override
	        public void run() {
	        	loadSection.delate();
	        }
	    }));
		
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/MenuScene.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage.setScene(scene);
        Stage.setTitle("Measurement Control");
        Stage.show();
        
    }
	
	@Override
    public void stop() throws Exception {
        socketConnection.stop();
    }

	public static SocketConnection getSocketConnection() {
        return socketConnection;
    }
	
	
    public static void main(String[] args) {
        launch(args);
        
    }
    
    
    
}
