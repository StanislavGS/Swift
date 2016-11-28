package task2_deck;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import task2_deck.Task2_Deck.CardRank;
import task2_deck.Task2_Deck.CardSuit;

/**
 *
 * @author Stanislav Stanislavov
 */
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
