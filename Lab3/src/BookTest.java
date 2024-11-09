/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class BookTest {
    public static void main(String[] args) {
        Author anAuthor = new Author("HuyenChing","dohuyenchinh@gmail.com",'F');
        Book aBook = new Book("Java for dummy", anAuthor, 19.95, 1000);
        System.out.println(aBook);
        Book anotherBook = new Book("more Java for dummy", new Author("HuyenChing","dohuyenchinh@gmail.com",'F'), 29.95, 888);
        System.out.println("Ten cua tac gia:: "+ aBook.getAuthorName());
        System.out.println("Email cua tac gia:: "+ aBook.getAuthorEmail());
        System.out.println("Gioi tinh cua tac gia: " + aBook.getAuthorGender());
    }
}
