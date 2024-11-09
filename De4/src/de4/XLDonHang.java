/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de4;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author PC
 */
public class XLDonHang {
    public Connection getConn(){
        Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=DLDonHang;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);  
//            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public ArrayList<Grocery> getGrocery(){
        ArrayList<Grocery> gr = new ArrayList<>();
        Connection con = getConn();
        String sql ="Select * from tbSanPham";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               
                String tensp = rs.getString("tensp");
                double gia = rs.getDouble("Giasp");
                String Han = rs.getString("Han");
                Grocery grocery = new Grocery(tensp,gia,Han);
                gr.add(grocery);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return gr;
    }
    public void UpdateKhachHang(Customer c ) throws SQLException{
        Connection con = getConn();
        String sql= String.format("Update tbKhachhang set IDKH=? TenKH=?  where IDKH=?");
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sql);
            pr.setString(0,c.getIDKH() );
            pr.setString(2,c.getTenKH());
            pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            if(pr!=null){
                pr.close();
            }
            if(con!=null){
                con.close();
            }
        }
        
    }
    public ArrayList<Order> getOrder(){
        Connection con = getConn();
        ArrayList<Order> od = new ArrayList<>();
        String sql = "Select * from tbHoaDon";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
              
               String IDDon = rs.getString("IDhoadon");
               String IDKh = rs.getString("IDKH");
               String TenKH = rs.getString("TenKH");
               String TenSp = rs.getString("TenSP");
               Double Gia = rs.getDouble("Gia");
               String date = rs.getString("Han");
                ArrayList<Grocery> gr = new ArrayList<>();
                Grocery grocery = new Grocery(TenSp,Gia,date);
                gr.add(grocery);
                Customer cs = new Customer(TenKH, IDKh);
                Order order = new Order(IDDon,cs,gr);
                od.add(order);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return od;
    }
  
}
