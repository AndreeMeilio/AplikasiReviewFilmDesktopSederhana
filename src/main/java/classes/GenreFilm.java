package classes;

import config.db.helper.GenreFilmHelper;

public class GenreFilm extends GenreFilmHelper {
    private int id_genre_film;
    private String nama_genre_film;
    private int jumlah_buku;

         
    public GenreFilm(){
        
    }
    
    public int getId_genre_film() {
        return id_genre_film;
    }

    public void setId_genre_film(int id_genre_film) {
        this.id_genre_film = id_genre_film;
    }

    public String getNama_genre_film() {
        return nama_genre_film;
    }

    public void setNama_genre_film(String nama_genre_film) {
        this.nama_genre_film = nama_genre_film;
    }
    
    public int getJumlah_buku() {
        return jumlah_buku;
    }

    public void setJumlah_buku(int jumlah_buku) {
        this.jumlah_buku = jumlah_buku;
    }
}
