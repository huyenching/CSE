/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlthuvien;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Member {
    private String TenTV;
    private String IDtvString;
    private ArrayList<Book> SachMuon;
    private int Capacity;

    public Member() {
    }

    public Member(String TenTV, String IDtvString, ArrayList<Book> SachMuon, int Capacity) {
        this.TenTV = TenTV;
        this.IDtvString = IDtvString;
        this.SachMuon = SachMuon;
        this.Capacity = Capacity;
    }

    public String getTenTV() {
        return TenTV;
    }

    public void setTenTV(String TenTV) {
        this.TenTV = TenTV;
    }

    public String getIDtvString() {
        return IDtvString;
    }

    public void setIDtvString(String IDtvString) {
        this.IDtvString = IDtvString;
    }

    public ArrayList<Book> getSachMuon() {
        return SachMuon;
    }

    public void setSachMuon(ArrayList<Book> SachMuon) {
        this.SachMuon = SachMuon;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }
    public void borrowedBooks(Book book){
        if(SachMuon.size()<Capacity && SachMuon.contains(book)){
            SachMuon.add(book);
            book.Checkout();
            System.out.println(TenTV +"Borrowed" + book);
        }
        else{
            System.out.println("Cannot borrow book");
        }
    }
    public void  returnBook(Book book){
        if(SachMuon.contains(book)){
            SachMuon.remove(book);
            returnBook(book);
            System.out.println(TenTV +" Tra Sach "+ book);
        }
    }
    @Override
   public String toString(){
       return "Ten thanh vien "+ TenTV +"ID thanh vien"+ IDtvString;
   }
}
