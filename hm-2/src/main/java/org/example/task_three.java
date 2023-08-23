package org.example;

import java.util.Scanner;

public class task_three {

    public void taskThree() {
//        3. Конец уроков
//        В некоторой школе занятия начинаются в 9:00. Продолжительность урока — 45 минут, после 1-го, 3-го, 5-го
//        и т.д. уроков перемена 5 минут, а после 2-го, 4-го, 6-го и т.д. — 15 минут.

        Scanner textInt = new Scanner(System.in);
        System.out.println("Enter a number lesson: ");
        Integer lesson = textInt.nextInt();
        int minutesLessons = 45;
        int evenBreak = (((lesson - 1 ) / 2) * 15) ;
        int noEvenBreak = (((lesson) / 2) * 5);
        int totalMinutesLessons = lesson * minutesLessons + noEvenBreak + evenBreak + (9 * 60);
        int lessonHour = totalMinutesLessons / 60;
        int lessonMinutes = totalMinutesLessons % 60;

        System.out.println("End of lesson " + lesson + " is " + lessonHour + " : " + lessonMinutes);


    }

}
