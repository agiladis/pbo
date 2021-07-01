
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
    JLabel lJudul = new JLabel("Judul");
    JLabel lAlur = new JLabel("Alur");
    JLabel lPenokohan = new JLabel("Penokohan");
    JLabel lAkting = new JLabel("Akting");
    
    JTextField tfJudul = new JTextField();
    JTextField tfAlur = new JTextField();
    JTextField tfPenokohan = new JTextField();
    JTextField tfAkting = new JTextField();
    
    JButton btnAdd = new JButton("Add Film");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnReset = new JButton("Reset");
    
    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Judul", "Alur", "Penokohan", "Akting", "Rating"};
    
    public ViewData() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Kontak");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(700,400);
        setLocationRelativeTo(null);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(lJudul);
        lJudul.setBounds(510, 20, 90, 20);
        add(tfJudul);
        tfJudul.setBounds(510, 40, 120, 20);
        
        add(lAlur);
        lAlur.setBounds(510, 60, 90, 20);
        add(tfAlur);
        tfAlur.setBounds(510, 80, 120, 20);
        
        add(lPenokohan);
        lPenokohan.setBounds(510, 100, 90, 20);
        add(tfPenokohan);
        tfPenokohan.setBounds(510, 120, 120, 20);
        
        add(lAkting);
        lAkting.setBounds(510, 140, 90, 20);
        add(tfAkting);
        tfAkting.setBounds(510, 160, 120, 20);
        
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
    
    public String getJudul(){
        return tfJudul.getText();
    }
    
    public void setJudul(String judul, boolean visibility) {
        tfJudul.setText(judul);
        tfJudul.setEditable(visibility);
    }
    
    public double getAlur(){
        return Double.parseDouble(tfAlur.getText()); // mengambil string lalu di parse menjadi double
    }
    
    public void setAlur(String alur) {
        tfAlur.setText(alur);
    }
    
    public double getPenokohan(){
        return Double.parseDouble(tfPenokohan.getText()); // mengambil string lalu di parse menjadi double
    }
    
    public void setPenokohan(String penokohan) {
        tfPenokohan.setText(penokohan);
    }
    
    public double getAkting(){
        return Double.parseDouble(tfAkting.getText()); // mengambil string lalu di parse menjadi double
    }
    
    public void setAkting(String akting) {
        tfAkting.setText(akting);
    }

   public void setEmptyField() {
        setJudul("", true);
        setAlur("");
        setPenokohan("");
        setAkting("");
   }
   
   public void visibiltyBtnUpdateDelete(boolean vis) {
        btnUpdate.setEnabled(vis);
        btnDelete.setEnabled(vis);
   }
}
