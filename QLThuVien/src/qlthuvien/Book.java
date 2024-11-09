/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package qlthuvien;

/**
 *
 * @author PC
 */
public class Book {

    /**
     * @param args the command line arguments
     */
    private  String TenS;
    private String TacGia;
    private boolean  ischeckout;

    public Book() {
    }

    public Book(String TenS, String TacGia) {
        this.TenS = TenS;
        this.TacGia = TacGia;
       
    }

    public String getTenS() {
        return TenS;
    }

    public void setTenS(String TenS) {
        this.TenS = TenS;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public boolean isIscheckout() {
        return ischeckout;
    }

    public void setIscheckout(boolean ischeckout) {
        this.ischeckout = ischeckout;
    }
    public void  Checkout(){
        this.ischeckout = true;
    }
    public void returnbook(){
        this.ischeckout= false;
    }
    @Override
    public String toString(){
        return "Ten Sach "+TenS+"Tac gia "+TacGia;
    }
}
