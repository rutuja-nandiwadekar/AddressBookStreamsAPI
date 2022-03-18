/*
 *Program to add multiple Address Book to the System. 
 *Each Address Book has a unique Name
 */
package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {
	static Scanner scanner = new Scanner(System.in);
	static String regex;
	// creation of arraylist
	ArrayList<Contacts> personDetails = new ArrayList<>();

	/*
	 * @purpose: This is the method to add a new Contact to Address Book
	 */
	public void newContact(Scanner scanner) {
		Contacts add = new Contacts();

		System.out.println("Enter your First Name");
		String firstName = scanner.next();
		add.setFirstName(validateFirstName(firstName, scanner));

		System.out.println("Enter your Last Name");
		String lastName = scanner.next();
		add.setLastName(validateLastName(lastName, scanner));

		System.out.println("Enter your City");
		String city = scanner.next();
		add.setCity(validateCity(city, scanner));

		System.out.println("Enter your state");
		String state = scanner.next();
		add.setState(validateState(state, scanner));

		System.out.println("Enter your Zip");
		String zip = scanner.next();
		add.setZip(validateZip(zip, scanner));

		System.out.println("Enter your Phone Number");
		String phoneNumber = scanner.next();
		add.setPhoneNumber(validatePhone(phoneNumber, scanner));

		System.out.println("Enter your email ID");
		String email = scanner.next();
		add.setEmail(validateEmail(email, scanner));

		System.out.println("Added Successfully");

		// Add the above list to personDetails array list
		personDetails.add(add);
		System.out.println(add);
	}

	/*
	 * @purpose: This is the method to edit existing contact person using their name
	 */
	public void editContact(Scanner scanner) {
		System.out.println("Enter name to Edit");
		String name = scanner.next();

		for (int i = 0; i < personDetails.size(); i++) {
			Contacts update = (Contacts) personDetails.get(i);

			if (name.equals(update.getFirstName())) {
				System.out.print(
						"Enter what to update(1.first name/ 2.last name/ 3.city/ 4.state/ 5.phone/ 6.zip/ 7.email): ");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter your first name to update:");
					String firstName = scanner.next();
					update.setFirstName(validateFirstName(firstName, scanner));
					break;
				case 2:
					System.out.println("Enter your last name to update:");
					String lastName = scanner.next();
					update.setLastName(validateLastName(lastName, scanner));
					break;
				case 3:
					System.out.println("Enter your city name to update:");
					String city = scanner.next();
					update.setCity(validateCity(city, scanner));
					break;
				case 4:
					System.out.println("Enter your state name to update:");
					String state = scanner.next();
					update.setState(validateState(state, scanner));
					break;
				case 5:
					System.out.println("Enter Your phone no to update:");
					String phoneNumber = scanner.next();
					update.setPhoneNumber(validatePhone(phoneNumber, scanner));
					break;
				case 6:
					System.out.println("Enter Your zip to update:");
					String zip = scanner.next();
					update.setZip(validateZip(zip, scanner));
					break;
				case 7:
					System.out.println("Enter Your email to update:");
					String email = scanner.next();
					update.setEmail(validateEmail(email, scanner));
					break;
				default:
					System.out.println("invalid choice");
					break;
				}
				System.out.println("Contacts Edited Successfully\n" + personDetails);
			}
		}
	}

	/*
	 * @purpose: This is the method to delete existing contact person using their
	 * name
	 */
	public void deletePerson() {

		System.out.println("Enter name to Delete");
		String name = scanner.next();

		for (int i = 0; i < personDetails.size(); i++) {
			Contacts p = (Contacts) personDetails.get(i);
			if (name.equals(p.getFirstName())) {
				personDetails.remove(i);
				System.out.println("Contacts deleted Successfully\n" + personDetails);
			}
		}
	}

	/*
	 * @purpose: This is the method to view existing contact details
	 */
	public void viewPerson() {
		for (Contacts p : personDetails) {
			System.out.println(p);
		}
	}

	public void operations() {
		int choice = 1;
		int person_count, addressbook_count, i, j;
		// Creating the object of the class
		AddressBook addPerson = new AddressBook();
		while (choice != 0) {
			System.out.println(
					"0.To exit\n1.To add new address book and add Persons details\n2.Edit Person\n3.Delete Person\n4.Display Person\nEnter your choice:\n");
			int option = scanner.nextInt();
			switch (option) {
			case 0:
				System.out.println("Exiting from address book");
				System.exit(0);
				break;
			case 1:
				System.out.println("Enter Number of Address book you want to add :");
				addressbook_count = scanner.nextInt();
				for (i = 0; i < addressbook_count; i++) {
					System.out.println("Enter the address book number");
					int N = scanner.nextInt();
					System.out.printf("welcome to Address-book_%d\n", N);
					System.out.println("Enter Number of persons you want to add :");
					person_count = scanner.nextInt();
					for (j = 0; j < person_count; j++) {
						addPerson.newContact(scanner);
					}
				}
				break;
			case 2:
				addPerson.editContact(scanner);
				break;
			case 3:
				addPerson.deletePerson();
				break;
			case 4:
				addPerson.viewPerson();
				break;
			default:
				System.out.println("Select valid option");
				break;
			}
		}
	}

	/*
	 * @purpose: As a User need to enter a valid First Name. First name starts with
	 * Cap and has maximum 10 characters
	 */
	public static String validateFirstName(String firstName, Scanner scanner) {
		regex = "^[A-Z]{1}[a-z]{2,9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(firstName);

		while (!matcher.matches()) {
			System.out.println("Invalid first name, please try again....");
			firstName = scanner.nextLine();
			matcher = pattern.matcher(firstName);
		}
		return firstName;
	}

	/*
	 * @purpose: As a User need to enter a valid Last Name. Last name starts with
	 * Cap and has maximum 10 characters
	 */
	public static String validateLastName(String lastName, Scanner scanner) {
		regex = "^[A-Z]{1}[a-z]{2,9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(lastName);

		while (!matcher.matches()) {
			System.out.println("Invalid first name, please try again...");
			lastName = scanner.nextLine();
			matcher = pattern.matcher(lastName);
		}
		return lastName;
	}

	/*
	 * @purpose: As a User need to enter a valid City. city name starts with Cap and
	 * has maximum 10 characters
	 */
	public static String validateCity(String city, Scanner scanner) {
		regex = "^[A-Z]{1}[a-z]{2,9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(city);

		while (!matcher.matches()) {
			System.out.println("Invalid City name, please try again....");
			city = scanner.nextLine();
			matcher = pattern.matcher(city);
		}
		return city;
	}

	/*
	 * @purpose: As a User need to enter a valid State. State name starts with Cap
	 * and has maximum 10 characters
	 */
	public static String validateState(String state, Scanner scanner) {
		regex = "^[A-Z]{1}[a-z]{2,9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(state);

		while (!matcher.matches()) {
			System.out.println("Invalid City name, please try again....");
			state = scanner.nextLine();
			matcher = pattern.matcher(state);
		}
		return state;
	}

	/*
	 * @purpose: As a User need to enter a valid Zip code. zip code do not starts
	 * with 0 and has 6 digit code
	 */
	public static String validateZip(String zip, Scanner scanner) {
		regex = "^[1-9]{1}[0-9]{2}[ ]?[0-9]{3}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(zip);

		while (!matcher.matches()) {
			System.out.println("Invalid Zip Code, please try again...");
			zip = scanner.nextLine();
			matcher = pattern.matcher(zip);
		}
		return zip;
	}

	/*
	 * @purpose:As a User need to follow pre defined Mobile Format - E.g. 91
	 * 9919819801 - Country code follow by space and 10 digit number
	 */
	public static String validatePhone(String phone, Scanner scanner) {
		regex = "^[91]+[ ]?[6-9]{1}[0-9]{9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phone);

		while (!matcher.matches()) {
			System.out.println("Invalid Phone number, please try again...");
			phone = scanner.nextLine();
			matcher = pattern.matcher(phone);
		}
		return phone;
	}

	/*
	 * @purpose:As a User need to enter a valid email E.g. abc.xyz@bl.co.in - Email
	 * has 3 mandatory parts (abc, bl & co) and 2 optional (xyz & in) with precise @
	 * and . positions
	 */
	public static String validateEmail(String email, Scanner scanner) {
		regex = "^[a-z]+[+-_.]*[a-z]*[@][a-z]+[.][a-z]{2,4}[.]*([a-z]{2})*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		while (!matcher.matches()) {
			System.out.println("Invalid Email, please try again...");
			email = scanner.nextLine();
			matcher = pattern.matcher(email);
		}
		return email;
	}

	// main method
	public static void main(String args[]) {
		AddressBook addressBookMain = new AddressBook();
		addressBookMain.operations();
	}
}
