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
        System.out.println();
        String text = "apple banana apple orange banana apple grape";
        String[] words = text.trim().split(" ");

        System.out.println();
        /* unique  Word count from string */
        System.out.println("  ********** unique  Word count from string  ********** ");
        /* 1 Using If else */
        System.out.println("   ********** 1 Using If else   ********** ");

        System.out.println(wordFrequency1(words));
        /* 2 Using getOrDefault */
        System.out.println("   **********  2 Using getOrDefault    ********** ");
        System.out.println(wordFrequency2(words));

        System.out.println();
        System.out.println("   **********  Get Single Element    ********** ");
        System.out.println(wordFrequency3(words));

        System.out.println();
        /* unique  character count from string */
        System.out.println("  **********  unique  character count from string    ********** ");
        System.out.println(charFrequncy(text));

        System.out.println();
        /* 	Given a list of words, find the first non-repeating word using */
        System.out.println("  **********  Given a list of words, find the first non-repeating word using   **********  ");
        System.out.println(firstNonRepatingWord(words));

        System.out.println();
        /* - Detect duplicates in an array using HashMap*/
        System.out.println("  **********  Detect duplicates in an array using HashMap  ********** ");
        System.out.println(duplicateInArray(words));

        System.out.println();
        /* - Get Unique in an array using HashMap*/
        System.out.println("  **********  Get Unique in an array using HashMap  ********** ");
        System.out.println(uniqueInArray(words));

        System.out.println();
        /* - - Design a cache using HashMap + LinkedHashMap (LRU cache).
            (Least Recently Used)
         * */
        System.out.println("  **********  Design a cache using HashMap + LinkedHashMap (LRU cache) (Least Recently Used)  ********** ");
        LRU();

        System.out.println();
        System.out.println("  **********  collision ********** ");
        /* *  collision :-
         * A collision occurs when two different keys produce the same hash code and therefore map to the same bucket index in the HashMap
         * */
        Map<String, Integer> map = new HashMap<>();
        map.put("AA", 1);
        map.put("BB", 2);
        System.out.println(map.hashCode());
        System.out.println(map.get("AA").hashCode());
        System.out.println(map.get("BB").hashCode());

        System.out.println();
        System.out.println("  **********  equals ********** ");
        System.out.println(map.get("BB").equals(map.get("BB"))); // true
        System.out.println(map.get("AA").equals(map.get("BB")));// false

        System.out.println();
        System.out.println("  **********  compareTo ********** ");

        System.out.println(map.get("AA").compareTo(map.get("BB"))); // -1
        System.out.println(map.get("BB").compareTo(map.get("AA"))); // 1
        System.out.println(map.get("BB").compareTo(map.get("BB"))); // 0
        System.out.println(map.get("AA").compareTo(map.get("AA"))); // 0

        System.out.println();
        System.out.println("  **********  String and Math conversion  ********** ");

        System.out.println(map.get("AA").toString()); // 1
        System.out.println(map.get("AA").byteValue()); // 1
        System.out.println(map.get("AA").byteValue()); // 1
        System.out.println(map.get("AA").floatValue()); // 1.0
        System.out.println(map.get("AA").intValue()); // 1

    }

    private static List<String> uniqueInArray(String[] words) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s : words) {
            hashMap.computeIfAbsent(s, k -> 1);
        }
        System.out.println(hashMap);
        hashMap.keySet().iterator().forEachRemaining(ele -> list.add(ele));
        return list;
    }

    private static HashMap<String, Integer> wordFrequency3(String[] words) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String w : words) {
            hashMap.put(w, hashMap.getOrDefault(w, 0) + 1);
        }
//        hashMap.keySet().removeIf(e->e.equalsIgnoreCase(hashMap.values().removeIf(ele->ele>1)));
        hashMap.keySet().removeIf(ele -> hashMap.get(ele) > 1);
        return hashMap;

    }

    private static void LRU() {
        LRUCache<Integer, String> cache = new LRUCache<>(1);
        cache.putValue(1, "A");
        cache.putValue(2, "B");
        cache.putValue(3, "C");
        cache.putValue(4, "D");
        cache.putValue(5, "E");
        cache.getValue(4);
        cache.putValue(3, "Z");
        System.out.println(cache);

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
            if (!hashMap.containsKey(word.trim())) {
                hashMap.put(word.trim(), 1);
            } else {
                hashMap.put(word.trim(), hashMap.get(word.trim()) + 1);
            }
        }
        return hashMap;
    }

    static HashMap<String, Integer> wordFrequency2(String[] words) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word.trim(), wordCount.getOrDefault(word.trim(), 0) + 1);
        }
        return wordCount;
    }

    static HashMap<String, Integer> charFrequncy(String text) {
        HashMap<String, Integer> charCount = new HashMap<>();
        String finalString = text.replaceAll(" ", "").trim();
        for (int i = 0; i < finalString.length(); i++) {
            charCount.put(String.valueOf(finalString.charAt(i)), charCount.getOrDefault(String.valueOf(finalString.charAt(i)), 0) + 1);
        }
        return charCount;
    }

}
