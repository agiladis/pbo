/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruang3d;

import bidang2d.Lingkaran;
import static java.lang.Math.sqrt;

/**
 *
 * @author ASUS
 */
public class Kerucut extends Lingkaran{
    int tinggi;
    
    public Kerucut(int tinggi, double r) {
        super(r);
        this.tinggi = tinggi;
    }
    
//  Ditambahkan untuk menghitung garis pelukis jika diketahui tinggi dan jari jari
    double Apotema() {
         return sqrt((r * r) + (tinggi * tinggi));
     }
    
//  Luas alas + luas selimut => pi.r.r + pi.r.s
    @Override
    public double hitungLuas() {
        return (double) Math.PI*r*r + Math.PI*r*Apotema();
    }
    
    // HARUSNYA TANPA MENULIS ULANG HITUNG KELILING BISA DIPANGGIL.
//    public double hitungKeliling(){
//        return (double) super.hitungKeliling();
//    }
    
}
