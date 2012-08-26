/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Rental;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author habibi dan riska
 */
//class untuk koneksi ke database
public class SintakRental {
    //url ke database

    private String url = "jdbc:mysql://localhost:3306/rentaldvd";
    //username database
    private String username = "root";
    //password database
    private String password = "";
    //variabel untuk membuat koneksi
    private Connection con;
    //untuk mendapatkan array dari pejabat
    private List<Rental> list;
    //variabel pembantu
    private String kode;
    private String kodemem;
    private String kodepeg;
    private String user;
    private String userlog;
    private int nmrlog;
    private String notrans;
    private int denda = 0;

    public SintakRental() {
        try {
            try {
                //mengenalkan driver
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                JOptionPane.showMessageDialog(null, "kesalahan " + ex);
            } catch (IllegalAccessException ex) {
                JOptionPane.showMessageDialog(null, "kesalahan : " + ex);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan : " + ex);
        }
    }

    public SintakRental(Connection con) {
        this.con = con;
    }
    //method untuk koneksi database

    public void connect() throws SQLException {
        this.con = DriverManager.getConnection(url, username, password);
    }
    //method untuk menutup koneksi ke database

    public void disconnect() throws SQLException {
        this.con.close();
    }
    //method mendapatkan data dari tabel dvd dalam bentuk array

    public List<Rental> readdvd() {
        try {
            //membuat statement
            Statement st = con.createStatement();
            String sql = "SELECT * FROM dvd order by kodedvd desc";
            //mendapatkan data dari tabel dalam bentuk result set
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Rental>();
            while (rs.next()) {
                Rental pj = new Rental();
                pj.setKodedvd(rs.getString("kodedvd"));
                pj.setJudul(rs.getString("judul"));
                pj.setGenre(rs.getString("genre"));
                pj.setStatus(rs.getString("status"));
                pj.setSewa(rs.getInt("sewa"));
                pj.setStok(rs.getInt("stok"));
                list.add(pj);
            }


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        return list;

    }

    //method mendapatkan data dari tabel member dalam bentuk array
    public List<Rental> readmem() {
        try {
            //membuat statement
            Statement st = con.createStatement();
            String sql = "SELECT * FROM member order by kodemem desc";
            //mendapatkan data dari tabel dalam bentuk result set
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Rental>();
            while (rs.next()) {
                Rental pj = new Rental();
                pj.setKodemem(rs.getString("kodemem"));
                pj.setNamamem(rs.getString("namamem"));
                pj.setAlamatmem(rs.getString("alamatmem"));
                pj.setTelpmem(rs.getString("telpmem"));
                pj.setDatemem(rs.getString("datemem"));
                list.add(pj);
            }


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        return list;

    }

    public List<Rental> readpeg() {
        try {
            //membuat statement
            Statement st = con.createStatement();
            String sql = "SELECT * FROM petugas order by kodepeg desc";
            //mendapatkan data dari tabel dalam bentuk result set
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Rental>();
            while (rs.next()) {
                Rental pj = new Rental();
                pj.setKodepeg(rs.getString("kodepeg"));
                pj.setNamapeg(rs.getString("namapeg"));
                pj.setAlamatpeg(rs.getString("alamatpeg"));
                pj.setTelppeg(rs.getString("telppeg"));
                pj.setDatepeg(rs.getString("datepeg"));
                list.add(pj);
            }


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        return list;

    }
//method untuk generate kode dvd

    public void setKode(String no) {
        try {
            //membuat statement
            String sql = "SELECT max(kodedvd) AS kode FROM dvd WHERE kodedvd like ?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, no + "%");
            //mendapatkan data dari tabel dalam bentuk result set
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("kode") != null) {
                    kode = rs.getString("kode");
                } else {
                    kode = no + "00000";
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

//method untuk generate kode member
    public void setKodemem(String no) {
        try {
            //membuat statement
            String sql = "SELECT max(kodemem) AS kode FROM member WHERE kodemem like ? ";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, no + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("kode") != null) {
                    kodemem = rs.getString("kode");
                } else {
                    kodemem = no + "00000";
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }

        this.kodemem = kodemem;

    }

    public String getKodemem() {
        return kodemem;
    }

//method untuk generate kode petugas
    public void setKodepeg(String no) {
        try {
            //membuat statement
            String sql = "SELECT kodepeg AS kode FROM petugas WHERE kodepeg = ? ";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kodepeg = rs.getString("kode");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }

        this.kodepeg = kodepeg;

    }

    public String getKodepeg() {
        return kodepeg;
    }

//method untuk generate nomor trans
    public void setNotrans(String thn) {
        try {
            //membuat statement
            String sql = "SELECT max(nmrtrans) AS no FROM transaksi";
            Statement st = con.createStatement();
            //mendapatkan data dari tabel dalam bentuk result set
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("no") != null) {
                    notrans = rs.getString("no");
                } else {
                    notrans = thn + "000000";
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        this.notrans = notrans;
    }

    public String getNotrans() {
        return notrans;
    }

//method untuk generate no detail transaksi
    public void getNodetail(Rental pj) {
        try {
            //membuat statement
            String sql = "SELECT max(nodetail) AS kode FROM dettrans WHERE nmrtrans=? ";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getNotrans());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("kode") == null) {
                    pj.setNodetail(0);
                } else {
                    pj.setNodetail(rs.getInt("kode"));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }

    }

//method untuk generate jk member
    public void cariJK(String no, Rental pj) {
        try {
            //membuat statement
            String sql = "SELECT jk FROM member WHERE kodemem = ? ";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pj.setJK(rs.getString("jk"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }

//method untuk generate value petugas
    public void cariValPeg(String no, Rental pj) {
        try {
            //membuat statement
            String sql = "SELECT jkpeg,level FROM petugas WHERE kodepeg = ? ";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pj.setJKPeg(rs.getString("jkpeg"));
                pj.setLevelpeg(rs.getString("level"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }

//method untuk insert ke database
    public void insertdvd(Rental pj) {
        try {
            //Memecah tanggal yang tampilannya dd-mm-yyyy
            String thn = pj.getDdate().substring(6, 10);
            String bln = pj.getDdate().substring(3, 5);
            String tgl = pj.getDdate().substring(0, 2);

            String sql = "INSERT INTO dvd VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getKodedvd());
            ps.setString(2, pj.getJudul());
            ps.setString(3, thn + "-" + bln + "-" + tgl);
            ps.setString(4, pj.getGenre());
            ps.setString(5, pj.getStatus());
            ps.setInt(6, pj.getSewa());
            ps.setInt(7, pj.getStok());
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }

    public void insertmem(Rental pj) {
        try {
            //Memecah tanggal yang tampilannya dd-mm-yyyy
            String thn = pj.getDatemem().substring(6, 10);
            String bln = pj.getDatemem().substring(3, 5);
            String tgl = pj.getDatemem().substring(0, 2);

            String sql = "INSERT INTO member VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getKodemem());
            ps.setString(2, pj.getNamamem());
            ps.setString(3, pj.getAlamatmem());
            ps.setString(4, pj.getTelpmem());
            ps.setString(5, pj.getJK());
            ps.setString(6, thn + "-" + bln + "-" + tgl);

            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }

    public void insertpeg(Rental pj) {
        try {
            //Memecah tanggal yang tampilannya dd-mm-yyyy
            String thn = pj.getDatepeg().substring(6, 10);
            String bln = pj.getDatepeg().substring(3, 5);
            String tgl = pj.getDatepeg().substring(0, 2);

            String sql = "INSERT INTO petugas VALUES(?,?,md5(?),?,?,?,?,?)";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getKodepeg());
            ps.setString(2, pj.getNamapeg());
            ps.setString(3, "1234");
            ps.setString(4, pj.getAlamatpeg());
            ps.setString(5, pj.getTelppeg());
            ps.setString(6, pj.getJKPeg());
            ps.setString(7, thn + "-" + bln + "-" + tgl);
            ps.setString(8, pj.getLevelpeg());

            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }

    public void insertdetail(Rental pj) {
        try {
            String sql = "INSERT INTO dettrans(indextrans,nmrtrans,nodetail,kodedvd,jumlah,jmlkembali,haruskbl,dvdstat,denda) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getIndex());
            ps.setString(2, pj.getNotrans());
            ps.setInt(3, pj.getNodetail());
            ps.setString(4, pj.getKodedvd());
            ps.setInt(5, pj.getJmldvd());
            ps.setInt(6, pj.getJmldvd());
            ps.setString(7, pj.getTglharus());
            ps.setString(8, "Borrowed");
            ps.setInt(9, 0);
            ps.executeUpdate();

            //update value total di tabel transaksi
            String query = "UPDATE transaksi set total=total + ? WHERE nmrtrans=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, pj.getSewa());
            pt.setString(2, pj.getNotrans());
            pt.executeUpdate();

            //update value stok di tabel dvd
            String quer = "UPDATE dvd set stok=? WHERE kodedvd=?";
            PreparedStatement pr = this.con.prepareStatement(quer);
            int stok = pj.getStok() - pj.getJmldvd();
            pr.setInt(1, stok);
            pr.setString(2, pj.getKodedvd());
            pr.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }
    
    public void insertgratis(Rental pj) {
        try {
            String sql = "INSERT INTO dettrans(indextrans,nmrtrans,nodetail,kodedvd,jumlah,jmlkembali,haruskbl,dvdstat,denda) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getIndex());
            ps.setString(2, pj.getNotrans());
            ps.setInt(3, pj.getNodetail());
            ps.setString(4, pj.getKodedvd());
            ps.setInt(5, pj.getJmldvd());
            ps.setInt(6, pj.getJmldvd());
            ps.setString(7, pj.getTglharus());
            ps.setString(8, "Borrowed");
            ps.setInt(9, 0);
            ps.executeUpdate();

            //update value stok di tabel dvd
            String quer = "UPDATE dvd set stok=? WHERE kodedvd=?";
            PreparedStatement pr = this.con.prepareStatement(quer);
            int stok = pj.getStok() - pj.getJmldvd();
            pr.setInt(1, stok);
            pr.setString(2, pj.getKodedvd());
            pr.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }

    public void inserttrans(Rental pj) {
        try {
            //Memecah tanggal yang tampilannya dd-mm-yyyy
            String thn = pj.getTgltrans().substring(6, 10);
            String bln = pj.getTgltrans().substring(3, 5);
            String tgl = pj.getTgltrans().substring(0, 2);

            String sql = "INSERT INTO transaksi VALUES(?,?,?,?,?)";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getNotrans());
            ps.setString(2, pj.getKodepeg());
            ps.setString(3, pj.getKodemem());
            ps.setString(4, thn + "-" + bln + "-" + tgl);
            ps.setInt(5, 0);

            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }

//method untuk update ke database
    public void updatedvd(String no, Rental pj) {
        try {
            String sql = "UPDATE dvd set judul=?, stok=?, genre=?, status=?, sewa=? WHERE kodedvd=?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getJudul());
            ps.setInt(2, pj.getStok());
            ps.setString(3, pj.getGenre());
            ps.setString(4, pj.getStatus());
            ps.setInt(5, pj.getSewa());
            ps.setString(6, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }

    }

    public void updatemem(String no, Rental pj) {
        try {
            String sql = "UPDATE member set namamem=?, alamatmem=?, telpmem=?, jk=? WHERE kodemem=?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getNamamem());
            ps.setString(2, pj.getAlamatmem());
            ps.setString(3, pj.getTelpmem());
            ps.setString(4, pj.getJK());
            ps.setString(5, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }

    }

    public void updatepeg(String no, Rental pj) {
        try {
            String sql = "UPDATE petugas set namapeg=?, alamatpeg=?, telppeg=?, jkpeg=?, level=? WHERE kodepeg=?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getNamapeg());
            ps.setString(2, pj.getAlamatpeg());
            ps.setString(3, pj.getTelppeg());
            ps.setString(4, pj.getJKPeg());
            ps.setString(5, pj.getLevelpeg());
            ps.setString(6, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }

    }

//method untuk delete database
    public void deletedvd(String no) {
        try {
            String sql = "DELETE from dvd WHERE kodedvd=?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }


    }

    public void deletemem(String no) {
        try {
            String sql = "DELETE from member WHERE kodemem=?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }

    public void deletepeg(String no) {
        try {
            String sql = "DELETE from petugas WHERE kodepeg=?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }
    
    public void delTrans(String no) {
        try {
            String sql = "DELETE from transaksi WHERE nmrtrans=?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }
    
    public void deletedetail(String no, Rental pj) {
        try {
            String sql = "DELETE from dettrans WHERE indextrans=?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, no);
            ps.executeUpdate();
            
            //update value total di tabel transaksi
            String query = "UPDATE transaksi set total=total - ? WHERE nmrtrans=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, pj.getSewa());
            pt.setString(2, pj.getNotrans());
            pt.executeUpdate();

            //update value stok di tabel dvd
            String quer = "UPDATE dvd set stok=? WHERE kodedvd=?";
            PreparedStatement pr = this.con.prepareStatement(quer);
            int stok = pj.getStok() + pj.getJmldvd();
            pr.setInt(1, stok);
            pr.setString(2, pj.getKodedvd());
            pr.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }

//method untuk pencarian
    public List<Rental> read(String no) {
        try {

            String sql = "SELECT * FROM dvd WHERE kodedvd like ? or judul like ? or genre like ? or status like ?";
            list = new ArrayList<Rental>();
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, "%" + no + "%");
            ps.setString(2, "%" + no + "%");
            ps.setString(3, "%" + no + "%");
            ps.setString(4, "%" + no + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rental pj = new Rental();
                pj.setKodedvd(rs.getString("kodedvd"));
                pj.setJudul(rs.getString("judul"));
                pj.setGenre(rs.getString("genre"));
                pj.setStatus(rs.getString("status"));
                pj.setSewa(rs.getInt("sewa"));
                pj.setStok(rs.getInt("stok"));
                list.add(pj);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        return list;

    }

    public List<Rental> readmemall(String no) {
        try {

            String sql = "SELECT * FROM member WHERE kodemem like ? or namamem like ? ";
            list = new ArrayList<Rental>();
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, "%" + no + "%");
            ps.setString(2, "%" + no + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rental pj = new Rental();
                pj.setKodemem(rs.getString("kodemem"));
                pj.setNamamem(rs.getString("namamem"));
                pj.setAlamatmem(rs.getString("alamatmem"));
                pj.setTelpmem(rs.getString("telpmem"));
                pj.setDatemem(rs.getString("datemem"));
                list.add(pj);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        return list;

    }

    public List<Rental> readpegall(String no) {
        try {

            String sql = "SELECT * FROM petugas WHERE kodepeg like ? or namapeg like ? ";
            list = new ArrayList<Rental>();
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, "%" + no + "%");
            ps.setString(2, "%" + no + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rental pj = new Rental();
                pj.setKodepeg(rs.getString("kodepeg"));
                pj.setNamapeg(rs.getString("namapeg"));
                pj.setAlamatpeg(rs.getString("alamatpeg"));
                pj.setTelppeg(rs.getString("telppeg"));
                pj.setDatepeg(rs.getString("datepeg"));
                list.add(pj);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        return list;

    }

    public List<Rental> listPinjam(String kode) {
        try {
            String sql = "SELECT d.indextrans,d.kodedvd,d.jumlah,d.jmlkembali,d.haruskbl FROM dettrans d inner join transaksi t ON d.nmrtrans=t.nmrtrans WHERE t.kodemem=? and d.dvdstat=? ";
            list = new ArrayList<Rental>();
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, kode);
            ps.setString(2, "Borrowed");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rental pj = new Rental();
                pj.setIndex(rs.getString("indextrans"));
                pj.setKodedvd(rs.getString("kodedvd"));
                pj.setJmldvd(rs.getInt("jumlah"));
                pj.setJmlkbl(rs.getInt("jmlkembali"));
                pj.setTglharus(rs.getString("haruskbl"));
                list.add(pj);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        return list;

    }
    
    public List<Rental> listHistoryDVD(String kode) {
        try {
            String sql = "SELECT t.kodemem,d.jumlah,d.haruskbl,d.tglkembali,d.dvdstat FROM dettrans d inner join transaksi t ON d.nmrtrans=t.nmrtrans WHERE d.kodedvd=? ";
            list = new ArrayList<Rental>();
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, kode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rental pj = new Rental();
                pj.setKodemem(rs.getString("kodemem"));
                pj.setJmldvd(rs.getInt("jumlah"));
                pj.setTglharus(rs.getString("haruskbl"));
                pj.setTglkbl(rs.getString("tglkembali"));
                pj.setStatus(rs.getString("dvdstat"));
                list.add(pj);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        return list;

    }
    
    public List<Rental> readHistoryDVD(Rental pj) {
        try {
            String sql = "SELECT t.kodemem,d.jumlah,d.haruskbl,d.tglkembali,d.dvdstat FROM dettrans d inner join transaksi t ON d.nmrtrans=t.nmrtrans WHERE d.kodedvd=? and (t.kodemem=? or d.haruskbl between ? and ? or d.tglkembali between ? and ?) ";
            list = new ArrayList<Rental>();
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getKodedvd());
            ps.setString(2, pj.getKodemem());
            ps.setString(3, pj.getTglharus());
            ps.setString(4, pj.getTglharus2());
            ps.setString(5, pj.getTglkbl());
            ps.setString(6, pj.getTglkbl2());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pj.setKodemem(rs.getString("kodemem"));
                pj.setJmldvd(rs.getInt("jumlah"));
                pj.setTglharus(rs.getString("haruskbl"));
                pj.setTglkbl(rs.getString("tglkembali"));
                pj.setStatus(rs.getString("dvdstat"));
                list.add(pj);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        return list;

    }
    
    public List<Rental> readHistory1(Rental pj) {
        try {
            String sql = "SELECT t.kodemem,t.kodepeg as peg1,t.datetrans,d.jumlah,t.total,d.kodepeg,d.tglkembali,d.denda FROM dettrans d inner join transaksi t ON d.nmrtrans=t.nmrtrans WHERE d.kodedvd=? or t.datetrans between ? and ?";
            list = new ArrayList<Rental>();
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getKodegen());
            ps.setString(2, pj.getTglharus());
            ps.setString(3, pj.getTglharus2());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pj.setKode1(rs.getString("kodemem"));
                pj.setKodepeg(rs.getString("peg1"));
                pj.setTgltrans(rs.getString("datetrans"));
                pj.setJmldvd(rs.getInt("jumlah"));
                pj.setTotal(rs.getInt("total"));
                pj.setKodepem(rs.getString("kodepeg"));
                pj.setTglkbl(rs.getString("tglkembali"));
                pj.setDenda(rs.getInt("denda"));
                list.add(pj);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        return list;

    }
    
    public List<Rental> readHistory2(Rental pj) {
        try {
            String sql = "SELECT d.kodedvd,t.kodepeg as peg1,t.datetrans,d.jumlah,t.total,d.kodepeg as peg2,d.tglkembali,d.denda FROM dettrans d inner join transaksi t ON d.nmrtrans=t.nmrtrans WHERE t.kodemem=? or t.datetrans between ? and ?";
            list = new ArrayList<Rental>();
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getKodegen());
            ps.setString(2, pj.getTglharus());
            ps.setString(3, pj.getTglharus2());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pj.setKode1(rs.getString("kodedvd"));
                pj.setKodepeg(rs.getString("peg1"));
                pj.setTgltrans(rs.getString("datetrans"));
                pj.setJmldvd(rs.getInt("jumlah"));
                pj.setTotal(rs.getInt("total"));
                pj.setKodepem(rs.getString("peg2"));
                pj.setTglkbl(rs.getString("tglkembali"));
                pj.setDenda(rs.getInt("denda"));
                list.add(pj);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        return list;

    }

//method untuk verifikasi login user
    public void verifikasiAkun(String user, String pass, Rental pj) {
        try {
            //membuat statement
            String sql = "SELECT kodepeg,password FROM petugas WHERE kodepeg = ? and password = md5(?) ";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pj.setUser(rs.getString("kodepeg"));
                pj.setPass(rs.getString("password"));
                pj.setRow(rs.getRow());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }

//method untuk memasukkan user pass
    public void userLogin(String user, String date) {
        try {
            //membuat statement
            String sql = "INSERT INTO login(kodepeg,lastlog) VALUES(?,?)";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, date);

            ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }

//method untuk mendapatkan login user
    public void setUser() {
        try {
            //membuat statement
            String sql = "SELECT max(kodepeg)as kode FROM login ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                userlog = rs.getString("kode");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        this.userlog = userlog;
    }

    public String getUser() {
        return userlog;
    }

//method untuk logout
    public void userLogout(String user, String date) {
        try {
            String query = "SELECT max(nmrlog)as kode FROM login where kodepeg=? ";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, user);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                nmrlog = rs.getInt("kode");
            }

            String sql = "UPDATE login set lastout=? WHERE nmrlog=?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, date);
            ps.setInt(2, nmrlog);

            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }

    }

//method untuk edit akun
    public void editAkun(String user, String pass) {
        try {
            String sql = "UPDATE petugas set password=md5(?) WHERE kodepeg=?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, user);

            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }

    }

//method untuk searching data member
    public void getValueMem(String user, Rental pj) {
        try {
            String query = "SELECT kodemem,namamem FROM member where kodemem=? ";
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pj.setKodemem(rs.getString("kodemem"));
                pj.setNamamem(rs.getString("namamem"));
                pj.setRow(rs.getRow());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }

    }

//method untuk searching data dvd
    public void getValueDVD(String dvd, Rental pj) {
        try {
            String query = "SELECT kodedvd,judul,stok,sewa,status FROM dvd where kodedvd=? ";
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, dvd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pj.setKodedvd(rs.getString("kodedvd"));
                pj.setJudul(rs.getString("judul"));
                pj.setStok(rs.getInt("stok"));
                pj.setSewa(rs.getInt("sewa"));
                pj.setStatus(rs.getString("status"));
                pj.setRow(rs.getRow());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }

    }

//method cek lama peminjaman
    public void cekDenda(int no, Rental pj) {
        try {
            //cek lama pinjam
            String query = "SELECT datediff(?,?)as lama FROM dettrans WHERE nodetail=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, pj.getTglkbl());
            pt.setString(2, pj.getTglharus());
            pt.setInt(3, no);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                pj.setLama(rs.getInt("lama"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }

    }

//method cek value tabel general
    public void valueGeneral(String stat, Rental pj) {
        try {
            String query = "SELECT lamapinjam,denda FROM general WHERE status=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, stat);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                pj.setLamapin(rs.getInt("lamapinjam"));
                pj.setDendapin(rs.getInt("denda"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }

    }

//method untuk transaksi pengembalian DVD
    public void transKembali(Rental pj) {
        try {
            String sql = "UPDATE dettrans set kodepeg=?, jmlkembali=jmlkembali-?, tglkembali=?, denda=denda+? WHERE nodetail=? and nmrtrans=?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getKodepeg());
            ps.setInt(2, pj.getJmlkbl());
            ps.setString(3, pj.getTglkbl());
            ps.setInt(4, pj.getDenda());
            ps.setInt(5, pj.getNodetail());
            ps.setString(6, pj.getNotrans());
            ps.executeUpdate();

            String query = "UPDATE dvd set stok=stok+? WHERE kodedvd=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, pj.getJmlkbl());
            pt.setString(2, pj.getKodedvd());
            pt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }

//method untuk mengecek jumlah kembali yang nanti akan digunakan sebagai status peminjaman
    public void cekJml(Rental pj) {
        try {
            String query = "SELECT jmlkembali FROM dettrans WHERE nodetail=? and nmrtrans=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, pj.getNodetail());
            pt.setString(2, pj.getNotrans());
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                pj.setJmlkbl(rs.getInt("jmlkembali"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }

    }

//method untuk merubah status peminjaman
    public void rubahStat(Rental pj) {
        try {
            String sql = "UPDATE dettrans set dvdstat=? WHERE nodetail=? and nmrtrans=?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, "Returned");
            ps.setInt(2, pj.getNodetail());
            ps.setString(3, pj.getNotrans());
            ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }
}
