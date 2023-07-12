package AddressBookSystem;


import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain 
{
    Scanner input = new Scanner(System.in);
    ArrayList<Contact> contacts = new ArrayList<>();
    public static <editContact> void main(String[] args) {
        System.out.println("Welcome to AddressBook program....!!!!");
        AddressBookMain addressBook = new AddressBookMain();
        Scanner input = new Scanner(System.in);
        addressBook.addNewContacts();
        boolean loop = true;
        while(loop) {
            System.out.println("Plz enter what you want to perform : " + '\n' + "press 1 for Edit Contact" +
                    '\n' + "press 2 for print contact" + '\n' + "Enter 3 for add contact" + '\n' +
                    "Enter 4 for delete contact" + '\n' + "Enter 0 to exit");
            final int editContact = 1, printContact = 2, addContact = 3, deleteContact = 4;
            int choice = input.nextInt();
            switch (choice) {
                case editContact:
                    addressBook.editContact();
                    System.out.println("After editing contact");
                    addressBook.printContacts();
                    break;
                case printContact:
                    addressBook.printContacts();
                    break;
                case addContact:
                    addressBook.addNewContacts();
                    System.out.println("After adding contacts");
                    addressBook.printContacts();
                    break;
                case deleteContact:
                    addressBook.deleteContact();
                    break;
                default:
                    loop = false;

            }
        }
    }

    public void addNewContacts() {
        System.out.println("Enter how many contacts you want to save");
        int noOfContacts = input.nextInt();

        for (int i = 0; i < noOfContacts; i++) {
            Contact contact = new Contact();
            System.out.println("Enter First Name of " + (i + 1) + " Contact: " );
            contact.firstName = input.next();
            System.out.println("Enter last Name of " + (i + 1) + " Contact: " );
            contact.lastName = input.next();
            System.out.println("Enter address of " + (i + 1) + " Contact: " );
            contact.address = input.next();
            System.out.println("Enter city of " + (i + 1) + " Contact: " );
            contact.city = input.next();
            System.out.println("Enter state of " + (i + 1) + " Contact: " );
            contact.state = input.next();
            System.out.println("Enter ZipCode of " + (i + 1) + " Contact: " );
            contact.zipCode = input.nextInt();
            System.out.println("Enter phone number of " + (i + 1) + " Contact: " );
            contact.phoneNumber = input.nextLong();
            System.out.println("Enter email of " + (i + 1) + " Contact: " );
            contact.email = input.next();

            contacts.add(contact);
        }
    }

    public void editContact() {
        System.out.println("Please Enter the name whose details you want to change");
        String name = input.next();
        for (int i = 0; i < contacts.size(); i++) {
            if (name.equalsIgnoreCase(contacts.get(i).firstName)) {
                boolean loop = true;
                while (loop) {
                    final int firstName = 1, lastName = 2, address = 3, city = 4, state = 5, zipCode = 6, phoneNumber = 7, email = 8, stopEditing = 0;
                    System.out.println("What you want to change :" + '\n' + "Press 1 for first name " + '\n' +
                            "Press 2 for last name " + '\n' + "Enter 3 for address " + '\n' + "Enter 4 for city"
                            + '\n' + "Enter 5 for state" + '\n' + "Enter 6 for zip code" + '\n' + "Enter 7 for phone number"
                            + '\n' + "Enter 8 for email" + '\n' + "Enter 0 to stop editing");
                    int choice = input.nextInt();
                    switch (choice) {
                        case firstName:
                            System.out.println("Please Enter the name to be updated");
                            contacts.get(i).firstName = input.next();
                            break;
                        case lastName:
                            System.out.println("Please Enter the lastname to be updated");
                            contacts.get(i).lastName = input.next();
                            break;
                        case address:
                            System.out.println("Please Enter the address to be updated");
                            contacts.get(i).address = input.next();
                            break;
                        case city:
                            System.out.println("Please Enter the city to be updated");
                            contacts.get(i).city = input.next();
                            break;
                        case state:
                            System.out.println("Please enter the state to be updated");
                            contacts.get(i).state = input.next();
                            break;
                        case zipCode:
                            System.out.println("Please Enter the zip code to be updated");
                            contacts.get(i).zipCode = input.nextInt();
                            break;
                        case phoneNumber:
                            System.out.println("Please Enter the phone number to be updated");
                            contacts.get(i).phoneNumber = input.nextLong();
                            break;
                        case email:
                            System.out.println("Please Enter the email to be updated");
                            contacts.get(i).email = input.next();
                            break;
                        case stopEditing:
                            loop = false;
                            break;
                        default:
                            System.out.println("You Entered wrong input");

                    }
                }
            }
        }
    }

    public void deleteContact() {
        System.out.println("Plz enter the name whose details you want to delete");
        String name = input.next();
        for (int i = 0; i < contacts.size(); i++) {
            if (name.equalsIgnoreCase(contacts.get(i).firstName)) {
                contacts.remove(i);
            }
        }
    }

    public void printContacts() {
        for (Contact x : contacts) {
            System.out.println(x.firstName + " " + x.lastName + " " + x.address + " " + x.city
                    + " " + x.state + " " + x.zipCode + " " + x.phoneNumber + " " + x.email);
        }
    }
}