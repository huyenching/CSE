/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class XLSach {
     public Connection getcon() {
        
         
       Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=DLSach;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = java.sql.DriverManager.getConnection(connectionString);  
//            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  conn;
     }
     public ArrayList<Sach> getSA(){
         Connection con = getcon();
         String sql = "select * from tbSach";
         ArrayList<Sach> sach = new ArrayList<>();
         try {
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 Sach s = new Sach(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
                 sach.add(s);
             }
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         return sach;
     }
     public void deleteSA(int namsx){
         Connection con = getcon();
         String sql = "delete from tbSach where NamXB=?";
         PreparedStatement ps = null;
         try {
             ps = con.prepareStatement(sql);
             ps.setInt(1, namsx);
             ps.executeUpdate();
         } catch (Exception e) {
             System.out.println(e.getMessage());
             e.printStackTrace();
         }
     }
}
