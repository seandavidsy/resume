package employees;
import student.TestCase;

/**
 * 
 * Tests all the methods in Employee to make sure
 * they run and perform as expected
 * 
 * @author Sean Sy
 * @version 2019.09.01
 */
public class EmployeeTest extends TestCase {
    private Employee emp;
    private Object obj;
    
    /**
     * Sets up each test method before it runs
     */
    public void setUp()
    {
        emp = new Employee("john", 101, 10.50);
        obj = new Object();
    }
    
    /**
     * Tests that the name matches
     */
    public void testGetName()
    {
        assertEquals("john", emp.getName());
    }
    
    /**
     * Tests that the employee ID matches
     */
    public void testGetEmployeeId()
    {
        assertEquals(101, emp.getEmployeeId());
    }
    
    /**
     * Tests that the hourly rate matches
     */
    public void testGetHourlyRate()
    {
        assertEquals(10.50, emp.getHourlyRate(), .01);
    }
    
    /**
     * Tests that the weekly pay returns the proper
     * weekly pay of an employee working 40 hours a week
     */
    public void testWeeklyPay()
    {
        assertEquals(10.5 * 40, emp.weeklyPay(), .01);
    }
    
    /**
     * Tests that two employees are equal when the name and
     * employee ID match and are not equal if either the name
     * or employee ID doesn't match or if the object is null
     */
    public void testEquals()
    {
        Employee emp1 = new Employee("john", 101, 10);
        Employee emp2 = new Employee("notJohn", 101, 10);
        Employee emp3 = new Employee("john", 102, 10);
        Employee emp4 = null;
        assertTrue(emp.equals(emp1));
        assertFalse(emp.equals(emp2));
        assertFalse(emp.equals(emp3));
        assertFalse(emp.equals(emp4));
        assertFalse(emp.equals(obj));
    }
}
