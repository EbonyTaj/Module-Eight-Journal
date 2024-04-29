import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public boolean addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            return false;
        }
        contacts.put(contact.getContactId(), contact);
        return true;
    }

    public boolean deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            return false;
        }
        contacts.remove(contactId);
        return true;
    }

    public boolean updateFirstName(String contactId, String firstName) {
        if (!contacts.containsKey(contactId)) {
            return false;
        }
        Contact contact = contacts.get(contactId);
        contact.setFirstName(firstName);
        return true;
    }

    public boolean updateLastName(String contactId, String lastName) {
        if (!contacts.containsKey(contactId)) {
            return false;
        }
        Contact contact = contacts.get(contactId);
        contact.setLastName(lastName);
        return true;
    }

    public boolean updatePhone(String contactId, String phone) {
        if (!contacts.containsKey(contactId)) {
            return false;
        }
        Contact contact = contacts.get(contactId);
        contact.setPhone(phone);
        return true;
    }

    public boolean updateAddress(String contactId, String address) {
        if (!contacts.containsKey(contactId)) {
            return false;
        }
        Contact contact = contacts.get(contactId);
        contact.setAddress(address);
        return true;
    }
}
