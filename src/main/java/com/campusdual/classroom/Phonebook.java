package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {

    private Map<String, Contact> Data;

    public Phonebook() {
        this.Data = new HashMap<>();
    }


    public void addContact(Contact c) {
        this.Data.put(c.getCode(), c);
    }

    public void deleteContact(String code) {
        this.Data.remove(code);
    }

    public void showPhonebook() {
        for (Contact c : Data.values()) {
            System.out.println(c);
        }
    }

    public Map<String, Contact> getData() {
        return Data;
    }

    public void setData(Map<String, Contact> data) {
        Data = data;
    }
}


