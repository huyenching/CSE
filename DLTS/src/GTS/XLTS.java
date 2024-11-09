/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GTS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;
/**
 *
 * @author PC
 */
public class XLTS implements IThisinh{
    
   @Override
   public Connection getConn(){
        Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=DLTS;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);  
//            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public ArrayList<Thisinh> getTS(){
        Connection con = getConn();
        String sql = "Select * from tbThisinh";
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
    public  void insertTS(Thisinh ts) {
        String sql = "Insert into tbThisinh(SoBD,Hoten,GT,NganhH,TongD) values(?,?,?,?,?)";
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = getConn();
            st = con.prepareStatement(sql);
            st.setString(1,ts.getSoBD().isEmpty() ? UUID.randomUUID().toString() : ts.getSoBD());
            st.setString(2, ts.getHoten());
            st.setString(3, ts.getGT());
            st.setString(4, ts.getNganhH());
            st.setDouble(5, ts.getTongD());
            st.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(st !=null){
                st.close();
            }
            if (con != null) {
                con.close();
                
            }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
    }
}
