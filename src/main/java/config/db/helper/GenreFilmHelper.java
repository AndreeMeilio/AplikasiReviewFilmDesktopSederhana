package config.db.helper;

import classes.GenreFilm;
import config.db.connection.ConnectDatabase;
import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreFilmHelper extends ConnectDatabase {

    public List<GenreFilm> select_data(){

        List<GenreFilm> lgf = new ArrayList<>();
        
        String query = "SELECT genre_film.*, (SELECT COUNT(film.id_film) FROM film WHERE film.id_genre_film=genre_film.id_genre_film) AS jumlah_film FROM `genre_film`;";
        try{
            PreparedStatement pstmt = super.db_stmt().prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                GenreFilm gf = new GenreFilm();
                
                gf.setId_genre_film(rs.getInt("id_genre_film"));
                gf.setNama_genre_film(rs.getString("nama_genre_film"));
                gf.setJumlah_buku(rs.getInt("jumlah_film"));
                
                lgf.add(gf);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return lgf;
    }
    
    public GenreFilm select_data_with_id(GenreFilm gf){
        GenreFilm result_gf = new GenreFilm();
        
        String query = "SELECT genre_film.*, (SELECT COUNT(film.id_film) FROM film WHERE film.id_genre_film=genre_film.id_genre_film) AS jumlah_film FROM `genre_film` WHERE genre_film.id_genre_film=?;";
        
        try{
            
            PreparedStatement pstmt = super.db_stmt().prepareStatement(query);
            pstmt.setInt(1, gf.getId_genre_film());
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()){
                result_gf.setId_genre_film(rs.getInt("id_genre_film"));
                result_gf.setNama_genre_film(rs.getString("nama_genre_film"));
                result_gf.setJumlah_buku(rs.getInt("jumlah_film"));
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return result_gf;
    }
    
    public boolean insert_data(GenreFilm gf){
        
        String query = "INSERT INTO genre_film(nama_genre_film) VALUES(?)";
        
        try{
            
            PreparedStatement pstmt = super.db_stmt().prepareStatement(query);
            
            pstmt.setString(1, gf.getNama_genre_film());
            
            int count_inserted = pstmt.executeUpdate();
            
            if (count_inserted != -1){
                return true;
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean edit_data(int id_genre_film, GenreFilm gf){
        
        String query = "UPDATE genre_film SET nama_genre_film = ? WHERE id_genre_film = ?";
        
        try{
            
            PreparedStatement pstmt = super.db_stmt().prepareStatement(query);
            
            pstmt.setString(1, gf.getNama_genre_film());
            pstmt.setInt(2, id_genre_film);
            
            int count_updated = pstmt.executeUpdate();
            
            if (count_updated != -1){
                return true;
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean delete_data(GenreFilm gf){
        
        String query = "DELETE FROM genre_film WHERE id_genre_film = ?";
        
        try{
            
            PreparedStatement pstmt = super.db_stmt().prepareStatement(query);
            pstmt.setInt(1, gf.getId_genre_film());
            
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
