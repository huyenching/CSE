/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class AuthorTest {
    public static void main(String[] args) {
        Author anAuthor = new Author("Tan Ah Teck","ahteck@somewhere.com" , 'm');
        System.out.println(anAuthor);
        anAuthor.setEmail("paul@nowhere.com");
        System.out.println(anAuthor);
    }
    
    
}
