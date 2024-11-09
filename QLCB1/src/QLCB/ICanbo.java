/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QLCB;
import java.sql.*;
/**
 *
 * @author PC
 */
public interface ICanbo {
    Connection getcon();
    void insertCB(Canbo cb);
}
