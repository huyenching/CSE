/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class MyComplexTest {
    public static void main(String[] args) {
       
        MyComplex c1 = new MyComplex(1.1, 2.2);
        MyComplex c2 = new MyComplex(3.3, 4.4);
        System.out.println("Number 1 is: "+ c1);
        System.out.println(c1+ " is "+ c1.isReal() + " a pure real number");
        System.out.println(c1+ " is "+ c1.isImaginary() + " a pure imaginary number");
        System.out.println("Number 2 is: "+ c2);
        System.out.println(c2+ " is "+ c2.isReal() + " a pure real number");
        System.out.println(c2+ " is "+ c2.isImaginary() + " a pure imaginary number");
        System.out.println(c1 +" is "+ c1.equals(c2) +"equal to "+ c2);
        MyComplex c3 = c1.add(c2);
        MyComplex c4 = c1.subtract(c2);
        MyComplex c5 = c1.multiplyWith(c2);
        MyComplex c6 = c1.divideBy(c2);
        System.out.println(c1 + "+" + c2 +" = "+ c3 );
        System.out.println(c1 + "-" + c2 +" = "+ c4 );
        System.out.println(c1 + "*" + c2 +" = "+ c5 );
        System.out.println(c1 + "/" + c2 +" = "+ c6 );
        System.out.println("Goc cua c1 theo radians: "+ c1.argumentInRadians());
        System.out.println("Goc cua c2 theo radians: "+ c2.argumentInRadians());
        System.out.println("Goc cua c1 theo do: "+ c1.argumentInDegrees());
        System.out.println("Goc cua c2 theo do: "+ c2.argumentInDegrees());
    }
}
