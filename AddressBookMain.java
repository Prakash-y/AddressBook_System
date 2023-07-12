package AddressBookSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain 
{
    ArrayList<Contact> contacts = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook program....!!!!");
        AddressBookMain addressBook = new AddressBookMain();
        addressBook.addNewContacts();
        for (Contact x : addressBook.contacts) 
        {
            System.out.println(x.firstName + " " + x.lastName + " " + x.address + " " + x.city
            + " " + x.state + " " + x.zipCode + " " + x.phoneNumber + " " + x.email);
        }
    }

    public void addNewContacts() 
    {
        System.out.println("Enter how many contacts you want to save");
        Scanner input = new Scanner(System.in);
        int noOfContacts = input.nextInt();

        for (int i = 0; i < noOfContacts; i++) 
        {
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
}	
   