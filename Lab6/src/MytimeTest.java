/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class MytimeTest {
    public static void main(String[] args) {
        Mytime mt = new Mytime(20,15, 50);
        System.out.println(mt);
        System.out.println("Gio sau do: "+mt.nextHour());
        System.out.println("Phut sau do: "+mt.nextMinute());
        System.out.println("Giay sau do: "+mt.nextSecond());
        System.out.println("Gio truoc do: "+ mt.previousHour());
        System.out.println("Phut truoc do: "+ mt.previousMinute());
        System.out.println("Giay truoc do: "+ mt.previousSecond());
        
    }
}
