module MeasurementControl {
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	
	//opens application to javafx.graphics, javafx.fxml;
	opens model to javafx.base, javafx.fxml;
	opens controller to javafx.fxml;
	exports main;
	exports controller;
	exports model;
	
}
