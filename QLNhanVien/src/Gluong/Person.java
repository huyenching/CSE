/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gluong;

/**
 *
 * @author PC
 */
public class Person {
    private String MaNV;
    private String Hoten;
    public Person(){
        this.MaNV =" ";
        this.Hoten = "";
    }
    public Person(String MaNV, String Hoten) {
        this.MaNV = MaNV;
        this.Hoten = Hoten;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }
    
}
