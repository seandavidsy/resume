package employees;

/**
 * 
 * Represents an external contractor that either works
 * by the hour or per project; an extension of employee
 * 
 * @author Sean Sy
 * @version 2019.09.01
 *
 */
public class ExternalContractor extends Employee {

    
    /**
     * Constructor for an ExternalContractor object
     * @param name
     *          Name of External Contractor
     * @param employeeId
     *          Employee ID of External Contractor
     * @param hourlyRate
     *          Pay rate of External Contractor
     *      
     */
    public ExternalContractor(String name, int employeeId, double hourlyRate)
    {
        super(name, employeeId, hourlyRate);
    }
    
    /**
     * Gets the pay rate of External Contractor based on
     * customer rank and returns 0 if rank is not A, B, or C
     * 
     * @param custRank
     *              Customer rank of External Contractor
     * @return hourly rate of External Contractor
     */
    public double getHourlyRate(char custRank)
    {
        switch(custRank)
        {
            case 'A':
                return 38.5;
            case 'B':
                return 41.75;
            case 'C':
                return 45.5;
            default:
                return 0;
        }
    }
     
    /**
     * Amount paid to External Contractor based on 
     * customer rank and hours worked
     * 
     * @param hours
     *          Hours worked by External Contractor
     * @param custRank        
     *          Customer rank of External Contractor
     * @return weekly pay of External contractor
     */
    public double weeklyPay(int hours, char custRank)
    {
        return hours * getHourlyRate(custRank);
    }
}
