package guru.springframework.json;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("Enter action (add, remove, edit, count, list, exit):");
            String action = scanner.nextLine().trim().toLowerCase();

            switch (action) {
                case "add":
                    System.out.println("Enter the name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter the surname:");
                    String surname = scanner.nextLine();
                    System.out.println("Enter the number:");
                    String phoneNumber = scanner.nextLine();

                    Contact contact = new Contact(name, surname, phoneNumber);
                    phoneBook.addContact(contact);
                    break;

                case "remove":
                    if (phoneBook.getContacts().isEmpty()) {
                        System.out.println("No records to remove!");
                    } else {
                        phoneBook.listContacts();
                        System.out.println("Select a record:");
                        int index = Integer.parseInt(scanner.nextLine()) - 1;
                        phoneBook.removeContact(index);
                    }
                    break;

                case "edit":
                    if (phoneBook.getContacts().isEmpty()) {
                        System.out.println("No records to edit!");
                    } else {
                        phoneBook.listContacts();
                        System.out.println("Select a record:");
                        int index = Integer.parseInt(scanner.nextLine()) - 1;
                        phoneBook.editContact(index, scanner);
                    }
                    break;

                case "count":
                    phoneBook.countContacts();
                    break;

                case "list":
                    phoneBook.listContacts();
                    break;

                case "exit":
                    return;

                default:
                    System.out.println("Unknown action!");
            }
        }
    }
}
