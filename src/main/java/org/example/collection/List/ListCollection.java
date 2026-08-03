package org.example.collection.List;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListCollection {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Suraj", "Ganesh", "Nitin", "Meghraj", "Kishan", "Krishna", "Akshay");

        Map<Integer, List<String>> integerListMap = words.stream().
                collect(Collectors.groupingBy(String::length));
        System.out.println(integerListMap);
        integerListMap.forEach((length, list) -> {
            System.out.println("length " + length);
            System.out.println("list " + list);
            System.out.println(" list length " + list.size());
        });

//
        List<Integer> numbers = Arrays.asList(1, 5, 132, 89, 6, 8, 87, 4, 89);
        int i = numbers.stream().distinct()
                .sorted((a, b) -> b - a)
                .skip(2).findFirst().get();
        System.out.println(i);
    }
}

