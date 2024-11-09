/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GLuong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class XLLuong {
     public Connection getConn(){
        Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=DLLuong;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);  
//            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
     public ArrayList<Nhanvien> getNV(){
         Connection con = getConn();
         String sql="select * from tbNhanvien ";
         ArrayList<Nhanvien> nv = new ArrayList<>();
         try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Nhanvien nvien = new Nhanvien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
                nv.add(nvien);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         return nv;
     }
     public ArrayList<Nhanvien> getNVbyMa(String MaNV){
         Connection con = getConn();
         String sql="select * from tbNhanvien where MaNV=?";
         ArrayList<Nhanvien> nv = new ArrayList<>();
         try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaNV);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Nhanvien nvien = new Nhanvien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
                nv.add(nvien);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         return nv;
     }
     public void updateNV(Nhanvien nv){
         Connection con = getConn();
         String sql = "update tbNhanvien set Hoten=?, Diachi=?,Luong=? where MaNV=?";
         PreparedStatement ps= null;
         try {
             ps = con.prepareStatement(sql);
             ps.setString(1, nv.getHoten());
             ps.setString(2, nv.getDiachi());
             ps.setDouble(3, nv.getLuong());
             ps.setString(4, nv.getMaNV());
             ps.executeUpdate();
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
     }
}
