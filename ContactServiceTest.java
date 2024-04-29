import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        
        assertTrue(contactService.addContact(contact));
    }

    @Test
    public void testDeleteContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        assertTrue(contactService.deleteContact("1234567890"));
    }

    @Test
    public void testUpdateFirstName() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        assertTrue(contactService.updateFirstName("1234567890", "Jane"));
        
        // Verify that the first name was updated correctly
        assertAll("Contact fields",
            () -> assertEquals("Jane", contact.getFirstName())
        );
    }

    @Test
    public void testUpdateLastName() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        assertTrue(contactService.updateLastName("1234567890", "Smith"));
        
        // Verify that the last name was updated correctly
        assertAll("Contact fields",
            () -> assertEquals("Smith", contact.getLastName())
        );
    }

    @Test
    public void testUpdatePhone() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        assertTrue(contactService.updatePhone("1234567890", "9876543210"));
        
        // Verify that the phone number was updated correctly
        assertAll("Contact fields",
            () -> assertEquals("9876543210", contact.getPhone())
        );
    }

    @Test
    public void testUpdateAddress() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        assertTrue(contactService.updateAddress("1234567890", "456 Oak St"));
        
        // Verify that the address was updated correctly
        assertAll("Contact fields",
            () -> assertEquals("456 Oak St", contact.getAddress())
        );
    }

    @Test
    public void testAddContactWithDuplicateID() {
        ContactService contactService = new ContactService();
        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Jane", "Smith", "9876543210", "456 Oak St");
        contactService.addContact(contact1);
        
        assertFalse(contactService.addContact(contact2));
    }

    @Test
    public void testDeleteNonExistentContact() {
        ContactService contactService = new ContactService();
        assertFalse(contactService.deleteContact("1234567890"));
    }

    @Test
    public void testUpdateNonExistentContact() {
        ContactService contactService = new ContactService();
        assertFalse(contactService.updateFirstName("1234567890", "Jane"));
    }
}
