/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GTS;

import java.util.List;
import java.sql.*;

/**
 *
 * @author PC
 */
public interface IThisinh {
    Connection getConn();
    List<Thisinh> getTS();
    void insertTS(Thisinh ts);
    
}
