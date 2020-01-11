public class Pakuri {
    private String AssignedSpecies;
    private int attack;
    private int defense;
    private int speed;

    public Pakuri(String species){
        //This method is the only constructor for this class. It initializes the pakuri's name, speed, defense, and attack
        AssignedSpecies = species;
        attack = (AssignedSpecies.length() * 7) + 9;
        defense = (AssignedSpecies.length() * 5) + 17;
        speed = (AssignedSpecies.length() * 6) +13;
    }

    public String getSpecies() {
        // this returns the species of the pakuri
        return AssignedSpecies;
    }

    public int getAttack(){
        //this returns the attack value for the pakuri
        return attack;
    }

    public int getDefense(){
        //this returns the defense value for the pakuri
        return defense;
    }

    public int getSpeed() {
        //this returns the speed of the pakuri
        return speed;
    }

    public void setAttack(int newAttack){
        //this can change the attack value for the pakuri
        attack = newAttack;
    }

    public void evolve(){
        //this will evolve the pakuri's stats
        attack = 2 * attack;
        defense = 4 * defense;
        speed = 3 * speed;
    }
}