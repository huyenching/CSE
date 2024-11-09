/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GLuong;

/**
 *
 * @author PC
 */
public class Person {
    private String MANV;
    private String Hoten;
    
    public Person() {
    }

    public Person(String MANV, String Hoten, String Diachi, Double Luong) {
        this.MANV = MANV;
        this.Hoten = Hoten;
        
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    
}
