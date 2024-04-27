import javax.swing.AbstractListModel;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;
//import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoList extends AbstractListModel<String> {
    private ArrayList<Task> tasks = new ArrayList<>();

    @Override
    public int getSize() {
        return tasks.size();
    }

    @Override
    public String getElementAt(int index) {
        Task task = tasks.get(index);
        return task.getTaskName();
    }

    public void addTask(Task task) {
        tasks.add(task);
        fireContentsChanged(this, 0, getSize() - 1); // Notify listeners of the change
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        fireContentsChanged(this, 0, getSize() - 1); // Notify listeners of the change
    }
    public void removeTaskByName(String taskName) {
        // Iterate through the list of tasks
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
        Task task = iterator.next();
        // Check if the task name matches the specified taskName
        if (task.getTaskName().equals(taskName)) {
            // Remove the task from the list
            iterator.remove();
            // Notify listeners of the change
            fireContentsChanged(this, 0, getSize() - 1);
            // Exit the loop since we found and removed the task
            break;
        }
    }
}
    public List<Task> getTasksByPriority() {
        return tasks.stream()
                .sorted(Comparator.comparingInt(Task::getPriority).reversed())
                .collect(Collectors.toList());
    }

    public List<Task> getDailyTasks() {
        return tasks.stream()
            .filter(task -> task.getDueDate() == 1) // Filter tasks with dueDate 1 (daily)
            .sorted(Comparator.comparingInt(Task::getPriority).reversed()) // Sort by priority
            .collect(Collectors.toList());
    }

    public List<Task> getWeeklyTasks() {
        return tasks.stream()
            .filter(task -> task.getDueDate() == 2) // Filter tasks with dueDate 2 (weekly)
            .sorted(Comparator.comparingInt(Task::getPriority).reversed()) // Sort by priority
            .collect(Collectors.toList());
    }

    public List<Task> getMonthlyTasks() {
        return tasks.stream()
            .filter(task -> task.getDueDate() == 3) // Filter tasks with dueDate 3 (monthly)
            .sorted(Comparator.comparingInt(Task::getPriority).reversed()) // Sort by priority
            .collect(Collectors.toList());
    }
    
    //Advanced method, using integers for day/week/month 
    /*private List<Task> getTasksByDateInterval(int days) {
        Date currentDate = new Date();
        Date pastDate = new Date(currentDate.getTime() - days * 24 * 3600 * 1000L);
        return tasks.stream()
                .filter(task -> task.getDueDate().after(pastDate))
                .collect(Collectors.toList());
    }
    */
}