/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GTS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import  java.sql.*;

/**
 *
 * @author PC
 */
public class XLTS implements IThisinh{

    @Override
    public Connection getCon() {
         
       Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=DLTS;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);  
//            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  conn;
     }

    @Override
    public ArrayList<Thisinh> getTS() {
        Connection con = getCon();
        String sql = "select * from tbThisinh";
        ArrayList<Thisinh> ts = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Thisinh thisinh = new Thisinh(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
                ts.add(thisinh);
            }
        } catch (Exception e) {
               System.out.println(e.getMessage());
        }
        return ts;
    }

    @Override
    public void insertTS(Thisinh ts) {
    
        Connection con = getCon();
        String sql = "insert into tbThisinh(SoBD,Hoten,GT,NganhH,TongD) values(?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1, ts.getSoBD());
            ps.setString(2, ts.getHoten());
            ps.setString(3, ts.getGT());
            ps.setString(4, ts.getNganhH());
            ps.setDouble(5, ts.getTongD());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }
    public void deleteTS(String SoBD){
        Connection con = getCon();
        String sql ="delete from tbThisinh where SoBD=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, SoBD);
            ResultSet rs = ps.executeQuery();
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void UpdateTS(Thisinh ts){
        Connection con = getCon();
        String sql = "update tbThisinh set Hoten=?, GT=?,NganhH=?,TongD=? where SoBD=?";
        PreparedStatement ps = null;
        try {
           ps= con.prepareStatement(sql);
            ps.setString(5, ts.getSoBD());
            ps.setString(1, ts.getHoten());
            ps.setString(2, ts.getGT());
            ps.setString(3, ts.getNganhH());
            ps.setDouble(4, ts.getTongD());
            ps.executeUpdate();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
    }
    public ArrayList<Thisinh> SearchTS(String SoBD){
        Connection con = getCon();
        String sql = "select * from tbThisinh where SoBD=?";
        ArrayList<Thisinh> ts = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, SoBD);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Thisinh thisinh = new Thisinh(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
                ts.add(thisinh);
            }
        } catch (Exception e) {
        }
        return ts;
    }
    
}
