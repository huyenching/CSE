/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlcb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class XLDL implements ICanbo{
     public Connection getConn(){
        Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=QLCB;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);  
//            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
     public ArrayList<Canbo> getCB(){
         Connection con = getConn();
         String sql = "Select * from tbCanbo";
         ArrayList<Canbo> cb = new ArrayList<>();
         try {
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 Canbo canbo = new Canbo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
                 cb.add(canbo);
             }
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         return  cb;
     }
     public void insertCB(Canbo cb){
         Connection con = getConn();
         String sql = "insert into tbCanbo(SoTK, Hoten,GT,Diachi,Luong) values(?,?,?,?,?)";
         PreparedStatement ps = null;
         try {
             ps = con.prepareStatement(sql);
             ps.setString(1, cb.getSoTK());
             ps.setString(2, cb.getHoten());
             ps.setString(3, cb.getGT());
             ps.setString(4, cb.getDiachi());
             ps.setDouble(5, cb.getLuong());
            int a= ps.executeUpdate();
            if(a>0){
                System.out.println("Thêm thành công!");
            }else{
                System.out.println("Thêm không thành công");
            }
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
     }
     public ArrayList<Canbo> SearchCB(String SoTK){
         Connection conn = getConn();
         String sql = "Select * from tbCanbo where SoTK = ?";
         ArrayList<Canbo> cb = new ArrayList<>();
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1,SoTK);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 Canbo canbo = new Canbo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
                 cb.add(canbo);
             }
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         return  cb;
     }
    public void deleteCB(String Sotk){
         Connection con = getConn();
         String sql = "delete from tbCanbo where SoTK =?";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, Sotk);
             ps.executeUpdate();
         } catch (Exception e) {
             System.out.println(e.getMessage());
             e.printStackTrace();
         }
     }
     public void UpdateCB(Canbo cb){
         Connection con = getConn();
         String sql = "Update tbCanbo set Hoten = ?,GT=?, Diachi =? ,Luong =? where SoTK =?";
         PreparedStatement ps = null;
         try {
             ps = con.prepareStatement(sql);
             ps.setString(1, cb.getHoten());
             ps.setString(2, cb.getGT());
             ps.setString(3, cb.getDiachi());
             ps.setDouble(4, cb.getLuong());
             ps.setString(5, cb.getSoTK());
             ps.executeUpdate();
            
         } catch (Exception e) {
              System.out.println(e.getMessage());
              e.printStackTrace();
         }
    }

   
}
