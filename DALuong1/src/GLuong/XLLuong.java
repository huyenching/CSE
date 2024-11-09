/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GLuong;



import java.util.ArrayList;

import java.sql.*;


/**
 *
 * @author PC
 */
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
        Connection con = getConn();
        String sql ="select * from tbNhanvien where MaNV =?";
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
    
    public ArrayList<Nhanvien> timNV(String MaNV){
        Connection con = getConn();
        String sql = String.format("Select * from tbNhanvien where MaNV=%s", MaNV);
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
}
