package ua.com.alevel;

import java.util.Random;
import java.util.Scanner;

public class HandControl {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public Person[] createPerson() {
        System.out.println("Сколько людей вы хотите создать? ");
        int people = scanner.nextInt();
        Person[] persons = new Person[people];
        for (int i = 0; i < people; i++) {
            Person pers = new Person(people);
            persons[i] = pers;
        }
        return persons;
    }
    public void handShake(Person[] persons) {
            for (int i = 0; i < persons.length; i++) {
               if(i == 0) {
                   persons[i].setHandShaked(true);
               }
               boolean isHandShaked = persons[i].shakedHand();
                System.out.println("человек с id: " + i + (isHandShaked ? " смог": " не смог" ) + " пожать руку " + (i + 1));
               while (!isHandShaked) {
                   isHandShaked = persons[i].shakedHand();
                   System.out.println("человек с id: " + i + (isHandShaked ? " смог": " не смог" ) + " пожать руку " + (i + 1));
               }
               if(i + 1 >= persons.length){
                   return;
               }
               persons[i + 1].setHandShaked(true);
            }
    }



}


