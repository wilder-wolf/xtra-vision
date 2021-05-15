/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACK_XTRAVISION;

import java.util.Scanner;
import database.Card;

/**
 *
 * @author rcvb8
 */
public class CardClass {
    
    Scanner sc = new Scanner(System.in);
    Card c;
    public String custCard;
 
public static void main(String[] args) {

         new CardClass();
        
        
    }
    
    public CardClass() {
        this.c = new Card(this);
        
        getCustomerCard();
        
    }
    
   
    
    
    public String getCustomerCard() { 
            
        System.out.println("Card in.");
        System.out.println("*For Test Purpose - New customer? Press ENTER. Or edit in existing card.");
       boolean validCard = false;
        do {
            try {
            custCard = sc.nextLine();                                   // Capture user input
                if (c.isNewCustomer(custCard)) {                    // Check to see if is a new customer
                   custCard = c.newCustCardGen();                 // If it is, generate a new card to be used (pretend they already had this) and insert into DB for record
                   validCard = true;                                        // newly generated card is automatically valid
                } else {
                validCard = c.validateCard(custCard);               // validate user's input to make sure it was a proper card number and that it matches with existing one in DB.
                }
                
            } catch (Exception e) {                                         // Catch any errors that might occur and print message
                System.out.println(e);   
            }
       } while (!validCard);                                                // Loop to get user input until card input is valid
        System.out.println("accepted");
        return custCard;
    }

    
}
