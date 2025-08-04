package com.digicontacts;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

//		System.out.println("Welcome to DigiContacts!");
		Scanner scanner = new Scanner(System.in);
		Phonebook phoneBook = new Phonebook();

		while (true) {
			System.out.println("\n****PhoneBook Menu****");
			System.out.println("1. Add Contact");
			System.out.println("2. View  All Contacts");
			System.out.println("3. Search Contact by Name");
			System.out.println("4. Update the Contact by Name");
			System.out.println("5. Delete the Contact");
			System.out.println("6. Exit");
			System.out.println("Choose an option (1-6): ");

			int choice = scanner.nextInt();
			// the below line of code will consume leftover newline
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter the  name: ");
				String personName = scanner.nextLine();

				System.out.println("Enter the  phone number: ");
				String phoneNumber = scanner.nextLine();

				System.out.println("Enter the  email: ");
				String emailId = scanner.nextLine();

				PhoneBookEntry entry = new PhoneBookEntry(personName, phoneNumber, emailId);
				phoneBook.addContact(entry);
				break;

			case 2:
//					System.out.println("See all contacts");
				phoneBook.viewContacts();
				break;

			case 3:
				System.out.println("Enter the name for which you want to search.");
				String searchPersonName = scanner.nextLine();
				phoneBook.searchContactByName(searchPersonName);
				break;

			case 4:
				System.out.println("Enter the name to edit: ");
				String nameToEdit = scanner.nextLine();
				phoneBook.editContactByName(nameToEdit, scanner);
				break;
			case 5:
				System.out.println("Enter name to delete.");
				String deleteName = scanner.nextLine();
				phoneBook.deleteContact(deleteName);
				break;
				
			case 6:
				System.out.println("Exiting DigiContacts. Goodbye!");
				scanner.close();
				System.exit(0);

			default:
				System.out.println("Invalid option. Please try again.");
			}

		}
	}

}
