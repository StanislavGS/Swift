/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Task1_Cards {

    public enum CardSuit {
        Clubs,
        Diamonds,
        Spades,
        Hearts;

    }

    public enum CardRank {
        Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace;
    }

    public static void main(String[] args) {
        String st="";
        for (CardSuit card2 : CardSuit.values()) {
            st+=", "+ card2;
        }
        System.err.println(st.substring(2));
        
        st="";
        for (CardRank card2 : CardRank.values()) {
            st+=", "+ card2;
        }
        System.err.println(st.substring(2));
        
        
        
    }
}
