package org.example.collection.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class HashMapPractice {
    public static void main(String[] args) {
        System.out.println("Welcome To Collection HashMap");
        Random random=new Random();
        HashMap<Integer, Integer> hashMap = new java.util.HashMap<Integer, Integer>();
        for (int i = 0; i < 5; i++) {
            hashMap.put(i, random.nextInt(10));
        }
        System.out.println(hashMap);
        ArrayList arrayList=new ArrayList();

//hashMap.forEach((ele,index)->{
//    if(index<=hashMap.size()-1){
//        if(ele+hashMap.)
//    }
//});
//        hashMap.computeIfPresent((ele1)->{
//            ele1
//        });
    }

}
