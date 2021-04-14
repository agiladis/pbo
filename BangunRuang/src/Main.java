
import bidang.Lingkaran;
import bidang.MenghitungBidang;
import bidang.PersegiPanjang;
import java.util.Scanner;
import ruang.Balok;
import ruang.Kerucut;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agila
 */
public class Main {
    // membuat scanner baru
    Scanner keyboard = new Scanner(System.in);
    
    public void hitungBalok() {
        // Deklarasi variabel
        double panjang, lebar, tBalok;
        
        System.out.println(" ");
        System.out.println("========= Hitung Balok =========");
        System.out.print("Panjang : ");
        panjang = keyboard.nextDouble();
        System.out.print("Lebar   : ");
        lebar = keyboard.nextDouble();
        System.out.print("Tinggi  : ");
        tBalok = keyboard.nextDouble();
        
        // Instansiasi
        PersegiPanjang persegiPanjang = new PersegiPanjang(panjang, lebar);
        Balok balok = new Balok(panjang, lebar, tBalok);
        
        System.out.println("Luas Persegi         : " + persegiPanjang.luas());
        System.out.println("Keliling Persegi     : " + persegiPanjang.keliling());
        System.out.println("Volume Balok         : " + balok.volume());
        System.out.println("Luas Permukaan Balok : " + balok.luasPermukaan());
        
        // Kembali ke menu
        System.out.println(" ");
        menu();
    }
    
    public void hitungKerucut() {
        // Deklarasi variabel
        double radius, tKerucut;
        
        System.out.println(" ");
        System.out.println("========= Hitung Kerucut =========");
        System.out.print("Jari-Jari : ");
        radius = keyboard.nextDouble();
        System.out.print("Tinggi    : ");
        tKerucut = keyboard.nextDouble();

        // Instansiasi
        Lingkaran lingkaran = new Lingkaran(radius);
        Kerucut kerucut = new Kerucut(tKerucut, radius);
        
        System.out.println("Luas Lingkaran         : " + lingkaran.luas());
        System.out.println("Keliling Lingkaran     : " + lingkaran.keliling());
        System.out.println("Volume Kerucut         : " + kerucut.volume());
        System.out.println("Luas Permukaan Kerucut : " + kerucut.luasPermukaan());
        
        // Kembali ke menu
        System.out.println(" ");
        menu();
    }
    
    public void keluar() {
        System.out.println("Good bye~~");
        System.exit(4);
    }
    
    public void menu() {
        int option;
        System.out.println("========= Menu =========");
        System.out.println("1. Hitung Balok");
        System.out.println("2. Hitung Kerucut");
        System.out.println("3. Keluar");
        System.out.print("Pilih : ");
        option = keyboard.nextInt();
        
        switch(option) {
            case 1:
                hitungBalok();
                break;
            case 2:
                hitungKerucut();
                break;
            case 3:
                keluar();
                break;
            default:
                System.out.println("pilihan yang kamu masukkan salah");
                menu();          
        }
    }
    
    public static void main(String[] args) {
        // Instansiasi
        Main program = new Main();
        program.menu();
    }
}
