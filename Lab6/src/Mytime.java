/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class Mytime {
    private int hour;
    private int minute;
    private int second;
    
    public Mytime(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public void setTime(int hour, int minute, int second){
        if(isValidTime(hour, minute,second)){
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
        else {
            throw new IllegalArgumentException("invalid hour, minute, or second!");
        }
    }
    public void setHour(int hour){
        if(hour>0 && hour<23){
            this.hour = hour;
        }
        else{
            throw new IllegalArgumentException("invalid hour!");
        }
    }
    public void setMinute(int minute){
        if(minute>0 && minute<59){
            this.minute = minute;
        }
        else{
            throw new IllegalArgumentException("invalid minute!");
        }
    }
    public void setSecond(int second){
        if(second>0 && second<59){
            this.second = second;
        }
        else{
            throw new IllegalArgumentException("invalid second!");
        }
    }
    public int getHour(){
        
        return hour;
    }
    public int getMinute(){
        return minute;
    }
    public int getSecond(){
        return second;
    }
    public String toString(){
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    public Mytime nextSecond() {
        if (second == 59) {
            second = 0;
            nextMinute();
        } else {
            second++;
        }
        return this;
    }
    public Mytime nextMinute(){
        if (minute == 59) {
            minute = 0;
            nextHour();
        } else {
            minute++;
        }
        return this;
    }
    public Mytime nextHour(){
        if(hour == 23){
            hour = 0;
        }
        else{
            hour++;
        }
        return this;
    }
    public Mytime previousSecond(){
        if(second == 0){
            second = 59;
            previousMinute();
        }
        else {
            second --;
        }
        return this;
    }
    public Mytime previousMinute(){
        if(minute == 0){
            minute =59;
            previousHour();
        }
        else{
            minute--;
        }
        return this;
    }
    public Mytime previousHour(){
        if(hour ==0){
            hour = 23;
        }
        else{
            hour--;
        }
        return this;
    }
    private boolean isValidTime(int hour, int minute, int second) {
        return(hour>0 && hour<=23 && minute>0 && minute<=59 && second >0 && second<=59);
    }
}
