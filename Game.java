package com.company;
import java.util.Scanner;

/**
 * @author Priya Shah
 * @version 1.0
 *
 * The Game class contains the main method as well as the additional  methods for the game to run.
 */
public class Game {
    private Deck deck;
    boolean busted = false;
    int playerTotal = 0;
    int dealerTotal = 0;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean run = false;
        System.out.println("Type START to continue");
        String response = scanner.nextLine();

        if (response.toLowerCase().equals("start")){
            run = true;
        }

        while (run){
            Game blackJack = new Game();
            break;
        }
    }

    /**
     * Constructor that starts the game
     */
    public Game(){
        Deck deck = new Deck();
        this.deck = deck;

        initialDeal();
        gamePlay();
        calculateScore();
    }

    /**
     * Starts with the inital deal of blackJack
     */
    public void initialDeal(){
        //Next step is to add the player total.
        System.out.println("Welcome to Black Jack\nEnter FINISH to exit.");
        //Gets the first card.
        Cards firstCard = player_hit();
        System.out.println("The player has: " + firstCard.getFullName());
        playerAdd(firstCard.getValue());
        //Dealer's first card
        Cards dealerCard = player_hit();
        System.out.println("The dealer has: " + dealerCard.getFullName());
        dealerAdd(dealerCard.getValue());
        //gets the second card.
        Cards secondCard = player_hit();
        playerAdd(secondCard.getValue());
        System.out.println("The player has: " + secondCard.getFullName());
        dealerAdd(player_hit().getValue());
        System.out.println("The dealer has: ?");
        System.out.println(playerTotal);
    }

    /**
     * Adds card value to the player total
     * @param value integer that contains the value of the card
     */
    public void playerAdd(int value){
        playerTotal = playerTotal + value;
    }

    /**
     * Adds card value to the dealer total
     * @param value integer that contains the value of the card
     */
    public void dealerAdd(int value){dealerTotal = dealerTotal + value;}

    /**
     *
     * @return
     */
    public Cards player_hit (){
        return deck.selectCard();
    }

    /**
     * A while loop that allows the user to enter STICK or HIT until player total is > 21 or play decides to STICK
     */
    public void gamePlay(){
        Scanner input = new Scanner(System.in);
        boolean stick = true;
        while (stick){
            System.out.println("Would the player like to STICK or HIT?");
            String response = input.nextLine();
            if (response.toLowerCase().equals("stick")){
                stick = false;
            } else if (response.toLowerCase().equals("hit")){
                Cards nextCard = player_hit();
                System.out.println("The player has: " + nextCard.getFullName());
                playerAdd(nextCard.getValue());
                if (playerTotal > 21){
                    busted = true;
                    break;
                }
                System.out.println(playerTotal);
            }
            else{
                System.out.println("Invalid input validation");
            }
        }
    }

    /**
     * Calculates whether the player has won or not
     */
    public void calculateScore(){
        if (busted){
            System.out.println("Player busted. You LOSE");
        }
        else{
            dealerAI();
            if (dealerTotal > 21){
                System.out.println("Dealer busted. You WIN");
            } else if(dealerTotal > playerTotal){
                System.out.println("Dealer has WON. you LOSE");
            } else {
                System.out.println("Dealer has LOST. you WIN");
            }
        }
    }

    /**
     * A simple dealerAI that continues to hit until it gets to 16 and then sticks.
     */
    public void dealerAI(){
        if (dealerTotal < 16){
            int nextValue = player_hit().getValue();
            dealerAdd(nextValue);
            dealerAI();
        }
    }
}