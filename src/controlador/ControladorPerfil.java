package controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import vista.EscenaPerfil;

public class ControladorPerfil {

    ControladorMenu cMenu;
    EscenaPerfil escenaPerfil;
    
    public ControladorPerfil(EscenaPerfil escenaPerfil, ControladorMenu cMenu) {
        this.escenaPerfil = escenaPerfil;
        this.cMenu = cMenu;
    }
    
    
    public void eventoPerfil(){
        
        AnchorPane slideMenu = escenaPerfil.getSlideMenu();
        slideMenu.setStyle("-fx-background-color: #005792;");
        slideMenu.setPrefSize(141,440.0);
        slideMenu.setLayoutX(-124);
        slideMenu.setOnMouseExited(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slideMenu);

            slide.setToX(0);
            slide.play();

            slideMenu.setTranslateX(61);
            
            
        });
        
        slideMenu.setViewOrder(1);
        
        AnchorPane menu = escenaPerfil.getMenuPane();
        menu.setOnMouseEntered(event -> {
	    	TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slideMenu);

            slide.setToX(61);
            slide.play();

            slideMenu.setTranslateX(0);
	});
        
        Button Binicio = escenaPerfil.getBinicio();
        Button Binicio2 = escenaPerfil.getBinicio2();
        Binicio.setOnMouseEntered(event -> {
	    	Binicio.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	    	Binicio2.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	});
        Binicio.setOnMouseExited(event -> {
	    	Binicio.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	    	Binicio2.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	});
        Binicio2.setOnMouseEntered(event -> {
	    	Binicio.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	    	Binicio2.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	});
        Binicio2.setOnMouseExited(event -> {
	    	Binicio.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	    	Binicio2.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	});
        
        Button Btabla = escenaPerfil.getBtabla();
        Button Btabla2 = escenaPerfil.getBtabla2();
        
        Btabla.setOnMouseEntered(event -> {
	    	Btabla.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	    	Btabla2.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	});
        Btabla.setOnMouseExited(event -> {
	    	Btabla.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	    	Btabla2.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	});
        Btabla2.setOnMouseEntered(event -> {
	    	Btabla.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	    	Btabla2.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	});
        Btabla2.setOnMouseExited(event -> {
	    	Btabla.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	    	Btabla2.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	});
        
        Button Bgrafica = escenaPerfil.getBgrafica();
        Button Bgrafica2 = escenaPerfil.getBgrafica2();
        
        Bgrafica.setOnMouseEntered(event -> {
	    	Bgrafica.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	    	Bgrafica2.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	});
        Bgrafica.setOnMouseExited(event -> {
	    	Bgrafica.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	    	Bgrafica2.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	});
        Bgrafica2.setOnMouseEntered(event -> {
	    	Bgrafica.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	    	Bgrafica2.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	});
        Bgrafica2.setOnMouseExited(event -> {
	    	Bgrafica.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	    	Bgrafica2.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	});
        
        Button Bajustes = escenaPerfil.getBajustes();
        Button Bajustes2 = escenaPerfil.getBajustes2();
        
        Bajustes.setOnMouseEntered(event -> {
	    	Bajustes.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	    	Bajustes2.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	});
        Bajustes.setOnMouseExited(event -> {
	    	Bajustes.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	    	Bajustes2.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	});
        Bajustes2.setOnMouseEntered(event -> {
	    	Bajustes.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	    	Bajustes2.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	});
        Bajustes2.setOnMouseExited(event -> {
	    	Bajustes.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	    	Bajustes2.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	});
        

 
        Timeline clockTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            updateClock();
	}));
	clockTimeline.setCycleCount(Timeline.INDEFINITE);
        clockTimeline.play();
        
        Button Bnoti = escenaPerfil.getBnoti();
        Bnoti.setOnMouseEntered(event -> {
	    	Bnoti.setStyle("-fx-background-color: #dad9d9;");
	});
        Bnoti.setOnMouseExited(event -> {
	    	Bnoti.setStyle("-fx-background-color: white;");
	});
        
        Button Bconfig = escenaPerfil.getBconfig();
        Bconfig.setOnMouseEntered(event -> {
	    	Bconfig.setStyle("-fx-background-color: #dad9d9;");
	});
        Bconfig.setOnMouseExited(event -> {
	    	Bconfig.setStyle("-fx-background-color: white;");
	}); 
        
        Button Bpower = escenaPerfil.getBpower();
        Bpower.setOnMouseEntered(event -> {
	    	Bpower.setStyle("-fx-background-color: #dad9d9;");
	});
        Bpower.setOnMouseExited(event -> {
	    	Bpower.setStyle("-fx-background-color: white;");
	});
        
        //Cambios de Escenas
        Binicio.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaPrincipal());
        });
        Binicio2.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaPrincipal());
        });
        
        Btabla.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaTabla());
        });
        
        Btabla2.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaTabla());
        });
        
        Bgrafica.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaGrafica());
        });
        Bgrafica2.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaGrafica());
        });
        
        Bajustes.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaAjustes());
        });
        Bajustes2.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaAjustes());
        });
        
    }
    public void updateClock() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        Date date = new Date();
        
        Label Lhora = escenaPerfil.getLhora();
        String formatedTime = timeFormat.format(date);
        Lhora.setText(formatedTime);
    }
    
    public void cambioIdiomas(int a){
        
        Button Binicio2 = escenaPerfil.getBinicio2();
        Button Btabla2 = escenaPerfil.getBtabla2();
        Button Bgrafica2 = escenaPerfil.getBgrafica2();
        Button Bajustes2 = escenaPerfil.getBajustes2(); 
        Label Menu = escenaPerfil.getMenu();
        Label bienvenida = escenaPerfil.getBienvenida();
        
        switch (a) {
            case 1 -> {
                Binicio2.setText("HOME");
                Btabla2.setText("TABLE");
                Bgrafica2.setText("CHART");
                Bajustes2.setText("SETTINGS");
                Menu.setText("Chart");
                bienvenida.setText("Observe their behavior.");
            }
            case 2 -> {
                Binicio2.setText("INÍCIO");
                Btabla2.setText("TABELA");
                Bgrafica2.setText("GRÁFICO");
                Bajustes2.setText("AJUSTES");
                Menu.setText("Gráfico");
                bienvenida.setText("Observar o seu comportamento.");
            }
            default -> {
                Binicio2.setText("INICIO");
                Btabla2.setText("TABLA");
                Bgrafica2.setText("GRAFICA");
                Bajustes2.setText("AJUSTES");
                Menu.setText("Grafica");
                bienvenida.setText("Observa su comportamiento.");
            }
        }
    }
}
