/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class XLGV {
    public Connection getCon() {
       Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=DLGV;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);  
//            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  conn;
    }
    
    public ArrayList<Giangvien> getGV(String Donvi,int SoCT){
        Connection con = getCon();
        String sql = "select * from tbGiangvien where Donvi=? and Soct=?";
        ArrayList<Giangvien> gv = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Donvi);
            ps.setInt(2, SoCT);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Giangvien giangvien = new Giangvien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                gv.add(giangvien);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return gv;
    }
    public ArrayList<Giangvien> getHienThi(){
        Connection con = getCon();
        String sql = "select * from tbGiangvien";
        ArrayList<Giangvien> gv = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Giangvien giangvien = new Giangvien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                gv.add(giangvien);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return gv;
    }
    public void insertGV(Giangvien gv){
        Connection con = getCon();
        String sql = "insert into tbGiangvien(MaDD,Hoten,GT,Donvi,Soct) values(?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, gv.getMaDD());
            ps.setString(2, gv.getHoten());
            ps.setString(3, gv.getGT());
            ps.setString(4, gv.getDonvi());
            ps.setInt(5, gv.getSoct());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteGV(String MaDD){
        Connection con = getCon();
        String sql = "delete from tbGiangvien where MaDD=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, MaDD);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateGV(Giangvien gv){
        Connection con = getCon();
        String sql = "update tbGiangvien set Hoten=?,GT=?,Donvi=?,Soct=? where MaDD=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(5, gv.getMaDD());
            ps.setString(1, gv.getHoten());
            ps.setString(2, gv.getGT());
            ps.setString(3, gv.getDonvi());
            ps.setInt(4, gv.getSoct());
            ps.executeUpdate();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
    }
}
