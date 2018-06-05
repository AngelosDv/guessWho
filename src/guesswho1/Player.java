/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guesswho1;

/**
 *
 * @author angel
 */
public class Player {
    private String name;
    private boolean win;

    //constructor:
    public Player() {
        win = false;
        name = "Not Given";
    }

    //set player's name:
    public void SetName(String name) {
        this.name = name;
    }
    
    //get player's name:
    public String GetName() {
        return name;
    }

    //set that players wins:
    public void SetWin() {
        win = true;
    }
    
    //get player's win:
    public boolean GetWin() {
        return win;
    }

}
