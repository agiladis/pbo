/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agila
 */
public class Mahasiswa {
    String name;
    float midtermScore, finalExamScore;
    int age, registNumber;
    
    public Mahasiswa(String name, int registNumber, int age, int midtermScore, int finalExamScore) {
        this.name = name;
        this.registNumber = registNumber;
        this.age = age;
        this.midtermScore = midtermScore;
        this.finalExamScore = finalExamScore;
    }
    
    public Mahasiswa() {
    
    }
    
    float averageScore() {
        return (this.midtermScore + this.finalExamScore)/2;
    }
    
    void showData() {
        System.out.println("Perkenalkan Saya " + this.name + ", NIM " + this.registNumber + ",");
        System.out.println("Usia         : " + this.age + " tahun");
        System.out.println("Nilai Akhir  : " + averageScore());
    }
}
