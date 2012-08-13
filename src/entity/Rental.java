/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 *
 * @author suryono
 */
public class Rental {
    //variabel yang ada untuk entitas sama dengan yang di database
        
        //entitas dvd
        private String kodedvd;
        private String judul;
        private String dvddate;
        private String stok;
        
        
        private String kodemem;
        private String kodepeg;
    
        private String namapeg;
        private String alamatpeg;
        private String telppeg;
    
    //getter
    public String getKodedvd() {
        return kodedvd;
    }
    //setter
    public void setKodedvd(String kodedvd) {
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
    public String getStok() {
        return stok;
    }
    //setter
    public void setStok(String stok) {
        this.stok = stok;
    }

    


}
