//import java.util.Date;

public class Task {
    private String taskName;
    private int dueDate;
    private int priority;
    private String category;

    // Constructor
    public Task(String taskName, int dueDate, int priority, String category) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
    }

    // Getters
    public String getTaskName() {
        return taskName;
    }


    public int getDueDate() {
        return dueDate;
    }


    public int getPriority() {
        return priority;
    }
    
    public String getPriorityString(){
        switch(priority) {
            case 0 -> {
                return "Casual";
            }
            case 1 -> {
                return "Low Priority";
            }
            case 2 -> {
                return "Normal Priority";
            }
            case 3 -> {
                return "Medium Priority";
            }
            case 4 -> {
                return "High Priority";
            }
            case 5 -> {
                return "Urgent!";
            }
                
        }
        return "None";
    }
    
    public String getCategory() {
        return category;
    }

    // Setters
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }


    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override 
    public String toString(){
        return taskName + "-" + dueDate + "-"  + priority + "-" + category;
    }
}
