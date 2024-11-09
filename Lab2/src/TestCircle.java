
import java.awt.Color;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class TestCircle {
    public static void main(String[] args) {
        Circle crCircle = new Circle();
        System.out.println("The circle has radius of"+ crCircle.getRadius()+" and area of "+ crCircle.getArea());
        Circle cr1 = new Circle(2.0);
        System.out.println("The circle has radius of"+ cr1.getRadius()+" and area of "+ cr1.getArea());
        System.out.println("radius: "+ crCircle.getRadius());
        Circle c2 = new Circle();
        c2.setRadius(5.0);
        c2.setColor("blue");
        Circle c3 = new Circle();
        c3.setRadius(6.0);
       System.out.println("radius: "+c2.getRadius()+";"+c2.getColor());
        System.out.println(cr1.toString());
        System.out.println(c3.toString());
        System.out.println(c3);
        System.out.println("Operator '+' invokes toString() too: "+ c3);
    }
}
