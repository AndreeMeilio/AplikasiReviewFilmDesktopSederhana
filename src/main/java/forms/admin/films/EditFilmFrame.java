/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms.admin.films;

import classes.Film;
import classes.GenreFilm;
import java.sql.Date;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author andreemeilio
 */
public class EditFilmFrame extends javax.swing.JFrame {

    private Film film;
    private GenreFilm gf;
    
    /**
     * Creates new form EditFilmFrame
     */
    public EditFilmFrame() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        gf = new GenreFilm();
        List<GenreFilm> lgf = gf.select_data();
        
        String[] nama_genre_film_arr = new String[lgf.size()];
        
        for (int i = 0; i < nama_genre_film_arr.length; i++){
            nama_genre_film_arr[i] = lgf.get(i).getNama_genre_film();
        }
        
        genre_film.setModel(new DefaultComboBoxModel<>(nama_genre_film_arr));
        
    }
    
    public EditFilmFrame(Film film){
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        gf = new GenreFilm();
        this.film = film;
        
        List<GenreFilm> lgf = gf.select_data();
        
        String[] nama_genre_film_arr = new String[lgf.size()];
        
        for (int i = 0; i < nama_genre_film_arr.length; i++){
            nama_genre_film_arr[i] = lgf.get(i).getNama_genre_film();
        }
        
        genre_film.setModel(new DefaultComboBoxModel<>(nama_genre_film_arr));
        
        judul_film.setText(this.film.getJudul_film());
        url_video.setText(this.film.getUrl_video());
        tgl_publish.setText(String.valueOf(this.film.getTanggal_publish()));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        judul_film = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        url_video = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        genre_film = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tgl_publish = new javax.swing.JTextField();
        btn_submit = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tambah Film");

        jLabel2.setText("Judul Film");

        jLabel3.setText("Url Video");

        jLabel4.setText("Genre Film");

        jLabel5.setText("Tanggal Publish");

        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genre_film, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(judul_film)
                    .addComponent(url_video)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btn_submit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(122, 122, 122))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(111, 111, 111))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(73, 73, 73))
                    .addComponent(tgl_publish))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(judul_film, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(url_video, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(genre_film, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tgl_publish, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_submit)
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(500, 500, 500))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
        if (judul_film.getText().toString() == "" ||
            url_video.getText().toString() == "" ||
            genre_film.getSelectedItem().toString() == "" ||
            tgl_publish.getText().toString() == ""){
            JOptionPane.showMessageDialog(this, "Nama Genre Film Must Be Fill", "Field Must Be Fill", JOptionPane.ERROR_MESSAGE);
        } else {
            int id_film = this.film.getId_film();
            String judul_film_result = judul_film.getText().toString();
            String url_video_result = url_video.getText().toString();
            String tgl_publish_result = tgl_publish.getText().toString();

            String genre_film_result = genre_film.getSelectedItem().toString();
            int id_genre_film = 0;

            List<GenreFilm> lgf = this.gf.select_data();

            for (int i = 0; i < lgf.size(); i++){
                if (lgf.get(i).getNama_genre_film().equals(genre_film_result)){
                    id_genre_film = lgf.get(i).getId_genre_film();
                }
            }

            Film film = new Film();

            film.setId_genre_film(id_genre_film);
            film.setJudul_film(judul_film_result);
            film.setUrl_video(url_video_result);
            film.setTanggal_publish(Date.valueOf(tgl_publish_result));

            boolean isUpdated = film.update_data(id_film, film);

            if (isUpdated){
                JOptionPane.showMessageDialog(this, "Update Data Film Successfully", "Update Data", JOptionPane.INFORMATION_MESSAGE);

                new FilmFrame().setVisible(true);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btn_submitActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        new FilmFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditFilmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditFilmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditFilmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditFilmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditFilmFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_submit;
    private javax.swing.JComboBox<String> genre_film;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField judul_film;
    private javax.swing.JTextField tgl_publish;
    private javax.swing.JTextField url_video;
    // End of variables declaration//GEN-END:variables
}