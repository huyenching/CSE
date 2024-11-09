/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeesPakage;


import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author PC
 */
public class EmployeesProcess implements IEmployees{

    @Override
    public java.sql.Connection getCon() {
       Connection conn = null;
        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=EmployeesDB;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
        try {
            conn =  java.sql.DriverManager.getConnection(connectionString);            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn; }

    @Override
    public ArrayList<Employees> getNV(String Phong, String GT) {
       
    Connection con = getCon();
    String sql = "Select * from tbEm where Phong=? and GT=?";
    ArrayList<Employees> em = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Phong);
            ps.setString(2, GT);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Employees employees = new Employees(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
                em.add(employees);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return em;
    }
     public ArrayList<Employees> getNVab() {
       
    Connection con = getCon();
    String sql = "Select * from tbEm ";
    ArrayList<Employees> em = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Employees employees = new Employees(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
                em.add(employees);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return em;
    }
}
