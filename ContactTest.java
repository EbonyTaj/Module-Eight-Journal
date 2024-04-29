import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testValidContactCreation() {
        // Valid input parameters
        String contactId = "1234567890";
        String firstName = "John";
        String lastName = "Doe";
        String phone = "1234567890";
        String address = "123 Main St";

        // Attempt to create a contact with valid input parameters
        Contact contact = new Contact(contactId, firstName, lastName, phone, address);

        // Verify that the contact object is not null and getters return the expected values
        assertAll("Valid Contact",
            () -> assertNotNull(contact),
            () -> assertEquals(contactId, contact.getContactId()),
            () -> assertEquals(firstName, contact.getFirstName()),
            () -> assertEquals(lastName, contact.getLastName()),
            () -> assertEquals(phone, contact.getPhone()),
            () -> assertEquals(address, contact.getAddress())
        );
    }

    @Test
    void testInvalidContactCreation_NullContactId() {
        // Invalid input parameters - null contactId
        String contactId = null;
        String firstName = "John";
        String lastName = "Doe";
        String phone = "1234567890";
        String address = "123 Main St";

        // Attempt to create a contact with invalid input parameters (null contactId)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phone, address);
        });

        // Verify that the correct exception is thrown with the expected message
        assertEquals("Contact ID must not be null and cannot be longer than 10 characters", exception.getMessage());
    }

    @Test
    void testInvalidContactCreation_LongContactId() {
        // Invalid input parameters - contactId longer than 10 characters
        String contactId = "12345678901"; // 11 characters
        String firstName = "John";
        String lastName = "Doe";
        String phone = "1234567890";
        String address = "123 Main St";

        // Attempt to create a contact with invalid input parameters (long contactId)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phone, address);
        });

        // Verify that the correct exception is thrown with the expected message
        assertEquals("Contact ID must not be null and cannot be longer than 10 characters", exception.getMessage());
    }

    @Test
    void testInvalidContactCreation_NullFirstName() {
        // Invalid input parameters - null firstName
        String contactId = "1234567890";
        String firstName = null;
        String lastName = "Doe";
        String phone = "1234567890";
        String address = "123 Main St";

        // Attempt to create a contact with invalid input parameters (null firstName)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phone, address);
        });

        // Verify that the correct exception is thrown with the expected message
        assertEquals("First name must not be null and cannot be longer than 10 characters", exception.getMessage());
    }

    @Test
    void testInvalidContactCreation_LongFirstName() {
        // Invalid input parameters - firstName longer than 10 characters
        String contactId = "1234567890";
        String firstName = "Johnnnnnnnnnn"; // 13 characters
        String lastName = "Doe";
        String phone = "1234567890";
        String address = "123 Main St";

        // Attempt to create a contact with invalid input parameters (long firstName)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phone, address);
        });

        // Verify that the correct exception is thrown with the expected message
        assertEquals("First name must not be null and cannot be longer than 10 characters", exception.getMessage());
    }

    @Test
    void testInvalidContactCreation_NullLastName() {
        // Invalid input parameters - null lastName
        String contactId = "1234567890";
        String firstName = "John";
        String lastName = null;
        String phone = "1234567890";
        String address = "123 Main St";

        // Attempt to create a contact with invalid input parameters (null lastName)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phone, address);
        });

        // Verify that the correct exception is thrown with the expected message
        assertEquals("Last name must not be null and cannot be longer than 10 characters", exception.getMessage());
    }

    @Test
    void testInvalidContactCreation_LongLastName() {
        // Invalid input parameters - lastName longer than 10 characters
        String contactId = "1234567890";
        String firstName = "John";
        String lastName = "DoeDoeDoeDoe"; // 13 characters
        String phone = "1234567890";
        String address = "123 Main St";

        // Attempt to create a contact with invalid input parameters (long lastName)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phone, address);
        });

        // Verify that the correct exception is thrown with the expected message
        assertEquals("Last name must not be null and cannot be longer than 10 characters", exception.getMessage());
    }

    @Test
    void testInvalidContactCreation_InvalidPhone() {
        // Invalid input parameters - phone not exactly 10 digits
        String contactId = "1234567890";
        String firstName = "John";
        String lastName = "Doe";
        String phone = "123456"; // Invalid phone number (not 10 digits)
        String address = "123 Main St";

        // Attempt to create a contact with invalid input parameters (invalid phone)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phone, address);
        });

        // Verify that the correct exception is thrown with the expected message
        assertEquals("Phone number must be exactly 10 digits", exception.getMessage());
    }

    @Test
    void testInvalidContactCreation_NullAddress() {
        // Invalid input parameters - null address
        String contactId = "1234567890";
        String firstName = "John";
        String lastName = "Doe";
        String phone = "1234567890";
        String address = null;

        // Attempt to create a contact with invalid input parameters (null address)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phone, address);
        });

        // Verify that the correct exception is thrown with the expected message
        assertEquals("Address must not be null and cannot be longer than 30 characters", exception.getMessage());
    }


}