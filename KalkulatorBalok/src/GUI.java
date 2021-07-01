
import java.awt.event.*;
import javax.swing.*;
import ruang3d.Balok;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agila
 */
public class GUI extends JFrame implements ActionListener {
    JLabel lnamaprogram = new JLabel("HITUNG BALOK");
    JLabel lsatuan1 = new JLabel("cm");
    JLabel lsatuan2 = new JLabel("cm");
    JLabel lsatuan3 = new JLabel("cm");
    
    JLabel lpanjang = new JLabel("Panjang");
    final JTextField fpanjang = new JTextField(10);
    
    JLabel llebar = new JLabel("Lebar");
    final JTextField flebar = new JTextField(10);
    
    JLabel ltinggi = new JLabel("Tinggi");
    final JTextField ftinggi = new JTextField(10);
    
    JLabel lhasil = new JLabel("HASIL :");
    
    JLabel hasilluas = new JLabel();
    JLabel hasilkeliling = new JLabel();
    JLabel hasilvolume = new JLabel();
    JLabel hasilluaspermukaan = new JLabel();
    
    JButton btnhitung = new JButton("Hitung");
    JButton btnreset = new JButton("Reset");
    
    public GUI()
    {
        setTitle("Kalkulator Balok");
        setSize(300, 600);
        
        setLayout(null);
        
        add(lnamaprogram);
        add(lpanjang);
        add(fpanjang);
        add(lsatuan1);
        add(llebar);
        add(flebar);
        add(lsatuan2);
        add(ltinggi);
        add(ftinggi);
        add(lsatuan3);
        add(lhasil);
        add(hasilluas);
        add(hasilkeliling);
        add(hasilvolume);
        add(hasilluaspermukaan);
        add(lhasil);
        add(btnhitung);
        add(btnreset);
        
        // setBound untuk tata letak
        lnamaprogram.setBounds(10, 10, 120, 20);
        lpanjang.setBounds(10, 50, 100, 20);
        fpanjang.setBounds(120, 50, 100, 20);
        lsatuan1.setBounds(225, 50, 30, 20);
        llebar.setBounds(10, 75, 100, 20);
        flebar.setBounds(120, 75, 100, 20);
        lsatuan2.setBounds(225, 75, 30, 20);
        ltinggi.setBounds(10, 100, 100, 20);
        ftinggi.setBounds(120, 100, 100, 20);
        lsatuan3.setBounds(225, 100, 30, 20);
        lhasil.setBounds(125, 135, 50, 20);
        hasilluas.setBounds(10, 165, 290, 20);
        hasilkeliling.setBounds(10, 185, 290, 20);
        hasilvolume.setBounds(10, 205, 290, 20);
        hasilluaspermukaan.setBounds(10, 225, 290, 20);
        btnhitung.setBounds(65, 275, 80, 20);
        btnreset.setBounds(155, 275, 80, 20);
        //Menampilkan
        setVisible(true);
        //Agar dapat close
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // event listeer pada btn save
        btnhitung.addActionListener(this);
        btnreset.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        int valpanjang, vallebar, valtinggi;
        if(e.getSource() == btnhitung) 
        {       
            if(fpanjang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Kolom Panjang tidak boleh kosong!");
            } else if(flebar.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Kolom Lebar tidak boleh kosong!");
            } else if(ftinggi.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Kolom Tinggi tidak boleh kosong!");
            } else {
                try {
                    valpanjang = Integer.parseInt(fpanjang.getText());
                    vallebar = Integer.parseInt(flebar.getText());
                    valtinggi = Integer.parseInt(ftinggi.getText());
                    Balok balok = new Balok (valpanjang, vallebar, valtinggi);
                    hasilluas.setText("Luas Persegi panjang       : " + balok.luas() + "cm2");
                    hasilkeliling.setText("Keliling Persegi Panjang  : " + balok.keliling() + "cm2");
                    hasilvolume.setText("Volume Balok                      : " + balok.volume() + "cm3");
                    hasilluaspermukaan.setText("Luas Permukaan                : " + balok.luasPermukaan() + "cm2");
                }catch(NumberFormatException err) {
                    JOptionPane.showMessageDialog(this, "Masukkan angka bilangan bulat!");
                }
            }
        }
        
        if(e.getSource() == btnreset){
            fpanjang.setText("");
            flebar.setText("");
            ftinggi.setText("");
            hasilluas.setText("");
            hasilkeliling.setText("");
            hasilvolume.setText("");
            hasilluaspermukaan.setText("");
        }
    }
}
