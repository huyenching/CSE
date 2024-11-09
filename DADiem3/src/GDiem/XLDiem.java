/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDiem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class XLDiem {
     public Connection getCon() {
         
       Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=DLDiem;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);  
//            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  conn;
     }
     public ArrayList<Hocvien> getHV(){
         Connection con = getCon();
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
     public void InsertHV(Hocvien hv ){
         Connection con = getCon();
         String sql ="insert into tbHocvien(MaHV,Hoten,Lop,Diem) values(?,?,?,?)";
         PreparedStatement ps = null;
         try {
             ps = con.prepareStatement(sql);
             ps.setString(1, hv.getMaHV());
             ps.setString(2, hv.getHoten());
             ps.setString(3, hv.getLop());
             ps.setDouble(4, hv.getDiem());
             ps.executeUpdate();
         } catch (Exception e) {
              System.out.println(e.getMessage());
         }
     }
}
