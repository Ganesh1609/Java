package org.example.StreamCoding.StreamOnList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfList {
    public static void main(String[] args) {
ListOfList listOfList = new ListOfList();
List<List<Integer>> list = Arrays.asList(
        Arrays.asList(1,2,4,6,7),
        Arrays.asList(12,22,84,46,87),
        Arrays.asList(1,72,64,46,87),
        Arrays.asList(1,28,4,2,7)
);
        System.out.println(list);
listOfList.removeDuplicate(list);
    }

    private void removeDuplicate(List<List<Integer>> list) {

        List<Integer> collect = list.stream().
                flatMap(list1 -> list1.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collect);
        //  .forEach(System.out::println);
    }
}
