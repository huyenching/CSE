/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeesPakage;

/**
 *
 * @author PC
 */
public class Employees {
    private String MaNV;
    private String Hoten;
    private String Phong;
    private String GT;
    private Double HSL;

    public Employees() {
    }

    public Employees(String MaNV, String Hoten, String Phong, String GT, Double HSL) {
        this.MaNV = MaNV;
        this.Hoten = Hoten;
        this.Phong = Phong;
        this.GT = GT;
        this.HSL = HSL;
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

    public String getPhong() {
        return Phong;
    }

    public void setPhong(String Phong) {
        this.Phong = Phong;
    }

    public String getGT() {
        return GT;
    }

    public void setGT(String GT) {
        this.GT = GT;
    }

    public Double getHSL() {
        return HSL;
    }

    public void setHSL(Double HSL) {
        this.HSL = HSL;
    }
    public Double TinhLuong(){
        return HSL*1490000;
    }
}
