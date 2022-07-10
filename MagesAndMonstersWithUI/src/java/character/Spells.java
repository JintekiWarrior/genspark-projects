package character;

public interface Spells {

    static int magicMissle(int intelligence, int mana)
    {
       mana -= 3;
       return intelligence + 2;
    }

    static int icyMist(int intelligence, int mana)
    {
        mana -= 5;
        return intelligence + 2;
    }
}
