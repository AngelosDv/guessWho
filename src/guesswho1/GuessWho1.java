package guesswho1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author angel
 */
public class GuessWho1 {

    public static void main(String[] args) {
        //create a new game:        
        Game guessWho = new Game();
        //start the game - basically create the players and get their names:
        guessWho.startGame();
        //player 1 selects character:
        guessWho.player1selectCharacter();
        //player 2 selects character:
        guessWho.player2selectCharacter();
        //play the game in turns until someone wins!!
        guessWho.playGame();
    }

}
