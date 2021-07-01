/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruang3d;

import bidang2d.Lingkaran;

/**
 *
 * @author ASUS
 */
public class Tabung extends Lingkaran{
    int tinggi;

    public Tabung(int tinggi, double r) {
        super(r);
        this.tinggi = tinggi;
    }
    
//    keliling lingkaran*tinggi + luas lingkaran * 2
    public double hitungLuas(){
        return (double) super.hitungKeliling() * tinggi + 2 * super.hitungLuas();
    }
    
    public double hitungVolume(){
        return (double) super.hitungLuas() * tinggi;
    }
}
