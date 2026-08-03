package org.example.StreamCoding.StreamOnList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateAndSort {
    public static void main(String[] args) {
        RemoveDuplicateAndSort removeDuplicateAndSort = new RemoveDuplicateAndSort();
        List<Integer> list = Arrays.asList(12, 26, 33, 8, 13, 52, 84, 42, 12, 95, 84, 13, 8, 39);
        removeDuplicateAndSort.ascOrder(list);
        removeDuplicateAndSort.dscOrder(list);
    }

    public void dscOrder(List<Integer> list) {
        List<Integer> integerList = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(" Reverse Order " + integerList);
    }

    public void ascOrder(List<Integer> list) {
        List<Integer> integerList = list.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("  Order " + integerList);
    }
}
