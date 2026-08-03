package org.example.StreamCoding.StreamOnList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestStringFromList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello", "World", "Java", "Angular");

        String minLength = list.stream()
                .min(Comparator.comparing(e -> e.length()))
                .orElseThrow(NullPointerException::new);
        String maxLength = list.stream()
                .max(Comparator.comparing(e -> e.length()))
                .orElseThrow(NullPointerException::new);
        System.out.println(minLength);
        System.out.println(maxLength);
    }
}
