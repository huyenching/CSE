/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GDiem;

/**
 *
 * @author PC
 */
public class Hocvien {

    /**
     * @param args the command line arguments
     */
   private String MaHV;
   private  String Hoten;
   private String Lop;
   private Double Diem;

    public Hocvien() {
    }

    public Hocvien(String MaHV, String Hoten, String Lop, Double Diem) {
        this.MaHV = MaHV;
        this.Hoten = Hoten;
        this.Lop = Lop;
        this.Diem = Diem;
    }

    public String getMaHV() {
        return MaHV;
    }

    public void setMaHV(String MaHV) {
        this.MaHV = MaHV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }

    public Double getDiem() {
        return Diem;
    }

    public void setDiem(Double Diem) {
        this.Diem = Diem;
    }
    public String Ketqua(){
        if(Diem>=25) return "Dat";
        return "";
    }
    
}
