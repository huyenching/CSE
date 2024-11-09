/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Order {
    private String IDDH;
    private Customer customer;
    private List<Grocery> items;

    public Order() {
    }

    public Order(String IDDH, Customer customer, List<Grocery> items) {
        this.IDDH = IDDH;
        this.customer = customer;
        this.items = items;
    }

    


    public String getIDDH() {
        return IDDH;
    }

    public void setIDDH(String IDDH) {
        this.IDDH = IDDH;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Grocery> getItems() {
        return items;
    }

    public void setItems(List<Grocery> items) {
        this.items = items;
    }

    

    
    public void addItem(Grocery it){
        items.add(it);
    }
    public Double getTong(){
        double tong = 0;
        for(Grocery it : items){
            tong+=getTong();
        }
        return tong;
    }
    public String toString(){
        return "ID Don hang: "+IDDH + "Khach hang: "+customer+ "Danh sach sp: "+items;
    }
}
