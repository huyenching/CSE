/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de1;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Student {
    private String TenSV;
    private  String MaSV;
    private String NganhH;
    private ArrayList<Course> courses;
    private int Capacity=50;

    public Student(){}
//    public Student(String string, String string1, String string2) {
//    }

    public Student(String TenSV, String MaSV, String NganhH) {
        this.TenSV = TenSV;
        this.MaSV = MaSV;
        this.NganhH = NganhH;
        //this.courses = courses;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String TenSV) {
        this.TenSV = TenSV;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getNganhH() {
        return NganhH;
    }

    public void setNganhH(String NganhH) {
        this.NganhH = NganhH;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }
    public boolean addCourse(Course c){
        if(courses.size()<Capacity && !courses.contains(c)){
            courses.add(c);
            c.addStudent(this);
            return true;
        }
        return  false;
    }
    public boolean dropCourse(Course c){
        if(courses.contains(c)){
            courses.remove(c);
            c.dropStudent(this);
            return true;
        }
        return false;
    }
    public double getGPA(){
        double diem=0;
        if(courses.size()==0) return 0.0;
        // mang truong [java 7,sql 6,dstt 5,linux 4]
        for(Course c: courses){
            diem += c.getDiem(this);
            
        }
        return diem/courses.size();
    }
    public String toString(){
        return "Ten SV "+TenSV+ " MaSV "+MaSV+ "Nganh Hoc "+NganhH;
    }
}
