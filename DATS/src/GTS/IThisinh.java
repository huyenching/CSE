/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GTS;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author PC
 */
public interface IThisinh {
    Connection getCon();
    ArrayList<Thisinh> getTS();
    void insertTS(Thisinh ts);
}
