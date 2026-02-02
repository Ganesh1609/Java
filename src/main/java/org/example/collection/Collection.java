package org.example.collection;

import org.example.collection.hashMap.HashMapPractice;

public class Collection extends HashMapPractice {

    Collection() {

    }

    public static void main(String[] aregs) {
        String text = "Ganesh ";
        System.out.println(charFrequncy(text));
        System.out.println();
        charFrequncy2(text);
    }
}
