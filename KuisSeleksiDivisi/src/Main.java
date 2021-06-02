
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
    
    int nik;
    double nt, nc, nw;
    String nm;
    
    public void formandroid() {
        System.out.print("Input NIK : ");
        nik = keyboard.nextInt();
        System.out.print("Input Nama : ");
        nm = keyboard.next();
        System.out.print("Input Nilai tulis : ");
        nt = keyboard.nextDouble();
        System.out.print("Input Nilai coding : ");
        nc = keyboard.nextDouble();
        System.out.print("Input Nilai wawancara : ");
        nt = keyboard.nextDouble();
        
        // Instansiasi
        CalonKaryawan calonkaryawan = new CalonKaryawan(nik, nm, nt, nc, nw);
        
        System.out.println("KETERANGAN : " + calonkaryawan.seleksiAndroidDev());
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
        
        switch(option) {
            case 1:
//                // Instansiasi
//                Form form = new Form(1);
//                
//                System.out.println("Divisi yang kamu pilih adalah " + form.jenisDivisi(1));
                formandroid();
                break;
            case 2:
                System.out.println("Form Web");
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
