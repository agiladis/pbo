/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agila
 */
public class CalonKaryawan implements Seleksi{

    int nik;
    double nilaiTulis, nilaiCoding, nilaiWawancara;
    String nama;

    public CalonKaryawan(int nik, String nama, double nilaiTulis, double nilaiCoding, double nilaiWawancara) {
        this.nik = nik;
        this.nilaiTulis = nilaiTulis;
        this.nilaiCoding = nilaiCoding;
        this.nilaiWawancara = nilaiWawancara;
        this.nama = nama;
    }
    
    @Override
    public double seleksiAndroidDev() {
        return ((nilaiTulis*0.2) + (nilaiCoding*0.5) + (nilaiWawancara*0.3));
//        if (nilaiTulis*0.2 + nilaiCoding*0.5 + nilaiWawancara*0.3 >= 85) {
//            System.out.println("KETERANGAN : LULUS");
//        } else {
//            System.out.println("KETERANGAN : GAGAL");
//        }
    }

    @Override
    public double seleksiWebDev() {
        return nilaiTulis*0.4 + nilaiCoding*0.35 + nilaiWawancara*0.25;
    }
    
}
