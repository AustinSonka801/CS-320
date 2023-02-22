public class Task {
    private final String ID;
    private String Name;
    private String Description;

    public Task(String ID_, String Name_, String Description_) {

        assert ID_ != null && ID_.length() <= 10 : "incorrect";

        ID = ID_;
        setName(Name_);
        setDescription(Description_);
    }

    public String getId() { return ID; }

    public String getName() { return Name; }

    public void setName(String Name_) {
        assert Name_ != null && Name_.length() <= 20 : "Name incorrect";
        Name = Name_;
    }

    public String getDescription() { return Description; }

    public void setDescription(String Description_) {
        assert Description_ != null && Description_.length() <= 50 : "Description incorrect";
        Description = Description_;
    }

    public String toString() {
        return "(" + ID + ", " + Name + ", " + Description + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != Task.class) {
            return false;
        }

        Task task = (Task) obj;
        return ID.equals(task.getId()) && Name.equals(task.getName()) && Description.equals(task.getDescription());
    }
}
