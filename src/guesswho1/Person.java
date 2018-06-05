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
public class Person {
    private String name, hair, shirt, eyes;
    private boolean glasses, smiling, hat;

    //constructor:
    public Person(String name, String hair, String shirt, String eyes, boolean glasses, boolean smiling, boolean hat) {
        this.name = name;
        this.hair = hair;
        this.shirt = shirt;
        this.eyes = eyes;
        this.glasses = glasses;
        this.smiling = smiling;
        this.hat = hat;
    }

    /*
    since we defined the constructor in that way and because of our design and implementation 
    of the game there is no need to have "setters"
    */
    
    //get person's name:
    public String getName() {
        return name;
    }

    //get person's hair:
    public String getHair() {
        return hair;
    }

    //get person's shirt:
    public String getShirt() {
        return shirt;
    }

    //get person's eyes:
    public String getEyes() {
        return eyes;

    }

    //get if person has glasses:
    public boolean getGlasses() {
        return glasses;

    }

     //get if person is smiling:
    public boolean getSmiling() {
        return smiling;
    }

    //get if person wears hat:
    public boolean getHat() {
        return hat;
    }

}
