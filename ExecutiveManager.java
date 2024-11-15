import java.util.Scanner;

/**
 * Manages departments, executives, and processes user commands to manage
 * executives within various departments in an organization.
 * Provides functions for hiring, assigning, and removing executives,
 * as well as displaying payroll information.
 */
public class ExecutiveManager {
    private Department[] d = new Department[10]; // Array to hold up to 10 departments
    private Executive[] e = new Executive[50]; // Array to hold up to 50 executives
    private int departmentCount = 0; // Tracks the number of departments
    private int executiveCount = 0; // Tracks the number of executives

    /**
     * Adds a new department to the organization.
     *
     * @param departmentName The name of the department to add.
     */
    public void addDepartment(String departmentName) {
        if (departmentCount < d.length) {
            d[departmentCount++] = new Department(departmentName);
            System.out.println("Department " + departmentName + " created.");
        } else {
            System.out.println("Max department limit reached."); // Error message if limit reached
        }
    }

    /**
     * Hires a new executive and adds them to the list of executives.
     *
     * @param executiveName The name of the executive to hire.
     */
    public void hireExecutive(String executiveName) {
        if (executiveCount < e.length) {
            e[executiveCount++] = new Executive(executiveName);
            System.out.println("Executive " + executiveName + " hired.");
        } else {
            System.out.println("Max executive limit reached."); // Error if max limit of executives is reached
        }
    }

    /**
     * Finds a department by name.
     *
     * @param departmentName The name of the department to search for.
     * @return The department if found; otherwise, null.
     */
    public Department findDepartment(String departmentName) {
        for (int i = 0; i < departmentCount; i++) {
            if (d[i].getName().equals(departmentName)) {
                return d[i];
            }
        }
        return null; // Return null if department is not found
    }

    /**
     * Finds an executive by name.
     *
     * @param executiveName The name of the executive to search for.
     * @return The executive if found; otherwise, null.
     */
    public Executive findExecutive(String executiveName) {
        for (int i = 0; i < executiveCount; i++) {
            if (e[i].getName().equals(executiveName)) {
                return e[i];
            }
        }
        return null; // Return null if executive is not found
    }

    /**
     * Assigns an executive to a department. Removes the executive from their
     * current department, if any, before adding them to the new department.
     *
     * @param executiveName  The name of the executive to join the department.
     * @param departmentName The name of the department to join.
     */
    public void joinDepartment(String executiveName, String departmentName) {
        Executive executive = findExecutive(executiveName);
        Department department = findDepartment(departmentName);

        if (executive == null || department == null) {
            System.out.println("Invalid executive or department."); // Error if invalid executive or department
            return;
        }

        if (executive.getDepartment() != null) {
            executive.getDepartment().removeExecutive(executive); // Remove from current department if exists
        }
        department.addExecutive(executive); // Add executive to new department
        System.out.println(executiveName + " joined " + departmentName + ".");
    }

    /**
     * Removes an executive from their current department.
     *
     * @param executiveName The name of the executive to remove.
     */
    public void quitDepartment(String executiveName) {
        Executive executive = findExecutive(executiveName);

        if (executive == null || executive.getDepartment() == null) {
            System.out.println("Executive not found in any department."); // Error if not in any department
            return;
        }

        Department department = executive.getDepartment();
        department.removeExecutive(executive); // Remove executive from their current department
        System.out.println(executiveName + " quit " + department.getName() + ".");
    }

    /**
     * Changes the department of an executive to a new department.
     *
     * @param executiveName     The name of the executive to move.
     * @param newDepartmentName The name of the new department.
     */
    public void changeDepartment(String executiveName, String newDepartmentName) {
        Executive executive = findExecutive(executiveName);
        Department newDepartment = findDepartment(newDepartmentName);

        if (executive == null || newDepartment == null) {
            System.out.println("Invalid executive or department."); // Error if invalid executive or department
            return;
        }

        quitDepartment(executiveName); // Remove executive from current department
        joinDepartment(executiveName, newDepartmentName); // Add executive to new department
    }

    /**
     * Displays the payroll for all departments, listing each executive and their salary.
     */
    public void displayPayroll() {
        for (int i = 0; i < departmentCount; i++) {
            d[i].listExecutives(); // List executives in each department
        }
    }

    /**
     * Displays the salary of a specified executive.
     *
     * @param executiveName The name of the executive whose salary is displayed.
     */
    public void displaySalary(String executiveName) {
        Executive executive = findExecutive(executiveName);
        if (executive == null || executive.getDepartment() == null) {
            System.out.println(executiveName + " is unemployed and has no salary."); // Error if executive is unemployed
            return;
        }

        int salary = executive.getDepartment().calculateSalary(executive); // Calculate and display salary
        System.out.println(executiveName + "'s Salary: $" + salary);
    }

    /**
     * The main method that runs the command-line interface for managing executives
     * and departments. Provides commands to add departments, hire executives, assign
     * executives to departments, view payroll, and other operations.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        ExecutiveManager manager = new ExecutiveManager();
        Scanner scanner = new Scanner(System.in);

        // Command loop to process user inputs
        while (true) {
            System.out.println("Enter a command:");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            String action = parts[0].toLowerCase();

            switch (action) {
                case "add":
                    if (parts.length < 2) {
                        System.out.println("Error: Department name required.");
                        break;
                    }
                    manager.addDepartment(parts[1]);
                    break;

                case "hire":
                    if (parts.length < 2) {
                        System.out.println("Error: Executive name required.");
                        break;
                    }
                    manager.hireExecutive(parts[1]);
                    break;

                case "join":
                    if (parts.length < 3) {
                        System.out.println("Error: Executive name and department required.");
                        break;
                    }
                    manager.joinDepartment(parts[1], parts[2]);
                    break;

                case "quit":
                    if (parts.length < 2) {
                        System.out.println("Error: Executive name required.");
                        break;
                    }
                    manager.quitDepartment(parts[1]);
                    break;

                case "change":
                    if (parts.length < 3) {
                        System.out.println("Error: Executive name and new department required.");
                        break;
                    }
                    manager.changeDepartment(parts[1], parts[2]);
                    break;

                case "payroll":
                    manager.displayPayroll();
                    break;

                case "salary":
                    if (parts.length < 2) {
                        System.out.println("Error: Executive name required.");
                        break;
                    }
                    manager.displaySalary(parts[1]);
                    break;

                case "exit":
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid command."); // Error for unknown command
            }
        }
    }
}
