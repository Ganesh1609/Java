package org.example.String;

import java.util.Optional;

public class StringExample {
    public static void main(String[] args) {
        String s = "San";
        String st = null;
//        System.out.println(s.contains("A"));

        Optional<String> optionalString = Optional.ofNullable(st);
        Optional<String> s1 = Optional.of(s);
        System.out.println(optionalString);
        System.out.println(s1);
        String string = optionalString.orElse("Hello");
        System.out.println(string);
        optionalString.ifPresent(e -> System.out.println(e));

        Optional<String> optionalString1 = s1.map(ele -> ele + " World");
        System.out.println(optionalString1);

    }
}
