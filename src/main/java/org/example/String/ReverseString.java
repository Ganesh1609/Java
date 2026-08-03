package org.example.String;

public class ReverseString {
    public static void main(String[] args) {
        String name = "Ganesh";
        String reverseName = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            reverseName = reverseName.concat(String.valueOf(name.charAt(i)));
        }
        System.out.println("name : " + name);
        System.out.println("reverseName : " + reverseName);
        if (name.equalsIgnoreCase(reverseName)) {
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is not Palindrome");
        }
        ReverseString reverseString = new ReverseString();
        reverseString.stringBufferMethod();
        reverseString.stringBuilderMethod();

    }

    public void stringBufferMethod() {
        System.out.println("************ stringBufferMethod ******************");
        String name = "Nitin";
        StringBuffer stringBuffer = new StringBuffer(name);
//        stringBuffer.append("Nitin");
        System.out.println(stringBuffer);

        String reverseString = stringBuffer.reverse().toString();
        System.out.println("reverseString " + reverseString);

        if (name.equalsIgnoreCase(reverseString)) {
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is not Palindrome");
        }
    }

    public void stringBuilderMethod() {
        System.out.println("********** stringBuilderMethod *************");
        String name = "Nitin";
        StringBuilder stringBuilder = new StringBuilder(name);
//        stringBuffer.append("Nitin");
        System.out.println(stringBuilder);

        String reverseString = stringBuilder.reverse().toString();
        System.out.println("reverseString " + reverseString);

        if (name.equalsIgnoreCase(reverseString)) {
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is not Palindrome");
        }
    }
}
