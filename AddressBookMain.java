package AddressBookSystem;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain
{
    HashMap<String, ArrayList<Contact>> addressBooks = new HashMap<>();

    Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Welcome to AddressBook program....!!!!");
        Scanner input = new Scanner(System.in);
        AddressBookMain addressBookMain = new AddressBookMain();
        AddressBook addressBook = new AddressBook();
        addressBookMain.createAddressBook();
        boolean loop = true;
        while (loop) {
            System.out.println("Enter what you want to perform");
            System.out.println("Press 1 to create new address book" + '\n' + "Press 2 to perform operation " +
                    "on existing address book" + '\n' + "Press 3 to search contacts with city " + '\n' + "Press 4 to get person with city" +
                    '\n' + "Press 5 to get number of contacts by city" + '\n' + "Press 6 to get sorted contacts by name" + '\n' + "Press 0 to exit");
            final int createAddressBook = 1, operateExisting = 2, searchContacts = 3, getPersonWithCity = 4, getNoOfContactByCity = 5,
                      sortedContactsByName = 6, exit = 0;
            int option = input.nextInt();
            switch (option) {
                case createAddressBook:
                    addressBookMain.createAddressBook();
                    break;
                case operateExisting:
                    System.out.println("Plz enter key belong to address book");
                    String inputKey = input.next();
                    if (addressBookMain.addressBooks.containsKey(inputKey))
                        addressBook.callAddressBook(addressBookMain.addressBooks.get(inputKey));
                    else
                        System.out.println("Entered book address book not available");
                    break;
                case searchContacts:
                    addressBookMain.searchContactsWithCity();
                    break;
                case getPersonWithCity:
                    addressBookMain.getContactByCityAndState();
                    break;
                case getNoOfContactByCity:
                    addressBookMain.getNumberContacts();
                    break;
                case sortedContactsByName:
                    addressBookMain.getSortedContactByName();
                    break;
                case exit:
                    loop = false;
                    break;
                default:
                    System.out.println("Entered Wrong input");
            }
        }
    }

    public void createAddressBook() 
    {
        System.out.println("Create address book of your choice");
        ArrayList<Contact> contacts = new ArrayList<>();
        System.out.println("Enter unique book name");
        String name = input.next();
        if (!addressBooks.containsKey(name))
            addressBooks.put(name, contacts);
        else
            System.out.println("Entered book is already available");
    }

    public void searchContactsWithCity()
    {
        System.out.println("Please enter city name");
        String cityName = input.next();
        List<Contact> listOfContacts = addressBooks.values().stream().flatMap(p -> p.stream())
                                       .filter(p -> p.getCity().equalsIgnoreCase(cityName)).collect(Collectors.toList());
        System.out.println(listOfContacts);
    }

    public void getContactByCityAndState() 
    {
        List<Contact> myContactList = addressBooks.values().stream().flatMap(A -> A.stream()).collect(Collectors.toList());
        Map<String, List<Contact>> myContactListByCity = myContactList.stream().collect(Collectors.groupingBy(Contact::getCity));
        System.out.println(myContactListByCity);
        Map<String, List<Contact>> myContactListByState = myContactList.stream().collect(Collectors.groupingBy(Contact::getState));
        System.out.println(myContactListByState);
    }

    public void getNumberContacts() 
    {
        System.out.println("Please enter city name");
        String cityName = input.next();
        long count = addressBooks.values().stream().flatMap(p -> p.stream()).filter(p -> p.getCity().equalsIgnoreCase(cityName)).count();
        System.out.println("Count of contacts with " + cityName + " are " + count);
    }

    public void getSortedContactByName() 
    {
        List<Contact> nameSortedAddressBook = addressBooks.values().stream().flatMap(A -> A.stream())
                .sorted((Comparator.comparing(Contact::getFirstName))).collect(Collectors.toList());
        System.out.println(nameSortedAddressBook);
    }
}