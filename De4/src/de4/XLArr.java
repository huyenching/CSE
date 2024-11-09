/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de4;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class XLArr {
    public static ArrayList<Order> getALL(ArrayList<Order> orders, String customerID){
        ArrayList<Order> a = new ArrayList<>();
        for(Order od : orders){
            if(od.getCustomer().getIDKH().equals(customerID)){
                a.add(od);
            }
        }
        return a;
    }
}
