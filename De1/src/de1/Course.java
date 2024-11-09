/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author PC
 */
public class Course {
    private String TenKH;
    private  String MaKH;
    private String Bomon;
    private int MaxCapacity=60;
    private ArrayList<Student> students;
    private HashMap<Student,Double> hs;
    public Course() {
    }

    public Course(String TenKH, String MaKH, String Bomon, ArrayList<Student> students) {
        this.TenKH = TenKH;
        this.MaKH = MaKH;
        this.Bomon = Bomon;
        this.students = students;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getBomon() {
        return Bomon;
    }

    public void setBomon(String Bomon) {
        this.Bomon = Bomon;
    }

    public int getMaxCapacity() {
        return MaxCapacity;
    }

    public void setMaxCapacity(int MaxCapacity) {
        this.MaxCapacity = MaxCapacity;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public boolean addStudent(Student s){
        if(students.size()<MaxCapacity && !students.contains(s)){
            students.add(s);
            hs.put(s, 0.0);
            return true;
        }
        return false;
    }
    public boolean dropStudent(Student s){
        if(students.contains(s)){
            students.remove(s);
            hs.remove(s);
            return true;
        }
        return false;
    }
    public double getAverage(){
        double tong =0;
        if(students.size()==0) return 0.0;
        for(double diem : hs.values()){
            tong+= diem;
           
        }
        return tong/students.size();
    }
    //Lay diem cua khoa hoc
    public double getDiem(Student s){
        return hs.getOrDefault(s, 0.0);
    }
    @Override
    public String toString(){
        return "Ten Kh: "+TenKH +" Ma KH "+MaKH+" Bo Mon "+Bomon;
    }
}
