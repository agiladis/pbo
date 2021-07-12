
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agila
 */
public class ModelData {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db_inventaris_pbo";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;

    public ModelData() {
        try{
            Class.forName(JDBC_DRIVER); //memanggil library
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public String[][] readData(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][5]; //[baris, kolomnya ada 5]
            
            String query = "Select * from inventaris"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("kode_barang"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("nama_barang");                
                data[jmlData][2] = resultSet.getString("jumlah");
                data[jmlData][3] = resultSet.getString("harga_satuan");
                data[jmlData][4] = resultSet.getString("total_harga");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void insertData(String kode_barang, String nama_barang, int jumlah, int harga_satuan){
        int jmlData=0;
        //parse to double
        
        // Buat variabel nilai
        int total_harga = jumlah * harga_satuan;
        try {
        // Cek apakah data sudah ada berdasarkan judul
           String query = "SELECT * FROM inventaris WHERE kode_barang='" + kode_barang + "'"; 
           System.out.println(kode_barang + " " + nama_barang + " " + jumlah + " " + harga_satuan + " " + total_harga); // buat ngecek di command
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
            
            if (jmlData==0) {
                query = "INSERT INTO inventaris VALUES('"+kode_barang+"','"+nama_barang+"','"+jumlah+"','"+harga_satuan+"', '"+total_harga+"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateData(String kode_barang, String nama_barang, int jumlah, int harga_satuan){
        int jmlData=0;
         try {
           String query = "SELECT * FROM inventaris WHERE kode_barang='" + kode_barang + "'"; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                int total_harga = jumlah * harga_satuan;
                query = "UPDATE inventaris SET nama_barang='" + nama_barang + "', jumlah='" + jumlah + "', harga_satuan='" + harga_satuan + "', total_harga='" + total_harga + "' WHERE kode_barang='" + kode_barang + "'";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void deleteData (String kode_barang) {
        try{
            String query = "DELETE FROM inventaris WHERE kode_barang='"+kode_barang + "'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from inventaris";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
}
