
import bidang2d.Lingkaran;
import java.util.Scanner;
import ruang3d.Kerucut;
import ruang3d.KerucutTerpancung;
import ruang3d.Tabung;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Agil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    // membuat scanner baru
    Scanner keyboard = new Scanner(System.in);
    
    public void menuLingkaran() {
        // Deklarasi variabel
        double radius;
        
        System.out.println(" ");
        System.out.println("========= Hitung Lingkaran =========");
        System.out.print("Jari-jari : ");
        radius = keyboard.nextDouble();
        
        // Instansiasi
        Lingkaran lingkaran = new Lingkaran(radius);
        
        System.out.println("Luas lingkaran     : " + lingkaran.hitungLuas());
        System.out.println("Keliling lingkaran : " + lingkaran.hitungKeliling());

        // Kembali ke menu
        System.out.println(" ");
        menu();
    }
    
    public void menuTabung() {
        // Deklarasi variabel
        int tinggi;
        double radius;
        
        System.out.println(" ");
        System.out.println("========= Hitung Tabung =========");
        System.out.print("Tinggi Tabung    : ");
        tinggi = keyboard.nextInt();
        System.out.print("Jari-jari Tabung : ");
        radius = keyboard.nextDouble();
        
        // Instansiasi
        Tabung tabung = new Tabung(tinggi, radius);
        
        System.out.println("Luas tabung     : " + tabung.hitungLuas());
        System.out.println("Keliling tabung : " + tabung.hitungVolume());

        // Kembali ke menu
        System.out.println(" ");
        menu();
    }
    
    public void kerucutUtuh() {
        // Deklarasi variabel
        int tinggi;
        double radius;
        
        System.out.println(" ");
        System.out.println("--------- Hitung Kerucut Utuh ---------");
        System.out.print("Tinggi Kerucut    : ");
        tinggi = keyboard.nextInt();
        System.out.print("Jari-jari Kerucut : ");
        radius = keyboard.nextDouble();
        
        // Instansiasi
        Kerucut kerucut = new Kerucut(tinggi, radius);
        
        System.out.println("Luas Kerucut          : " + kerucut.hitungLuas());
        System.out.println("Keliling alas Kerucut : " + kerucut.hitungKeliling());

        // Kembali ke menu
        System.out.println(" ");
        menu();
    }
    
    public void kerucutTerpancung() {
        // Deklarasi variabel
        int tinggi;
        double radiusBig, radiusSmall;
        
        System.out.println(" ");
        System.out.println("--------- Hitung Kerucut Terpancung ---------");
        System.out.print("Tinggi Kerucut          : ");
        tinggi = keyboard.nextInt();
        System.out.print("Jari-jari Besar Kerucut : ");
        radiusBig = keyboard.nextDouble();
        System.out.print("Jari-jari Kecil Kerucut : ");
        radiusSmall = keyboard.nextDouble();
        
        // Instansiasi
        Lingkaran kerucutTerpancung = new KerucutTerpancung(tinggi, radiusBig, radiusSmall);
        
        System.out.println("Luas selimut Kerucut terpancung : " + kerucutTerpancung.hitungLuas());
        System.out.println("Keliling alas Kerucut           : " + kerucutTerpancung.hitungKeliling(radiusBig));
        System.out.println("Keliling penutup Kerucut        : " + kerucutTerpancung.hitungKeliling(radiusSmall));

        // Kembali ke menu
        System.out.println(" ");
        menu();
    }
    public void menuKerucut() {
        // Deklarasi variabel
        int option;
        
        System.out.println(" ");
        System.out.println("========= Menu Kerucut =========");
        System.out.println("  1. Hitung Kerucut utuh");
        System.out.println("  2. Hitung Kerucut terpancung");
        System.out.println("  3. Kembali ke menu sebelumnya");
        System.out.print("  Pilih : ");
        option = keyboard.nextInt();
        
        switch(option) {
            case 1:
                kerucutUtuh();
                break;
            case 2:
                kerucutTerpancung();
                break;
            case 3:
                menu();
                break;
            default:
                System.out.println("pilihan yang kamu masukkan salah");
                menuKerucut();          
        }
    }
    
    public void menuBola() {
        // Deklarasi variabel
        int option;
        
        System.out.println(" ");
        System.out.println("========= Menu Bola =========");
        System.out.println("  1. Hitung Kerucut utuh");
        System.out.println("  2. Hitung Kerucut terpancung");
        System.out.println("  3. Kembali ke menu sebelumnya");
        System.out.print("  Pilih : ");
        option = keyboard.nextInt();
        
        switch(option) {
            case 1:
                kerucutUtuh();
                break;
            case 2:
                kerucutTerpancung();
                break;
            case 3:
                menu();
                break;
            default:
                System.out.println("pilihan yang kamu masukkan salah");
                menuKerucut();          
        }
    }
    
    public void keluar() {
        System.out.println("Good bye~~");
        System.exit(4);
    }
    
    public void menu() {
        int option;
        System.out.println("========= Menu =========");
        System.out.println("1. Lingkaran");
        System.out.println("2. Tabung");
        System.out.println("3. Kerucut");
        System.out.println("4. Bola");
        System.out.println("5. Keluar");
        System.out.print("Pilih : ");
        option = keyboard.nextInt();
        
        switch(option) {
            case 1:
                menuLingkaran();
                break;
            case 2:
                menuTabung();
                break;
            case 3:
                menuKerucut();
                break;
            case 4:
                menuBola();
                System.out.println("menu bola");
//                menuBola();
                break;
            case 5:
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
