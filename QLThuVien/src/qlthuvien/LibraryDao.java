/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlthuvien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class LibraryDao {
     public Connection getConn(){
        Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=QLSach;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);  
//            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
     public ArrayList<Book> getBook(){
         Connection connection = getConn();
         String sql = "select * from tbSach";
         ArrayList<Book> books = new ArrayList<>();
         try {
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql);
             String tens = rs.getString("TenSach");
             String tg = rs.getString("TenTG");
             Book bk = new Book(tens,tg);
             books.add(bk);
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         return books;
     }
     public void insertSach(Book book){
         Connection connection = getConn();
         String sql = "insert into tbSach(TenSach,TenTG)";
         PreparedStatement pr = null;
         try {
             Book bk = new Book();
             pr = connection.prepareStatement(sql);
             pr.setString(1, bk.getTenS());
             pr.setString(2, bk.getTacGia());
             pr.executeUpdate();
             
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         
     }
}
