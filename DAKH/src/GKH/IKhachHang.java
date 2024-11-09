/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GKH;


import java.util.ArrayList;
import java.sql.Connection;

/**
 *
 * @author PC
 */
public interface IKhachHang {
    Connection getCon();
    public ArrayList<Khachhang> getbySTK(String SoTK);
    public void updateKH(Khachhang kh);
}
