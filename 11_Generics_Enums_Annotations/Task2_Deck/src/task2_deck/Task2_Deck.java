/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2_deck;

/**
 *
 * @author Stanislav Stanislavov
 */
public class Task2_Deck {
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
        Card[] cards=new Card[52];
        int i=0;
        for(CardSuit suit: CardSuit.values()){
            for(CardRank rank:CardRank.values()){
                cards[i++]=new Card(suit, rank);
            }
        }
        
        for (Card card: cards){
            System.out.println(card.toString());
        }        
        
    }

}
