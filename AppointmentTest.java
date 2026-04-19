import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class AppointmentTest {

    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }

    private Date getPastDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }

    @Test
    public void testValidAppointmentCreation() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("A123", futureDate, "Doctor visit");

        assertEquals("A123", appointment.getAppointmentId());
        assertEquals("Doctor visit", appointment.getDescription());
        assertEquals(futureDate, appointment.getAppointmentDate());
    }

    @Test
    public void testInvalidAppointmentId() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, getFutureDate(), "Doctor visit"));
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("12345678901", getFutureDate(), "Doctor visit"));
    }

    @Test
    public void testInvalidAppointmentDate() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("A123", null, "Doctor visit"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("A123", getPastDate(), "Doctor visit"));
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("A123", getFutureDate(), null));
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("A123", getFutureDate(), "This description is definitely longer than fifty characters total."));
    }

    @Test
    public void testSetDescription() {
        Appointment appointment = new Appointment("A123", getFutureDate(), "Doctor visit");
        appointment.setDescription("Dentist visit");

        assertEquals("Dentist visit", appointment.getDescription());
    }

    @Test
    public void testSetDescriptionRejectsInvalidValue() {
        Appointment appointment = new Appointment("A123", getFutureDate(), "Doctor visit");

        assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(null));
    }

    @Test
    public void testAppointmentDateUsesDefensiveCopy() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("A123", futureDate, "Doctor visit");

        Date returnedDate = appointment.getAppointmentDate();
        returnedDate.setTime(returnedDate.getTime() + 86400000L);

        assertNotEquals(returnedDate, appointment.getAppointmentDate());
    }
}
