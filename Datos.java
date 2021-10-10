
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Datos {
    private static String SQL_SELECT = "SELECT * FROM ";
    private static final String SQL_INSERT = "INSERT INTO favoritos(usuario, pokemon_id) VALUES(?, ?)";
    private static final String SQL_DELETE = "DELETE FROM favoritos WHERE pokemon_id = ?";
    
    public static ResultSet ejecutarConsulta(String tabla, String consulta){ 
        //interaccion con la base 
        String query = SQL_SELECT + tabla + consulta;
        Connection cn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            cn = ClsConexion.getConnetion();
            st = cn.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } 
        return rs;
    }
}

