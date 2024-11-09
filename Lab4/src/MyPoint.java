/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
//1.3 Exercise: The MyPoint Class
public class MyPoint {
    
    private int x;
    private int y;
    
    public MyPoint(){
        this.x=0;
        this.y=0;
    }
    public MyPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x= x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setXY( int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString(){
        return "(" + x+ ","+y +")";
    }
    public double distance(int x, int y){
        int xDiff = this.x -x;
        int yDiff = this.y - y;
        return Math.sqrt(xDiff*xDiff+yDiff*yDiff);
    }
    public double distance(MyPoint another) { 
        int xDiff = this.x - another.x;
        int yDiff = this.y - another.y;
        return Math.sqrt(xDiff*xDiff+yDiff*yDiff);
    }
}
