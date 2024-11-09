/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class TestMyTriangle {
    public static void main(String[] args) {
        MyPoint v1  = new MyPoint(2,3);
        MyPoint v2  = new MyPoint(3,4);
        MyPoint v3  = new MyPoint(2,4);
        MyTriangle t1 = new MyTriangle(v1,v2,v3);
        System.out.println(t1);
        System.out.println("Perimeter: "+ t1.getPerimeter());
        t1.printType();
    }
    
}
