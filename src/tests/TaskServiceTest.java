public static void main(String[] args) {
	
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
// Needed to make junit tests
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TaskServiceTest {
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
    private final String ID1 = "8765";
    private final String Name1 = "Dan nad";
    private final String Description1 = "milk sell";
    private final Task task1 = new Task(ID1, Name1, Description1);

    private TaskService service = new TaskService(task1);

    @Test
    public void testConstructor() {
        System.out.println("test");

        System.out.printf("Fixed", task1);
        assertEquals(task1, service.getTask(task1));

        System.out.println("0");
        TaskService service2 = new TaskService();
        assertEquals(service2.getSize(), 0);
    }

    @Test
    public void testInsertion() {
        System.out.println("test");

        Task task2 = new Task("346767", "Add", "Try new task");
        System.out.printf("Try task", task2);
        assertEquals(true, service.addTask(task2));
        assertEquals(task2, service.getTask(task2));

        System.out.println("Try false");
        assertEquals(false, service.addTask(task1));
    }

    @Test
    public void testUpdate() {
        System.out.println("Update");
        Task task3 = new Task(task1.getId(), "Update", "Updated name");

        System.out.println("update");
        assertEquals(true, service.updateTask(task3));
        assertEquals(task3, service.getTask(task3));

        System.out.println("update");
        assertEquals(false, service.updateTask(new Task("222222", "No", "does not exist")));
    }

    @Test
    public void testRemove() {
        System.out.println("Remove");
        Task task4 = new Task("8888", "Task", "temp");

        System.out.println("remove");
        service.addTask(task4);
        assertEquals(true, service.removeTask(task4));

        System.out.println("remove");
        assertEquals(false, service.removeTask(task4));
    }
}
}
