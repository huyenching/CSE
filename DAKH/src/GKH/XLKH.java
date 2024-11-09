/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GKH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class XLKH implements  IKhachHang{

   
  
    @Override
    public Connection getCon() {
       Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=DLKH;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);  
//            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  conn;
    }
    public ArrayList<Khachhang> getKH(){
        Connection con = getCon();
        String sql = "select * from tbKH";
        ArrayList<Khachhang> kh = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Khachhang khachhang = new Khachhang(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
                kh.add(khachhang);
            }
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
        return kh;
    }
    @Override
    public ArrayList<Khachhang> getbySTK(String SoTK){
        Connection con = getCon();
        String sql = "select * from tbKH where SoTK=?";
        ArrayList<Khachhang> kh = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, SoTK);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Khachhang khachhang = new Khachhang(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
                kh.add(khachhang);
            }
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
        return kh;
    }

    @Override
    public void updateKH(Khachhang kh) {
        Connection con = getCon();
        String sql = "Update tbKH set Hoten=?,GT=?,Diachi=?,Sodu=? where SoTK=?";
        PreparedStatement ps = null;
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1, kh.getHoten());
            ps.setString(2,kh.getGT());
            ps.setString(3,kh.getDiachi());
            ps.setDouble(4, kh.getSodu());
            ps.setString(5,kh.getSoTK());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertKH(Khachhang kh){
        Connection con = getCon();
        String sql = "insert into tbKH(SoTK,Hoten,GT,Diachi,Sodu) values(?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1,kh.getSoTK());
            ps.setString(2, kh.getHoten());
            ps.setString(3,kh.getGT());
            ps.setString(4,kh.getDiachi());
            ps.setDouble(5, kh.getSodu());
           ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteKH(String SoTK){
        Connection con = getCon();
        String sql = "delete from tbKH where SoTK=?";
        PreparedStatement ps = null;
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1, SoTK);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

   
    
}
