package org.example.collection.hashMap;

import java.util.*;

public class HashMapPractice {
    public static void main(String[] args) {
        System.out.println("Welcome To Collection HashMap");
        Random random = new Random();
        HashMap<Integer, Integer> hashMap = new java.util.HashMap<Integer, Integer>();
        for (int i = 0; i < 5; i++) {
            hashMap.put(i, (i + 1) * (random.nextInt(10) * 10));
        }
        System.out.println(hashMap);
        String text = "apple banana apple orange banana apple grape";
        String[] words = text.split(" ");
        /* unique  Word count from string */
        /* 1 Using If else */
        System.out.println(wordFrequency1(words));
        /* 2 Using getOrDefault */
        System.out.println(wordFrequency2(words));

        /* unique  character count from string */
        System.out.println(charFrequncy(text));

        /* 	Given a list of words, find the first non-repeating word using */
        System.out.println(firstNonRepatingWord(words));

        /* - Detect duplicates in an array using HashMap*/
        System.out.println(duplicateInArray(words));

        /* - - Design a cache using HashMap + LinkedHashMap (LRU cache).
            (Least Recently Used)
         * */
        System.out.println(LRU());

    }

    private static boolean LRU() {
        LRUCache<Integer, String> cache = new LRUCache<>(1);
        cache.putValue(1, "A");
        cache.putValue(2, "B");
        cache.putValue(3, "C");
        cache.putValue(4, "D");
        cache.putValue(5, "E");
        cache.getValue(4);
        cache.putValue(3, "Z");
        System.out.println(cache);
        return false;
    }

    private static List<String> duplicateInArray(String[] words) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }
        HashMap<String, Integer> finalWords = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String w : words) {
            if (hashMap.get(w) > 1 && !list.contains(w)) {
                list.add(w);
            }
        }

        return list;

    }

    private static String firstNonRepatingWord(String[] words) {
        String word = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word1 : words) {
            hashMap.put(word1, hashMap.getOrDefault(word1, 0) + 1);
        }
        for (String w : words) {
            if (hashMap.get(w).equals(1)) { // can use == or .equals
                return w;
            }
        }
        System.out.println(hashMap);

        return word;
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

    static HashMap<String, Integer> charFrequncy(String text) {
        HashMap<String, Integer> charCount = new HashMap<>();
        String finalString = text.replaceAll(" ", "");
        for (int i = 0; i < finalString.length(); i++) {
            charCount.put(String.valueOf(finalString.charAt(i)), charCount.getOrDefault(String.valueOf(finalString.charAt(i)), 0) + 1);
        }
        return charCount;
    }

}
