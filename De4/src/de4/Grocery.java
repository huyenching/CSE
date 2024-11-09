/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de4;

/**
 *
 * @author PC
 */
public class Grocery {

    /**
     * @param args the command line arguments
     */
    
    private String TenSP;
    private Double GiaSP;
    private String Date;

    public Grocery() {
    }

    
    public Grocery(String TenSP, Double GiaSP, String Date) {
        this.TenSP = TenSP;
        this.GiaSP = GiaSP;
        this.Date = Date;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public Double getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(Double GiaSP) {
        this.GiaSP = GiaSP;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    public  String getDetail(){
        return "Ten SP : "+TenSP+ " Gia SP : "+ GiaSP + " thoi Gian: "+Date;
    }
    
}
