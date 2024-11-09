/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlcb;

/**
 *
 * @author PC
 */
public class Test_insertCB {
    public static  void doInsertCB(){
        Canbo cb = new Canbo();
        cb.setSoTK("a5");
        cb.setHoten("Tien Dat");
        cb.setGT("Nam");
        cb.setDiachi("Thai Binh");
        cb.setLuong(400.0);
        ICanbo xl = new XLDL();
        try {
            xl.insertCB(cb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        doInsertCB();
    }
}
