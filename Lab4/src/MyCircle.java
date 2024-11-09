
import java.security.spec.NamedParameterSpec;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class MyCircle {
    private MyPoint center;
    private int radius;
    public MyCircle (int x, int y, int radius ){
        this.center = new MyPoint( x, y);
        this.radius = radius;
    }
    public MyCircle (MyPoint center, int radius){
        this.center= center;
        this.radius = radius;
    }
    public int getRadius(){
        return radius;
    }
    public MyPoint GetCenter(){
        return center;
    }
    public int getCenterX(){
        return center.getX();
    }
    public int getCenterY(){
        return center.getY();
    }
    public void setRadius(int radius){
        this.radius = radius;
    }
    public void setCenter(MyPoint center){
        this.center = center;
    }
    public String toString(){
        int x;
        int y;
        return "Circle @ (" + center.toString()+") radius = " + radius;
    }

    public double getArea(){
       return Math.PI * radius * radius;
   }
}
