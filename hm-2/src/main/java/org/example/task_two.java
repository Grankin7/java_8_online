package org.example;

import java.util.Scanner;

public class task_two {

    public void taskTwo(){
// 2. реализуйте задачу, которая
// принимает строку с консоли и вычленяет все символы латиницы/кириллицы и сортирует их,
// указывая количество вхождений каждого символа

        Scanner textString = new Scanner(System.in);
        System.out.println("Enter a phrase: ");
        String userPhrase = textString.nextLine();

        int numbers[] = new int[userPhrase.length()];

        char ch[] = userPhrase.toCharArray();

        for(int i = 0; i < ch.length-1; i++) {
            numbers[i] = 1;
            for (int j = i + 1; j < ch.length; j++) {
                if(ch[i] == ch[j]) {
                    numbers[i]++;
                    ch[j] = '0';
                }
            }
        }

        for (int i = 0; i < numbers.length; i ++) {
            if(ch[i] != '0' && ch[i] != ' ') {
                System.out.println(ch[i] + " - " + numbers[i]);
            }
        }



    }

}
