package com.digicontacts;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Phonebook {
	private ArrayList<PhoneBookEntry> contacts;

	public Phonebook() {
		contacts = new ArrayList<>();
	}

	public void addContact(PhoneBookEntry entry) {
		contacts.add(entry);
		System.out.println("Contact added");
	}

	public void viewContacts() {
		if (contacts.isEmpty()) {
			System.out.println("No contacts found");
		} else {
			for (PhoneBookEntry contact : contacts) {
				System.out.println(contact);
			}
		}
	}

	public void searchContactByName(String name) {
		boolean found = false;
		for (PhoneBookEntry phoneBookEntry : contacts) {
			if (phoneBookEntry.getName().equalsIgnoreCase(name)) {
				System.out.println(phoneBookEntry);
				found = true;
			}
		}

		if (!found) {
			System.out.println("No contact found with such name");
		}
	}

	public void deleteContact(String name) {
		boolean removed = false;
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getName().equalsIgnoreCase(name)) {
				contacts.remove(i);
				removed = true;
				System.out.println("Contact deleted successfully.");
				break;
			}
		}
		if (!removed) {
			System.out.println("No contact found with such name.");
		}
	}

	public void editContactByName(String name, Scanner scanner) {
		boolean found = false;

		for (PhoneBookEntry phoneBookEntry : contacts) {
			if (phoneBookEntry.getName().equalsIgnoreCase(name)) {
				System.out.println("Contact found: " + phoneBookEntry);
				
				System.out.println("Enter new name (leave blank to keep unchanged: )");
				String updatedName = scanner.nextLine();
				if (!updatedName.isEmpty()) {
					phoneBookEntry.setName(updatedName);
				}
				
				System.out.println("Enter a new phonenumber (leave blank to keep unchanged)");
				String updatedPhoneNumber = scanner.nextLine();
				if(!updatedPhoneNumber.isEmpty()) {
					phoneBookEntry.setPhoneNumber(updatedPhoneNumber);
				}
				
				System.out.println("Enter a new emailId (leave blank to keep unchanged)");
				String updatedEmailId = scanner.nextLine();
				if(!updatedEmailId.isEmpty()) {
					phoneBookEntry.setEmail(updatedEmailId);
				}
				
				System.out.println("Contact updated successfully.");
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("No contact found with that name");
		}
	}
	
	public void saveToFile(String filename) {
		try (FileWriter writer = new FileWriter(filename)){
			for (PhoneBookEntry phoneBookEntry : contacts) {
				writer.write(phoneBookEntry.getName() + ", " + phoneBookEntry.getPhoneNumber() +", " + phoneBookEntry.getEmail() + "\n");
			}
		} catch (Exception e) {
			System.out.println("Error saving to file: "+e.getMessage());
		}
	}
	
	public void loadFromFile(String filename) {
		try(Scanner filescanner = new Scanner(new File(filename))) {
			while (filescanner.hasNextLine()) {
				String line =  filescanner.nextLine();
				String[] parts = line.split(",");
				if (parts.length==3) {
					PhoneBookEntry phoneBookEntry = new PhoneBookEntry(parts[0], parts[1], parts[2]);
					contacts.add(phoneBookEntry);
				}
			}
		} catch (Exception e) {
			
		}
	}
}
