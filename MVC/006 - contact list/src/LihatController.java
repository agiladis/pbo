
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
 * @author Orenji
 */
public class LihatController {

    LihatModel lihatModell;
    LihatView lihatVieww;
    
    public LihatController(LihatView lihatView, LihatModel lihatModel) {
        this.lihatModell = lihatModel;
        this.lihatVieww = lihatView;
        
        if (lihatModell.getBanyakData()!=0) {
            String dataKontak[][] = lihatModell.readContact();
            lihatVieww.tabel.setModel((new JTable(dataKontak, lihatVieww.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        lihatVieww.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = lihatVieww.getNama();
                String NoHp = lihatVieww.getNoHp();
                String Umur = lihatVieww.getUmur();
                String Email = lihatVieww.getEmail();
                lihatModell.insertData(Nama, NoHp, Umur, Email);
         
                String dataKontak[][] = lihatModell.readContact();
                lihatVieww.tabel.setModel((new JTable(dataKontak, lihatVieww.namaKolom)).getModel());
            }
        });
        
        lihatVieww.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = lihatVieww.getNama();
                String NoHp = lihatVieww.getNoHp();
                String Umur = lihatVieww.getUmur();
                String Email = lihatVieww.getEmail();
                lihatModell.updateContact(Nama, NoHp, Umur, Email);
                
                String dataKontak[][] = lihatModell.readContact();
                lihatVieww.tabel.setModel((new JTable(dataKontak, lihatVieww.namaKolom)).getModel());
            }
        });
        
        lihatVieww.btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = lihatVieww.getCariNama();
                
                if (Nama.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Kosong");
                }
                else {
                    String dataKontak[][] = lihatModell.cariContact(Nama);
                    lihatVieww.tabel.setModel((new JTable(dataKontak, lihatVieww.namaKolom)).getModel());
                }
                
            }
        });
        
        lihatVieww.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataKontak[][] = lihatModell.readContact();
                lihatVieww.tabel.setModel((new JTable(dataKontak, lihatVieww.namaKolom)).getModel());
            }
        });
        
       
        lihatVieww.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = lihatVieww.tabel.getSelectedRow();
                int kolom = lihatVieww.tabel.getSelectedColumn(); // ga kepake sekarang

                String dataterpilih = lihatVieww.tabel.getValueAt(baris, 1).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus NoHp " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);
                System.out.println("input : " + input);

                if (input == 0) {
                    lihatModell.deleteContact(dataterpilih);
                    String dataKontak[][] = lihatModell.readContact();
                    lihatVieww.tabel.setModel(new JTable(dataKontak, lihatVieww.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        }
        );
    }
}
