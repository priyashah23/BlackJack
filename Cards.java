package com.company;

/**
 * @author Priya Shah
 * @version 1.0;
 *
 * The cards class contains a Card object.
 */
public class Cards {
    private String suit;
    private int number;
    private int value;
    private String fullName;

    /**
     * A constructor for the cards
     * @param suit the suit that the card is
     * @param number an integer showing the id of the card
     */
    public Cards(String suit, int number){
        this.suit = suit;
        this.number = number + 1;
        setFullName(suit, number + 1);
        setValue(number + 1);
    }

    /**
     * Gets the name of the card for the command line
     * @return a String of the full name.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Gets the value of a card
     * @return an integer with the actual value of a card
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value, as the integer number does not reflect what value a card will hold
     * @param number an integer that may change depending on the scenario
     */
    public void setValue(int number){
        switch (number){
            case 11:
                value = 10;
                break;
            case 12:
                value = 10;
                break;
            case 13:
                value = 10;
                break;
            default:
                value = number;
        }
    }


    /**
     * To have a String name for the command line
     * @param suit A string containing the suit of the card
     * @param number An integer giving what number the card is
     */
    public void setFullName(String suit, int number) {
        //changes a value if number is Ace, King, Queen or Jack.
        String name;

        switch(number){
            case 1:
                name = "Ace";
                break;
            case 11:
                name = "Jack";
                break;
            case 12:
                name = "Queen";
                break;
            case 13:
                name = "King";
                break;
            default:
                Integer n = number;
                name = n.toString();
        }
        this.fullName =  name + " of " + suit;
    }

    /**
     * To String method to debug if the card is created correctly.
     * @return a String of the card object
     */
    public String toString(){
        // this will be overwritten to just contain the full name
        return "Suits = " + suit + " Number = " + number + "Value = " + value + "Full Name" + fullName;
    }
}
