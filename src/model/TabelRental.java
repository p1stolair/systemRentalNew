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
public class TabelRental extends AbstractTableModel {

    List<Rental> list;

    public TabelRental(List<Rental> list) {
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
        return 5;
    }
    //mendapatkan no dan nama

    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getKodedvd();
            case 1:
                return list.get(rowIndex).getJudul();
            case 2:
                return list.get(rowIndex).getGenre();
            case 3:
                return list.get(rowIndex).getStatus();
            case 4:
                return list.get(rowIndex).getStok();
            default:
                return null;

        }
    }
    //untuk memberi nama kolom di tabel

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode DVD";
            case 1:
                return "Judul";
            case 2:
                return "Genre";
            case 3:
                return "Status";
            case 4:
                return "Stok";
            default:
                return null;

        }

    }
}
