/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javax.swing.*;
import java.awt.event.*;
import ruang3d.Balok;

/**
 *
 * @author xShido
 */
public class View extends JFrame implements ActionListener{
       JLabel title = new JLabel("KALKULATOR BALOK");
    
       JLabel lp = new JLabel("Panjang");
       JTextField fp = new JTextField(10);
       
       JLabel ll = new JLabel("Lebar");
       JTextField fl = new JTextField(10);
       
       JLabel lt = new JLabel("Tinggi");
       JTextField ft = new JTextField(10);
       
       JLabel hasil = new JLabel("HASIL :");
       
       JLabel lluas = new JLabel();
       JLabel lkeliling = new JLabel();
       JLabel lvolume = new JLabel();
       JLabel lluaspermukaan = new JLabel();
       
       JButton bhitung = new JButton("Hitung");
       JButton breset = new JButton("Reset");

       public View(){
           setTitle("Mengitung Balok");
           
           setSize( 500 ,  500 );
           setLayout(null);
           add(title);
           add(lp);
           add(fp);
           add(ll);
           add(fl);
           add(lt);
           add(ft);
           add(hasil);
           add(lluas);
           add(lkeliling);
           add(lvolume);
           add(lluaspermukaan);
           add(bhitung);
           add(breset);
           
           title.setBounds(170, 5, 150, 40);
           lp.setBounds(10,50,120,20);
           fp.setBounds(170,50,260,20);
           ll.setBounds(10,90,120,20);
           fl.setBounds(170,90,260,20);
           lt.setBounds(10,130,120,20);
           ft.setBounds(170,130,260,20);
           hasil.setBounds(170,170,120,20);
           lluas.setBounds(170,210,200,20);
           lkeliling.setBounds(170,235,200,20);
           lvolume.setBounds(170,285,200,20);
           lluaspermukaan.setBounds(170,260,200,20);
           bhitung.setBounds(150,430,100,20);
           breset.setBounds(260,430,100,20);
           
           setVisible(true);
           setDefaultCloseOperation(EXIT_ON_CLOSE);
           setLocationRelativeTo(null);
       
           bhitung.addActionListener(this);
           breset.addActionListener(this);
       }

 
       public void actionPerformed (ActionEvent e){
           int p, l, t;
           
           if(e.getSource() == bhitung){
               if(fp.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, "Kolom Panjang tidak boleh kosong!");
               } else if(fl.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, "Kolom Lebar tidak boleh kosong!");
               } else if(ft.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, "Kolom Tinggi tidak boleh kosong!");
               } else {
                    try{
                         p = Integer.parseInt(fp.getText());
                         l = Integer.parseInt(fl.getText());
                         t = Integer.parseInt(ft.getText());
                         Balok balok = new Balok(p, l, t);
                         lluas.setText("Luas Persegi Panjang = " + balok.luas());
                         lkeliling.setText("Keliling Persegi Panjang = " + balok.keliling());
                         lvolume.setText("Volume Balok = " + balok.volume());
                         lluaspermukaan.setText("Luas Permukaan = " + balok.luasPermukaan());
                     } catch(NumberFormatException err){
                         JOptionPane.showMessageDialog(this, "Masukkan angka bilangan bulat!");
                     }
               }
           }
           
           if(e.getSource() == breset){
               fp.setText("");
               fl.setText("");
               ft.setText("");
               lluas.setText("");
               lkeliling.setText("");
               lvolume.setText("");
               lluaspermukaan.setText("");
               
           }
        }
}
