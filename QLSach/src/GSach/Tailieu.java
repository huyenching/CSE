/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;

/**
 *
 * @author PC
 */
public abstract class Tailieu {
    private String Mas;
    private String TenS;

    public Tailieu() {
    }

    public Tailieu(String Mas, String TenS) {
        this.Mas = Mas;
        this.TenS = TenS;
    }

    public String getMas() {
        return Mas;
    }

    public void setMas(String Mas) {
        this.Mas = Mas;
    }

    public String getTenS() {
        return TenS;
    }

    public void setTenS(String TenS) {
        this.TenS = TenS;
    }
    public abstract Double Thanhtien();
}
