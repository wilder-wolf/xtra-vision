/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACK_XTRAVISION;

import java.util.Scanner;
import PACK_MOVIES.FILMS;

/**
 *
 * @author Fabiolla/Wilder
 */
public class WelcomeClass {
    Scanner sc = new Scanner(System.in);
    FILMS myW;
    int firstquestion;
     int filmName;
     
     public static void main(String[] args) {

         new WelcomeClass();
    }
    
    public WelcomeClass(){
        this.myW = new FILMS(this);
        welcomePage();
        
    }
    
    public  void welcomePage(){
        System.out.println("********************************");
        System.out.println("WELCOME TO SUPERXTRA!");
        System.out.println("Press 1 to RENT or 2 to HOME");
        System.out.println("********************************");
        int question1 = sc.nextInt();
        if(question1 == 1){
            showMovieSelection();
        } else {
            System.out.println("We will back soon...");
        }
            
    }
    
    public void showMovieSelection(){
        
            System.out.println("");
            System.out.println("Movie`s Choice:");
            System.out.println("__________________");
            System.out.println("");
            myW.showAvailableMovies();
            System.out.println("");
            System.out.println("To view sinopse, press:");
            System.out.println("1 - The Hobit,   2 - The Lion King,   3 - Deadpool,   4 - Avengers \n"
                    + "5 - The Lord of the Rings");
            System.out.println("");
            selectMovie();
    }
    
    public void selectMovie() {
        int movieNum = sc.nextInt();
        myW.showMovieInfo(movieNum);
        System.out.println("");
        System.out.println("add to bag?");
        System.out.println("Press y - YES or n - NO");
        String cartAns = sc.next();
        if (cartAns.equalsIgnoreCase("y")) {
            myW.addToCart(movieNum);
        } else if (cartAns.equalsIgnoreCase("n")) {
            showMovieSelection();
        }
    }
      
    
    
}
