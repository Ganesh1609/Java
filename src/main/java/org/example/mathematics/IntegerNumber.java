package org.example.mathematics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class IntegerNumber {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            int randomNumber = random.nextInt(100);
            integerList.add(i * randomNumber);
        }
        System.out.println(integerList);
        List<Integer> filterList = integerList.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println("Even Number  ...  " + filterList);

        filterList = integerList.stream().filter(e -> e % 2 != 0).collect(Collectors.toList());
        System.out.println("Odd Number  ...  " + filterList);
    }
}
