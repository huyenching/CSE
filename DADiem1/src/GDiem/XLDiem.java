/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDiem;

import java.util.ArrayList;

import  java.util.UUID;
import java.sql.*;


/**
 *
 * @author PC
 */
public class XLDiem {
    public Connection getConn(){
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
    public  ArrayList<Hocvien> getHV(){
        Connection con = getConn();
        String sql = " Select * from tbHocvien";
        ArrayList<Hocvien> hv = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Hocvien hvien = new Hocvien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
                hv.add(hvien);}
        } catch (Exception e) {
                System.out.println(e.getMessage());
                }
        return hv;
        }
    public void insertHV(Hocvien hv) throws SQLException{
        Connection con = null;
        String sql = "insert into tbHocvien(MaHV,Hoten,Lop,Diem) values(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            con = getConn();
            ps = con.prepareStatement(sql);
            ps.setString(1,hv.getMaHV().isEmpty() ? UUID.randomUUID().toString() : hv.getMaHV());
            ps.setString(2, hv.getHoten());
            ps.setString(3, hv.getLop());
            ps.setDouble(4, hv.getDiem());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if(ps!=null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
      public void UpdateHV(Hocvien hv,String MaHV) throws SQLException{
          Connection con = getConn();
          String sql =String.format(" Update tbHocvien set MaHV=? Hoten=? Lop=? Diem=? where MaHV=%s",MaHV);
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
          } finally {
              if(ps!=null){
                  ps.close();
              }
              if(con!=null){
                  con.close();
              }
          }
      }  
    }

