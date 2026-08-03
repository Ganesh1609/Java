package org.example.StreamCoding.StreamOnList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindNthNumberFromList {
    public static void main(String[] args) {
        FindNthNumberFromList findNthNumberFromList = new FindNthNumberFromList();
        List<Integer> list = Arrays.asList(12, 26, 33, 8, 13, 52, 84, 42, 12, 95, 84, 13, 8, 39);
        List<Integer> integerList = list.stream().distinct().sorted()
                .collect(Collectors.toList());
        System.out.println(integerList);

        findNthNumberFromList.findNthSmallestNumber(list, 1);
        findNthNumberFromList.findNthHighestNumber(list, 2);
        findNthNumberFromList.findNthNumber(list, 4);
        findNthNumberFromList.findRangeIndexNumber(list, 2, 4);
    }

    private void findRangeIndexNumber(List<Integer> list, int i, int i1) {
        if (i < 0 || (i > list.size() - 1) || i1 < 0 || (i1 > list.size() - 1)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        List<Integer> integerList = list.stream().skip(i - 1).
                limit(i1)
                .collect(Collectors.toList());
        System.out.println(integerList);
    }

    public void findNthSmallestNumber(List<Integer> list, Integer nth) {
        if (nth < 0 || (nth > list.size() - 1)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int value = list.stream().
                distinct()
                .sorted()
                .skip(nth - 1)
                .findFirst()
                .orElseThrow(NullPointerException::new);
        System.out.println(value);
    }

    public void findNthHighestNumber(List<Integer> list, Integer nth) {
        if (nth < 0 || (nth > list.size() - 1)) {
            throw new ArrayIndexOutOfBoundsException();

        }
        int value = list.stream().
                distinct()
                .sorted(Comparator.reverseOrder())
                .skip(nth - 1)
                .findFirst()
                .orElseThrow(NullPointerException::new);
        System.out.println(value);
        System.out.println("************ Alternate reverse ************");
        int value2 = list.stream().
                distinct()
                .sorted(Comparator.comparingInt(ele -> -1 * ele))
                .skip(nth - 1)
                .findFirst()
                .orElseThrow(NullPointerException::new);
        System.out.println(value2);

    }

    public void findNthNumber(List<Integer> list, Integer nth) {
        if (nth < 0 || (nth > list.size() - 1)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int value = list.stream()
                .skip(nth - 1)
                .findFirst()
                .orElseThrow(NullPointerException::new);
        System.out.println(value);
    }
}
