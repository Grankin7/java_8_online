package ua.com.alevel;

public class Main {
    public static void main(String[] args) {
        HandControl handControl = new HandControl();
        Person[] people =  handControl.createPerson();
        handControl.handShake(people);


    }
}