/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLCB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author PC
 */
public class QLCB implements ICanbo{

    public Connection getcon() {
        
         
       Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=QLCB;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);  
//            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  conn;
     }
    
    public ArrayList<Canbo> getCB(){
        Connection con = getcon();
        String sql = "select * from tbCanbo";
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
        return cb;
    }
    @Override
    public void insertCB(Canbo cb) {
       Connection con = getcon();
       String sql = "insert into tbCanbo(SoTK,Hoten,GT,Diachi,Luong) values(?,?,?,?,?)";
       PreparedStatement ps = null;
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1, cb.getSoTK());
            ps.setString(2, cb.getHoten());
            ps.setString(3, cb.getGT());
            ps.setString(4, cb.getDiachi());
            ps.setDouble(5, cb.getLuong());
            int i = ps.executeUpdate();
            if(i>0){
                System.out.println("Them thanh cong");
            }
            else {
                System.out.println("Them khong thanh cong");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }
    public void deleteCB(String SoTK){
        Connection con = getcon();
        String sql = "delete from tbCanbo where SoTK=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, SoTK);
            ps.executeUpdate();
        } catch (Exception e) {
              System.out.println(e.getMessage());
        }
    }
    public void updateCB(Canbo cb){
        Connection con = getcon();
        String sql = "update tbCanbo set Hoten=?, GT=?,Diachi=?,Luong=? where SoTk=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(5, cb.getSoTK());
            ps.setString(1, cb.getHoten());
            ps.setString(2, cb.getGT());
            ps.setString(3, cb.getDiachi());
            ps.setDouble(4, cb.getLuong());
            ps.executeUpdate();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
    }
    public  ArrayList<Canbo> searchCB(String Sotk){
        Connection con = getcon();
        String sql ="select * from tbCanbo where soTK=?";
        ArrayList<Canbo> cb = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,Sotk );
            ResultSet rs = ps.executeQuery();
             while(rs.next()){
                Canbo canbo = new Canbo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
                cb.add(canbo);
            }
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
        return cb;
    }
    
    
}
