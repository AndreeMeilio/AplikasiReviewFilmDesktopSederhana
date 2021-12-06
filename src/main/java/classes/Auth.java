/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import config.hashing.BCrypt;
import java.sql.ResultSet;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 *
 * @author andreemeilio
 */
public class Auth {
    
    public boolean login(String email, String password, String login_as) throws NoSuchAlgorithmException, SQLException {
        
        if (login_as == "Admin"){
            Admin adm = new Admin();
            adm.setEmail(email);
            adm.setPassword(password);
            
            Admin rsAdmin = adm.select_data_with_email(adm);
                     
            if (rsAdmin.getId_admin() == 0){
                return false;
            }
            
            boolean matched_adm = BCrypt.checkpw(adm.getPassword(), rsAdmin.getPassword());
            
            if (matched_adm){
                return true;                
            }
            
            return false;
        } else {
            Watcher wtc = new Watcher();
            wtc.setEmail(email);
            wtc.setPassword(password);
            
            Watcher rsWatcher = wtc.select_data_with_email(wtc);
                      
            if (rsWatcher.getId_watcher() == 0){
                return false;
            }
            
            boolean matched_wtc = BCrypt.checkpw(wtc.getPassword(), rsWatcher.getPassword());
            System.out.println(matched_wtc);
            if (matched_wtc){
                System.out.println("TEST PASS");
                return true;                
            }
            
            return false;
        }
    }
    
    public boolean register(String username, String email, String password){
        Watcher wtc = new Watcher();
        wtc.setUsername(username);
        wtc.setEmail(email);
        wtc.setPassword(password);
        
        boolean reg = wtc.register_or_insert(wtc);
        
        return reg;
    }
}
