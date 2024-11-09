/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDiem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author PC
 */
public class XLDiem {
     public Connection getConn(){
        Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=DLDiem;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);  
//            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public ArrayList<Hocvien> getHV(){
        Connection con = getConn();
        String sql = "select * from tbHocvien";
        ArrayList<Hocvien> hv = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Hocvien hocvien = new Hocvien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
                hv.add(hocvien);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hv;
}
    public void insertHV(Hocvien hv){
        Connection con = getConn();
        String sql = "insert into tbHocvien(MaHV,Hoten,Lop,Diem) values(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, hv.getMaHV());
            ps.setString(2, hv.getHoten());
            ps.setString(3, hv.getLop());
            ps.setDouble(4,hv.getDiem() );
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public  void deleteHV(String MaHV){
        Connection con = getConn();
        String sql = "delete from tbHocvien where MaHV=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, MaHV);
            ps.executeUpdate();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
    }
    public ArrayList<Hocvien> searchHV(String MaHV) throws SQLException{
        Connection con = getConn();
        String sql = "select * from tbHocvien where MaHV=?";
        ArrayList<Hocvien> hv = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaHV);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Hocvien hocvien = new Hocvien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
                hv.add(hocvien);}
        } catch (Exception e) {
                 System.out.println(e.getMessage());
                }
        return hv;
        }
    public void updateHV(Hocvien hv){
        Connection con = getConn();
        String sql ="Update tbHocvien set Hoten = ? ,Lop=?,Diem=? where MaHV=?";
         PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, hv.getHoten());
            ps.setString(2, hv.getLop());
            ps.setDouble(3,hv.getDiem() );
            ps.setString(4, hv.getMaHV());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    }

