/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACK_MOVIES;

import PACK_XTRAVISION.WelcomeClass;

/**
 *
 * @author Fabiolla/Wilder
 */
public class FILMS {
    protected int discCard;
    protected String movieTitle;
    protected String movieDescription;
    protected int playTime;
    protected int category;
    protected String genre;
    protected int quantities;
    protected boolean availability;
    
    
    
    WelcomeClass cli;
    DATABASE db;
    
    public FILMS(WelcomeClass cli){
        this.cli = cli;
        this.db = new DATABASE(this);
    }

    public int getQuantities() {
        return quantities;
    }

    public boolean isAvailability() {
        return availability;
    }
    
    public void showAvailableMovies() {
        db.getMovieSelection();
    }
    
    public void showMovieInfo(int movieNum){
        db.getMovieInfo(movieNum);
    }
    
    public void addToCart(int movieNum) {
        
    }
    
}