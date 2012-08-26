/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Rental;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author habibi dan riska
 */
//berguna untuk menampung data dari database terus ditampilkan ke tabel
public class TabelHistory extends AbstractTableModel {

    List<Rental> list;

    public TabelHistory(List<Rental> list) {
        this.list = list;
    }

    public Rental get(int row) {
        return list.get(row);
    }
    //mendapatkan jumlah baris

    public int getRowCount() {
        return list.size();
    }
    //mendapatkan jumlah kolom

    public int getColumnCount() {
        return 8;
    }
    //mendapatkan no dan nama

    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getKode1();
            case 1:
                return list.get(rowIndex).getKodepeg();
            case 2:
                return list.get(rowIndex).getTgltrans();
            case 3:
                return list.get(rowIndex).getJmldvd();
            case 4:
                return list.get(rowIndex).getTotal();
            case 5:
                return list.get(rowIndex).getKodepem();
            case 6:
                return list.get(rowIndex).getTglkbl();
            case 7:
                return list.get(rowIndex).getDenda();

            default:
                return null;

        }
    }
    //untuk memberi nama kolom di tabel

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Member / Kode DVD";
            case 1:
                return "Petugas Pelaksana";
            case 2:
                return "Tgl Transaksi";
            case 3:
                return "Jml Dipinjam";
            case 4:
                return "Total Trans";
            case 5:
                return "Petugas Pengembalian";
            case 6:
                return "Tgl Pengembalian";
            case 7:
                return "Denda";
            default:
                return null;

        }

    }
}
