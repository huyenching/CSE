/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GLuong;

/**
 *
 * @author PC
 */
public class Nhanvien extends Person{
    private String Diachi;
    private Double Luong;

    public Nhanvien() {
        super();
    }

    

    public Nhanvien(String MANV, String Hoten, String Diachi, Double Luong) {
        super(MANV, Hoten, Diachi, Luong);
        this.Diachi = Diachi;
        this.Luong = Luong;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public Double getLuong() {
        return Luong;
    }

    public void setLuong(Double Luong) {
        this.Luong = Luong;
    }

    
    
    
}
