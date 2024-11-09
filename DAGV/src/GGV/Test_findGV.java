/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGv;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Test_findGV {
    public static void dogetGV(){
       Scanner sc = new Scanner(System.in);
       XLGV xl = new XLGV();
       xl.getCon();
        System.out.println("Nhap Don vi: ");
        String donvi = sc.nextLine();
        System.out.println("Nhap SoTC");
        int soct = sc.nextInt();
        ArrayList<Giangvien> giangviens = xl.getGV(donvi, soct);
        for(Giangvien gv: giangviens){
            System.out.println("MaDD: "+gv.getMaDD());
            System.out.println("Ho ten: "+ gv.getHoten());
            System.out.println("Gioi Tinh: "+gv.getGT());
            System.out.println("Don Vi: "+gv.getDonvi());
            System.out.println("SoCT: "+gv.getSoct());
        }
    }
    public static void main(String[] args) {
        dogetGV();
    }
}
