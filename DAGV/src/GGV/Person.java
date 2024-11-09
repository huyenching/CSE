/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGv;

/**
 *
 * @author PC
 */
public abstract class Person {
    private  String MaDD;
    private  String Hoten;
    private String GT;

    public Person() {
    }

    public Person(String MaDD, String Hoten, String GT) {
        this.MaDD = MaDD;
        this.Hoten = Hoten;
        this.GT = GT;
    }

    public String getMaDD() {
        return MaDD;
    }

    public void setMaDD(String MaDD) {
        this.MaDD = MaDD;
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
    public abstract String Xetthuong();
}
