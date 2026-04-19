import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }

    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("A123", getFutureDate(), "Doctor visit");

        service.addAppointment(appointment);

        assertNotNull(service.getAppointment("A123"));
        assertEquals("A123", service.getAppointment("A123").getAppointmentId());
    }

    @Test
    public void testAddDuplicateAppointmentFails() {
        AppointmentService service = new AppointmentService();
        Appointment appointmentOne = new Appointment("A123", getFutureDate(), "Doctor visit");
        Appointment appointmentTwo = new Appointment("A123", getFutureDate(), "Dentist visit");

        service.addAppointment(appointmentOne);

        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointmentTwo));
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("A123", getFutureDate(), "Doctor visit");

        service.addAppointment(appointment);
        service.deleteAppointment("A123");

        assertNull(service.getAppointment("A123"));
    }

    @Test
    public void testDeleteMissingAppointmentFails() {
        AppointmentService service = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("A123"));
    }
}
