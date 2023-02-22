
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
// Needed to make junit tests
import org.junit.Test;
import static org.junit.Assert.assertEquals;
// Needed to handle expected Assertion Exceptions
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class TaskTest {
    public static void main(String[] Args) {
        Result result = JUnitCore.runClasses(TaskTest.class);

        for(Failure fail: result.getFailures()) {
            System.out.println(fail);
        }

        if(result.wasSuccessful()) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
    }

    // Valid set of inputs
    private final String ID = "987654321";
    private final String Name = "Kenny Rigers";
    private final String Description = "1";

    // Invalid inputs
    private final String badID = "75847362849";
    private final String badName = "long";
    private final String badDescription = "2000 the year i came into this world. I saw green and red and yellow and loved life until i realized it was too long.";

    // Setter inputs
    private final String ID2 = "687";
    private final String Name2 = "Fuko Lorena";
    private final String Description2 = "Second";

    private final Task testTask = new Task(ID, Name, Description);

    @Rule
    public ExpectedException rule = ExpectedException.none();

    @Test
    public void testTask() {
        System.out.println("Task");

        System.out.printf("%s\n", ID);
        assertEquals(ID, testTask.getId());

        System.out.printf("%s\n", Name);
        assertEquals(Name, testTask.getName());

        System.out.printf("%s\n", Description);
        assertEquals(Description, testTask.getDescription());

        System.out.println("error");
        rule.expect(AssertionError.class);
        new Task(null, null, null);
    }

    @Test
    public void testID() {
        System.out.println("test");

        System.out.printf("%s\n", badID);
        rule.expect(AssertionError.class);
        new Task(badID, Name, Description);
    }

    @Test
    public void testName() {
        System.out.println("test");
        Task secondTask = new Task(ID2, Name, Description);

        System.out.printf("%s\n", Name2);
        secondTask.setName(Name2);
        assertEquals(Name2, secondTask.getName());

        System.out.printf("error", badName);
        rule.expect(AssertionError.class);
        secondTask.setName(badName);
    }

    @Test
    public void testDescription() {
        System.out.println("test");
        Task secondTask = new Task(ID2, Name, Description);

        System.out.printf("%s\n", Description2);
        secondTask.setDescription(Description2);
        assertEquals(Description2, secondTask.getDescription());

        System.out.printf(" %s\n", badDescription);
        rule.expect(AssertionError.class);
        secondTask.setDescription(badDescription);
    }
}
