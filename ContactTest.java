/*
 * Author: Alexis Lewis
 * ContactTest.java
 *
 * JUnit 5 test case to build out a new contact and see if it stored
 * the information correctly.
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContact() {
		// Builds out new contact based upon entered information.
		Contact contact = new Contact(
		        "C7284",
		        "Minju",
		        "Park",
		        "7245553816",
		        "47 Willow Lane"
		    );
		 
		// Checks that the entered information was stored correctly.
			assertEquals("C7284", contact.getContactId());
			assertEquals("Minju", contact.getFirstName());
		    assertEquals("Park", contact.getLastName());
		    assertEquals("7245553816", contact.getPhone());
		    assertEquals("47 Willow Lane", contact.getAddress());
		}
	
	@Test
	void testContactIdTooLong() {
	    // Checks that a contact cannot be created with an ID exceeding 10 characters.
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
	            "N7459058435892",
	            "Minju",
	            "Park",
	            "7245553816",
	            "47 Willow Lane"
	        );
	    });
	}
	
	@Test
	void testContactIdNull() {
	    // Checks that a contact cannot be created with an ID equal to null.
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
	            null,
	            "Minju",
	            "Park",
	            "7245553816",
	            "47 Willow Lane"
	        );
	    });
	}
	
	@Test
	void testContactFirstNameTooLong() {
	    // Checks that a contact cannot be created with a first name exceeding 10 characters.
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
	            "U5478",
	            "Annamarie Shirley",
	            "Smith",
	            "4129924862",
	            "951 Franklin Road"
	        );
	    });
	}
	
	@Test
	void testContactFirstNameNull() {
	    // Checks that a contact cannot be created with a first name equal to null.
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
	            "U5478",
	            null,
	            "Smith",
	            "4129924862",
	            "951 Franklin Road"
	        );
	    });
	}
	
	@Test
	void testContactLastNameTooLong() {
	    // Checks that a contact cannot be created with a last name exceeding 10 characters.
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
	            "I15438",
	            "Hubert",
	            "Wolfeschlegelsteinhausenbergerdorff",
	            "4124635033",
	            "76 Berlin Court"
	        );
	    });
	}
	
	@Test
	void testContactLastNameNull() {
	    // Checks that a contact cannot be created with a last name equal to null.
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
	            "I15438",
	            "Hubert",
	            null,
	            "4124635033",
	            "76 Berlin Court"
	        );
	    });
	}
	
	@Test
	void testContactPhoneNumberTooLong() {
	    // Checks that a contact cannot be created with a phone number exceeding 10 digits.
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
		            "L6578",
		            "Roberto",
		            "Ramirez",
		            "527249870185",
		            "521 Flavor Lane"
	        );
	    });
	}
	
	@Test
	void testContactPhoneNumberTooShort() {
	    // Checks that a contact cannot be created with a phone number less than 10 digits.
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
		            "L6578",
		            "Roberto",
		            "Ramirez",
		            "72497018",
		            "521 Flavor Lane"
	        );
	    });
	}
	
	@Test
	void testContactPhoneNumberNonDigits() {
	    // Checks that a contact cannot be created with a phone number with letters instead of numbers.
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
		            "L6578",
		            "Roberto",
		            "Ramirez",
		            "jkfdjhasdi",
		            "521 Flavor Lane"
	        );
	    });
	}
	
	@Test
	void testContactPhoneNumberNull() {
	    // Checks that a contact cannot be created with a phone number equal to null.
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
		            "L6578",
		            "Roberto",
		            "Ramirez",
		            null,
		            "521 Flavor Lane"
	        );
	    });
	}
	
	@Test
	void testContactAddressTooLong() {
	    // Checks that a contact cannot be created with an address exceeding 30 characters.
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
	            "Q2890",
	            "Jotaro",
	            "Kujo",
	            "7243501484",
	            "48 Stardust Crusaders Bizarre Adventure Avenue"
	        );
	    });
	}
	
	@Test
	void testContactAddressNull() {
	    // Checks that a contact cannot be created with an address equal to null.
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
	            "Q2890",
	            "Jotaro",
	            "Kujo",
	            "7243501484",
	            null
	        );
	    });
	}
	
	@Test
	void testContactFieldsCanBeUpdated() {
	    Contact contact = new Contact(
	        "M5832",
	        "Yuna",
	        "Kim",
	        "4125557834",
	        "15 Seoul Street"
	    );

	    // Updates each field that the customer allows to be changed.
	    contact.setFirstName("Sora");
	    contact.setLastName("Park");
	    contact.setPhone("7245553921");
	    contact.setAddress("27 Han River Road");

	    // Checks that each new value was stored correctly.
	    assertEquals("Sora", contact.getFirstName());
	    assertEquals("Park", contact.getLastName());
	    assertEquals("7245553921", contact.getPhone());
	    assertEquals("27 Han River Road", contact.getAddress());
	}
}