package com.contactmanager;

import java.util.Scanner;

public class Main {
    private static final ContactManager contactManager = new ContactManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                   Hello and Welcome to smart Contact Manager!
                    1. Add new contact;
                    2. Search contact;
                    3. List of contacts;
                    4. Exit""");
            System.out.print("Please select an option by number: ");
            String customerInput = scanner.nextLine();

            switch (customerInput) {
                case "1" -> addContact();
                case "2" -> searchContact();
                case "3" -> listOfContacts();
                case "4" -> {
                    System.out.print("See you!");
                    return;
                }
                default -> System.out.println("Wrong choice! Try again 😊");
            }
        }
    }

    private static void addContact() {
        System.out.print(" * Creating new contact * \n Enter the full name: ");
        String nameInput = scanner.nextLine();
        System.out.print("Please enter the phone number (10 digits, format 04xxxxxxxx): ");
        String phoneInput = scanner.nextLine();

        contactManager.addContact(new Contact(nameInput, phoneInput));
        System.out.println("New contact was added.\n");
    }

    private static void searchContact() {
        System.out.print(" * Find an exist contact * \nEnter the name to search: ");
        String nameSearch = scanner.nextLine();

        Contact found = contactManager.searchContact(nameSearch);
        if (found != null) {
            System.out.print(found.toLine());
        } else {
            System.out.println("No contact found.\n");
        }
    }

    private static void listOfContacts() {
        System.out.println("Here all your contacts:");
        if (contactManager.isEmpty()) {
            System.out.println("You still do not have any contacts.\n");
        } else {
            for (Contact contact : contactManager.displayAllContacts()){
                System.out.print(contact.toLine());
            }
        }

    }

}
