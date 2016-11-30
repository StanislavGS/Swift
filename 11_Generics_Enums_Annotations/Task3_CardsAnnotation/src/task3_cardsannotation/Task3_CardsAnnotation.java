/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3_cardsannotation;


import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author Stanislav Stanislavov
 */
@Retention(RetentionPolicy.RUNTIME)
@interface CardsAnnotation {
    String type() default "N/A";
    String category()default "N/A";
    String description();
}

public class Task3_CardsAnnotation {

    @CardsAnnotation(
            type = "enum",
            category = "CardGames",
            description = "Contains a set of constants for the suits of a card.")
    public enum CardSuit {
        Clubs,
        Diamonds,
        Spades,
        Hearts;

    }

    @CardsAnnotation(
            type = "enum",
            category = "CardGames",
            description = "Contains a set of constants for the ranks of a card.")
    public enum CardRank {
        Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace;
    }

    public static void main(String[] args) {

        Card card = new Card(CardSuit.Clubs, CardRank.Jack);
        CardsAnnotation   annotations= card.getClass().getAnnotation(CardsAnnotation.class);
        String st=card.getClass().toString();
        st=st.substring(st.lastIndexOf('.')+1);
        System.out.println(st +" " +annotations.type()+ " "+ annotations.description());
        
        CardsAnnotation ann1=CardRank.class.getAnnotation(CardsAnnotation.class);
        st=CardRank.class.toString();
        st=st.substring(st.lastIndexOf('$')+1);
        System.out.println(st + " "+ ann1.type()+" "+  ann1.description());
        
        ann1=CardSuit.class.getAnnotation(CardsAnnotation.class);
        st=CardSuit.class.toString();
        st=st.substring(st.lastIndexOf('$')+1);        
        System.out.println(st + " "+ ann1.type()+" "+
                ann1.description());
    }

}
