package ua.com.alevel.string;

public class Strings {

    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;

        for (int i = 0; i < length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[length - 1 - i];
            chars[length - 1 - i] = temp;
        }

        return new String(chars);
    }

    public static String reverse(String src, String dest) {
        int startIndex = src.indexOf(dest);
        int endIndex = startIndex + dest.length() - 1;

        if (startIndex != -1) {
            String reversedSubstring = reverseSubstring(src, startIndex, endIndex);
            System.out.println(reversedSubstring);

            return reversedSubstring;
        } else {

            return src;
        }
    }

    public static String reverseSubstring(String input, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= input.length() || startIndex > endIndex) {

            return input;
        }

        char[] chars = input.toCharArray();

        for (int i = startIndex, j = endIndex; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return new String(chars);
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        if (firstIndex < 0 || lastIndex >= src.length() || firstIndex > lastIndex) {
            return src;
        }

        char[] chars = src.toCharArray();

        for (int i = firstIndex, j = lastIndex; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        System.out.println(new String(chars));
        return new String(chars);
    }

}
