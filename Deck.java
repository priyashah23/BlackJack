package com.company;

import java.util.Random;
import java.util.ArrayList;

/**
 * @author Priya Shah
 * @version 1.0
 *
 * The Deck Class contains the Deck Object whose main functionality is to choose a card from random.
 *
 */
public class Deck {
    private ArrayList<Cards> cards = new ArrayList<>();
    enum suits {
        DIAMONDS,
        HEARTS,
        SPADES,
        CLUBS
    }
    int suit = 13;

    /**
     * A constructor to create a deck of cards
     */
    public Deck(){
        for(suits thisSuit : suits.values()){
            for (int i = 0; i < suit; i++){
                cards.add(new Cards(thisSuit.toString(), i));
            }
        }
    }

    int upperbound = 51; //keeps track of what cards can be used
    /**
     * Selects a card from random
     * @return a Card from the deck
     */
    public Cards selectCard(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(upperbound);
        Cards Selected = cards.get(randomNumber);
        try{
            cards.remove(Selected);
            --upperbound;
        } catch (ArrayIndexOutOfBoundsException e){
            Deck d = new Deck();
            selectCard();
        }
        return Selected;
    }

    /**
     * For debugging purposes
     * @return an ArrayList of cards
     */
    public ArrayList<Cards> getCards() {
        return cards;
    }
}
