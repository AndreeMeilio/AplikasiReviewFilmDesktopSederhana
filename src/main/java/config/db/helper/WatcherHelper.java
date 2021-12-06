/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.db.helper;

import classes.Watcher;
import config.db.connection.ConnectDatabase;
import config.hashing.BCrypt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andreemeilio
 */
public class WatcherHelper extends ConnectDatabase {
    
    public Watcher select_data_with_email(Watcher wtc){
                
        String query = "SELECT * FROM watcher WHERE email = ?";
        
        try{
            Watcher wtc_result = new Watcher();
            
            PreparedStatement pstmt = super.db_stmt().prepareStatement(query);
            pstmt.setString(1, wtc.getEmail());
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()){
                wtc_result.setId_watcher(rs.getInt("id_watcher"));
                wtc_result.setUsername(rs.getString("username"));
                wtc_result.setEmail(rs.getString("email"));
                wtc_result.setPassword(rs.getString("password"));
            }
            
            return wtc_result;
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    public boolean register_or_insert(Watcher wtc){
        
        String HashPassword = BCrypt.hashpw(wtc.getPassword(), BCrypt.gensalt(12));
        String query = "INSERT INTO watcher(username, email, password) VALUES('"+ wtc.getUsername() +"','"+ wtc.getEmail() +"','"+ HashPassword +"')";
        
        try{
            
            PreparedStatement pstmt = super.db_stmt().prepareStatement(query);
            
//            pstmt.setString(1, username);
//            pstmt.setString(2, email);
//            pstmt.setString(3, HashPassword);
//            
            int inserted = pstmt.executeUpdate();
            System.out.println(HashPassword);
            
            if (inserted != -1){
                return true;
            }
                       
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return false;
    }
    
}
