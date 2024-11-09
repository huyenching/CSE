/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EmployeesPakage;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author PC
 */
public interface IEmployees {
   Connection getCon();
   ArrayList<Employees> getNV(String Phong, String GT);
}
