/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guesswho1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author angel
 */
public class PersonList {
    //object-array  where we will store all persons for each board.
    private ArrayList<Person> persons;
    
    /*constructor:
    every time we create an object of this class we will actually create the boards for the players
    therefore, we have to create the persons-characters that each player has on his/her board
    Since names are unique we do not need an id attribute (based on our design and implementation) */
    public PersonList() {
        persons = new ArrayList<>();
        persons.add(new Person("Angel", "Brown", "Black", "Brown", true, false, true));
        persons.add(new Person("Chris", "Black", "Yellow", "Blue", false, true, false));
        persons.add(new Person("Mairy", "Blonde", "Red", "Black", true, false, true));
        persons.add(new Person("Bill", "Orange", "White", "Green", false, true, false));
        persons.add(new Person("Charles", "Blonde", "Red", "Brown", true, true, false));
        persons.add(new Person("Susan", "White", "Black", "Brown", false, false, false));
        persons.add(new Person("Tom", "Brown", "Brown", "Black", true, false, true));
        persons.add(new Person("Peter", "White", "Blue", "Blue", false, false, false));
        persons.add(new Person("David", "Blonde", "Purple", "Brown", true, true, true));
        persons.add(new Person("Alex", "Brown", "Green", "Blue", true, false, false));
        persons.add(new Person("Sussan", "White", "Black", "Brown", false, true, false));
        persons.add(new Person("Sophia", "Blonde", "Green", "Blue", true, false, true));
    }

    // get how many players are contained in the board:
    public int getPersonListLength() {
        int length = persons.size();
        return length;
    }
    
    //print persons-characters of the game:
    public void printPerson() {
        String printChar = "";
        for (Person character : persons) {
            String glasses = "";
            if (character.getGlasses() == true) {
               glasses = "Yes";
            } else {
                glasses = "No";
            }
            String smile = "";
            if (character.getSmiling() == true) {
                smile = "Yes";

            } else {
                smile = "No";
            }
            String hat = "";
            if (character.getHat() == true) {
                hat = "Yes";

            } else {
                hat = "No";
            }
            printChar = "Name:" + character.getName() + "- Hair:" + character.getHair() + "- Shirt:" + character.getShirt() + "- Eyes:" + character.getEyes()
                    + "- Glasses:" + glasses + "- Smile:" + smile + "- Hat:" + hat;
            System.out.println(printChar);
        }
    }

    /*the following functions are needed to get all attributes of the person
    each player chooses to "hide", since we require only the name to be inserted*/
    
    //get hair of the selected person:
    public String getSelectedCharHair(String name) {
        String hair = "";
        for (Person character : persons) {
            if (name.equals(character.getName())) {
                hair = character.getHair();
            }
        }
        return hair;
    }
    
    //get shirt of the selected person:
    public String getSelectedCharShirt(String name) {
        String shirt = "";
        for (Person character : persons) {
            if (name.equals(character.getName())) {
                shirt = character.getShirt();
            }
        }
        return shirt;
    }

    //get eyes of the selected person:
    public String getSelectedCharEyes(String name) {
        String eyes = "";
        for (Person character : persons) {
            if (name.equals(character.getName())) {
                eyes = character.getEyes();
            }
        }
        return eyes;
    }

    //get glasses of the selected person:
    public boolean getSelectedGlasses(String name) {
        boolean glasses = false;
        for (Person character : persons) {
            if (name.equals(character.getName())) {
                glasses = character.getGlasses();
            }
        }
        return glasses;
    }

    //get smile of the selected person:
    public boolean getSelectedSmile(String name) {
        boolean smile = false;
        for (Person character : persons) {
            if (name.equals(character.getName())) {
                smile = character.getSmiling();
            }
        }
        return smile;
    }

    //get hat of the selected person:
    public boolean getSelectedHat(String name) {
        boolean hat = false;
        for (Person character : persons) {
            if (name.equals(character.getName())) {
                hat = character.getHat();
            }
        }
        return hat;
    }

    
    /*the following functions are needed to delete the persons-characters
    based on the characteristic the players takes a guess for*/
    
    //delete persons if name was found:
    public void deleteName(String name, String guess) {
        if (name.equals(guess)) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (!name.equals(iterator.next().getName())) {
                    iterator.remove();
                }
            }
            System.out.println("YES! Name Correct You Found the Person!!!");
        } else {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (guess.equals(iterator.next().getName())) {
                    iterator.remove();
                }
            }
            System.out.println("No! Incorrect!");
        }
    }
    
    //delete persons if hair was found: 
    public void deleteHair(String hair, String guess) {
        if (hair.equals(guess)) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (!hair.equals(iterator.next().getHair())) {
                    iterator.remove();
                }
            }
            System.out.println("YES! Hair Correct!");
        } else {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {

                if (guess.equals(iterator.next().getHair())) {
                    iterator.remove();
                }

            }
            System.out.println("No! Incorrect!");
        }

    }

    //delete persons if shirt was found:
    public void deleteShirt(String shirt, String guess) {
        if (shirt.equals(guess)) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (!shirt.equals(iterator.next().getShirt())) {
                    iterator.remove();
                }
            }
            System.out.println("YES! Shirt Correct!");
        } else {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {

                if (guess.equals(iterator.next().getShirt())) {
                    iterator.remove();
                }
            }
            System.out.println("No! Incorrect!");
        }
    }

    //delete persons if eyes was found:
    public void deleteEyes(String eyes, String guess) {
        if (eyes.equals(guess)) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (!eyes.equals(iterator.next().getEyes())) {
                    iterator.remove();
                }
            }

            System.out.println("YES! Eyes Correct!");
        } else {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {

                if (guess.equals(iterator.next().getEyes())) {
                    iterator.remove();
                }
            }
            System.out.println("No! Incorrect!");
        }
    }

    //delete persons if glasses was found:
    public void deleteGlasses(boolean glasses, String guess) {
        boolean hasGlasses;
        if ("Yes".equals(guess)) {
            hasGlasses = true;
        } else {
            hasGlasses = false;
        }
        if (glasses && hasGlasses) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (!iterator.next().getGlasses()) {
                    iterator.remove();
                }
            }
            System.out.println("Yes! Has Glasses!");
        } else if (!glasses && !hasGlasses) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (iterator.next().getGlasses()) {
                    iterator.remove();
                }
            }
            System.out.println("Yes! Has not Glasses!");
        } else if (glasses && !hasGlasses) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (!iterator.next().getGlasses()) {
                    iterator.remove();
                }
            }
            System.out.println("No! Has glasses!");
        } else if (!glasses && hasGlasses) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (iterator.next().getGlasses()) {
                    iterator.remove();
                }
            }
            System.out.println("No! Has not Glasses!");
        }
    }

    //delete persons if smile was found:
    public void deleteSmile(boolean smile, String guess) {
        boolean hasSmile;
        if ("Yes".equals(guess)) {
            hasSmile = true;
        } else {
            hasSmile = false;
        }
        if (smile && hasSmile) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (!iterator.next().getSmiling()) {
                    iterator.remove();
                }
            }
            System.out.println("Yes! Is Smiling!");
        } else if (!smile && !hasSmile) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (iterator.next().getSmiling()) {
                    iterator.remove();
                }
            }
            System.out.println("Yes! Is not Smiling!");
        } else if (smile && !hasSmile) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (!iterator.next().getSmiling()) {
                    iterator.remove();
                }
            }
            System.out.println("No! Is Smiling!");
        } else if (!smile && hasSmile) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (iterator.next().getSmiling()) {
                    iterator.remove();
                }
            }
            System.out.println("No! Is not Smiling!");
        }
    }

    //delete persons if hat was found:
    public void deleteHat(boolean hat, String guess) {
        boolean hasHat;
        if ("Yes".equals(guess)) {
            hasHat = true;
        } else {
            hasHat = false;
        }
        if (hat && hasHat) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (!iterator.next().getHat()) {
                    iterator.remove();
                }
            }
            System.out.println("Yes! Has Hat!");
        } else if (!hat && !hasHat) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (iterator.next().getHat()) {
                    iterator.remove();
                }
            }
            System.out.println("Yes! Has not Hat!");
        } else if (hat && !hasHat) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (!iterator.next().getHat()) {
                    iterator.remove();
                }
            }
            System.out.println("No! Has Hat!");
        } else if (!hat && hasHat) {
            for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
                if (iterator.next().getHat()) {
                    iterator.remove();
                }
            }
            System.out.println("No! Has not Hat!");
        }
    }

    
    /*the following functions are needed to check the user input
    regarding the player's guess, since we want the players only to insert
    values that they see on their board.*/
    
    //check if name exists on board and is written as expected:
    public String checkNameInList(String name) {
        String match = "";
        for (Person character : persons) {
            if (name.equals(character.getName())) {
                match = "matched";
            }
        }
        return match;
    }

   //check if hair's colour exists on board and is written as expected:
    public String checkHair(String hair) {
        String match = "";
        for (Person character : persons) {
            if (hair.equals(character.getHair())) {
                match = "matched";
            }
        }
        return match;
    }

    //check if shirt's colour exists on board and is written as expected:
    public String checkShirt(String shirt) {
        String match = "";
        for (Person character : persons) {
            if (shirt.equals(character.getShirt())) {
                match = "matched";
            }
        }
        return match;
    }
    
     //check if eyes' colour exists on board and is written as expected:
    public String checkEyes(String eyes) {
        String match = "";
        for (Person character : persons) {
            if (eyes.equals(character.getEyes())) {
                match = "matched";
            }
        }
        return match;
    }
    
}
