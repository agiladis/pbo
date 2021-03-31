/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agila
 */
// mengimpor Scanner ke program
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // deklarasi variabel
        String name;
        int age, midtermScore, finalExamScore, registNumber, option;

        // membuat scanner baru
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("========= Input Data Mahasiswa =========");
        System.out.print("Nama : ");
        name = keyboard.nextLine();
        System.out.print("NIM  : ");
        registNumber = keyboard.nextInt();
        System.out.print("Usia : ");
        age = keyboard.nextInt();
        System.out.print("UTS  : ");
        midtermScore = keyboard.nextInt();
        System.out.print("UAS  : ");
        finalExamScore = keyboard.nextInt();
        
        // Instansiasi
        Mahasiswa mhs = new Mahasiswa(name, registNumber, age, midtermScore, finalExamScore);
        
        System.out.println("========= Opsi =========");
        System.out.println("1. Tampil Data");
        System.out.println("2. Edit Data");
        System.out.println("3. Exit");
        System.out.print("Pilih : ");
        option = keyboard.nextInt();

        switch(option) {
            case 1:
                mhs.showData();
                break;
                
            case 2:
                System.out.println("Balik ke menu");
                break;
                
            default:
                System.out.println("Anda keluar!");
        }
    }
}
