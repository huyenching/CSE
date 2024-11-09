/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class Mydate {
    private int year;
    private  int month;
    private  int day;
    private static final String[] strMonths={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    private static final String[] strDays ={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    private static final int [] daysInmonths={31,28,31,30,31,30,31,31,30,31,30,31};
    public Mydate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public boolean isLeapYear(int year){
        return(year %4 ==0 & year%100!=0 || year%400==0);
    }
    public boolean isValidDate(int year, int month, int day){
         if (year < 1 || year > 9999) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        int Daymax = daysInmonths[month - 1];
        if (month == 2 && isLeapYear(year)) {
            Daymax = 29;
        }
        return day >= 1 && day <= Daymax;
    }
//    public int getDayofWeak(int year, int month, int day){
//        return year;
//    }
    public int getDayOfMonth(int year, int month, int day){
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int maxDay = daysInMonths[month - 1];
        if (month == 2 && isLeapYear(year)) {
            maxDay = 29;
        }
        return maxDay;
    
    }
    public void setDate(int year, int month, int day) {
        if(isValidDate( year,month, day)){
            this.day = day;
            this.month = month;
            this.year = year;
         }
        else{
            throw  new IllegalArgumentException("Invalid year, month, or day!");
        }
    }
    public void setYear(int year){
        if(year<1 || year>9999){
            throw  new IllegalArgumentException("Invalid year!");
        }
        this.year = year;
    }
    public  void setMonth(int month){
        if(month <1 || month >12){
            throw  new IllegalArgumentException("Invalid month!");
        }
        this.month = month;
    }
    public void setDay(int day) {
        int Daymax = getDayOfMonth(year, month, day);
        if(day<1 || day > Daymax){
            throw  new IllegalArgumentException("Invalid day!");
        }
        this.day = day;
    }
    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    @Override
    public  String toString(){
        return day +"/"+ month +"/"+ year;
    }
    
}
