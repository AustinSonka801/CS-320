import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ContactTest {
//variables
 private String contactIdTest;
 private String firstNameTest;
 private String lastNameTest;
 private String phoneNumberTest;
 private String numberAddressTest;
 private String tooBigContactId;
 private String tooBigFirstName;
 private String tooBigLastName;
 private String tooBigPhoneNumber;
 private String tooSmallPhoneNumber;
 private String tooBigNumberAddress;
 @BeforeEach
 void setUp() {
//assigning values
 contactIdTest = "112345678";
 firstNameTest = "Austin";
 lastNameTest = "Sonka";
 phoneNumberTest = "8306234466";
 numberAddressTest = "11026 Angel Point";
 tooBigContactId = "567364386789345677";
 tooBigFirstName = "Kim Wexarly";
 tooBigLastName = "Romerojoness";
 tooBigPhoneNumber = "60354484488";
 tooSmallPhoneNumber = "602226";
 tooBigNumberAddress = "11026 angel point san antonio tx, 78254";
 }
 //doesnt return
 @Test
 void contactTest() {
 Contact contact = new Contact(contactIdTest, tooBigFirstName, lastNameTest, 
numberAddressTest, phoneNumberTest);
 assertNotNull(contact);
 }
 
value
 @Test
 void updateFirstNameTest() {
 Contact contact = new Contact(contactIdTest, tooBigFirstName, lastNameTest, 
numberAddressTest, phoneNumberTest);
 contact.setFirstName(firstNameTest);
 assertThrows(IllegalArgumentException.class,
 () -> contact.setFirstName(null));
 assertThrows(IllegalArgumentException.class,
 () -> contact.setFirstName(tooBigFirstName));
 assertEquals(firstNameTest, contact.getFirstName());
 }
 @Test

 void updateContactIDTest() {
 Contact contact = new Contact(contactIdTest, tooBigFirstName, lastNameTest, 
numberAddressTest, phoneNumberTest);
 contact.setContactID(contactIdTest);
 assertThrows(IllegalArgumentException.class,
 () -> contact.setContactID(null));
 assertThrows(IllegalArgumentException.class,
 () -> contact.setContactID(tooBigContactId));
 }
 @Test
 void updateLastNameTest() {
 Contact contact = new Contact(contactIdTest, tooBigFirstName, lastNameTest, 
numberAddressTest, phoneNumberTest);
 contact.setLastName(lastNameTest);
 assertThrows(IllegalArgumentException.class,
 () -> contact.setLastName(null));
 assertThrows(IllegalArgumentException.class,
 () -> contact.setFirstName(tooBigLastName));
 assertEquals(lastNameTest, contact.getLastName());
 }
 @Test
 void updateNumberAddressTest() {
 Contact contact = new Contact(contactIdTest, tooBigFirstName, lastNameTest, 
numberAddressTest, phoneNumberTest);
 contact.setNumberAddress(numberAddressTest);
 assertThrows(IllegalArgumentException.class,
 () -> contact.setNumberAddress(null));
 assertThrows(IllegalArgumentException.class,
 () -> contact.setNumberAddress(tooBigNumberAddress));
 assertEquals(numberAddressTest, contact.getNumberAddress());
 }
 @Test
 void updatePhoneNumberTest() {
 Contact contact = new Contact(contactIdTest, tooBigFirstName, lastNameTest, 
numberAddressTest, phoneNumberTest);
 contact.setPhoneNumber(phoneNumberTest);
 assertThrows(IllegalArgumentException.class,
 () -> contact.setPhoneNumber(null));
 assertThrows(IllegalArgumentException.class,
 () -> contact.setPhoneNumber(tooBigPhoneNumber));
 assertThrows(IllegalArgumentException.class,
 () -> contact.setPhoneNumber(tooSmallPhoneNumber));
 assertEquals(phoneNumberTest, contact.getPhoneNumber());
 }
}