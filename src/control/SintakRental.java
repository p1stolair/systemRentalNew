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
    //method mendapatkan data dari database pejabat dalam bentuk array

    public List<Rental> readdvd() {
        try {
            //membuat statement
            Statement st = con.createStatement();
            String sql = "SELECT * FROM dvd";
            //mendapatkan data dari tabel dalam bentuk result set
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Rental>();
            while (rs.next()) {
                Rental pj = new Rental();
                pj.setKodedvd(rs.getString("kodedvd"));
                pj.setJudul(rs.getString("judul"));
                pj.setStok(rs.getInt("stok"));
                list.add(pj);
            }


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        return list;

    }
//method untuk insert ke database

    public void insertdvd(Rental pj) {
        try {
            //Memecah tanggal yang tampilannya dd-mm-yyyy
            String thn=pj.getDdate().substring(6, 10);
            String bln=pj.getDdate().substring(3, 5);
            String tgl=pj.getDdate().substring(0, 2);
            
            String sql = "INSERT INTO dvd VALUES(?,?,?,?)";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getKodedvd());
            ps.setString(2, pj.getJudul());
            ps.setString(3, thn+"-"+bln+"-"+tgl);
            ps.setInt(4, pj.getStok());
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
    }
//method untuk update ke database

    public void updatedvd(String no, Rental pj) {
        try {
            String sql = "UPDATE dvd set judul=?, stok=? WHERE kodedvd=?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, pj.getJudul());
            ps.setInt(2, pj.getStok());
            ps.setString(3, no);
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
//method untuk pencarian

    public List<Rental> read(String no) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM dvd WHERE kodedvd like ? or judul like ?";
            list = new ArrayList<Rental>();
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, "%"+ no + "%");
            ps.setString(2, "%"+ no + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rental pj = new Rental();
                pj.setKodedvd(rs.getString("kodedvd"));
                pj.setJudul(rs.getString("judul"));
                pj.setStok(rs.getInt("stok"));
                list.add(pj);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kesalahan pada sintak : " + ex);
        }
        return list;
        
    }
}
