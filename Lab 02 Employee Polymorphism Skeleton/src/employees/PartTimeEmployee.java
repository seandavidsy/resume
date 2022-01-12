package employees;

/**
 * 
 * Represents a part time employee working a certain
 * amount of hours a week; an extension of employee
 * 
 * @author Sean Sy
 * @version 2019.09.01
 *
 */
public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    
    /**
     * Constructor for a PartTimeEmployee object
     * 
     * @param name
     *          Name of Part Time Employee
     * @param employeeId
     *          Employee ID of Part Time Employee
     * @param hourlyRate
     *          Pay rate of Part Time Employee (per hour)
     * @param hoursWorked
     *          Hours worked by Part Time Employee
     */
    public PartTimeEmployee(String name, int employeeId,
        double hourlyRate, int hoursWorked)
    {
        super(name, employeeId, hourlyRate);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    
    /**
     * Gets the hours worked by the Part Time Employee
     * 
     * @return hours worked
     */
    public int getHoursWorked()
    {
        return hoursWorked;
    }
    
    @Override
    /**
     * Amount paid to Part Time Employee based on hours
     * worked and pay rate
     * 
     * @return weekly pay of Part Time Employee
     */
    public double weeklyPay()
    {
        return hourlyRate * hoursWorked;
    }
    
}
