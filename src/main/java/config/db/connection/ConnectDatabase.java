/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package config.db.connection;

import java.sql.*;

/**
 *
 * @author andreemeilio
 */
public class ConnectDatabase {
    public static final String DB_URL       = "jdbc:mysql://localhost/layanan_streaming?useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER         = "root";
    public static final String PASS         = "";
    
    public Connection conn;
    
    public Connection db_stmt(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
           
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
        return this.conn;
    }
}
