import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("12345", "Tre", "Olson", "1234567890", "123 Main Street");

        assertEquals("12345", contact.getContactId());
        assertEquals("Tre", contact.getFirstName());
        assertEquals("Olson", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "Tre", "Olson", "1234567890", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "Tre", "Olson", "1234567890", "123 Main Street"));
    }

    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", null, "Olson", "1234567890", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "Christopher", "Olson", "1234567890", "123 Main Street"));
    }

    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "Tre", null, "1234567890", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "Tre", "Longlastname", "1234567890", "123 Main Street"));
    }

    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "Tre", "Olson", null, "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "Tre", "Olson", "123", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "Tre", "Olson", "123456789A", "123 Main Street"));
    }

    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "Tre", "Olson", "1234567890", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "Tre", "Olson", "1234567890", "1234567890123456789012345678901"));
    }

    @Test
    public void testSettersUpdateFields() {
        Contact contact = new Contact("12345", "Tre", "Olson", "1234567890", "123 Main Street");

        contact.setFirstName("Trace");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Oak Avenue");

        assertEquals("Trace", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Avenue", contact.getAddress());
    }

    @Test
    public void testSettersRejectInvalidValues() {
        Contact contact = new Contact("12345", "Tre", "Olson", "1234567890", "123 Main Street");

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("Longlastname"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12"));
        assertThrows(IllegalArgumentException.class,
                () -> contact.setAddress("1234567890123456789012345678901"));
    }
}
