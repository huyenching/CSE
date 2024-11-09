/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private  MyPoint v3;
    
    public MyTriangle(int x1, int y1,int x2, int y2, int x3, int y3){
            this.v1 = new MyPoint(x1,y1);
            this.v2 = new MyPoint(x2,y2);
            this.v3 = new MyPoint(x3,y3);
        }
    public  MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3){
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }
    public String toString(){
       
        return "Triangle @"+v1.toString() +","+ v2.toString() +"," +v3.toString() + ",";
    }
    public double getPerimeter(){
        double sz1 = v1.distance(v2);
        double sz2 = v2.distance(v3);
        double sz3 = v3.distance(v1);
        return sz1+sz2+sz3;
    }
    public void printType(){
        double sz1 = v1.distance(v2);
        double sz2 = v2.distance(v3);
        double sz3 = v3.distance(v1);
        if(sz1 == sz2 && sz2 == sz3){
            System.out.println("equilateral");
        }
        else if(sz1 == sz2 || sz1 == sz3 || sz2 == sz3){
            System.out.println("isosceles");
        }
        else{
            System.out.println("scalene");
        }
    }
}
