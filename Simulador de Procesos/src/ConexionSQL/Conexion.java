/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author lucas
 */
public class Conexion {

    // Librería de MySQL
    public String driver = "com.mysql.jdbc.Driver";
    // Nombre de la base de datos
    public String database = "aca va el nombre de la base de datos";
    // Host
    public String hostname = "localhost";
    // Puerto
    public String port = "3306";
    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    // Nombre de usuario
    public String username = "root";
    // Clave de usuario (está de ejemplo)
    public String password = "123456789";

    public Connection conectarMySQL() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }    
}
