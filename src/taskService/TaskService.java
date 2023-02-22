import java.util.HashMap;


public class TaskService {
    HashMap<String, Task> services;

    public TaskService() { services = new HashMap<String, Task>(); }

    public TaskService(Task task) {
        services = new HashMap<String, Task>();
        services.put(task.getId(), task);
    }

    public boolean addTask(Task task) {
        if(task != null && services.containsKey(task.getId()) == false) { 
            services.put(task.getId(), task);
            return true;
        }

        return false;
    }

    public boolean updateTask(Task task) {
        if(task != null && services.containsKey(task.getId()) == true) {

            Task toChange = services.get(task.getId());
            toChange.setName(task.getName());
            toChange.setDescription(task.getDescription());
            return true;
        }

        return false;
    }

    public boolean removeTask(Task task) {
        if(task != null && services.containsKey(task.getId())) {
            services.remove(task.getId());
            return true;
        }

        return false;
    }

    public Task getTask(Task task) {
        if(task == null) {
            return null;
        }

        return services.getOrDefault(task.getId(), null);
    }

    public int getSize() {
        return services.size();
    }
}
