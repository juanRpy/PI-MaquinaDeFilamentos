package Modelo;

import java.time.LocalDateTime;

public class Medidas {
    private int id;
    private Double temperatura;
    private Double tiempo;
    private LocalDateTime fecha;

    public Medidas(Double temperatura, Double tiempo, LocalDateTime fecha) {
        this.temperatura = temperatura;
        this.tiempo = tiempo;
        this.fecha = fecha;
    }

    public Medidas() {
        temperatura = 0.0;
        tiempo = 0.0;
        fecha = LocalDateTime.now();

    }

    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getTemperatura() {
        return temperatura;
    }


    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura ;
    }


    public Double getTiempo() {
        return tiempo;
    }


    public void setTiempo(Double tiempo) {
        this.tiempo = tiempo;
    }


    public LocalDateTime getFecha() {
        return fecha;
    }


    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }		
}
