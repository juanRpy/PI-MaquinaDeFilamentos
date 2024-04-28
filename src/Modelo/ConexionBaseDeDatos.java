package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDeDatos {
    
    Connection conexion = null;
    
    public ConexionBaseDeDatos(){
        
    }
            
    public Connection getConexion() {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3305/filamentmachine_db", "root", "7492");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conexion;
    }
}
