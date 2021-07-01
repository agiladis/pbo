/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bidang2d;

/**
 *
 * @author ASUS
 */
public class Lingkaran implements Bidang2D{
//    diberi public agar dapat diakses oleh kerucut
    public double r;

    public Lingkaran(double r) {
        this.r = r;
    }

    @Override
    public double hitungKeliling() {
       return (double) (Math.PI*2*r);
    }

    @Override
    public double hitungLuas() {
        return (double) (Math.PI*r*r);
    }

//    Overload untuk digunakan pada saat menghitung keliling kerucut terpancung
    public double hitungKeliling(double r) {
        return (double) (Math.PI*2*r);
    }
}
