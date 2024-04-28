package controlador;

import Modelo.CargarSecciones;
import Modelo.Medidas;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import vista.EscenaTabla;
import vista.MenuPrincipal;

public class ControladorTabla {
    
    EscenaTabla escenaTabla;
    ControladorMenu cMenu;
    private Thread tableThread;
    private Thread excelThread;
    
    public ControladorTabla(EscenaTabla escenaTabla, ControladorMenu cMenu){
        this.escenaTabla = escenaTabla;
        this.cMenu = cMenu;
    }
    
    public void eventoTabla(){
        
        AnchorPane slideMenu = escenaTabla.getSlideMenu();
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
        
        AnchorPane menu = escenaTabla.getMenuPane();
        menu.setOnMouseEntered(event -> {
	    	TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slideMenu);

            slide.setToX(61);
            slide.play();

            slideMenu.setTranslateX(0);
	});
        
        Button Binicio = escenaTabla.getBinicio();
        Button Binicio2 = escenaTabla.getBinicio2();
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
        
        Button Btabla = escenaTabla.getBtabla();
        Button Btabla2 = escenaTabla.getBtabla2();
        
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
        
        Button Bgrafica = escenaTabla.getBgrafica();
        Button Bgrafica2 = escenaTabla.getBgrafica2();
        
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
        
        Button Bajustes = escenaTabla.getBajustes();
        Button Bajustes2 = escenaTabla.getBajustes2();
        
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
        
        Button Bdescargar = escenaTabla.getBdescargar();
        Bdescargar.setOnAction((t) -> {
            exportToExcel();
        });
        
        
        /*Bdescargar.setOnMouseEntered(event -> {
	    TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slideMenu);

            slide.setToX(0);
            slide.play();

            Bdescargar.setTranslateX(20);
	});
	    
        Bdescargar.setOnMouseExited(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slideMenu);

            slide.setToX(20);
            slide.play();

            Bdescargar.setTranslateX(0);
        });*/
 
        Timeline clockTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            updateClock();
	}));
	clockTimeline.setCycleCount(Timeline.INDEFINITE);
        clockTimeline.play();
        
        Button Bnoti = escenaTabla.getBnoti();
        Bnoti.setOnMouseEntered(event -> {
	    	Bnoti.setStyle("-fx-background-color: #dad9d9;");
	});
        Bnoti.setOnMouseExited(event -> {
	    	Bnoti.setStyle("-fx-background-color: white;");
	});
        
        Button Bconfig = escenaTabla.getBconfig();
        Bconfig.setOnMouseEntered(event -> {
	    	Bconfig.setStyle("-fx-background-color: #dad9d9;");
	});
        Bconfig.setOnMouseExited(event -> {
	    	Bconfig.setStyle("-fx-background-color: white;");
	}); 
        
        Button Bpower = escenaTabla.getBpower();
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
        
        loadColumn();
        
    }
    
    private void loadColumn() {
        TableView<Medidas> TablaDeDatos = escenaTabla.getTablaDeDatos();
        TableColumn<Medidas, Double> temperatureCol = escenaTabla.getTemperatureCol();
        TableColumn<Medidas, Double> timeCol  = escenaTabla.getTimeCol();
        TableColumn<Medidas, Date> dateCol = escenaTabla.getDateCol();
        tableThread = new Thread(() -> {
            temperatureCol.setCellValueFactory(new PropertyValueFactory<>("temperatura"));
            timeCol.setCellValueFactory(new PropertyValueFactory<>("tiempo"));
            dateCol.setCellValueFactory(new PropertyValueFactory<>("fecha"));          // Cargar los datos desde la base de datos y agregarlos a la tabla
            CargarSecciones loadSections = new CargarSecciones();

            while (true) {  // Esto mantiene el hilo en ejecución continuamente
                ObservableList<Medidas> data = loadSections.read();

                Platform.runLater(() -> {
                    TablaDeDatos.setItems(data);
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
    
    public void exportToExcel() {
        TableView<Medidas> TablaDeDatos = escenaTabla.getTablaDeDatos();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar archivo");
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Archivos de Excel", "*.xls"));

        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try (FileOutputStream fileOut = new FileOutputStream(file)) {
                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("Mi hoja de trabajo 1");

                ObservableList<TableColumn<Medidas, ?>> columns = TablaDeDatos.getColumns();

                // Crear la primera fila con los encabezados
                HSSFRow headerRow = sheet.createRow(0);
                for (int i = 0; i < columns.size(); i++) {
                    headerRow.createCell(i).setCellValue(columns.get(i).getText());
                }

                // Obtener los datos de la tabla
                ObservableList<Medidas> data = TablaDeDatos.getItems();

                // Llenar el archivo Excel con los datos de la tabla
                for (int i = 0; i < data.size(); i++) {
                    HSSFRow row = sheet.createRow(i + 1);
                    row.createCell(0).setCellValue(data.get(i).getTemperatura());
                    row.createCell(1).setCellValue(data.get(i).getTiempo());
                    row.createCell(2).setCellValue(data.get(i).getFecha().toString());
                }

                workbook.write(fileOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void updateClock() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        Date date = new Date();
        
        Label Lhora = escenaTabla.getLhora();
        String formatedTime = timeFormat.format(date);
        Lhora.setText(formatedTime);
    }
    
    public void cambioIdiomas(int a){
        Button Binicio2 = escenaTabla.getBinicio2();
        Button Btabla2 = escenaTabla.getBtabla2();
        Button Bgrafica2 = escenaTabla.getBgrafica2();
        Button Bajustes2 = escenaTabla.getBajustes2(); 
        Label Menu = escenaTabla.getMenu();
        Label bienvenida = escenaTabla.getBienvenida();
        switch (a) {
            case 1 -> {
                Binicio2.setText("HOME");
                Btabla2.setText("TABLE");
                Bgrafica2.setText("CHART");
                Bajustes2.setText("SETTINGS");
                Menu.setText("Table");
                bienvenida.setText("Remember to save the data!");
                
            }
            case 2 -> {
                Binicio2.setText("INÍCIO");
                Btabla2.setText("TABELA");
                Bgrafica2.setText("GRÁFICO");
                Bajustes2.setText("AJUSTES");
                Menu.setText("Tabela");
                bienvenida.setText("Não se esqueça de guardar os dados!");
            }
            default -> {
                Binicio2.setText("INICIO");
                Btabla2.setText("TABLA");
                Bgrafica2.setText("GRAFICA");
                Bajustes2.setText("AJUSTES");
                Menu.setText("Tabla");
                bienvenida.setText("Recuerda guardar los datos!");
            }
        }
    }
    
    public AnchorPane getLayout() {
        return escenaTabla.getAnchorPane2();
    }
    
}
