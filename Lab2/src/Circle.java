/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class Circle {
    private double radius;
    private String color;
    public Circle(){
        this.radius = 1.0;
        this.color = "red";
    }
    public Circle(double radius){
        this.radius = radius;
        this.color = "red";
    }
    public double getRadius(){
        return radius;
    }
    public double getArea() {
      return radius*radius*Math.PI;
    }
    public Circle(double r, String c){
        this.radius  = r;
        this.color = c;
    }
    public  String getColor(){
        return color;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String toString(){
        return "Circle : radius = "+radius +"color = "+ color;
    }
}
