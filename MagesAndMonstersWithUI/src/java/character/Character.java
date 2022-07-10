package character;

import GameBoard.GameBoard;

public class Character {

    // constructors
    String name;
    String race;
    String type;
    String symbol;
    int health;
    int speed;

    // non-constructors
    int rowPosition;
    int colPosition;

    public Character(String name, String race, String type, String symbol, int health, int speed) {
        this.name = name;
        this.race = race;
        this.type = type;
        this.symbol = symbol;
        this.health = health;
        this.speed = speed;
    }

    /********** GETTERS **********/
    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public String getType() {
        return type;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public int getColPosition() {
        return colPosition;
    }


    /********** SETTERS **********/
    public void setHealth(int health) {
        this.health = health;
    }

    public void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }

    public void setColPosition(int colPosition) {
        this.colPosition = colPosition;
    }
}
