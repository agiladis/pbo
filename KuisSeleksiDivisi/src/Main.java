
import java.util.Scanner;

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
    Scanner keyboard = new Scanner(System.in);
    
    boolean edit;
    int nik, divisi;
    double nt, nc, nw;
    String nm;
    
    public void subMenu() {
        int pilih;
        
        System.out.println(" ");
        System.out.println("MENU");
        System.out.println("1. Edit");
        System.out.println("2. Tampil");
        System.out.println("3. Exit");
        System.out.print("Pilih : ");
        pilih = keyboard.nextInt();
        
        if (pilih == 1) {
            formAndroid(true);
        } else if (pilih == 2) {
            hitungNilai();
        } else {
            keluar();
        }
    }
    
    public void hitungNilai() {
        // Instansiasi
                CalonKaryawan calonkaryawan = new CalonKaryawan(nik, nm, nt, nc, nw);
                if(divisi == 1) {
                    System.out.println("Nilai Akhir : " + calonkaryawan.seleksiAndroidDev());
                    if (calonkaryawan.seleksiAndroidDev() >= 85) {
                        System.out.println("KETERANGAN : LULUS");
                        System.out.println("Selamat kepada "+ nm + " diterima untuk posisi Android");
                    } else {
                        System.out.println("KETERANGAN : GAGAL");
                        System.out.println("Mohon maaf kepada "+ nm + " ditolak untuk posisi Android");
                    }
                } else {
                    System.out.println("Nilai Akhir : " + calonkaryawan.seleksiWebDev());
                    if (calonkaryawan.seleksiWebDev()>= 85) {
                        System.out.println("KETERANGAN : LULUS");
                        System.out.println("Selamat kepada "+ nm + " diterima untuk posisi Web");
                    } else {
                        System.out.println("KETERANGAN : GAGAL");
                        System.out.println("Mohon maaf kepada "+ nm + " ditolak untuk posisi Web");
                    }
                }
                subMenu();
    }
    
    public void formAndroid() {
        System.out.print("Input Nilai tulis : ");
        nt = keyboard.nextDouble();
        System.out.print("Input Nilai coding : ");
        nc = keyboard.nextDouble();
        System.out.print("Input Nilai wawancara : ");
        nw = keyboard.nextDouble();
        
        subMenu();
    }
    
    public void formAndroid(boolean edit) {
        System.out.println(" ");
        System.out.println("FORM EDIT");
        System.out.print("Input Nilai tulis : ");
        nt = keyboard.nextDouble();
        System.out.print("Input Nilai coding : ");
        nc = keyboard.nextDouble();
        System.out.print("Input Nilai wawancara : ");
        nw = keyboard.nextDouble();
        
        subMenu();
    }
    
    public void keluar() {
        System.out.println("Good bye~~");
        System.exit(4);
    }
    
    public void menu() {
        int option;
        System.out.println("========= MENU PENDAFTARAN =========");
        System.out.println("1. Android Development");
        System.out.println("2. Web Development");
        System.out.println("3. Keluar");
        System.out.print("Pilih Jenis Form : ");
        option = keyboard.nextInt();
        System.out.println(" ");
        System.out.print("Input NIK : ");
        nik = keyboard.nextInt();
        System.out.print("Input Nama : ");
        nm = keyboard.next();
        divisi = option;
        
        switch(option) {
            case 1:
                formAndroid();
                break;
            case 2:
                formAndroid();
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
