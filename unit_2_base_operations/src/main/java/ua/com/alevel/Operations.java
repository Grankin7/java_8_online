package ua.com.alevel;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Operations {
    public void circle() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int x = 20;
        System.out.println("x = " + (++x));
        System.out.println("x = " + x);

        int[] ints = new int[10];

        for (int i = 0; i < 10; i++) {
            ints[i] = i;
        }

        for (int i = 0; i < ints.length; i++) {
            System.out.println("ints = " + ints[i]);
        }

        int st = 0;
        while (st < ints.length) {
            System.out.println("ints = " + ints[st]);
            ++st;
        }
        try {
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                System.out.println("text = " + text);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("finish");
    }

    public void ifSwitch() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int number = Integer.parseInt(bufferedReader.readLine());
            if (number < 10) {
                System.out.println("number < " + number);
            } else if (number < 50) {
                System.out.println("number >= 10 && number < 50");
            } else {
                System.out.println("number >= 50");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
