/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gluong;

/**
 *
 * @author PC
 */
import java.sql.*;
import java.util.ArrayList;
public class XLLuong {
     public Connection getConn() {
        Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=DLLuong;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
     public ArrayList<Nhanvien> getNVbyMa(){
            Connection conn = getConn();
            String sql = "Select * from tbNhanvien Where MaNV = ?";
            ArrayList<Nhanvien> nv = new ArrayList<Nhanvien>();
         try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Nhanvien nvien = new Nhanvien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                nv.add(nvien);
            }
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         return nv;
     }
     public void updateNV(String MaNV, String Hoten, String Diachi,int Luong){
            Connection conn = null;
            String sql = "Update tbNhanvien set MaNV =?  Hoten=? Diachi=? Luong =? where MaNV =?";
            PreparedStatement st = null;
         try {
                conn = getConn();
                st =conn.prepareStatement(sql);
                st.setString(1, MaNV);
                st.setString(2, Hoten);
                st.setString(3, Diachi);
                st.setInt(4, Luong);
                st.executeUpdate();
                
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         
     }
     
}
