/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author Fabiolla/Wildder
 */
public class AVALIABLERENT {
    protected int cardName;
    protected int discCard;
    protected int xtraDate;
    protected int returnDate;
    protected int xtraduration;
    protected double totalCharge;
    protected String xtraCode = "xtrafree123";
    protected double promoxDiscount = 2.99;
    protected boolean boolXD = false;
    protected boolean boolWL = false;
    protected boolean boolVXP = false;
    
    protected String userxDisc;                       //Maybe not the right place, but we will see 
    
   ArrayList<FILMS> movies;                          // I don't think this is necessary in here, but we will see
    
    
    public AVALIABLERENT(){
        
    }

    
    public int getdiscCard() {
        return discCard;
    }

    public int getcardName() {
        return cardName;
    }

    public int getxtraDate() {
        return xtraDate;
    }

    public int getReturnDate() {
        return returnDate;
    }

    public double getTotalCharge() {
        return totalCharge;
    }
    
    public String getxtraCode() {         
        return xtraCode;
    }
    
    public boolean xDisccont() {
        return boolXD;
    }
    
    public boolean warningLate() {
        return boolWL;
    }
    
    public boolean validatextraPromo() {
        return boolVXP;
    }
    
    public void xtraAddCharges() {
        
    }
    
    public void chargeXtra() {
        
    }
    
    public void applyPromo() {
        
    }
    
}
