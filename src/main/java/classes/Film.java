package classes;

import config.db.helper.FilmHelper;

import java.sql.Date;

public class Film extends FilmHelper {

    private int id_film;
    private String judul_film;
    private String url_video;
    private Date tanggal_publish;
    private int id_genre_film;

        
    private GenreFilm genre_film;

    public Film(){

        genre_film = new GenreFilm();
    }
    
    public int getId_film() {
        return id_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }

    public String getJudul_film() {
        return judul_film;
    }

    public void setJudul_film(String judul_film) {
        this.judul_film = judul_film;
    }

    public String getUrl_video() {
        return url_video;
    }

    public void setUrl_video(String url_video) {
        this.url_video = url_video;
    }

    public Date getTanggal_publish() {
        return tanggal_publish;
    }

    public void setTanggal_publish(Date tanggal_publish) {
        this.tanggal_publish = tanggal_publish;
    }

    public GenreFilm getGenre_film() {
        return genre_film;
    }

    public void setGenre_film(GenreFilm genre_film) {
        this.genre_film = genre_film;
    }
    
    public int getId_genre_film() {
        return id_genre_film;
    }

    public void setId_genre_film(int id_genre_film) {
        this.id_genre_film = id_genre_film;
    }
}
