/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLCB;

/**
 *
 * @author PC
 */
public class Test_insertCB {
    public static void doInsertCB(){
        Canbo cb = new Canbo();
        cb.setSoTK("a6");
        cb.setHoten("Hai");
        cb.setGT("Nam");
        cb.setDiachi("Ha Noi");
        cb.setLuong(250.0);
        ICanbo xl = new QLCB();
        xl.insertCB(cb);
    }
    public static void main(String[] args) {
        doInsertCB();
    }
}
