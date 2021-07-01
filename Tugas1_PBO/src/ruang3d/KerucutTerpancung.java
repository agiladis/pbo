/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruang3d;

import static java.lang.Math.sqrt;

/**
 *
 * @author ASUS
 */
public class KerucutTerpancung extends Kerucut{
    double r2;
    
    public KerucutTerpancung(int tinggi, double r) {
        super(tinggi, r);
    }
    
//    OVERLOAD
    public KerucutTerpancung(int tinggi, double r, double r2) {
        super(tinggi, r);
        this.r2 = r2;
    }
    
    @Override
    double Apotema() {
         return sqrt((tinggi * tinggi) + (r - r2)*(r - r2));
     }
    
//    π. α (r + R)
    @Override
    public double hitungLuas() {
        return (double) Math.PI*Apotema()*(r+r2);
    }
}
