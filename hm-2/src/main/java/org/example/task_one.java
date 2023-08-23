package org.example;

import java.util.Scanner;


public class task_one {

    public void taskOne() {
//    1. реализуйте задачу, которая принимает строку с консоли и вычленяет все числа и находит их сумму

        Scanner textString = new Scanner(System.in);
        System.out.println("Enter a phrase: ");
        String userPhrase = textString.nextLine();

        String number = "";
        char symbol = ' ';
        int indicator = 0;
        double sum = 0;

        for (int i = 0; i < userPhrase.length(); i++) {
            symbol = userPhrase.charAt(i);

            if (Character.isDigit(symbol) == false && indicator > 0) {
                sum = sum + Integer.parseInt(number);
                indicator = 0;
                number = "";
            }

            if (Character.isDigit(symbol)) {
                number += symbol;
                indicator++;
            }


        }
        if (indicator > 0)
            sum = sum + Integer.parseInt(number);

        System.out.println("Sum of all numbers: " + sum);


    }
        }






