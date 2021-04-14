/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bidang;

import static ruang.MenghitungRuang.PHI;

/**
 *
 * @author agila
 */
public class Lingkaran implements MenghitungBidang{
    public double jari_jari;

    public Lingkaran(double jari_jari) {
        this.jari_jari = jari_jari;
    }
    
    @Override
    public double luas() {
        return PHI * jari_jari * jari_jari;
    }

    @Override
    public double keliling() {
        return (2 * PHI * jari_jari);
    }

    
    
}
