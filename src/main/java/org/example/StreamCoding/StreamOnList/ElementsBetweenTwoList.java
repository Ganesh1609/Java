package org.example.StreamCoding.StreamOnList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ElementsBetweenTwoList {
    public static void main(String[] args) {
        ElementsBetweenTwoList elementsBetweenTwoList = new ElementsBetweenTwoList();
        List<Integer> list1 = Arrays.asList(1, 32, 37, 42,15,76,57, 8, 49, 10);
        List<Integer> list2 = Arrays.asList(11, 32, 37, 42,125,76,57, 85, 49, 100);

        elementsBetweenTwoList.commonElements(list1,list2);
    }

    private void commonElements(List<Integer> list1, List<Integer> list2) {
        List<Integer> common = list1.stream()
                .filter(x -> list2.stream().anyMatch(y -> x == y))
                .collect(Collectors.toList());
        System.out.println(common);
        List<Integer> common2 = list1.stream()
                .filter(x -> list2.contains(x)) //O(n) time complexity
                .sorted()
                .collect(Collectors.toList());
        System.out.println(common2);

        Set<Integer> commonSet = new HashSet<>(list1);
        Set<Integer> collect = list2.stream().filter(y -> commonSet.contains(y))//O(1) time complexity
                .collect(Collectors.toSet());
        System.out.println(collect);


    }
}
