package com.contactmanager;

import java.util.ArrayList;

public class ContactManager {
    private final ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return contacts.isEmpty();
    }

    public ArrayList<Contact> displayAllContacts() {
        return contacts;
    }


}
