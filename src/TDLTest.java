/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author saraholopainen
 */
import java.util.Date;
public class TDLTest {
    public static void main (String[] args){
        ToDoList tdl = new ToDoList();
        Task task = new Task("Dishes", 1, 1, "Personal");
        Task task2 = new Task("Do homework", 1, 3, "School");
        tdl.addTask(task);
        tdl.addTask(task2);
        System.out.print(tdl.getTasksByPriority());
    }
}
