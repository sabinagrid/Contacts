package guru.springframework.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("The record added.");
    }

    public void removeContact(int index) {
        if (index < 0 || index >= contacts.size()) {
            System.out.println("No records to remove!");
        } else {
            contacts.remove(index);
            System.out.println("The record removed!");
        }
    }

    public void editContact(int index, Scanner scanner) {
        if (index < 0 || index >= contacts.size()) {
            System.out.println("No records to edit!");
            return;
        }
        Contact contact = contacts.get(index);
        System.out.println("Select a field (name, surname, number):");
        String field = scanner.nextLine();
        switch (field) {
            case "name":
                System.out.println("Enter name:");
                contact.setName(scanner.nextLine());
                break;
            case "surname":
                System.out.println("Enter surname:");
                contact.setSurname(scanner.nextLine());
                break;
            case "number":
                System.out.println("Enter number:");
                contact.setPhoneNumber(scanner.nextLine());
                break;
            default:
                System.out.println("Invalid field.");
        }
        System.out.println("The record updated!");
    }

    public void listContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    public void countContacts() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
