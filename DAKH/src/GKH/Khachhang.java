/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GKH;

/**
 *
 * @author PC
 */
public class Khachhang {

    /**
     * @param args the command line arguments
     */
    private String SoTK;
    private String Hoten;
    private String GT;
    private String Diachi;
    private Double Sodu;

    public Khachhang() {
    }

    public Khachhang(String SoTK, String Hoten, String GT, String Diachi, Double Sodu) {
        this.SoTK = SoTK;
        this.Hoten = Hoten;
        this.GT = GT;
        this.Diachi = Diachi;
        this.Sodu = Sodu;
    }

    public String getSoTK() {
        return SoTK;
    }

    public void setSoTK(String SoTK) {
        this.SoTK = SoTK;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getGT() {
        return GT;
    }

    public void setGT(String GT) {
        this.GT = GT;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public Double getSodu() {
        return Sodu;
    }

    public void setSodu(Double Sodu) {
        this.Sodu = Sodu;
    }
    
}
