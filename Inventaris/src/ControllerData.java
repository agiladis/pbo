
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agila
 */
public class ControllerData {
    ViewData view;
    ModelData model;

    public ControllerData(ViewData view, ModelData model) {
        this.view = view;
        this.model = model;
        
        if (model.getBanyakData()!=0) {
            String dataInventaris[][] = model.readData();
            view.tabel.setModel((new JTable(dataInventaris, view.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        // Ketika btn tambah ditekan
        view.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kode_barang = view.getKode();
                String nama_barang = view.getNama();
                int jumlah = view.getJumlah();
                int harga_satuan = view.getHarga();
                
                model.insertData(kode_barang, nama_barang, jumlah, harga_satuan);
         
                view.setEmptyField();
                String data[][] = model.readData();
                view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
            }
        });
        
        // Ketika baris tertentu dipilih
        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = view.tabel.getSelectedRow();
                
                //Jika ada data yg dipilih 
                view.visibiltyBtnUpdateDelete(true);

//                String dataterpilih = (String) view.tabel.getValueAt(baris, 0); // Karena primary kita kode yg beraada pada kolom 1 maka pada array 0
                String rowKode = (String) view.tabel.getValueAt(baris, 0); // kolom 0 = Kode
                String rowNama = (String) view.tabel.getValueAt(baris, 1); // kolom 1 = Nama
                String rowJumlah = (String) view.tabel.getValueAt(baris, 2); // kolom 1 = Jumlah
                String rowHarga = (String) view.tabel.getValueAt(baris, 3); // kolom 1 = Harga

                System.out.println(rowKode);

                // Menampilkan pada kolom form setelah diklik
                view.setKode(rowKode, false);
                view.setNama(rowNama);
                view.setJumlah(rowJumlah);
                view.setHarga(rowHarga);
 
                // Ketika sudah dipilih data dan ditekan tombol delete
                view.btnDelete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        // Dialog memastikan data akan dihapus
                        int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus Barang" + rowKode + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);
                        
                        if (input == 0) {
                            model.deleteData(rowKode);
                            String data[][] = model.readData();
                            view.tabel.setModel(new JTable(data, view.namaKolom).getModel());
                        } else {
                            JOptionPane.showMessageDialog(null, "Batal Dihapus");
                        }
                    }
                });
                
                // Ketika btn update ditekan
                view.btnUpdate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String kode_barang = view.getKode();
                        String nama_barang = view.getNama();
                        int jumlah = view.getJumlah();
                        int harga_satuan = view.getHarga();
                        
                        model.updateData(kode_barang, nama_barang, jumlah, harga_satuan);

                        String data[][] = model.readData();
                        view.setEmptyField();
                        view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
                    }
                });
            }
        });
        
        view.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setEmptyField();
                view.visibiltyBtnUpdateDelete(false);
            }
        });
    } 
}
