package com.example.cours.service;

import com.example.cours.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private static List<Contact> contacts = new ArrayList<>();


    public void add(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContactById(int id) {
        return contacts.get(id);
    }
}
