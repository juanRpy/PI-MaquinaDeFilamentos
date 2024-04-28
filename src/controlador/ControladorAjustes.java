package controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import vista.EscenaAjustes;


public class ControladorAjustes {
    
    ControladorMenu cMenu;
    ControladorTabla cTabla;
    ControladorGrafica cGrafica;
    EscenaAjustes escenaAjustes;
    
    
    public ControladorAjustes(EscenaAjustes escenaAjustes,ControladorMenu cMenu, ControladorTabla cTabla, ControladorGrafica cGrafica){
        this.escenaAjustes = escenaAjustes;
        this.cMenu = cMenu;
        this.cTabla = cTabla;
        this.cGrafica = cGrafica;
    }
    
    public void eventoAjustes(){
        
        AnchorPane slideMenu = escenaAjustes.getSlideMenu();
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
        
        AnchorPane menu = escenaAjustes.getMenuPane();
        menu.setOnMouseEntered(event -> {
	    	TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slideMenu);

            slide.setToX(61);
            slide.play();

            slideMenu.setTranslateX(0);
	});
        
        Button Binicio = escenaAjustes.getBinicio();
        Button Binicio2 = escenaAjustes.getBinicio2();
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
        
        Button Btabla = escenaAjustes.getBtabla();
        Button Btabla2 = escenaAjustes.getBtabla2();
        
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
        
        Button Bgrafica = escenaAjustes.getBgrafica();
        Button Bgrafica2 = escenaAjustes.getBgrafica2();
        
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
        
        Button Bajustes = escenaAjustes.getBajustes();
        Button Bajustes2 = escenaAjustes.getBajustes2();
        
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
        
        Button Bnoti = escenaAjustes.getBnoti();
        Bnoti.setOnMouseEntered(event -> {
	    	Bnoti.setStyle("-fx-background-color: #dad9d9;");
	});
        Bnoti.setOnMouseExited(event -> {
	    	Bnoti.setStyle("-fx-background-color: white;");
	});
        
        Button Bconfig = escenaAjustes.getBconfig();
        Bconfig.setOnMouseEntered(event -> {
	    	Bconfig.setStyle("-fx-background-color: #dad9d9;");
	});
        Bconfig.setOnMouseExited(event -> {
	    	Bconfig.setStyle("-fx-background-color: white;");
	}); 
        
        Button Bpower = escenaAjustes.getBpower();
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
        
        Button BGuardarAjustes = escenaAjustes.getBGuardarAjustes();
        BGuardarAjustes.setOnMouseEntered(event -> {
	    	BGuardarAjustes.setStyle("-fx-background-color: #004781; -fx-background-radius: 3");
	});
        BGuardarAjustes.setOnMouseExited(event -> {
	    	BGuardarAjustes.setStyle("-fx-background-color: #005792; -fx-background-radius: 3");
	});
        
        BGuardarAjustes.setOnMousePressed(event -> {
            escalasTemp();
            cambioIdioma();
        });
        modoNoche();
    }
    
    public void updateClock() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        Date date = new Date();
        
        Label Lhora = escenaAjustes.getLhora();
        String formatedTime = timeFormat.format(date);
        Lhora.setText(formatedTime);
    }
    
    private void escalasTemp(){
        
        ComboBox escalaTemp = escenaAjustes.getEscalaTemp();
        int index = escalaTemp.getSelectionModel().getSelectedIndex();
        switch (index) {
            case 0 -> cMenu.escalasTemp(0);
            case 1 -> cMenu.escalasTemp(1);
            case 2 -> cMenu.escalasTemp(2);
            
        }
        
    }
    private void cambioIdioma(){
        ComboBox cambioIdiomas = escenaAjustes.getCambioIdiomas();
        Button Binicio2 = escenaAjustes.getBinicio2();
        Button Btabla2 = escenaAjustes.getBtabla2();
        Button Bgrafica2 = escenaAjustes.getBgrafica2();
        Button Bajustes2 = escenaAjustes.getBajustes2(); 
        Label Menu = escenaAjustes.getMenu();
        Label bienvenida = escenaAjustes.getBienvenida();
        Label LEscalaTemp = escenaAjustes.getLEscalaTemp();
        Label LCambioIdiomas = escenaAjustes.getLCambioIdiomas();
        Label LModoNoche = escenaAjustes.getLModoNoche();
        
        int index = cambioIdiomas.getSelectionModel().getSelectedIndex();
        switch (index) {
            case 1 -> {
                Binicio2.setText("HOME");
                Btabla2.setText("TABLE");
                Bgrafica2.setText("CHART");
                Bajustes2.setText("SETTINGS");
                Menu.setText("Settings");
                bienvenida.setText("What do you want to change?");
                LEscalaTemp.setText("Temperature scales");
                LCambioIdiomas.setText("Change language");
                LModoNoche.setText("Night mode");
                cMenu.cambioIdiomas(1);
                cTabla.cambioIdiomas(1);
                cGrafica.cambioIdiomas(1);
            }
            case 2 -> {
                Binicio2.setText("INÍCIO");
                Btabla2.setText("TABELA");
                Bgrafica2.setText("GRÁFICO");
                Bajustes2.setText("AJUSTES");
                Menu.setText("Ajustes");
                bienvenida.setText("O que é que quer mudar?");
                LEscalaTemp.setText("Escalas de temperatura");
                LCambioIdiomas.setText("Alterar a língua");
                LModoNoche.setText("Modo noturno");
                cMenu.cambioIdiomas(2);
                cTabla.cambioIdiomas(2);
                cGrafica.cambioIdiomas(2);
            }
            default -> {
                Binicio2.setText("INICIO");
                Btabla2.setText("TABLA");
                Bgrafica2.setText("GRAFICA");
                Bajustes2.setText("AJUSTES");
                Menu.setText("Ajustes");
                bienvenida.setText("¿Que quieres cambiar?");
                LEscalaTemp.setText("Escalas de temperatura");
                LCambioIdiomas.setText("Cambiar idioma");
                LModoNoche.setText("Modo noche");
                cMenu.cambioIdiomas(3);
                cTabla.cambioIdiomas(2);
                cGrafica.cambioIdiomas(2);
            }
        }
        
    }
    
    private void modoNoche(){
        escenaAjustes.getModoNoche().selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                escenaAjustes.getanchorPane4().setStyle("-fx-background-color: #111111;");
                escenaAjustes.getmenu().setStyle("-fx-background-color: #1F1F1F;");
                escenaAjustes.getslideMenu().setStyle("-fx-background-color: #1F1F1F;");
                escenaAjustes.getBinicio().setStyle("-fx-background-color: #1F1F1F;");
                escenaAjustes.getBtabla().setStyle("-fx-background-color: #1F1F1F;");
                escenaAjustes.getBgrafica().setStyle("-fx-background-color: #1F1F1F;");
                escenaAjustes.getBajustes().setStyle("-fx-background-color: #1F1F1F;");
                escenaAjustes.getBinicio2().setStyle("-fx-background-color: #1F1F1F;");
                escenaAjustes.getBtabla2().setStyle("-fx-background-color: #1F1F1F;");
                escenaAjustes.getBgrafica2().setStyle("-fx-background-color: #1F1F1F;");
                escenaAjustes.getBajustes2().setStyle("-fx-background-color: #1F1F1F;");
                escenaAjustes.getLModoNoche().setTextFill(Color.WHITE);
                escenaAjustes.getbienvenida().setTextFill(Color.WHITE);
                escenaAjustes.getLhora().setTextFill(Color.WHITE);
                escenaAjustes.getLEscalaTemp().setTextFill(Color.WHITE);
                escenaAjustes.getLCambioIdiomas().setTextFill(Color.WHITE);
                /*
                
                
                
                main.ModoNoche(true);
                */
                
            } 
            else {
                escenaAjustes.getanchorPane4().setStyle("-fx-background-color: white;");
                escenaAjustes.getmenu().setStyle("-fx-background-color: #005792;");
                escenaAjustes.getslideMenu().setStyle("-fx-background-color: #005792;");
                escenaAjustes.getBinicio().setStyle("-fx-background-color: #005792;");
                escenaAjustes.getBtabla().setStyle("-fx-background-color: #005792;");
                escenaAjustes.getBgrafica().setStyle("-fx-background-color: #005792;");
                escenaAjustes.getBajustes().setStyle("-fx-background-color: #005792;");
                escenaAjustes.getBinicio2().setStyle("-fx-background-color: #005792;");
                escenaAjustes.getBtabla2().setStyle("-fx-background-color: #005792;");
                escenaAjustes.getBgrafica2().setStyle("-fx-background-color: #005792;");
                escenaAjustes.getBajustes2().setStyle("-fx-background-color: #005792;");
                escenaAjustes.getLModoNoche().setTextFill(Color.BLACK);
                escenaAjustes.getbienvenida().setTextFill(Color.BLACK);
                escenaAjustes.getLhora().setTextFill(Color.BLACK);
                escenaAjustes.getLEscalaTemp().setTextFill(Color.BLACK);
                escenaAjustes.getLCambioIdiomas().setTextFill(Color.BLACK);
                /*
                LModoNoche.setTextFill(Color.BLACK);
                bienvenida.setTextFill(Color.BLACK);
                Menu.setTextFill(Color.rgb(0, 87, 145));
                Lhora.setTextFill(Color.BLACK);
                LEscalaTemp.setTextFill(Color.BLACK);
                LCambioIdiomas.setTextFill(Color.BLACK);
                
                main.ModoNoche(false);
                */
            }
        });
    }
    
}
