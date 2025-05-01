package org.example.mathematics.randomNumber;

import java.util.Random;

public class RandomNumberInteger {
    public static void main(String[] args) {
        System.out.println("Welcome To Random Number Generation");
        Random random = new Random();
        /* Random number with bound:
         *If you want only positive integers, then use random.nextInt(bound) or filter out negatives manually.
         * random.nextInt(upperBound) gives a number from 0 (inclusive) to upperBound (exclusive).
         *
         * */

        int number = random.nextInt(100); // generates a number from 0 to 99
        System.out.println("Random number with bound: " + number);

        /* Random number without a bound:
         *This will return a random number in the full range of int
         *which is: from -2,147,483,648 to 2,147,483,647
         *Useful when you want truly random int values, not limited to a range.
         *
         * */
        int value = random.nextInt();
        System.out.println("Random number without a bound: " + value);

        /*Random number with a Math.Random:
         *Math.random() is a static method in the Math class that returns a random double value between.
         * 0.0 (inclusive) and 1.0 (exclusive).
         * To convert full integer multiply by 10/100/1000 as per your requirement.
         * */
        int numberFromMathRandom = (int) (Math.random() * 100); // 0 to 99
        System.out.println("Random number With Math.random(): " + numberFromMathRandom);

        /*
        *To Generate Integer in a Specific Range
        *Example: Integer between 50 and 100
        *
        * */
        int min = 50;
        int max = 1000;
        final double amount= Math.random();
        System.out.println("amount "+amount);
        System.out.println("Random number With Math.random() with specific range: " + (int)(amount * (max )));
        System.out.println("Random number With Math.random() with specific range: " + (int)(amount * (max-min )));
        System.out.println("Random number With Math.random() with specific range: " + (int)(amount * (max -min+1)));
        System.out.println("Random number With Math.random() with specific range: " + (int)(amount * (max -min+1))+min);

        int randomNumberWithRange = (int)( amount * (max - min + 1)) + min;
        System.out.println("Final Random number With Math.random() with specific range: " + randomNumberWithRange);

    }
}
