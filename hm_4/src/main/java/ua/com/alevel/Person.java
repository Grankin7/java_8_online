package ua.com.alevel;

import java.util.Random;

public class Person  {
   int peoplecount;
    Person(int people) {
        peoplecount = people;
    }
    Random random = new Random();
    private int id;
    private boolean isHandShaked = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHandShaked() {
        return isHandShaked;
    }

    public void setHandShaked(boolean handShaked) {
        isHandShaked = handShaked;
    }



    public boolean shakedHand() {
        int randomNumber = random.nextInt(peoplecount);
        return randomNumber < peoplecount / 2;
    }
}
