/*
 * Author: Alexis Lewis
 * ContactService.java
 *
 * HashMap to store contact ID to contact object.
 */
import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	private Map<String, Contact> contacts = new HashMap<>();
	
	// Adds a new contact as long as the contact ID is unique.
	public void addContact(Contact contact) {
	    if (contacts.containsKey(contact.getContactId())) {
	        throw new IllegalArgumentException("Contact ID already exists");
	    }

	    contacts.put(contact.getContactId(), contact);
	}

	// Deletes a contact using its contact ID.
	public void deleteContact(String contactId) {
	    if (!contacts.containsKey(contactId)) {
	        throw new IllegalArgumentException("Contact ID does not exist");
	    }

	    contacts.remove(contactId);
	}

	// Updates the first name of an existing contact.
	public void updateFirstName(String contactId, String firstName) {
	    getContact(contactId).setFirstName(firstName);
	}

	// Updates the last name of an existing contact.
	public void updateLastName(String contactId, String lastName) {
	    getContact(contactId).setLastName(lastName);
	}

	// Updates the phone number of an existing contact.
	public void updatePhone(String contactId, String phone) {
	    getContact(contactId).setPhone(phone);
	}

	// Updates the address of an existing contact.
	public void updateAddress(String contactId, String address) {
	    getContact(contactId).setAddress(address);
	}

	// Finds and returns a contact using its contact ID.
	public Contact getContact(String contactId) {
	    Contact contact = contacts.get(contactId);

	    if (contact == null) {
	        throw new IllegalArgumentException("Contact ID does not exist");
	    }

	    return contact;
	}
}
