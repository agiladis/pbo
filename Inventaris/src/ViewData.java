
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agila
 */
public class ViewData extends JFrame {
    JLabel lKode = new JLabel("Kode");
    JLabel lNama = new JLabel("Nama");
    JLabel lJumlah = new JLabel("Jumlah");
    JLabel lHarga = new JLabel("Harga");
    
    JTextField tfKode = new JTextField();
    JTextField tfNama = new JTextField();
    JTextField tfJumlah = new JTextField();
    JTextField tfHarga = new JTextField();
    
    JButton btnAdd = new JButton("Add Iventaris");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnReset = new JButton("Reset");
    
    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Kode", "Nama Barang", "Jumlah", "Satuan", "Total Harga"};
    
    public ViewData() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Inventaris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(700,400);
        setLocationRelativeTo(null);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(lKode);
        lKode.setBounds(510, 20, 90, 20);
        add(tfKode);
        tfKode.setBounds(510, 40, 120, 20);
        
        add(lNama);
        lNama.setBounds(510, 60, 90, 20);
        add(tfNama);
        tfNama.setBounds(510, 80, 120, 20);
        
        add(lJumlah);
        lJumlah.setBounds(510, 100, 90, 20);
        add(tfJumlah);
        tfJumlah.setBounds(510, 120, 120, 20);
        
        add(lHarga);
        lHarga.setBounds(510, 140, 90, 20);
        add(tfHarga);
        tfHarga.setBounds(510, 160, 120, 20);
        
        add(btnAdd);
        btnAdd.setBounds(510, 190, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(510, 220, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(510, 250, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(510, 280, 90, 20);
        
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    
    public String getKode(){
        return tfKode.getText();
    }
    
    public void setKode(String kode_barang, boolean visibility) {
        tfKode.setText(kode_barang);
        tfKode.setEditable(visibility);
    }
    
    public String getNama(){
//        return Double.parseDouble(tfNama.getText()); // mengambil string lalu di parse menjadi int
        return tfNama.getText();
    }
    
    public void setNama(String alur) {
        tfNama.setText(alur);
    }
    
    public int getJumlah(){
        return Integer.parseInt(tfJumlah.getText()); // mengambil string lalu di parse menjadi int
    }
    
    public void setJumlah(String penokohan) {
        tfJumlah.setText(penokohan);
    }
    
    public int getHarga(){
        return Integer.parseInt(tfHarga.getText()); // mengambil string lalu di parse menjadi int
    }
    
    public void setHarga(String akting) {
        tfHarga.setText(akting);
    }

   public void setEmptyField() {
        setKode("", true);
        setNama("");
        setJumlah("");
        setHarga("");
   }
   
   public void visibiltyBtnUpdateDelete(boolean vis) {
        btnUpdate.setEnabled(vis);
        btnDelete.setEnabled(vis);
   }
}
