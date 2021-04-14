/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruang;

import bidang.Lingkaran;
import static java.lang.Math.sqrt;

/**
 *
 * @author agila
 */
public class Kerucut extends Lingkaran implements MenghitungRuang {
     double tinggi;
     
     double Apotema() {
         return sqrt((jari_jari * jari_jari) + (tinggi * tinggi));
     }

    public Kerucut(double tinggi, double jari_jari) {
        super(jari_jari);
        this.tinggi = tinggi;
    }
     
    @Override
    public double luasPermukaan() {
        return (PHI * jari_jari * (jari_jari + Apotema()));
    }

    @Override
    public double volume() {
        return (PHI * jari_jari * jari_jari * tinggi)/3;
    }
}
