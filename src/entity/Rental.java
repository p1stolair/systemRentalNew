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

    //entitas tabel dvd
    private int kodedvd;
    private String judul;
    private String dvddate;
    private String genre;
    private String status;
    private int stok;
    
    //entitas tabel member
    private String kodemem;
    private String namamem;
    private String alamatmem;
    private String telpmem;
    private String datemem;
    private String jk;
    
    //entitas tabel pegawai
    private String kodepeg;
    private String namapeg;
    private String alamatpeg;
    private String telppeg;
    
    //entitas pembantu
    private int kode;
    private String charmem;
    private int nomem;

    
//method untuk entitas dvd
    
    public int getKodedvd() {
        return kodedvd;
    }

    public void setKodedvd(int kodedvd) {
        this.kodedvd = kodedvd;
    }
    
    public String getJudul() {
        return judul;
    }
    
    public void setJudul(String judul) {
        this.judul = judul;
    }
   
    public String getDdate() {
        return dvddate;
    }
    
    public void setDdate(String dvddate) {
        this.dvddate = dvddate;
    }
    
    public int getStok() {
        return stok;
    }
    
    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
//method pembantu

    public int getKode() {
        return kode;
    }
    
    public void setKode(int status) {
        this.kode = kode;
    }


    public void setCharmem(String charmem) {
        this.charmem = charmem;
    }
    public String getCharmem() {
        return charmem;
    }
    public void setNomem(int nomem) {
        this.nomem = nomem;
    }
    public int getNomem() {
        return nomem;
    }
   

//method untuk entitas member
    
    public String getKodemem() {
        return kodemem;
    }
    
    public void setKodemem(String kodemem) {
        this.kodemem = kodemem;
    }
    
    public String getNamamem() {
        return namamem;
    }
    
    public void setNamamem(String namamem) {
        this.namamem = namamem;
    }
    
    public String getAlamatmem() {
        return alamatmem;
    }

    public void setAlamatmem(String alamatmem) {
        this.alamatmem = alamatmem;
    }
    
    public String getTelpmem() {
        return telpmem;
    }

    public void setTelpmem(String telpmem) {
        this.telpmem = telpmem;
    }
    
    public String getDatemem() {
        return datemem;
    }

    public void setDatemem(String datemem) {
        this.datemem = datemem;
    }
    
    public String getJK() {
        return jk;
    }

    public void setJK(String jk) {
        this.jk = jk;
    }
    
}
