import java.util.Date;

public class Appointment {

  final private byte APPOINTMENT_ID_LENGTH;
  final private byte APPOINTMENT_DESCRIPTION_LENGTH;
  final private String INITIALIZER;
  private String appointmentId;
  private Date appointmentDate;
  private String description;

  {
    APPOINTMENT_ID_LENGTH = 10;
    APPOINTMENT_DESCRIPTION_LENGTH = 50;
    INITIALIZER = "start";
  }

  Appointment() {
    Date today = new Date();
    appointmentId = INITIALIZER;
    appointmentDate = today;
    description = INITIALIZER;
  }

  Appointment(String id) {
    Date today = new Date();
    updateAppointmentId(id);
    appointmentDate = today;
    description = INITIALIZER;
  }

  Appointment(String id, Date date) {
    updateAppointmentId(id);
    updateDate(date);
    description = INITIALIZER;
  }

  Appointment(String id, Date date, String description) {
    updateAppointmentId(id);
    updateDate(date);
    updateDescription(description);
  }

  public void updateAppointmentId(String id) {
    if (id == null) {
      throw new IllegalArgumentException("no.");
    } else if (id.length() > APPOINTMENT_ID_LENGTH) {
      throw new IllegalArgumentException("too long " +
                                         APPOINTMENT_ID_LENGTH +
                                         " letters");
    } else {
      this.appointmentId = id;
    }
  }

  public String getAppointmentId() { return appointmentId; }

  public void updateDate(Date date) {
    if (date == null) {
      throw new IllegalArgumentException("cant be null.");
    } else if (date.before(new Date())) {
      throw new IllegalArgumentException(
          "none past.");
    } else {
      this.appointmentDate = date;
    }
  }

  public Date getAppointmentDate() { return appointmentDate; }

  public void updateDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException(
          "no null.");
    } else if (description.length() > APPOINTMENT_DESCRIPTION_LENGTH) {
      throw new IllegalArgumentException(
          "no exceed " +
          APPOINTMENT_DESCRIPTION_LENGTH + " letters");
    } else {
      this.description = description;
    }
  }

  public String getDescription() { return description; }
}