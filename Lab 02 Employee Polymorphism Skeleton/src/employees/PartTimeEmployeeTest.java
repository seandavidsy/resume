package employees;
import student.TestCase;

/**
 * 
 * Tests all the methods in PartTimeEmployee to
 * make sure they run and perform as expected
 * 
 * @author Sean Sy
 * @version 2019.09.01
 *
 */
public class PartTimeEmployeeTest extends TestCase {
    private PartTimeEmployee temp;
    
    /**
     * Sets up each test method before it runs
     */
    public void setUp()
    {
        temp = new PartTimeEmployee("john", 101, 10.5, 20);
    }
    
    /**
     * Tests that the hours worked matches
     */
    public void testGetHoursWorked()
    {
        assertEquals(20, temp.getHoursWorked());
    }
    
    /**
     * Tests that the weeklyPay method from PartTimeEmployee
     * correctly overrides the weeklyPay method from Employee
     * and that it returns the weekly pay of a PartTimeEmployee
     */
    public void testWeeklyPay() 
    {
        assertEquals(20 * 10.5, temp.weeklyPay(), .01);
    }
}
