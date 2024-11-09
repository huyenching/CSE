/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;
import java.util.UUID;

/**
 *
 * @author PC
 */
public class XLDL {
    public Connection getConn(){
        Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=QLKhoaHoc;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);  
  //          System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public ArrayList<Student> getSV(){
        Connection con = getConn();
        String sql ="Select * from tbSinhvien";
        ArrayList<Student> sv = new ArrayList<Student>();
        try {
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               Student svien = new Student(rs.getString("TenSV"),rs.getString("MaSV"),rs.getString("NganhH"));
               sv.add(svien);
           }
           return sv;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } 
    }
    public void insertSV(Student sv) throws SQLException{
        Connection con = getConn();
        String sql = " insert into tbSinhvien(TenSV,MaSV,NganhH) values (?,?,?) ";
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sv.getTenSV());
            ps.setString(2,sv.getMaSV().isEmpty() ? UUID.randomUUID().toString() : sv.getMaSV());
            ps.setString(3,sv.getNganhH());
            ps.executeUpdate();
        } catch (Exception e) {
           System.out.println(e.getMessage());
        } finally {
            if(ps!=null) {
                ps.close();
            }
            if(con!=null){
                con.close();
            }
        }
    }
}
