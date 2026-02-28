package org.example.collection.hashMap;

import java.util.HashMap;
import java.util.Map;

public class contact {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.addContact("Rakesh", "98654445456");
        phoneDirectory.addContact("Rahul", "98653335452");
        phoneDirectory.addContact("Milind", "9865335453");
        phoneDirectory.addContact("Umesh", "98658905454");
        phoneDirectory.addContact("Nitin", "98654905455");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap = phoneDirectory.getAllContacts();
        System.out.println(" ********** Get All Contacts  **********");
        for (Map.Entry<String, String> map : hashMap.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }

        System.out.println("  ********** Get  Contact By Name  **********");

        System.out.println(phoneDirectory.getContact("Nitin"));
        System.out.println(phoneDirectory.getContact("Umesh"));
        System.out.println(phoneDirectory.getContact("Pradip"));

        System.out.println(" ********** Delete  Contact By Name  **********");

        System.out.println(phoneDirectory.deleteContact("Milind"));

        System.out.println(" ********** Get All Updated Contact List **********");

        hashMap = phoneDirectory.getAllContacts();
        for (Map.Entry<String, String> map : hashMap.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }
}
