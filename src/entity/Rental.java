/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 *
 * @author habibi dan riska
 */
public class Rental {
    //variabel yang ada untuk entitas sama dengan yang di database
        
        //entitas dvd
        private int kodedvd;
        private String judul;
        private String dvddate;
        private String genre;
        private String status;
        private int stok;
        
        
        private String kodemem;
        private String kodepeg;
    
        private String namapeg;
        private String alamatpeg;
        private String telppeg;
        private int kode;
        
    
    //getter
    public int getKodedvd() {
        return kodedvd;
    }
    //setter
    public void setKodedvd(int kodedvd) {
        this.kodedvd = kodedvd;
    }
    //getter
    public String getJudul() {
        return judul;
    }
    //setter
    public void setJudul(String judul) {
        this.judul = judul;
    }
    //getter
    public String getDdate() {
        return dvddate;
    }
    //setter
    public void setDdate(String dvddate) {
        this.dvddate = dvddate;
    }
    //getter
    public int getStok() {
        return stok;
    }
    //setter
    public void setStok(int stok) {
        this.stok = stok;
    }
    public String getGenre() {
        return genre;
    }
    //setter
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getStatus() {
        return status;
    }
    //setter
    public void setStatus(String status) {
        this.status = status;
    }
    public int getKode() {
        return kode;
    }
    //setter
    public void setKode(int status) {
        this.kode = kode;
    }

    


}
