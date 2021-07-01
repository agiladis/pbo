/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bidang2d;

/**
 *
 * @author xShido
 */
public class PersegiPanjang implements MenghitungBidang{
    protected int p, l;

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public PersegiPanjang(int p, int l) {
        this.p = p;
        this.l = l;
    }

    @Override
    public double luas() {
        return this.p*this.l;
    }

    @Override
    public double keliling() {
       return 2*(this.p+this.l);
    }
}
