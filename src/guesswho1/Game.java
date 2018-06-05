/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guesswho1;

import java.util.Scanner;

/**
 *
 * @author angel
 */
public class Game {
    Scanner scanInput = new Scanner(System.in);
    //here, we basically initialize the game:
    private int playerTurn = 0;
    private int players1left, players2left;
    private final Player player1 = new Player();
    private final Player player2 = new Player();
    private final PersonList board1 = new PersonList();
    private final PersonList board2 = new PersonList();
    private Person player1char = new Person("", "", "", "", true, true, true);
    private Person player2char = new Person("", "", "", "", true, true, true);

    //function to get player's names:
    public void startGame() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~ GUESS WHO ~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Questions should be close-ended (Yes/No)." + "\n"
                + "Insert first the characteristic as written on your board e.g. 'Hair'!" + "\n"
                + "Then take a guess by inserting the value e.g.'Brown', again as written on your board!");
        System.out.println();
        System.out.println("Player 1 insert your name:");
        String player1name = scanInput.next();
        player1.SetName(player1name);
        System.out.println();
        System.out.println("Player 2 insert your name:");
        String player2name = scanInput.next();
        player2.SetName(player2name);
        System.out.println();
     }

    
    
    //function for player 1 to select character-person to "hide":
    public void player1selectCharacter() {
        board1.printPerson();
        System.out.println();
        System.out.println("---------- " + player1.GetName() + " select your character by instering his/her name:");
        boolean chooseChar = false;
        while (!chooseChar) {
            String char1 = scanInput.next();
            if ("matched".equals(board1.checkNameInList(char1))) {
                player1char = new Person(char1, board1.getSelectedCharHair(char1), board1.getSelectedCharShirt(char1),
                        board1.getSelectedCharEyes(char1), board1.getSelectedGlasses(char1), board1.getSelectedSmile(char1),
                        board1.getSelectedHat(char1));
                chooseChar = true;
            } else {
                System.out.println("Name must be written as above! Select again:");
            }
        }
        System.out.println();
    }

    //function for player 2 to select character-person to "hide":
    public void player2selectCharacter() {
        board2.printPerson();
        System.out.println();
        System.out.println("---------- " + player2.GetName() + " select your character by instering his/her name:");
        boolean chooseChar = false;
        while (!chooseChar) {
            String char2 = scanInput.next();
            if ("matched".equals(board2.checkNameInList(char2))) {
                player2char = new Person(char2, board2.getSelectedCharHair(char2), board2.getSelectedCharShirt(char2),
                        board2.getSelectedCharEyes(char2), board2.getSelectedGlasses(char2), board2.getSelectedSmile(char2),
                        board2.getSelectedHat(char2));
                chooseChar = true;
            } else {
                System.out.println("Name must be written as above! Select again:");
            }
        }
        System.out.println();
    }

    //this is actully the game function - players guess in turns until someone wins:
    public void playGame(){
        while(!player1.GetWin() && !player2.GetWin()){
            playInTurns();
        }
        System.out.println("***** GAME OVER *****");
        if (player1.GetWin()){
            System.out.println(player1.GetName()+" wins!");
        }
        else{
            System.out.println(player2.GetName()+" wins!");
        }
    }
    
    //function to allow players to play in turns:
    public void playInTurns(){
        if((playerTurn%2)==0){
            System.out.println();
            System.out.println();
            System.out.println("---------- " + player1.GetName() + " it's your turn!");
            player1guess();
            players1left = board1.getPersonListLength();
            if(players1left == 1){
                player1.SetWin();
            }
        }
        else{
            System.out.println();
            System.out.println();
            System.out.println("---------- " + player2.GetName() + " it's your turn!");
            player2guess();
            players2left = board2.getPersonListLength();
            if(players2left == 1){
                player2.SetWin();
            }
        }
        playerTurn ++;
    }
        
    //function for player 1 to take a guess:
    //we check his/her inputs and delete the characters-persons that are on his/her board based on his/her guess
    //and if he/she guessed right.
    public void player1guess() {
        board1.printPerson();
        System.out.println("~~~~~ TAKE A GUESS!");
        boolean chooseChar = false;
        while (!chooseChar) {
            System.out.println("characteristic:");
            String characteristic = scanInput.next();
           if ("Name".equals(characteristic)) {
                boolean chooseName = false;
                while (!chooseName) {
                    System.out.println("guess:");
                    String guess = scanInput.next();
                    if ("matched".equals(board1.checkNameInList(guess))) {
                        board1.deleteName(player2char.getName(), guess);
                        chooseName = true;
                    } else {
                        System.out.println("Insert exactly one of the names above! Guess again!");
                    }
                    chooseChar = true;
                }
            } else if ("Hair".equals(characteristic)) {
                boolean chooseColour = false;
                while (!chooseColour) {
                    System.out.println("guess:");
                    String guess = scanInput.next();
                    if ("matched".equals(board1.checkHair(guess))) {
                        board1.deleteHair(player2char.getHair(), guess);
                        chooseColour = true;
                    } else {
                        System.out.println("Insert exactly one of the colours above! Guess again!");
                    }
                    chooseChar = true;
                }
            } else if ("Shirt".equals(characteristic)) {
                boolean chooseColour = false;
                while (!chooseColour) {
                    System.out.println("guess:");
                    String guess = scanInput.next();
                    if ("matched".equals(board1.checkShirt(guess))) {
                        board1.deleteShirt(player2char.getShirt(), guess);
                        chooseColour = true;
                    } else {
                        System.out.println("Insert exactly one of the colours above! Guess again!");
                    }
                }
                chooseChar = true;
            } else if ("Eyes".equals(characteristic)) {
                boolean chooseColour = false;
                while (!chooseColour) {
                    System.out.println("guess:");
                    String guess = scanInput.next();
                    if ("matched".equals(board1.checkEyes(guess))) {
                        board1.deleteEyes(player2char.getEyes(), guess);
                        chooseColour = true;
                    } else {
                        System.out.println("Insert exactly one of the colours above! Guess again!");
                    }
                }
                chooseChar = true;
            } else if ("Glasses".equals(characteristic)) {
                boolean chooseColour = false;
                while (!chooseColour) {
                    System.out.println("guess:");
                    String guess = scanInput.next();
                    if ("Yes".equals(guess) || "No".equals(guess)) {
                        board1.deleteGlasses(player2char.getGlasses(), guess);
                        chooseColour = true;
                    } else {
                        System.out.println("Enter 'Yes' or 'No'! Guess again!");
                    }
                }
                chooseChar = true;
            } else if ("Smile".equals(characteristic)) {
                boolean chooseColour = false;
                while (!chooseColour) {
                    System.out.println("guess:");
                    String guess = scanInput.next();
                    if ("Yes".equals(guess) || "No".equals(guess)) {
                        board1.deleteSmile(player2char.getSmiling(), guess);
                        chooseColour = true;
                    } else {
                        System.out.println("Enter 'Yes' or 'No'! Guess again!");
                    }
                }
                chooseChar = true;
            } else if ("Hat".equals(characteristic)) {
                boolean chooseColour = false;
                while (!chooseColour) {
                    System.out.println("guess:");
                    String guess = scanInput.next();
                    if ("Yes".equals(guess) || "No".equals(guess)) {
                        board1.deleteHat(player2char.getHat(), guess);
                        chooseColour = true;
                    } else {
                        System.out.println("Enter 'Yes' or 'No'! Guess again!");
                    }
                }
                chooseChar = true;
            } else {
                System.out.println("Characteristics must be written as above! Guess again!");
            }
        }
        board1.printPerson();
    }

    
    
    //function for player 2 to take a guess:
    //we check his/her inputs and delete the characters-persons that are on his/her board based on his/her guess
    //and if he/she guessed right.
    public void player2guess() {
        board2.printPerson();
        System.out.println("~~~~~ TAKE A GUESS!");
        boolean chooseChar = false;
        while (!chooseChar) {
            System.out.println("characteristic:");
            String characteristic = scanInput.next();
            if ("Name".equals(characteristic)) {
                boolean chooseName = false;
                while (!chooseName) {
                    System.out.println("guess:");
                    String guess = scanInput.next();
                    if ("matched".equals(board2.checkNameInList(guess))) {
                        board2.deleteName(player1char.getName(), guess);
                        chooseName = true;
                    } else {
                        System.out.println("Insert exactly one of the names above! Guess again!");
                    }
                    chooseChar = true;
                }
            }
            else 

if ("Hair".equals(characteristic)) {
                boolean chooseColour = false;
                while (!chooseColour) {
                    System.out.println("guess:");
                    String guess = scanInput.next();
                    if ("matched".equals(board2.checkHair(guess))) {
                        board2.deleteHair(player1char.getHair(), guess);
                        chooseColour = true;
                    } else {
                        System.out.println("Insert exactly one of the colours above! Guess again!");
                    }
                    chooseChar = true;
                }
            } else if ("Shirt".equals(characteristic)) {
                boolean chooseColour = false;
                while (!chooseColour) {
                    System.out.println("guess:");
                    String guess = scanInput.next();
                    if ("matched".equals(board2.checkShirt(guess))) {
                        board2.deleteShirt(player1char.getShirt(), guess);
                        chooseColour = true;
                    } else {
                        System.out.println("Insert exactly one of the colours above! Guess again!");
                    }
                }
                chooseChar = true;
            } else if ("Eyes".equals(characteristic)) {
                boolean chooseColour = false;
                while (!chooseColour) {
                    System.out.println("guess:");
                    String guess = scanInput.next();
                    if ("matched".equals(board2.checkEyes(guess))) {
                        board2.deleteEyes(player1char.getEyes(), guess);
                        chooseColour = true;
                    } else {
                        System.out.println("Insert exactly one of the colours above! Guess again!");
                    }
                }
                chooseChar = true;
            } else if ("Glasses".equals(characteristic)) {
                boolean chooseColour = false;
                while (!chooseColour) {
                    System.out.println("guess:");
                    String guess = scanInput.next();
                    if ("Yes".equals(guess) || "No".equals(guess)) {
                        board2.deleteGlasses(player1char.getGlasses(), guess);
                        chooseColour = true;
                    } else {
                        System.out.println("Enter 'Yes' or 'No'! Guess again!");
                    }
                }
                chooseChar = true;
            } else if ("Smile".equals(characteristic)) {
                boolean chooseColour = false;
                while (!chooseColour) {
                    System.out.println("guess:");
                    String guess = scanInput.next();
                    if ("Yes".equals(guess) || "No".equals(guess)) {
                        board2.deleteSmile(player1char.getSmiling(), guess);
                        chooseColour = true;
                    } else {
                        System.out.println("Enter 'Yes' or 'No'! Guess again!");
                    }
                }
                chooseChar = true;
            } else if ("Hat".equals(characteristic)) {
                boolean chooseColour = false;
                while (!chooseColour) {
                    System.out.println("guess:");
                    String guess = scanInput.next();
                    if ("Yes".equals(guess) || "No".equals(guess)) {
                        board2.deleteHat(player1char.getHat(), guess);
                        chooseColour = true;
                    } else {
                        System.out.println("Enter 'Yes' or 'No'! Guess again!");
                    }
                }
                chooseChar = true;
            } else {
                System.out.println("Characteristics must be written as above! Guess again!");
            }
        }
        board2.printPerson();
    }

}
