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

public class CargarSecciones {
    ConexionBaseDeDatos conexion;
	
    public CargarSecciones() {
        conexion = new ConexionBaseDeDatos();
    }

    public boolean create (Medidas medida) {


            PreparedStatement myStatament= null;

            Connection accessBBDD = conexion.getConexion();

            String sql = "INSERT INTO measures (temperature, times, date_time) VALUES (?,?,?)";

            try {  

                    myStatament = accessBBDD.prepareStatement(sql);
                    myStatament.setDouble(1, medida.getTemperatura());
                    myStatament.setDouble(2, medida.getTiempo()); 
                    myStatament.setTimestamp(3, Timestamp.valueOf(medida.getFecha()));
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

    public boolean update (Medidas medida) {

            PreparedStatement myStatament= null;

            Connection accessBBDD = conexion.getConexion();

            String sql = "UPDATE measures SET temperature=?, times=?, date_time=? WHERE id=?";

            try {  

                    myStatament = accessBBDD.prepareStatement(sql);
                    myStatament.setDouble(1, medida.getTemperatura());
                    myStatament.setDouble(2, medida.getTiempo());
                    myStatament.setTimestamp(3, Timestamp.valueOf(medida.getFecha()));
                    myStatament.setInt(4, medida.getId());
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

    public boolean delate () {

            Statement myStatament= null;

            Connection accessBBDD = conexion.getConexion();

            String sql = "DELETE FROM measures";
            String resetIdSql = "ALTER TABLE measures AUTO_INCREMENT = 1";

            try {  

                    myStatament = accessBBDD.createStatement();
                    myStatament.execute(sql);

                    myStatament.execute(resetIdSql);


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

    public ObservableList<Medidas> read() {

            ObservableList<Medidas> lista = FXCollections.observableArrayList();

            Statement myStatament= null;
            ResultSet resultSet = null;

            Connection accessBBDD = conexion.getConexion();

            String sql = "SELECT * FROM measures ORDER BY date_time DESC ";

            try {  

                    myStatament = accessBBDD.createStatement();
                    resultSet = myStatament.executeQuery(sql);

                    while(resultSet.next()) {

                            //measure.setTemperature(resultSet.getString("temperature"));
                            //measure.setTimes(resultSet.getString("times"));
                            //measure.setDate_time(resultSet.getDate("date_time"));

                            Double temperatura = Double.parseDouble(resultSet.getString("temperature"));
                            Double tiempo = Double.parseDouble(resultSet.getString("times"));
                            Timestamp timestamp = resultSet.getTimestamp("date_time");
                            LocalDateTime fecha = timestamp.toLocalDateTime();

                            Medidas medida = new Medidas(temperatura, tiempo, fecha);

                            lista.add(medida);

                            //return true;
                    }

                    //return false;

            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    System.err.println(e);
                    //return false;
            } finally {

                    try {
                            accessBBDD.close();
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                    }

            }
            return lista;

    }
}
