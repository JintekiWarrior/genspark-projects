package DataModel;

import User.User;

public class Character
{
    private String type;
    private int health;
    private int attack;
    private String symbol;
    private User user;

    public Character(String type, int health, int attack, String symbol, User user)
    {
        this.type = type;
        this.health = health;
        this.attack = attack;
        this.symbol = symbol;
        this.user = user;
    }

    /***** Getters *****/
    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public String getSymbol() {
        return symbol;
    }

    public User getUser() {
        return user;
    }

    /***** Setters *****/
    public void setType(String type) {
        this.type = type;
    }

    public void sethealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /***** Methods *****/
    public void getAttacked(int damage)
    {
        health -= damage;
    }
}
