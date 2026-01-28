package org.example.collection.hashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class HashMapPractice {
    public static void main(String[] args) {
        System.out.println("Welcome To Collection HashMap");
        Random random = new Random();
        HashMap<Integer, Integer> hashMap = new java.util.HashMap<Integer, Integer>();
        for (int i = 0; i < 5; i++) {
            hashMap.put(i, (i + 1) * 10);

        }
        System.out.println(hashMap);
        String text = "apple banana apple orange banana apple grape";

        String[] words = text.split(" ");
        System.out.println(wordFrequency1(words));
        System.out.println(wordFrequency2(words));

    }

    static HashMap<String, Integer> wordFrequency1(String[] words) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        System.out.println(Arrays.toString(words));
        for (String word : words) {
            if (!hashMap.containsKey(word)) {
                hashMap.put(word, 1);
            } else {
                hashMap.put(word, hashMap.get(word) + 1);
            }
        }
        return hashMap;
    }

    static HashMap<String, Integer> wordFrequency2(String[] words) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

}
