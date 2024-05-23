
package Modelo;

import java.time.LocalDateTime;


public class Registros {
    private String nombre;
    private String usuario;
    private String pin;
    private LocalDateTime fecha;

    public Registros(String nombre, String usuario, String pin,LocalDateTime fecha) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.pin = pin;
        this.fecha = fecha;
    }
    
    public Registros() {
        nombre = "";
        usuario = "";
        pin = "";
        fecha = LocalDateTime.now();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    
    public LocalDateTime getFecha() {
        return fecha;
    }


    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }	
    
}
