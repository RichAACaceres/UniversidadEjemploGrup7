/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.AccesoADato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conexion {
    private static final String URL="";
    private static final String DB="";
    private static final String USUARIO="";
    private static final String PASSWORD="";

    private static Connection connection;

    public Conexion() {
    }
    
    public static Connection getConexion(){
        if (connection==null) {
            
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                
                connection= DriverManager.getConnection(URL+DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC"  
                                                        + "&user=" + USUARIO + "&password=" + PASSWORD);
                
            } catch (ClassNotFoundException ex) {
                 JOptionPane.showMessageDialog(null,"Error a cargar el driver"+ex.getMessage());
            }catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,"Error a cconectarse a la base de datos"+ex.getMessage());
        }
            
        }
        
        return connection;
  
    }
    
}
