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
import vista.EscenaGrafica;

public class ControladorGrafica {

    ControladorMenu cMenu;
    EscenaGrafica escenaGrafica;
    
    static final int DATA_SERIES_SIZE = 10; // Número máximo de puntos en la serie de datos
    static final int MIN_Y_VALUE = 340;
    static  int MAX_Y_VALUE = 360;
    int time = 0;
    
    public ControladorGrafica(EscenaGrafica escenaGrafica, ControladorMenu cMenu) {
        this.escenaGrafica = escenaGrafica;
        this.cMenu = cMenu;
    }
    
    
    public void eventoGrafica(){
        
        AnchorPane slideMenu = escenaGrafica.getSlideMenu();
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
        
        AnchorPane menu = escenaGrafica.getMenuPane();
        menu.setOnMouseEntered(event -> {
	    	TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slideMenu);

            slide.setToX(61);
            slide.play();

            slideMenu.setTranslateX(0);
	});
        
        Button Binicio = escenaGrafica.getBinicio();
        Button Binicio2 = escenaGrafica.getBinicio2();
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
        
        Button Btabla = escenaGrafica.getBtabla();
        Button Btabla2 = escenaGrafica.getBtabla2();
        
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
        
        Button Bgrafica = escenaGrafica.getBgrafica();
        Button Bgrafica2 = escenaGrafica.getBgrafica2();
        
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
        
        Button Bajustes = escenaGrafica.getBajustes();
        Button Bajustes2 = escenaGrafica.getBajustes2();
        
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
        
        Button Bperfil = escenaGrafica.getBperfil();
        Button Bperfil2 = escenaGrafica.getBperfil2();
        Bperfil.setOnMouseEntered(event -> {
            Bperfil.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
            Bperfil2.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	});
        Bperfil.setOnMouseExited(event -> {
            Bperfil.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
            Bperfil2.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	});
        Bperfil2.setOnMouseEntered(event -> {
            Bperfil.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
            Bperfil2.setStyle("-fx-background-color: #004781; -fx-background-radius: 0");
	});
        Bperfil2.setOnMouseExited(event -> {
            Bperfil.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
            Bperfil2.setStyle("-fx-background-color: #005792; -fx-background-radius: 0");
	});

 
        Timeline clockTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            updateClock();
	}));
	clockTimeline.setCycleCount(Timeline.INDEFINITE);
        clockTimeline.play();
        
        Button Bnoti = escenaGrafica.getBnoti();
        Bnoti.setOnMouseEntered(event -> {
	    	Bnoti.setStyle("-fx-background-color: #dad9d9;");
	});
        Bnoti.setOnMouseExited(event -> {
	    	Bnoti.setStyle("-fx-background-color: white;");
	});
        
        Button Bconfig = escenaGrafica.getBconfig();
        Bconfig.setOnMouseEntered(event -> {
	    	Bconfig.setStyle("-fx-background-color: #dad9d9;");
	});
        Bconfig.setOnMouseExited(event -> {
	    	Bconfig.setStyle("-fx-background-color: white;");
	}); 
        
        Button Bpower = escenaGrafica.getBpower();
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
        
        Bajustes.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaAjustes());
        });
        Bajustes2.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaAjustes());
        });
        
        Bperfil.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaPerfil());
        });
        Bperfil2.setOnMousePressed(event -> {
            cMenu.cambioDeEscena(cMenu.getEscenaPerfil());
        });
        
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(this::updateData, 0, 1, TimeUnit.SECONDS);
        
    }
    
    private void updateData() {
        
        XYChart.Series<Number, Number> dataSeries = escenaGrafica.getDataSeries();
        NumberAxis xAxis = escenaGrafica.getxAxis();
        NumberAxis yAxis = escenaGrafica.getyAxis();
        // Generar un valor aleatorio en el rango [MIN_Y_VALUE, MAX_Y_VALUE]
        double randomValue = MIN_Y_VALUE + Math.random() * (MAX_Y_VALUE - MIN_Y_VALUE);

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
    }
    public void updateClock() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        Date date = new Date();
        
        Label Lhora = escenaGrafica.getLhora();
        String formatedTime = timeFormat.format(date);
        Lhora.setText(formatedTime);
    }
    
    public void cambioIdiomas(int a){
        
        Button Binicio2 = escenaGrafica.getBinicio2();
        Button Btabla2 = escenaGrafica.getBtabla2();
        Button Bgrafica2 = escenaGrafica.getBgrafica2();
        Button Bajustes2 = escenaGrafica.getBajustes2(); 
        Label Menu = escenaGrafica.getMenu();
        Label bienvenida = escenaGrafica.getBienvenida();
        LineChart<Number, Number> lineChart = escenaGrafica.getLineChart();
        NumberAxis xAxis = escenaGrafica.getxAxis();
        NumberAxis yAxis = escenaGrafica.getyAxis();
        
        switch (a) {
            case 1 -> {
                Binicio2.setText("HOME");
                Btabla2.setText("TABLE");
                Bgrafica2.setText("CHART");
                Bajustes2.setText("SETTINGS");
                Menu.setText("Chart");
                bienvenida.setText("Observe their behavior.");
                lineChart.setTitle("Temperature vs Time");
                xAxis.setLabel("Time");
                yAxis.setLabel("Temperature");
            }
            case 2 -> {
                Binicio2.setText("INÍCIO");
                Btabla2.setText("TABELA");
                Bgrafica2.setText("GRÁFICO");
                Bajustes2.setText("AJUSTES");
                Menu.setText("Gráfico");
                bienvenida.setText("Observar o seu comportamento.");
                lineChart.setTitle("Temperatura vs Tempo");
                xAxis.setLabel("Tempo");
                yAxis.setLabel("Temperatura");
            }
            default -> {
                Binicio2.setText("INICIO");
                Btabla2.setText("TABLA");
                Bgrafica2.setText("GRAFICA");
                Bajustes2.setText("AJUSTES");
                Menu.setText("Grafica");
                bienvenida.setText("Observa su comportamiento.");
                lineChart.setTitle("Temperatura vs Tiempo");
                xAxis.setLabel("Tiempo");
                yAxis.setLabel("Temperatura");
            }
        }
    }
}
