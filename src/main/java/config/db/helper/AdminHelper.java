/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.db.helper;

import classes.Admin;
import config.db.connection.ConnectDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andreemeilio
 */
public class AdminHelper extends ConnectDatabase{
    
    public Admin select_data_with_email(Admin adm){
                
        String query = "SELECT * FROM admin WHERE email = ?";
        System.out.println(adm.getEmail());
        
        try{
            Admin adm_result = new Admin();
            
            PreparedStatement pstmt = super.db_stmt().prepareStatement(query);
            pstmt.setString(1, adm.getEmail());
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()){
                adm_result.setId_admin(rs.getInt("id_admin"));
                adm_result.setEmail(rs.getString("email"));
                adm_result.setPassword(rs.getString("password"));
            }
            
            return adm_result;
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }
}
