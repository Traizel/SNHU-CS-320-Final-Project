import java.util.Date;

public class Appointment {
    private final String appointmentId;
    private final Date appointmentDate;
    private String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        validateAppointmentId(appointmentId);
        validateAppointmentDate(appointmentDate);
        validateDescription(description);

        this.appointmentId = appointmentId;
        this.appointmentDate = new Date(appointmentDate.getTime());
        this.description = description;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return new Date(appointmentDate.getTime());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

    private void validateAppointmentId(String appointmentId) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID is invalid.");
        }
    }

    private void validateAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date is invalid.");
        }

        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past.");
        }
    }

    private void validateDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Appointment description is invalid.");
        }
    }
}
