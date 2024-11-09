/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDiem;

import java.lang.invoke.MethodHandles;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;


/**
 *
 * @author PC
 */
public class XLDiem {
     public Connection getConn() {
        Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=QLDiem1;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
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
         String sql ="select * from tbHocvien";
         ArrayList<Hocvien> hv = new ArrayList<Hocvien>();
         try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Hocvien hvien = new Hocvien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4));
                hv.add(hvien);
            }
            
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         return hv;
     }
     public void insertHV(Hocvien hv){
         Connection con = null;
         String sql = "Insert Into tbHocvien(Mahv,Hoten,Lop,Diem) ";
         PreparedStatement st = null;
         try {
             con = getConn();
             st = con.prepareStatement(sql);
             st.setString(1, hv.getMaHV().isEmpty() ? UUID.randomUUID().toString() : hv.getMaHV());
             st.setString(2, hv.getHoten());
             st.setString(3, hv.getLop());
             st.setFloat(4, hv.getDiem());
         } catch (Exception e) {
             System.out.println(e.getMessage());
         } finally {
             try {
                 if(st!=null){
                     st.close();
                 }
                 if (con!=null) {
                     con.close();
                     
                 }
             } catch (Exception e) {
                 System.out.println(e.getMessage());
             }
         }
     }
   
}
