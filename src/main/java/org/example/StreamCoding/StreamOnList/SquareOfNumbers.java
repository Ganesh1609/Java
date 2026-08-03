package org.example.StreamCoding.StreamOnList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareOfNumbers {
    public static void main(String[] args) {
        SquareOfNumbers squareOfNumbers = new SquareOfNumbers();
        List<Integer> list = Arrays.asList(12, 26, 33, 8, 13, 52, 84, 42, 12, 95, 84, 13, 8, 39);
        squareOfNumbers.allNumbersSquare(list);
        System.out.println(" ************");
        squareOfNumbers.evenNumbersSquare(list);
        System.out.println(" ***********");
        squareOfNumbers.oddNumbersSquare(list);
    }

    public void evenNumbersSquare(List<Integer> list) {
        System.out.println(" Even Numbers Square");
        List<Integer> integerList = list.stream().distinct()
                .filter(e -> e % 2 == 0)
                .map(ele -> ele * ele)
                .collect(Collectors.toList());
        System.out.println(" Even Numbers Square " + integerList);
    }

    public void oddNumbersSquare(List<Integer> list) {
        System.out.println(" Odd Numbers Square");
        List<Integer> integerList = list.stream().distinct()
                .filter(e -> e % 2 != 0)
                .map(ele -> ele * ele)
                .collect(Collectors.toList());
        System.out.println(" Odd Numbers Square " + integerList);
    }

    public void allNumbersSquare(List<Integer> list) {
        System.out.println(" All Numbers Square");
        List<Integer> integerList = list.stream().distinct()

                .map(ele -> ele * ele)
                .collect(Collectors.toList());
        System.out.println(" All Numbers Square " + integerList);

    }
}
