/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
import java.sql.*;
public class abc {
    
    public Connection getConn() {
        Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=QLDiem;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);
            System.out.println("Ket noi thanh cong!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void main(String[] args) {
        abc a = new abc();
        a.getConn();
        
        
    }
}
