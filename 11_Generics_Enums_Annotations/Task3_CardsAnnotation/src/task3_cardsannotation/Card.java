package task3_cardsannotation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import task3_cardsannotation.Task3_CardsAnnotation.CardRank;
import task3_cardsannotation.Task3_CardsAnnotation.CardSuit;

/**
 *
 * @author Stanislav Stanislavov
 */
@CardsAnnotation(
         type = "class", 
         category = "CardGames",
         description = "Represents a card object used to play games with.")
public class Card implements Comparable<Card>{
    private CardSuit suit;
    private CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }
       
    @Override
    public int compareTo(Card o) {
        return this.getRank().compareTo(o.getRank());
    }

    @Override
    public String toString() {
        return this.getRank().toString() + " of " + this.getSuit().toString() ; 
    }
    
}
