/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GLuong;

/**
 *
 * @author PC
 */
public class Person {

    /**
     * @param args the command line arguments
     */
   private String MaNV;
   private String Hoten;

    public Person() {
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
