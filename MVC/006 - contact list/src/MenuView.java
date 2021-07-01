
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Orenji
 */
public class MenuView extends JFrame{
    JButton btnLihat = new JButton("Lihat Kontak");
    JButton btnInput = new JButton("Tambah Kontak");
    // JLabel background = new JLabel();

    public MenuView() {
        setTitle("Data Kontak");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(300,400);
        
        // background.setIcon();
        
        add(btnLihat);
        btnLihat.setBounds(60, 170, 150, 20);
    }
}
