/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.db.helper;


import classes.Film;
import config.db.connection.ConnectDatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author andreemeilio
 */
public class FilmHelper extends ConnectDatabase{

    public List<Film> select_data(){

        List<Film> lfilm = new ArrayList<>();
        
        String query_select = "SELECT * FROM film";
        
        try{
            PreparedStatement pstmt = super.db_stmt().prepareStatement(query_select);
            
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                Film film = new Film();
                
                film.setId_film(rs.getInt("id_film"));
                film.setJudul_film(rs.getString("judul_film"));
                film.setUrl_video(rs.getString("url_video"));
                film.setTanggal_publish(rs.getDate("tanggal_publish"));
                film.setId_genre_film(rs.getInt("id_genre_film"));
                
                lfilm.add(film);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return lfilm;
    }
    
    public Film select_data_with_id(Film film){
        
        Film film_result = new Film();
        
        String query = "SELECT * FROM film WHERE id_film = ?";
        
        try{
            
            PreparedStatement pstmt = super.db_stmt().prepareStatement(query);
            
            pstmt.setInt(1, film.getId_film());
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()){
                film_result.setId_film(rs.getInt("id_film"));
                film_result.setId_genre_film(rs.getInt("id_genre_film"));
                film_result.setJudul_film(rs.getString("judul_film"));
                film_result.setUrl_video(rs.getString("url_video"));
                film_result.setTanggal_publish(rs.getDate("tanggal_publish"));
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
                
        return film_result;
    }
    
    public boolean insert_data(Film film){
        
        String query = "INSERT INTO film(id_genre_film, judul_film, url_video, tanggal_publish) VALUES(?,?,?,?)";
        
        try{
            
            PreparedStatement pstmt = super.db_stmt().prepareStatement(query);
            
            pstmt.setInt(1, film.getId_genre_film());
            pstmt.setString(2, film.getJudul_film());
            pstmt.setString(3, film.getUrl_video());
            pstmt.setDate(4, film.getTanggal_publish());
            
            int count_inserted = pstmt.executeUpdate();
            
            if (count_inserted != -1){
                return true;
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean update_data(int id_film, Film film){
        String query = "UPDATE film SET judul_film = ?, url_video = ?, tanggal_publish = ?, id_genre_film = ? WHERE id_film = ?";
        
        try{
        
            PreparedStatement pstmt = super.db_stmt().prepareStatement(query);
            
            pstmt.setString(1, film.getJudul_film());
            pstmt.setString(2, film.getUrl_video());
            pstmt.setDate(3, film.getTanggal_publish());
            pstmt.setInt(4, film.getId_genre_film());
            pstmt.setInt(5, id_film);
            
            int count_updated = pstmt.executeUpdate();
            
            if (count_updated != -1){
                return true;
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
                
        return false;
    }
    
    public boolean delete_data(Film film){
        String query = "DELETE FROM film WHERE id_film = ?";
        
        try{
            
            PreparedStatement pstmt = super.db_stmt().prepareStatement(query);
            
            pstmt.setInt(1, film.getId_film());
            
            int count_deleted = pstmt.executeUpdate();
            
            if (count_deleted != -1){
                return true;
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return false;
    }
}
