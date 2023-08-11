package ua.com.alevel;
import ua.com.alevel.test.MyMassage;
import ua.com.alevel.depends.Depends;
public class HelloJava {
    public static void main(String[] args){
        System.out.println("Hello Java!");
        //ua.com.alevel.test.MyMassage myMassage = new ua.com.alevel.test.MyMassage();
        MyMassage myMassage = new MyMassage();
        byte b = Byte.MAX_VALUE;
        byte b1 = Byte.MIN_VALUE;
        short s = Short.MAX_VALUE;
        int a = Integer.MAX_VALUE;
        long l = Long.MAX_VALUE;
        myMassage.print(String.valueOf(b));
        myMassage.print(String.valueOf(b1));
        myMassage.print(String.valueOf(s));
        myMassage.print(String.valueOf(a));
        myMassage.print(String.valueOf(l));

        System.out.println(" ");
        Depends d = new Depends();
        d.console("Hello!!");

    }
}