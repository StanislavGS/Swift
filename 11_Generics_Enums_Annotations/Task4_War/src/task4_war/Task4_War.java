/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task4_war;

import java.lang.annotation.Annotation;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stanislav Stanislavov
 */
public class Task4_War {

    public enum CardRank {

        Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace
    };

    public enum CardSuit {
        Clubs, Diamonds, Spades, Hearts;
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String st1 = sc.nextLine(), st2 = sc.nextLine();
        String[] s1 = st1.split(" ");
        String[] s2 = st2.split(" ");
        if (s1.length != n || s2.length != n) {
            throw new IllegalArgumentException();
        }

        Deque<Card> player1 = new ArrayDeque<Card>();
        Deque<Card> player2 = new ArrayDeque<Card>();
        for (String st : s1) {
            Card card = recognize(st);
            player1.add(card);
        }
        for (String st : s2) {
            Card card = recognize(st);
            player2.add(card);
        }
        Remi roundPlayed = new Remi();
        int i = playWar(player1, player2, roundPlayed);
        if (i > 0) {
            System.out.println("Player 1 wins on round " + i + ".");
        } else if (i < 0) {
            System.out.println("Player 2 wins on round " + (-i) + ".");
        } else {
            System.out.println("Game is draw on round " + roundPlayed.getRounds() + ".");
        }
    }

    private static Card recognize(String st) {
        CardRank rank;
        CardSuit suit;
        switch (st.charAt(0)) {
            case '2':
                rank = CardRank.Two;
                break;
            case '3':
                rank = CardRank.Three;
                break;
            case '4':
                rank = CardRank.Four;
                break;
            case '5':
                rank = CardRank.Five;
                break;
            case '6':
                rank = CardRank.Six;
                break;
            case '7':
                rank = CardRank.Seven;
                break;
            case '8':
                rank = CardRank.Eight;
                break;
            case '9':
                rank = CardRank.Nine;
                break;
            case 'T':
                rank = CardRank.Ten;
                break;
            case 'J':
                rank = CardRank.Jack;
                break;
            case 'Q':
                rank = CardRank.Queen;
                break;
            case 'K':
                rank = CardRank.King;
                break;
            case 'A':
                rank = CardRank.Ace;
                break;
            default:
                throw new IllegalArgumentException();
        }

        switch (st.charAt(1)) {
            case 'c':
                suit = CardSuit.Clubs;
                break;
            case 'd':
                suit = CardSuit.Diamonds;
                break;
            case 'h':
                suit = CardSuit.Hearts;
                break;
            case 's':
                suit = CardSuit.Spades;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return new Card(suit, rank);
    }

    private static int playWar(Deque<Card> pl1, Deque<Card> pl2, Remi isRemi) {
        int round = 0;
        boolean remi = false;
        while (!pl1.isEmpty() && !pl2.isEmpty() && !remi) {
            round++;
            int i = pl1.peek().compareTo(pl2.peek());
            if (i > 0) {
                pl1.add(pl1.poll());
                pl1.add(pl2.poll());
            } else if (i < 0) {
                pl2.add(pl2.poll());
                pl2.add(pl1.poll());
            } else {
                Deque<Card> pl1Table = new ArrayDeque<Card>();
                Deque<Card> pl2Table = new ArrayDeque<Card>();
                pl1Table.add(pl1.poll());
                pl2Table.add(pl2.poll());
                while (!pl1.isEmpty() && !pl2.isEmpty() && !remi) {
                    int sumPl1 = 0, sumPl2 = 0;;
                    for (int j = 0; j < 3; j++) {
                        if (!pl1.isEmpty()) {
                            sumPl1 += pl1.peek().getRank().ordinal();
                            pl1Table.add(pl1.poll());
                        }
                        if (!pl2.isEmpty()) {
                            sumPl2 += pl2.peek().getRank().ordinal();
                            pl2Table.add(pl2.poll());
                        }
                    }
                    remi = (pl1.isEmpty() || pl2.isEmpty()) && sumPl1 == sumPl2;
                    //remi=(pl1.isEmpty() && pl2.isEmpty()) && sumPl1==sumPl2;
                    if (remi) {
                        break;
                    } else if (sumPl1 > sumPl2) {
                        pl1.add(pl1Table.poll());// Or No
                        pl1.add(pl2Table.poll());// Or No
                        while (!pl1Table.isEmpty()) {
                            pl1.add(pl1Table.poll());
                        }
                        while (!pl2Table.isEmpty()) {
                            pl1.add(pl2Table.poll());
                        }
                        break;
                    } else if (sumPl1 < sumPl2) {
                        pl2.add(pl2Table.poll());// Or No
                        pl2.add(pl1Table.poll());// Or No
                        while (!pl2Table.isEmpty()) {
                            pl2.add(pl2Table.poll());
                        }
                        while (!pl1Table.isEmpty()) {
                            pl2.add(pl1Table.poll());
                        }
                        break;
                    }

                }

            }

        }
        isRemi.setRounds(round);
        isRemi.setRemi(remi);
        if(remi){
            return 0;
        }
        if (pl1.isEmpty()) {
            return -round;
        }
        if (pl2.isEmpty()) {
            return round;
        }

        return 0;
    }
    
    private static class Remi{
        private boolean remi;
        private int rounds;

        public Remi(boolean remi, int rounds) {
            this.remi = remi;
            this.rounds = rounds;
        }

        public Remi() {
            this.remi = false;
            this.rounds = 0;
        }

        public boolean isRemi() {
            return remi;
        }       

        public void setRemi(boolean remi) {
            this.remi = remi;
        }

        public int getRounds() {
            return rounds;
        }

        public void setRounds(int rounds) {
            this.rounds = rounds;
        }
        
    }
}
