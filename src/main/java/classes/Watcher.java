/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import config.db.helper.WatcherHelper;

/**
 *
 * @author andreemeilio
 */
public class Watcher extends WatcherHelper{
    private int id_watcher;
    private String username;
    private String email;
    private String password;

    public int getId_watcher() {
        return id_watcher;
    }

    public void setId_watcher(int id_watcher) {
        this.id_watcher = id_watcher;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
