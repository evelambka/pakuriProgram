import java.util.Arrays;

public class Pakudex {
    private int sizeofPakudex;
    private Pakuri [] pakudexArray;
    private String [] pakuriString = null;
    private int countofPakuri = 0;
    private int attack, defense, speed;
    private int [] pakuriStats;
    private String [] pakuriStringNoNulls = null;

    public Pakudex() {
        // this is a default constructor that will create a default array with a capacity of 20 if there is no capacity given
        sizeofPakudex = 20;
        pakudexArray = new Pakuri [20];
        pakuriString = new String [20];
    }

    public Pakudex(int capacity) {
        //this initializes the array of pakuri to have a capacity that the user entered at the beginning of the program
        sizeofPakudex = capacity;
        pakudexArray = new Pakuri [sizeofPakudex];
        pakuriString = new String [sizeofPakudex];
    }

    public int getSize() {
        //this returns the number of pakuri currently being stored in the Pakudex
        return countofPakuri;
    }

    public int getCapacity() {
        //this returns the number of pakuri that the Pakudex has the capacity to hold at most
        return sizeofPakudex;
    }

    public String[] getSpeciesArray() {
        // this returns a String array containing the species of the critters as ordered in the Pakudex
        //it will return null if there are no pakuri in the pkudex yet
        if (pakuriString[0] == null) {
            return null;
        }

        //this creates a string of pakuri names with no null values
        pakuriStringNoNulls = new String [countofPakuri];
        for (int d = 0; d <= countofPakuri; d++) {
            if (pakuriString[d] == null) {
                break;
            }
            pakuriStringNoNulls[d] = pakuriString[d];
        }
        return pakuriStringNoNulls;
    }

    public int[] getStats(String species) {
        //this returns an integer array containing the attack, defense, and speed statistics of pakuri at indices 0, 1, and 2
        int count = 0;
        if (pakudexArray == null) {
            System.out.println("Error: No such Pakuri!");
            return null;
        }
        //this for loop looks for the pakuri in the array
        for (int i = 0; i < pakudexArray.length; i++) {
            //if the pakuri is found, then the correct stats will be returned in an integer array
            if (pakudexArray[i].getSpecies().equals(species)) {
                attack = pakudexArray[count].getAttack();
                defense = pakudexArray[count].getDefense();
                speed = pakudexArray[count].getSpeed();
                pakuriStats = new int[]{attack, defense, speed};
                return pakuriStats;
            }
            //if the end of the array is reached and no pakuri has been found, then the code will break out of the loop and return a null array
            if (count == pakudexArray.length-1) {
                break;
            }
            count++;
            if (pakudexArray[count] == null) {
                System.out.println("Error: No such Pakuri!");
                break;
            }
        }
        //if there are no pakuri in the Pakudex, then it returns null
        return null;
    }

    public void sortPakuri() {
        //this sorts the Pakuri objects in this Pakudex according to Java standard lexicographical ordering of species name
        Arrays.sort(pakuriString,0, countofPakuri);
    }

    public boolean addPakuri(String species) {
        //this adds a pakuri to the Pakudex
        Pakuri newPakuri = new Pakuri(species);
        //this for loop and if statement look to see if there is already another pakuri in the array with the same name
        //if so, the user is given an error message and the value of false is returned
        for (int j = 0; j < pakudexArray.length; j++) {
            if (species.equals(pakuriString[j])) {
                System.out.println("Error: Pakudex already contains this species!");
                return false;
            }
        }
        //this puts the pakuri in the array
        pakudexArray[countofPakuri] = newPakuri;
        pakuriString[countofPakuri] = species;
        countofPakuri ++;
        System.out.println("Pakuri species " + species + " successfully added!");
        return true;
    }

    public boolean evolveSpecies(String species) {
        //this evolves pakuri within the Pakudex
        int count2 = 0;
        //if the array is null/empty then the user will be shown an error message
        if (pakudexArray == null) {
            System.out.println("Error: No such Pakuri!");
            return false;
        }
        //this foor loop goes through each pakuri in the pakudex
        for (int i = 0; i < pakuriString.length; i++) {
            //if the species they are looking for is found, then the Pakuri's stats will be updated in the array and the value of true is returned
            if (pakuriStringNoNulls[i].equals(species)) {
                pakudexArray[count2].evolve();
                pakuriStats = new int[]{attack, defense, speed};
                return true;
            }
            count2++;
            if (pakudexArray[count2] == null) {
                System.out.println("Error: No such Pakuri!");
                return false;
            }
            //if the end of the array is reached and the program has not found the Pakuri that the user is searching for, then the code will return an
            //error message and a value of false
            if (pakuriStringNoNulls.length == count2) {
                System.out.println("Error: No such Pakuri!");
                return false;
            }
        }
        System.out.println("Error: No such Pakuri!");
        return false;
    }

}
