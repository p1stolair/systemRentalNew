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
    private String kodedvd;
    private String judul;
    private String dvddate;
    private String genre;
    private String status;
    private int stok;
    private int sewa;
    
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
    private String datepeg;
    private String jkpeg;
    private String passpeg;
    private String levelpeg;
    
    //entitas pembantu
    private int kode;
    private String user;
    private String pass;
    private String userlog;
    int row;
    private String kodegen;
    private String kodepem;
    private String kode1;
    
    //entitas transaksi
    private int nodetail;
    private String notrans;
    private int lama;
    private int jml;
    private int jmlkbl;
    private int denda;
    private String tgltrans;
    private String tglkbl;
    private String tglharus;
    private String tglkbl2;
    private String tglharus2;
    private int lamapin;
    private int dendapin;
    private String dvdstat;
    private int total;
    private String index;
    
//method untuk entitas dvd
    
    public String getKodedvd() {
        return kodedvd;
    }

    public void setKodedvd(String kodedvd) {
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
     public int getSewa() {
        return sewa;
    }
    
    public void setSewa(int sewa) {
        this.sewa = sewa;
    }
    
//method pembantu

    public int getKode() {
        return kode;
    }
    
    public void setKode(int status) {
        this.kode = kode;
    }
    
    public String getKodegen() {
        return kodegen;
    }
    
    public void setKodegen(String kodegen) {
        this.kodegen = kodegen;
    }
    
    public String getKodepem() {
        return kodepem;
    }
    
    public void setKodepem(String kodepem) {
        this.kodepem = kodepem;
    }
    
    public String getKode1() {
        return kode1;
    }
    
    public void setKode1(String kode1) {
        this.kode1 = kode1;
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
    
//method untuk entitas pegawai
    
    public String getKodepeg() {
        return kodepeg;
    }
    
    public void setKodepeg(String kodepeg) {
        this.kodepeg = kodepeg;
    }
    
    public String getNamapeg() {
        return namapeg;
    }
    
    public void setNamapeg(String namapeg) {
        this.namapeg = namapeg;
    }
    
    public String getAlamatpeg() {
        return alamatpeg;
    }

    public void setAlamatpeg(String alamatpeg) {
        this.alamatpeg = alamatpeg;
    }
    
    public String getTelppeg() {
        return telppeg;
    }

    public void setTelppeg(String telppeg) {
        this.telppeg = telppeg;
    }
    
    public String getDatepeg() {
        return datepeg;
    }

    public void setDatepeg(String datepeg){
        this.datepeg = datepeg;
    }
    
    public String getJKPeg() {
        return jkpeg;
    }

    public void setJKPeg(String jkpeg) {
        this.jkpeg = jkpeg;
    }
    
    public String getPasspeg() {
        return passpeg;
    }

    public void setPasspeg(String passpeg) {
        this.passpeg = passpeg;
    }
    
    public String getLevelpeg() {
        return levelpeg;
    }

    public void setLevelpeg(String levelpeg) {
        this.levelpeg = levelpeg;
    }
    
//method login user
    public void setUser(String user) {
        this.user = user;
    }
    public String getUser() {
        return user;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getPass() {
        return pass;
    }
    public void setRow(int row){
        this.row=row;
    }
    public int getRow(){
        return row;
    }
    
//method untuk entitas transaksi
    public void setNodetail(int nodetail){
        this.nodetail=nodetail;
    }
    public int getNodetail(){
        return nodetail;
    }
    public void setNotrans(String notrans){
        this.notrans=notrans;
    }
    public String getNotrans(){
        return notrans;
    }
    public void setJmldvd(int jml){
        this.jml=jml;
    }
    public int getJmldvd(){
        return jml;
    }
    public void setJmlkbl(int jmlkbl){
        this.jmlkbl=jmlkbl;
    }
    public int getJmlkbl(){
        return jmlkbl;
    }
    public void setTgltrans(String tgltrans){
        this.tgltrans=tgltrans;
    }
    public String getTgltrans(){
        return tgltrans;
    }
    public void setTglharus(String tglharus){
        this.tglharus=tglharus;
    }
    public String getTglharus(){
        return tglharus;
    }
    public void setTglharus2(String tglharus2){
        this.tglharus2=tglharus2;
    }
    public String getTglharus2(){
        return tglharus2;
    }
    public void setTglkbl(String tglkbl){
        this.tglkbl=tglkbl;
    }
    public String getTglkbl(){
        return tglkbl;
    }
    public void setTglkbl2(String tglkbl2){
        this.tglkbl2=tglkbl2;
    }
    public String getTglkbl2(){
        return tglkbl2;
    }
    public void setDenda(int denda){
        this.denda=denda;
    }
    public int getDenda(){
        return denda;
    }
    public void setLama(int lama){
        this.lama=lama;
    }
    public int getLama(){
        return lama;
    }
    public void setDendapin(int dendapin){
        this.dendapin=dendapin;
    }
    public int getDendapin(){
        return dendapin;
    }
    public void setLamapin(int lamapin){
        this.lamapin=lamapin;
    }
    public int getLamapin(){
        return lamapin;
    }
    public void setDvdstat(String dvdstat){
        this.dvdstat=dvdstat;
    }
    public String getDvdstat(){
        return dvdstat;
    }
    public void setTotal(int total){
        this.total=total;
    }
    public int getTotal(){
        return total;
    }
    public void setIndex(String index){
        this.index=index;
    }
    public String getIndex(){
        return index;
    }
    
}
