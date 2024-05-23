package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vista.EscenaRegistro;

public class CargarRegistros {
    ConexionBaseDeDatos conexion;
	
    public CargarRegistros() {
        conexion = new ConexionBaseDeDatos();
    }

    public boolean crear(Registros registro) {
        PreparedStatement myStatament= null;

        Connection accessBBDD = conexion.getConexion();

        String sql = "INSERT INTO registros (nombre, usuario, pin, fecha) VALUES (?,?,?,?)";

        try {  

                myStatament = accessBBDD.prepareStatement(sql);
                myStatament.setString(1, registro.getNombre());
                myStatament.setString(2, registro.getUsuario()); 
                myStatament.setString(3, registro.getPin()); 
                myStatament.setTimestamp(4, Timestamp.valueOf(registro.getFecha()));
                myStatament.execute();

                return true;

        } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.err.println(e);
                return false;
        } finally {

                try {
                        accessBBDD.close();
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

        }

    }
    
    public boolean eliminar(Registros registro) {
        PreparedStatement myStatement = null;
        Connection accessBBDD = conexion.getConexion();

        String sql = "DELETE FROM registros WHERE usuario = ?";

        try {
            myStatement = accessBBDD.prepareStatement(sql);
            myStatement.setString(1, registro.getUsuario());
            myStatement.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                if (accessBBDD != null) {
                    accessBBDD.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void actualizar() {
    }
    
    public void leer() {
    }
}
