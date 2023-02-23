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

    public void update(String firstName, String lastName, String phone, int id) {
        Contact contact = getContactById(id);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
    }

    public void deleteContact(int id) {
        /*List<Contact> tmpContacts = new ArrayList<>();
        for(int i=0; i < contacts.size(); i++) {
            if(i != id) {
                tmpContacts.add(contacts.get(i));
            }
        }
        contacts = tmpContacts;*/
        contacts.remove(id);
    }
}
