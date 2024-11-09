/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de4;

/**
 *
 * @author PC
 */
public class Customer {
    private String TenKH;
    private String IDKH;

    
    public Customer(String TenKH, String IDKH) {
        this.TenKH = TenKH;
        this.IDKH = IDKH;
    }

    public Customer() {
         }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getIDKH() {
        return IDKH;
    }

    public void setIDKH(String IDKH) {
        this.IDKH = IDKH;
    }
    @Override
    public String toString(){
        return "Ten KH: "+TenKH+" ID Kh: "+IDKH;
    }
}
