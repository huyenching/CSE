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
public class XLArrayList {
    public ArrayList<Student> removeStudentsByMajor(ArrayList<Student> students,  String major){
        for(Student s : students){
            students.remove(s);
        }
        return students;
    }
}
