import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Tre", "Olson", "1234567890", "123 Main Street");

        service.addContact(contact);

        assertNotNull(service.getContact("12345"));
        assertEquals("Tre", service.getContact("12345").getFirstName());
    }

    @Test
    public void testAddDuplicateContactFails() {
        ContactService service = new ContactService();
        Contact first = new Contact("12345", "Tre", "Olson", "1234567890", "123 Main Street");
        Contact second = new Contact("12345", "John", "Smith", "0987654321", "456 Oak Avenue");

        service.addContact(first);

        assertThrows(IllegalArgumentException.class, () -> service.addContact(second));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Tre", "Olson", "1234567890", "123 Main Street");

        service.addContact(contact);
        service.deleteContact("12345");

        assertNull(service.getContact("12345"));
    }

    @Test
    public void testDeleteMissingContactFails() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99999"));
    }

    @Test
    public void testUpdateFields() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Tre", "Olson", "1234567890", "123 Main Street");

        service.addContact(contact);
        service.updateFirstName("12345", "Trace");
        service.updateLastName("12345", "Smith");
        service.updatePhone("12345", "0987654321");
        service.updateAddress("12345", "456 Oak Avenue");

        assertEquals("Trace", service.getContact("12345").getFirstName());
        assertEquals("Smith", service.getContact("12345").getLastName());
        assertEquals("0987654321", service.getContact("12345").getPhone());
        assertEquals("456 Oak Avenue", service.getContact("12345").getAddress());
    }

    @Test
    public void testUpdateMissingContactFails() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("99999", "Trace"));
    }

    @Test
    public void testUpdateRejectsInvalidValues() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Tre", "Olson", "1234567890", "123 Main Street");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("12345", "123"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("12345", null));
    }
}
