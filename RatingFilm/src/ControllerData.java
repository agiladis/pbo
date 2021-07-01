
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
            String dataKontak[][] = model.readData();
            view.tabel.setModel((new JTable(dataKontak, view.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        // Ketika btn tambah ditekan
        view.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = view.getJudul();
                double alur = view.getAlur();
                double penokohan = view.getPenokohan();
                double akting = view.getAkting();
                
                model.insertData(judul, alur, penokohan, akting);
         
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

//                String dataterpilih = (String) view.tabel.getValueAt(baris, 0); // Karena primary kita judul yg beraada pada kolom 1 maka pada array 0
                String rowJudul = (String) view.tabel.getValueAt(baris, 0); // kolom 0 = Judul
                String rowAlur = (String) view.tabel.getValueAt(baris, 1); // kolom 1 = Alur
                String rowPenokohan = (String) view.tabel.getValueAt(baris, 2); // kolom 1 = Penokohan
                String rowAkting = (String) view.tabel.getValueAt(baris, 3); // kolom 1 = Akting

                System.out.println(rowJudul);

                // Menampilkan pada kolom form setelah diklik
                view.setJudul(rowJudul, false);
                view.setAlur(rowAlur);
                view.setPenokohan(rowPenokohan);
                view.setAkting(rowAkting);
 
                // Ketika sudah dipilih data dan ditekan tombol delete
                view.btnDelete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        // Dialog memastikan data akan dihapus
                        int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus Film berjudul " + rowJudul + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);
                        
                        if (input == 0) {
                            model.deleteData(rowJudul);
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
                        String judul = view.getJudul();
                        double alur = view.getAlur();
                        double penokohan = view.getPenokohan();
                        double akting = view.getAkting();
                        model.updateData(judul, alur, penokohan, akting);

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
