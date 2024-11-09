/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;

/**
 *
 * @author PC
 */
public class Sach extends Tailieu{
    private int NamSX;
    private Double GiaB;

    public Sach() {
        super();
    }

    public Sach( String Mas, String TenS,int NamSX, Double GiaB) {
        super(Mas, TenS);
        this.NamSX = NamSX;
        this.GiaB = GiaB;
    }

    public int getNamSX() {
        return NamSX;
    }

    public void setNamSX(int NamSX) {
        this.NamSX = NamSX;
    }

    public Double getGiaB() {
        return GiaB;
    }

    public void setGiaB(Double GiaB) {
        this.GiaB = GiaB;
    }
    
   
    
    @Override
    public Double Thanhtien() {
    if(NamSX<2015) return GiaB*0.85;
    if(NamSX>2015) return GiaB*0.95;
    return null;
    }
    
}
