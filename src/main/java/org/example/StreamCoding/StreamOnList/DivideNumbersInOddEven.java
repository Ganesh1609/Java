package org.example.StreamCoding.StreamOnList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DivideNumbersInOddEven {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 26, 33, 8, 13, 52, 84, 42, 12, 95, 84, 13, 8, 39);

        Map<Boolean, List<Integer>> collect = list.stream().distinct().collect(
                Collectors.partitioningBy(e -> e % 2 == 0));

        System.out.println(collect);

    }

}
