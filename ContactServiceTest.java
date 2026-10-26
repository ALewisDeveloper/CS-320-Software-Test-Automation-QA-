/*
 * Author: Alexis Lewis
 * ContactServiceTest.java
 *
 * JUnit 5 test cases to make sure contacts can be added, deleted,
 * and updated correctly based on the requirements.
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	void testAddContact() {
	    ContactService service = new ContactService();
	    Contact contact = new Contact(
	        "A1987",
	        "Hana",
	        "Lee",
	        "4125557821",
	        "82 Moonlight Drive"
	    );

	    service.addContact(contact);

	    assertEquals(contact, service.getContact("A1987"));
	}

	@Test
	void testDeleteContact() {
	    ContactService service = new ContactService();
	    Contact contact = new Contact(
	        "B2486",
	        "Hana",
	        "Lee",
	        "4125557821",
	        "82 Moonlight Drive"
	    );

	    service.addContact(contact);
	    service.deleteContact("B2486");

	    assertThrows(IllegalArgumentException.class, () -> {
	        service.getContact("B2486");
	    });
	}

	@Test
	void testUpdateContactFields() {
	    ContactService service = new ContactService();
	    Contact contact = new Contact(
	        "C3579",
	        "Hana",
	        "Lee",
	        "4125557821",
	        "82 Moonlight Drive"
	    );

	    service.addContact(contact);

	    service.updateFirstName("C3579", "Sora");
	    service.updateLastName("C3579", "Kim");
	    service.updatePhone("C3579", "7245559012");
	    service.updateAddress("C3579", "17 Starlight Road");

	    assertEquals("Sora", contact.getFirstName());
	    assertEquals("Kim", contact.getLastName());
	    assertEquals("7245559012", contact.getPhone());
	    assertEquals("17 Starlight Road", contact.getAddress());
	}
	
	@Test
	void testDuplicateContactId() {
	    ContactService service = new ContactService();

	    Contact firstContact = new Contact(
	        "K4821",
	        "Minseo",
	        "Choi",
	        "4125553847",
	        "29 Cherry Blossom Way"
	    );

	    Contact secondContact = new Contact(
	        "K4821",
	        "Jiwoo",
	        "Kang",
	        "7245556193",
	        "81 Han River Road"
	    );

	    service.addContact(firstContact);

	    assertThrows(IllegalArgumentException.class, () -> {
	        service.addContact(secondContact);
	    });
	}
	
	@Test
	void testDeleteMissingContact() {
	    ContactService service = new ContactService();

	    // Checks that a contact ID must exist before it can be deleted.
	    assertThrows(IllegalArgumentException.class, () -> {
	        service.deleteContact("NO404");
	    });
	}

	@Test
	void testUpdateMissingContact() {
	    ContactService service = new ContactService();

	    // Checks that a contact ID must exist before its information can be updated.
	    assertThrows(IllegalArgumentException.class, () -> {
	        service.updateFirstName("NO404", "Yuna");
	    });
	}
}
