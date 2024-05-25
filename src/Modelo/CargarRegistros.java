package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import vista.EscenaRegistro;

public class CargarRegistros {
    ConexionBaseDeDatos conexion;
    CargarRegistros cargarRegistros;
    Registros registros;
	
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
                showInformationDialog("Registro exitoso", "Registro terminado, " + registro.getNombre() + ", inicia sesión con los datos de tu cuenta");
                return true;

        } catch (SQLException e) {
                // TODO Auto-generated catch block
                if (e.getErrorCode() == 1062) { // Código de error para duplicados en MySQL
                    showErrorDialog("Registro fallido", "El usuario ya está tomado. Por favor, elige otro nombre de usuario.");
                } else {
                    e.printStackTrace();
                }
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
    
    private void showErrorDialog(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void showInformationDialog(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public void actualizar() {
    }
    
    public List<Registros> leer() {
        List<Registros> listaRegistros = new ArrayList<>();
        Statement myStatement = null;
        ResultSet rs = null;
        Connection accessBBDD = conexion.getConexion();

        String sql = "SELECT * FROM registros";

        try {
            myStatement = accessBBDD.createStatement();
            rs = myStatement.executeQuery(sql);

            while (rs.next()) {
                Registros registro = new Registros(
                        rs.getString("nombre"),
                        rs.getString("usuario"),
                        rs.getString("pin"),
                        rs.getTimestamp("fecha").toLocalDateTime()
                );
                listaRegistros.add(registro);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (myStatement != null) myStatement.close();
                if (accessBBDD != null) accessBBDD.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaRegistros;
    
    }
    
    public boolean login(String usuario, String pin) {
        PreparedStatement myStatement = null;
        ResultSet rs = null;
        Connection accessBBDD = conexion.getConexion();

        String sql = "SELECT * FROM registros WHERE usuario = ? AND pin = ?";

        try {
            myStatement = accessBBDD.prepareStatement(sql);
            myStatement.setString(1, usuario);
            myStatement.setString(2, pin);
            rs = myStatement.executeQuery();

            if (rs.next()) {
                // Login successful
                return true;
            } else {
                // Login failed
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (myStatement != null) myStatement.close();
                if (accessBBDD != null) accessBBDD.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
