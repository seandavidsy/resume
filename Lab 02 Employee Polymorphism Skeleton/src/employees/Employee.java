package employees;

// -------------------------------------------------------------------------
/**
 * Represents an average employee working 40 hours per week.
 *
 * @author Sean Sy
 * @version 2019.09.01
 */
public class Employee {
    // ~ Fields ................................................................

    private String name;
    private int employeeId;
    private double hourlyRate;


    // ~ Constructor ...........................................................
    /**
     * New Employee object.
     *
     * @param name
     *            Name of Employee
     * @param employeeId
     *            Employee ID of Employee
     * @param hourlyRate
     *            Pay rate of Employee (per hour).
     */
    public Employee(String name, int employeeId, double hourlyRate) {
        this.name = name;
        this.employeeId = employeeId;
        this.hourlyRate = hourlyRate;
    }

    // ~ Methods ...............................................................


    // ----------------------------------------------------------
    /**
     * Gets the employee's name.
     * 
     * @return the employee's name
     */
    public String getName() {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Gets the employee's employee identifier.
     * 
     * @return the employee's employee identifier
     */
    public int getEmployeeId() {
        return employeeId;
    }


    // ----------------------------------------------------------
    /**
     * Gets the pay rate (per hour).
     * 
     * @return the pay rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }


    // ----------------------------------------------------------
    /**
     * Amount paid to the employee for an average 40 hour work week.
     * 
     * @return weekly pay for employee
     */
    public double weeklyPay() {
        return hourlyRate * 40;
    }
    
    @Override
    /**
     * Overrides equals method from Object using Employee data
     * 
     * @return true if Employee objects are equal
     * @return false if Employee objects are not equal
     * @return false if an Employee object is null
     * 
     */
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (this.getClass()  == obj.getClass())
        {
            Employee other = (Employee) obj;
            return name.equals(other.name)
                 && employeeId == other.employeeId; 
        }
        return false;
    }
}
