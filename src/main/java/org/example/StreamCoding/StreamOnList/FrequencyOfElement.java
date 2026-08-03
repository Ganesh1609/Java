package org.example.StreamCoding.StreamOnList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOfElement {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 26, 33, 52, 13, 52, 84, 42, 12, 95, 84, 13, 8, 39);

        Map<Integer, Long> integerIntegerMap = list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(integerIntegerMap);
    }
}
