import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a department that holds a queue of executives ordered by seniority.
 * Each executive has a salary based on their position in the queue.
 */
public class Department {
    private String name; 
    private Queue<Executive> execs; // Queue of executives in order of seniority

    /**
     * Constructs a new Department with the specified name.
     *
     * @param name The name of the department.
     */
    public Department(String name) {
        this.name = name;
        this.execs = new LinkedList<>();
    }

    /**
     * Retrieves the name of the department.
     *
     * @return The department name.
     */
    public String getName() { 
        return name; 
    }

    /**
     * Adds an executive to the department and sets the executive's department to this.
     *
     * @param executive The executive to add.
     */
    public void addExecutive(Executive executive) {
        execs.add(executive);
        executive.setDepartment(this); 
    }

    /**
     * Removes an executive from the department and clears the executive's department reference.
     *
     * @param executive The executive to remove.
     */
    public void removeExecutive(Executive executive) {
        execs.remove(executive);
        executive.setDepartment(null); 
    }

    /**
     * Calculates the salary for a specific executive based on their seniority.
     * Executives earn a base salary plus additional salary depending on their position
     * in the queue.
     *
     * @param executive The executive whose salary is being calculated.
     * @return The calculated salary of the executive.
     */
    public int calculateSalary(Executive executive) {
        int baseSalary = 40000; // Base salary for each executive
        int additionalSalary = 0; // Additional salary based on seniority
        boolean found = false; 

        for (Executive e : execs) {
            if (e == executive) {
                found = true; 
            } else if (found) {
                additionalSalary += 5000; // Add extra salary for each subsequent executive
            }
        }
        return baseSalary + additionalSalary; 
    }

    /**
     * Lists all executives in the department and their respective salaries, ordered
     * by seniority (from the most junior to the most senior).
     */
    public void listExecutives() {
        Executive[] execArr = execs.toArray(new Executive[0]);

        System.out.println("Department: " + name);
         
        for (int i = execArr.length - 1; i >= 0; i--) {
            Executive executive = execArr[i];
            System.out.println(executive.getName() + ": $" + calculateSalary(executive));
        }
    }
}
