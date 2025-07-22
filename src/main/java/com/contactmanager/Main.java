package com.contactmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Contact> contacts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add new contact;\n2. Search contact;\n3. List of contacts;\n4. Exit");
            System.out.print("Kindly select an option by number: ");
            String customerInput = scanner.nextLine();

            switch (customerInput) {
                case "1" -> addContact();
                case "2" -> searchContact();
                case "3" -> listOfContacts();
                case "4" -> {
                    System.out.print("See you!");
                    return;
                }
                default -> System.out.print("Wrong choice! Try again 😊");
            }
        }
    }

    private static void addContact() {
        System.out.println("\n Creating new account. \n Enter the full name: ");
        String nameInput = scanner.nextLine();
        System.out.println("Please enter the phone number (10 digits, format 04xxxxxxxx): ");
        String phoneInput = scanner.nextLine();

        contacts.add(new Contact(nameInput, phoneInput));
        System.out.print("New contact was added.");
    }

    private static void searchContact() {
        System.out.println("\n Find an exist contact. \nEnter the name to search: ");
        String nameSearch = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(nameSearch)) {
                System.out.println(contact.toLine());
                return;
            }
        }

        System.out.print("No contact found.");
    }

    private static void listOfContacts() {
        System.out.println("Here all your contacts:");
        if (contacts.isEmpty()) {
            System.out.print("You still do not have any contacts.");
        } else {
            for (Contact contact : contacts){
                System.out.print(contact.toLine());
            }
        }

    }

}
