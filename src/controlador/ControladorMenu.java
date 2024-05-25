package controlador;

import Modelo.CargarSecciones;
import Modelo.Medidas;
import Modelo.Notificaciones;
import com.sun.tools.javac.Main;
import java.awt.AWTException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import static measurementcontrol.ControlDeMedidas.mensaje;
import measurementcontrol.ControlDeMedidas;
import vista.EscenaGrafica;
import vista.EscenaTabla;
import vista.EscenaLogin;
import vista.EscenaRegistro;
import vista.MenuPrincipal;
import vista.EscenaPerfil;

public class ControladorMenu {
    
    ControlDeMedidas cM;
    MenuPrincipal menuPrincipal;
    EscenaTabla tabla;
    EscenaGrafica grafica;
    private Medidas medida;
    private CargarSecciones cargarSeccion;
    private Scene escenaPrincipal;
    private Scene escenaTabla;
    private Scene escenaGrafica;
    private Scene escenaAjustes;
    private Scene escenaPerfil;
    private Scene escenaLogin;
    private Scene escenaRegistro;
    private Thread hiloGrafica;
    int time = 0;
    int TempC= 0;
    int Cperfil= 0;
    private Thread serverThread;
    private AtomicReference<ConexionSocket> socketConnectionRef = new AtomicReference<>();
    static final int DATA_SERIES_SIZE = 10; // Número máximo de puntos en la serie de datos
    static final int MIN_Y_VALUE = 20;
    static  int MAX_Y_VALUE = 50;
    
    
    
    
    public ControladorMenu(MenuPrincipal menuPrincipal){
        this.menuPrincipal = menuPrincipal;         
    }


    
    public void eventoMenu(){
        
        Notificaciones notificacion = new Notificaciones();
        
        mensaje = "Asies";
        
        Timeline clockTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
	        updateClock();
	    }));
	clockTimeline.setCycleCount(Timeline.INDEFINITE);
	clockTimeline.play();
        
        ToggleButton Bnoti = menuPrincipal.getBnoti();
        Bnoti.setOnMouseEntered(event -> {
            Bnoti.setStyle("-fx-background-color: #dad9d9;");
        });
        Bnoti.setOnMouseExited(event -> {
            Bnoti.setStyle("-fx-background-color: white;");
        });
        
        Bnoti.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                Bnoti.setGraphic(menuPrincipal.getBnotiI());
                //menuPrincipal.getBnotiIcon().setFill(Color.rgb(255, 0, 0));
                Bnoti.setStyle("-fx-background-color: #dad9d9;");
                //menuPrincipal.getPnotificaciones().setLayoutY(1);
                
                TranslateTransition slide = new TranslateTransition();
                slide.setDuration(Duration.seconds(0.4));
                slide.setNode(menuPrincipal.getPnotificaciones());
                
                slide.setToY(200);
                slide.play();
                
                menuPrincipal.getPnotificaciones().setTranslateY(1);
                
                
            } 
            else {
                //menuPrincipal.getBnotiIcon().setFill(Color.rgb(0, 0, 0));
                //menuPrincipal.getPnotificaciones().setLayoutY(-200);
                Bnoti.setStyle("-fx-background-color: white;");
                TranslateTransition slide = new TranslateTransition();
                slide.setDuration(Duration.seconds(0.4));
                slide.setNode(menuPrincipal.getPnotificaciones());
                
                slide.setToY(-200);
                slide.play();
                
                menuPrincipal.getPnotificaciones().setTranslateY(-200);
            }
        });
        
        
        Button Bconfig = menuPrincipal.getBconfig();
        Bconfig.setOnMouseEntered(event -> {
                Bconfig.setStyle("-fx-background-color: #dad9d9;");
        });
        Bconfig.setOnMouseExited(event -> {
                Bconfig.setStyle("-fx-background-color: white;");
        });
        
        // Botón de encendido
        ToggleButton Bpower = menuPrincipal.getBpower();
        Bpower.setOnMouseEntered(event -> {
            Bpower.setStyle("-fx-background-color: #dad9d9;");
        });
        Bpower.setOnMouseExited(event -> {
            Bpower.setStyle("-fx-background-color: white;");
        });
        
        Bpower.setOnAction((t) -> {
            String packageData = "";
            if (socketConnectionRef != null && Bpower.isSelected()) {
                String key = "O";
                packageData = "ON";
                socketConnectionRef.get().sendPackage(packageData,key);
            }
            if (socketConnectionRef != null && !Bpower.isSelected()) {
                String key = "O";
                packageData = "OFF";
                socketConnectionRef.get().sendPackage(packageData,key);
            }
        });

        // Botón de inicio
        Button Binicio = menuPrincipal.getBinicio();
        // Botón de inicio en el menú deslizante
        Button Binicio2 = menuPrincipal.getBinicio2();
        
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

        // Botón de tabla
        Button Btabla = menuPrincipal.getBtabla();
        // Botón de tabla en el menú deslizante
        Button Btabla2 = menuPrincipal.getBtabla2();
        
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

        // Botón de gráfica
        Button Bgrafica = menuPrincipal.getBgrafica();
        // Botón de gráfica en el menú deslizante
        Button Bgrafica2 = menuPrincipal.getBgrafica2();
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
        
        Button Bajustes = menuPrincipal.getBajustes();
        Button Bajustes2 = menuPrincipal.getBajustes2();
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
        
        Button Bperfil = menuPrincipal.getBperfil();
        Button Bperfil2 = menuPrincipal.getBperfil2();
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
        
        Slider Smotor = menuPrincipal.sMotor();
        Label LSmotor = menuPrincipal.getLsmotor();
        Smotor.valueProperty().addListener((observable, oldValue, newValue) -> {
            int nuevoValor = newValue.intValue();
            LSmotor.setText("" + nuevoValor); // Actualiza el texto del Label cuando cambia el valor del Slider
            /*
            if (socketConnectionRef != null) {
                String key = "M";
                socketConnectionRef.get().sendPackage(String.valueOf("M"+nuevoValor),key);
            } else {
                System.out.println("Error: socketConnection es null");
            }
            */
            Smotor.setOnMouseReleased(event -> {
            String key = "M";
            socketConnectionRef.get().sendPackage(String.valueOf("M"+nuevoValor),key);
            });
        });
        
        Slider Stemp = menuPrincipal.sTemp();
        Label LStemp = menuPrincipal.getLstemp();
        Stemp.valueProperty().addListener((observable, oldValue, newValue) -> {
            int nuevoValor = newValue.intValue();
            LStemp.setText("" + nuevoValor); // Actualiza el texto del Label cuando cambia el valor del Slider
            if (socketConnectionRef != null) {
                String key = "C";
                socketConnectionRef.get().sendPackage(String.valueOf("C"+nuevoValor),key);
            } else {
                System.out.println("Error: socketConnection es null");
            }
        });
        
        Slider SVventilador = menuPrincipal.sVventilador();
        Label LSVventilador = menuPrincipal.getLsVventilador();
        SVventilador.valueProperty().addListener((observable, oldValue, newValue) -> {
            int nuevoValor = newValue.intValue();
            LSVventilador.setText("" + nuevoValor); // Actualiza el texto del Label cuando cambia el valor del Slider
            if (socketConnectionRef != null) {
                String key = "C";
                socketConnectionRef.get().sendPackage(String.valueOf("C"+nuevoValor),key);
            } else {
                System.out.println("Error: socketConnection es null");
            }
        });
                
                
                
                
        AnchorPane slideMenu = menuPrincipal.getSlideMenu();
        slideMenu.setOnMouseExited(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slideMenu);

            slide.setToX(0);
            slide.play();

            slideMenu.setTranslateX(61);
        });
        
        AnchorPane menu = menuPrincipal.getMenu2();
        menu.setOnMouseEntered(event -> {
                TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slideMenu);

            slide.setToX(61);
            slide.play();

            slideMenu.setTranslateX(0);
        });
        
        Bgrafica.setOnMousePressed(event -> {
            cambioDeEscena(getEscenaGrafica());
        });
        Btabla.setOnMousePressed(event -> {
            cambioDeEscena(getEscenaTabla());
        });
        
        Bgrafica2.setOnMousePressed(event -> {
            cambioDeEscena(getEscenaGrafica());
        });
        Btabla2.setOnMousePressed(event -> {
            
            cambioDeEscena(getEscenaTabla());
        });
        
        Bajustes.setOnMousePressed(event -> {
            cambioDeEscena(getEscenaAjustes());
        });
        Bajustes2.setOnMousePressed(event -> {
            cambioDeEscena(getEscenaAjustes());
        });
        
        Bperfil.setOnMousePressed(event -> {
            cambioDeEscena(getEscenaPerfil());
        });
        Bperfil2.setOnMousePressed(event -> {
            cambioDeEscena(getEscenaPerfil());
        });
        
        
        
        Button BLogin = menuPrincipal.getBLogin();
        BLogin.setOnMousePressed(event -> {
            cambioDeEscena(getEscenaLogin());
        });
        
        
        
        Button BCambioDePerfil  = menuPrincipal.getBCambioDePerfil();
        BCambioDePerfil.setOnMouseEntered(event -> {
	    	BCambioDePerfil.setStyle("-fx-background-color: #004781; -fx-background-radius: 3");
	});
        BCambioDePerfil.setOnMouseExited(event -> {
	    	BCambioDePerfil.setStyle("-fx-background-color: #005792; -fx-background-radius: 3");
	});
        
        ComboBox cambioPerfil = menuPrincipal.getCambioDePerfil();
        LineChart<Number, Number> lineChart = menuPrincipal.getLineChart();
        XYChart.Series<Number, Number> dataSeries = menuPrincipal.getDataSeries();
        XYChart.Series<Number, Number> dataSeries2 = menuPrincipal.getDataSeries2();
        XYChart.Series<Number, Number> dataSeries3 = menuPrincipal.getDataSeries3();
        
        cambioPerfil.setOnAction((t) -> {
            int index = cambioPerfil.getSelectionModel().getSelectedIndex();

            // Remover todas las series existentes del gráfico
            

            // Agregar las series correspondientes según el índice seleccionado
            if (index == 0) {
                lineChart.getData().clear();
                lineChart.getData().add(dataSeries);
            } else if (index == 1) {
                lineChart.getData().clear();
                lineChart.getData().add(dataSeries2);
            } else if (index == 2) {
                lineChart.getData().clear();
                lineChart.getData().add(dataSeries3);
            }
        });
        
        BCambioDePerfil.setOnMousePressed((t) -> {
            try {
                notificacion.mje();
            } catch (AWTException ex) {
                Logger.getLogger(ControlDeMedidas.class.getName()).log(Level.SEVERE, null, ex);
            }
            Bnoti.setGraphic(menuPrincipal.getBnotiI_2());
        });
       
        loadData();
        
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(this::updateData, 0, 1, TimeUnit.SECONDS);
    }
    
    public void updateClock() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        Date date = new Date();
        
        Label Lhora = menuPrincipal.getLhora();
        String formatedTime = timeFormat.format(date);
        Lhora.setText(formatedTime);
    }
    
    public void loadData() {

    	socketConnectionRef = new AtomicReference<>(cM.getSocketConnection());
    	
    	serverThread = new Thread(() -> {
	    	
	        while (true) {
	        socketConnectionRef.get().Data();
                String message = socketConnectionRef.get().getMsg();
	            if (message != null) {
	                String[] data = message.split(",");
	                final String temperatura = data[0];
	                final String tiempo = data[1];
	                
	                fill();
	               
	                Platform.runLater(() -> {
	                    menuPrincipal.getLtemp().setText(temperatura);
	                    menuPrincipal.getLtiempo().setText(tiempo);
	                });
                        
	            } else {
	            }
	            
	            try {
	                Thread.sleep(1);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    });
		
	    serverThread.setDaemon(true);
	    serverThread.start();
    }
    
    public void fill() {
        cargarSeccion = new CargarSecciones();
        medida = new Medidas();
        LocalDateTime fecha = medida.getFecha(); 
        String temp = menuPrincipal.getLtemp().getText();
        String tiempo = menuPrincipal.getLtiempo().getText();

        if (!temp.isEmpty() && !tiempo.isEmpty()) {
            try {
                medida.setTemperatura(Double.parseDouble(temp));
                medida.setTiempo(Double.parseDouble(tiempo));
                medida.setFecha(fecha);
                cargarSeccion.create(medida);
            } catch (NumberFormatException e) {
                e.printStackTrace(); 
            }
        } else {
            // Manejar el caso en que una de las cadenas está vacía
        }
    }
    
    private void updateData() {
        hiloGrafica= new Thread(() -> {
                XYChart.Series<Number, Number> dataSeries = menuPrincipal.getDataSeries();
                XYChart.Series<Number, Number> dataSeries2 = menuPrincipal.getDataSeries2();
                XYChart.Series<Number, Number> dataSeries3 = menuPrincipal.getDataSeries3();
                NumberAxis xAxis = menuPrincipal.getxAxis();
                NumberAxis yAxis = menuPrincipal.getyAxis();

                //double randomValue = MIN_Y_VALUE + Math.random() * (MAX_Y_VALUE - MIN_Y_VALUE);
                String vTemperatura = menuPrincipal.getLtemp().getText();
                String vTiempo= menuPrincipal.getLtiempo().getText();
                double randomValue2 = 50+MIN_Y_VALUE + Math.random() * (MAX_Y_VALUE - MIN_Y_VALUE);
                double randomValue3 = 100+MIN_Y_VALUE + Math.random() * (MAX_Y_VALUE - MIN_Y_VALUE);

                if (!vTemperatura.isEmpty()) {
                    try {
                        // Convertir la cadena de tiempo a un número
                        double temperatura = Double.parseDouble(vTemperatura);
                        double tiempo = Double.parseDouble(vTiempo);
                        // Actualizar los valores existentes en la serie
                        Platform.runLater(() -> {
                            // Agregar nuevo punto de datos
                            dataSeries.getData().add(new XYChart.Data<>(tiempo, temperatura));
                            dataSeries2.getData().add(new XYChart.Data<>(time, randomValue2));
                            dataSeries3.getData().add(new XYChart.Data<>(time, randomValue3));

                            // Eliminar el punto más antiguo si la serie supera el tamaño máximo permitido
                            if (dataSeries.getData().size() > DATA_SERIES_SIZE) {
                                dataSeries.getData().remove(0);
                            }
                            if (dataSeries2.getData().size() > DATA_SERIES_SIZE) {
                                dataSeries2.getData().remove(0);
                            }
                            if (dataSeries3.getData().size() > DATA_SERIES_SIZE) {
                                dataSeries3.getData().remove(0);
                            }

                            cambioPerfiles(temperatura);
                            //Ltemp.setText(String.valueOf(randomValue));



                            if(Cperfil == 0){
                                cambioPerfiles(temperatura);
                            }
                            if(Cperfil == 1){
                                cambioPerfiles(randomValue2);
                            }
                            if(Cperfil == 2){
                                cambioPerfiles(randomValue3);
                            }
                            // Actualizar valores del eje X para que se desplace de derecha a izquierda

                            xAxis.setLowerBound(tiempo - DATA_SERIES_SIZE + 1);
                            xAxis.setUpperBound(tiempo);
                            // Incrementar el tiempo
                            time++;
                        });
                    } catch (NumberFormatException e) {
                        // Manejar la excepción para la conversión, si es necesario
                        e.printStackTrace();
                    }
                } else {
                    // Manejar el caso donde la cadena de tiempo está vacía
                }
                // Actualizar los valores existentes en la serie
            });
            hiloGrafica.setDaemon(true);
            hiloGrafica.start();
    }
    
    private void cambioPerfiles(double rV){
        ComboBox cambioPerfil = menuPrincipal.getCambioDePerfil();
        Label Ltemp = menuPrincipal.getLtemp();
        int index = cambioPerfil.getSelectionModel().getSelectedIndex();
        
                switch (index) {
                    case 1 -> {
                        switch (TempC) {
                            case 0 -> Ltemp.setText(String.valueOf(rV));
                            case 1 -> {
                                double f = (rV*1.8)+32;
                                Ltemp.setText(String.valueOf(f));
                            }
                            case 2 -> {
                                double k = (rV+273.15);
                                Ltemp.setText(String.valueOf(k));
                            }
                            
                        }
                    }
                    case 2 -> {
                        switch (TempC) {
                            case 0 -> Ltemp.setText(String.valueOf(rV));
                            case 1 -> {
                                double f = (rV*1.8)+32;
                                Ltemp.setText(String.valueOf(f));
                            }
                            case 2 -> {
                                double k = (rV+273.15);
                                Ltemp.setText(String.valueOf(k));
                            }
                        }
                    }
                    default -> {
                        switch (TempC) {
                            case 0 -> Ltemp.setText(String.valueOf(rV));
                            case 1 -> {
                                double f = (rV*1.8)+32;
                                Ltemp.setText(String.valueOf(f));
                            }
                            case 2 -> {
                                double k = (rV+273.15);
                                Ltemp.setText(String.valueOf(k));
                            }
                        }
                    }
                }
    }
    
    public void escalasTemp(int a){
        Label Ltemp2 = menuPrincipal.getLtemp2();
        switch (a) {
            case 0 -> {
                Ltemp2.setText("°C");
                TempC = 0;
            }
            case 1 -> {
                Ltemp2.setText("°F");
            }
            case 2 -> {
                Ltemp2.setText("K");
                TempC = 2;
            }
            
        }
    }
    
    public void cambioIdiomas(int a){
        Button Binicio2 = menuPrincipal.getBinicio2();
        Button Btabla2 = menuPrincipal.getBtabla2();
        Button Bgrafica2 = menuPrincipal.getBgrafica2();
        Button Bajustes2 = menuPrincipal.getBajustes2(); 
        Label Menu = menuPrincipal.getMenu();
        Label bienvenida = menuPrincipal.getBienvenida();
        Label Ltemperatura = menuPrincipal.getLabel();
        Label Ltiempo1 = menuPrincipal.getLabel2();
        LineChart<Number, Number> lineChart = menuPrincipal.getLineChart();
        NumberAxis xAxis = menuPrincipal.getxAxis();
        NumberAxis yAxis = menuPrincipal.getyAxis();
        
        switch (a) {
            case 1 -> {
                Binicio2.setText("HOME");
                Btabla2.setText("TABLE");
                Bgrafica2.setText("CHART");
                Bajustes2.setText("SETTINGS");
                Menu.setText("Home");
                bienvenida.setText("Hello user, welcome back!");
                Ltemperatura.setText("Temperature");
                Ltiempo1.setText("Time");
                lineChart.setTitle("Temperature vs Time");
                xAxis.setLabel("Time");
                yAxis.setLabel("Temperature");
                
            }
            case 2 -> {
                Binicio2.setText("INÍCIO");
                Btabla2.setText("TABELA");
                Bgrafica2.setText("GRÁFICO");
                Bajustes2.setText("AJUSTES");
                Menu.setText("Início");
                bienvenida.setText("Olá utilizador, bem-vindo de volta!");
                Ltemperatura.setText("Temperatura");
                Ltiempo1.setText("Tempo");
                lineChart.setTitle("Temperatura vs Tempo");
                xAxis.setLabel("Tempo");
                yAxis.setLabel("Temperatura");
            }
            default -> {
                Binicio2.setText("INICIO");
                Btabla2.setText("TABLA");
                Bgrafica2.setText("GRAFICA");
                Bajustes2.setText("AJUSTES");
                Menu.setText("Inicio");
                bienvenida.setText("Hola usuario, bienvenido de nuevo!");
                Ltemperatura.setText("Temperatura");
                Ltiempo1.setText("Tiempo");
                lineChart.setTitle("Temperatura vs Tiempo");
                xAxis.setLabel("Tiempo");
                yAxis.setLabel("Temperatura");
            }
        }
    }
    
    public void cambioDeEscena(Scene scene) {
        // Implementa la lógica para cambiar a la vista de tabla
        if (escenaPrincipal != null) {
            menuPrincipal.getPrimaryStage().setScene(scene);
        }
    }
    
    public void inicializarEscenaTabla(Scene escenaTabla) {
        this.escenaTabla = escenaTabla;
    }
    
    public void inicializarEscenaPrincipal(Scene escenaPrincipal) {
        this.escenaPrincipal = escenaPrincipal;
    }
    
    public void inicializarEscenaGrafica(Scene escenaGrafica) {
        this.escenaGrafica = escenaGrafica;
    }
    
    public void inicializarEscenaAjustes(Scene escenaAjustes) {
        this.escenaAjustes = escenaAjustes;
    }
    
    public void inicializarEscenaPerfil(Scene escenaPerfil) {
        this.escenaPerfil = escenaPerfil;
    }
    
    public void inicializarEscenaLogin(Scene escenaLogin) {
        this.escenaLogin = escenaLogin;
    }
    
    public void inicializarEscenaRegistro(Scene escenaRegistro) {
        this.escenaRegistro = escenaRegistro;
    }
    
    public Scene getEscenaPrincipal() {
        return escenaPrincipal;
    }
    public Scene getEscenaTabla() {
        return escenaTabla;
    }
    public Scene getEscenaGrafica() {
        return escenaGrafica;
    }
    public Scene getEscenaAjustes() {
        return escenaAjustes;
    }
    public Scene getEscenaPerfil() {
        return escenaPerfil;
    }
    public Scene getEscenaLogin() {
        return escenaLogin;
    }
    public Scene getEscenaRegistro() {
        return escenaRegistro;
    }
    
    
    /*public Scene getEscenaGrafica() {
        return EscenaGrafica;
    }*/
}
