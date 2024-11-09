/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class Book {
    private String name;
    private Author author;
    private double price;
    private int qtyInStock;
    
    public Book(String name,Author author, double price ){
        this.name = name;
        this.author = author;
        this.price =  price;
        this.qtyInStock = 0;
    }
    
    public Book(String name,Author author, double price, int qtyInStock ){
        this.name = name;
        this.author = author;
        this.price =  price;
        this.qtyInStock = qtyInStock;
    }
    public String getName(){
        return name;
    }
    public Author getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
    public int getQtyInStock(){
        return qtyInStock;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setQtyInStock(int qtyInStock){
        this.qtyInStock = qtyInStock;
    }
    public String getAuthorName(){
        return author.getName();
    }
    public String getAuthorEmail(){
        return author.getEmail();
    }
    public char getAuthorGender(){
        return author.getGender();
    }
    @Override
    public String toString(){
        return name + " by "+ author.toString() + price + qtyInStock ;
    }
}
