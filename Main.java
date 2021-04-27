package com.company;
import java.util.Scanner;

public class Main {

    @Deprecated
    public static void main(String[] args) {
        boolean start = false;
        boolean finish = false; //initiates game loop.
        Scanner input = new Scanner(System.in);

        //startGame(start, input);

        while(!finish){
            //Start game loop
            //gameLoop();
            finish = true;
        }
    }

    @Deprecated
    public void startGame(boolean start, Scanner input){
        while (!start){
            System.out.println("Type START to continue");
            String response = input.nextLine();
            if (response.equals("START")) {
                System.out.println("WELCOME TO BLACK JACK");
                System.out.println("ENTER FINISH TO EXIT");
                start = true;
            }
        }
    }

    @Deprecated
    public void gameLoop(){
        int player_total = 0;
        int dealer_total = 0;
        Scanner gameRead = new Scanner(System.in);
        System.out.println("YOU HAVE NOW ENTERED THE GAME LOOP");
        // Obtains card
        Game newGame = new Game();

        System.out.println("PLAYER ONE: STICK OR HIT?");
        String response = gameRead.nextLine();

        //switch statement? probably
        if (response.equals("STICK")){
            System.out.println("Player has stuck");
        }
        else if (response.equals("HIT")){
            System.out.println("Player has hit");
        }
    }

}
