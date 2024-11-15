/**
 * Represents an executive within an organization. Each executive has a name
 * and may be associated with a department. An executive can be assigned or removed
 * from a department.
 */
public class Executive {
    private String name; 
    private Department department; 

    /**
     * Constructs an Executive with a specified name. Initially, the executive is not assigned to any department.
     *
     * @param name The name of the executive.
     */
    public Executive(String name) {
        this.name = name;
        this.department = null; // No department assigned upon creation
    }

    /**
     * Gets the name of the executive.
     *
     * @return The name of the executive.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the department to which the executive is currently assigned.
     *
     * @return The executive's department, or null if not assigned to any department.
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Sets the department of the executive. This can be used to assign the executive to a new department
     * or to remove them from a department by setting it to null.
     *
     * @param department The department to assign to the executive, or null to remove assignment.
     */
    public void setDepartment(Department department) {
        this.department = department; 
    }
}
