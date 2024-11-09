/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gluong;

/**
 *
 * @author PC
 */
public class Nhanvien {
    private Person MaNV;
    private Person Hoten;
    private String Diachi;
    private int Luong;
    public Nhanvien(String string, String string1, String string2, String string3){
        this.Diachi ="";
        this.Luong =0;
    }

    public Nhanvien(String Diachi, int Luong) {
        this.Diachi = Diachi;
        this.Luong = Luong;
    }

    public Person getMaNV() {
        return MaNV;
    }

    public void setMaNV(Person MaNV) {
        this.MaNV = MaNV;
    }

    public Person getHoten() {
        return Hoten;
    }

    public void setHoten(Person Hoten) {
        this.Hoten = Hoten;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }
    
}

