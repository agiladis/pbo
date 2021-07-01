/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruang3d;
import bidang2d.PersegiPanjang;

/**
 *
 * @author xShido
 */
public class Balok extends PersegiPanjang implements MenghitungRuang{
    private int t;

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public Balok(int p, int l, int t) {
        super(p, l);
        this.t = t;
    }
    @Override
    public double volume() {
        return this.luas()*this.t;
    }

    @Override
    public double luasPermukaan() {
        int panjang = this.p;
        int lebar = this.l;
        int tinggi = this.t;
        return 2*(this.luas()+(panjang*tinggi)+(tinggi*lebar));
    }
   
    
}
