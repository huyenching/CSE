/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
//1.3 Exercise: The MyPoint Class
public class MyPointTest {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(3,0);
        MyPoint p2 = new MyPoint(0,4);
        System.out.println(p1.distance(p2));
        System.out.println(p1.distance(5, 6));
        //2
        MyPoint[] points = new MyPoint[10];
        for(int i=0;i < points.length;i++){
            points[i] = new MyPoint(i+1,i+1);
        }
         
    }
}
