public class Hello_java {
    public static void main(String[] args){
        System.out.println("Hello Java!");
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




    }
}