import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class PakuriProgram {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);

        //this chunk of code is only printed one time as an introduction to the Pakudex Tracker game
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.print("Enter max capacity of the Pakudex: ");
        int capacityofArray;

        //this try catch will test the input that the user enters to create the size of the pakudex
        while (true) {
            try {
                //if it is an interger, it must be positive so this if statement checks if the integer is greater than 0
                capacityofArray = keyboard.nextInt();
                //if it is a negative, the user is prompted to enter a valid size
                if (capacityofArray <= 0) {
                    System.out.println("Please enter a valid size.");
                    System.out.print("Enter max capacity of the Pakudex: ");
                    capacityofArray = keyboard.nextInt();
                }
                break;
            }
            //this will catch any input that is not an integer and prompt the user to enter a valid size.
            catch (Exception e){
                System.out.println("Please enter a valid size.");
                System.out.print("Enter max capacity of the Pakudex: ");
                keyboard.next();
            }
        }

        //this establishes the Pakudex that I will use throughout the rest of the project
        Pakudex pakudex1 = new Pakudex(capacityofArray);
        System.out.println("The Pakudex can hold " + pakudex1.getCapacity() + " species of Pakuri.");

        int RunGame = 0;
        //this while loop will continue to run the game until the user chooses to exit the program
        while (RunGame == 0) {
            System.out.println(" ");
            System.out.println("Pakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit");

            System.out.print("What would you like to do? ");
            int personChoice = 0;

            //this try catch tests if the person's menu choice is a valid integer (between 1 and 6)
            try {
                personChoice = keyboard.nextInt();
            }
            catch (Exception e) {
                personChoice = 10;
                keyboard.next();
            }

            String [] pakudexArray = new String[capacityofArray];

            //this if statement will list the pakuri in the Pakudex
            if (personChoice == 1) {
                pakudexArray = pakudex1.getSpeciesArray();
                //if the array is null or empty, the code will tell the user that there are no pakuri in the pakudex yet
                if (pakudexArray == null || pakudexArray.length == 0 ) {
                    System.out.println("No Pakuri in Pakudex yet!");
                    continue;
                }

                //this if statement goes through each item in the array and prints out the list of pakuri
                System.out.println("Pakuri In Pakudex:");
                for (int i = 0; i < pakudexArray.length; i++) {
                    if (pakudexArray[i] == null) {
                        continue;
                    }
                    System.out.println((i+1) + ". " + pakudexArray[i]);
                }
            }

            //this if statement will list show the name, speed, defense, and attack for the chose pakuri
            else if (personChoice == 2) {
                pakudexArray = pakudex1.getSpeciesArray();
                System.out.print("Enter the name of the species to display: ");
                String speciesToDisplay = keyboard.next();

                //if the array is null or empty then the program will tell the user that there is no such pakuri
                if (pakudexArray == null) {
                    System.out.println("Error: No such Pakuri!");
                    continue;
                }
                if (pakudex1.getSize() == 0) {
                    System.out.println("Error: No such Pakuri!");
                    continue;
                }

                //this new array holds the speed, defense, and attack values for the pakuri that the user has chosen
                int [] pakuriStats = pakudex1.getStats(speciesToDisplay);
                int count4 = 0;
                //this for loop is used to try to find the pakuri in the pakudex
                for (int j = 0; j < pakudexArray.length; j++) {
                    //if it is found, the stats will be printed for the pakuri with this if statement
                    if (speciesToDisplay.equals(pakudexArray[j])) {
                        System.out.println(" ");
                        System.out.println("Species: " + speciesToDisplay);
                        System.out.println("Attack: " + pakuriStats[0]);
                        System.out.println("Defense: " + pakuriStats[1]);
                        System.out.println("Speed: " + pakuriStats[2]);
                        break;
                    }
                }
            }

            //this if statement is used ot create a new pakuri
            else if (personChoice == 3) {
                //if the current size of the array of pakuri is equal to the capacity, then it is full and the user will be give an error message
                if (pakudex1.getSize() == pakudex1.getCapacity()) {
                    System.out.println("Error: Pakudex is full!");
                    continue;
                }

                //if the array is not full then the user can create a pakuri here
                System.out.print("Enter the name of the species to add: ");
                String pakuriName = keyboard.next();
                pakudex1.addPakuri(pakuriName);
            }

            //this if statement is used to evolve a pakuri (update their stats)
            else if (personChoice == 4) {
                pakudexArray = pakudex1.getSpeciesArray();
                System.out.print("Enter the name of the species to evolve: ");
                String species = keyboard.next();
                int count5 = 0;

                //if the array is null/empty then the user will be shown an error message
                if (pakudexArray == null) {
                    System.out.println("Error: No such Pakuri!");
                    continue;
                }

                //if the array has pakuri, then this for loop will go through each one to find the pakuri that the user wants to evolve
                for (int l = 0; l < pakudexArray.length; l++) {
                    //if it is found, then this if statement will evolve the pakuri's stats
                    if (pakudexArray[l].equals(species)) {
                        pakudex1.evolveSpecies(species);
                        System.out.println(species + " has evolved!");
                        break;
                    }
                    //if the end of the array is reached and the pakuri has not been found then the user will be given and error message
                    if (count5 == pakudexArray.length-1) {
                        System.out.println("Error: No such Pakuri!");
                        break;
                    }
                    count5++;
                }
            }

            //this if statement will sort the pakuri in alphabetical order
            else if (personChoice == 5) {
                pakudex1.sortPakuri();
                System.out.println("Pakuri have been sorted!");
            }

            //this if statement will exit the game
            else if (personChoice == 6) {
                System.out.println("Thanks for using Pakudex! Bye!");
                RunGame = 1;
            }
            //this if statement will handle and menu choice that is not 1 through 6
            else {
                System.out.println("Unrecognized menu selection!");
            }
        }
    }
}
