package org.example.collection.hashMap;

import java.util.HashMap;

public class PhoneDirectory {
    private HashMap<String, String> directory;

    PhoneDirectory() {
        directory = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        directory.put(name, phoneNumber);
    }

    public String getContact(String name) {
        return directory.getOrDefault(name, "Contact Not Found");
    }

    public boolean deleteContact(String name) {
        return directory.remove(name) != null;
    }

    public HashMap<String, String> getAllContacts() {
        return directory;
    }
}
