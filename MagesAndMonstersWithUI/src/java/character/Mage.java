package character;

import java.util.ArrayList;

public class Mage extends Character implements Spells {
    // Mana
    // Intelligence
    int mana;
    int intelligence;
    boolean frozen;
    ArrayList<String> spell = new ArrayList<>();

    public Mage(String name, String type, String symbol, int health, int speed, int mana, int intelligence) {
        super(name, "Mage", type, symbol, health, speed);
        this.mana = mana;
        this.intelligence = intelligence;
        boolean frozen = false;
    }

    /********** GETTERS **********/
    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public ArrayList<String> getSpell() {
        return spell;
    }

    /********** SETTERS **********/
    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public void setSpell(ArrayList<String> spell) {
        this.spell = spell;
    }

    // Display all stats
    public void displayAllStats()
    {
        System.out.println("name: " + getName());
        System.out.println("health: " + getHealth());
        System.out.println("int: " + getIntelligence());
        System.out.println("mana: " + getMana());
        System.out.println("type: " + getType());
        System.out.println("Symbol: " + getSymbol());
        System.out.println("speed: " + getSpeed());
    }

    // Use spell
    public void useSpell(String spell)
    {
        switch (spell)
        {
            case "magicMissle":
                Spells.magicMissle(this.intelligence, this.mana);
                break;
            case "icyMist":
                Spells.icyMist(this.intelligence, this.mana);
        }
    }
}
