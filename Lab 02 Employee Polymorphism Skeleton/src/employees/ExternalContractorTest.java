package employees;
import student.TestCase;

/**
 * Tests all the methods in ExternalContractor to make sure
 * they run and perform as expected
 * 
 * @author Sean Sy
 * @version 2019.09.01
 *
 */
public class ExternalContractorTest extends TestCase {
    private ExternalContractor ec;
    
    /**
     * Sets up each test method before it runs
     */
    public void setUp()
    {
        ec = new ExternalContractor("john", 101, 10.5);
    }
    
    /**
     * Tests that the getHourlyRate method in ExternalContractor
     * correctly overloads the same method in Employee and that
     * ExternalContractor hourly rate correctly corresponds to its customer rank
     */
    public void testGetHourlyRate()
    {
        assertEquals(38.5, ec.getHourlyRate('A'), .01);
        assertEquals(41.75, ec.getHourlyRate('B'), .01);
        assertEquals(45.5, ec.getHourlyRate('C'), .01);
        assertEquals(0, ec.getHourlyRate('D'), .01);
    }
    
    /**
     * Tests that the weeklyPay method in ExternalContractor correctly 
     * overloads the weeklyPay method in Employee and returns the correct
     * amount corresponding to customer rank
     */
    public void testWeeklyPay()
    {
        assertEquals(10.5 * 40, ec.weeklyPay(), .01);
        assertEquals(38.5 * 20, ec.weeklyPay(20, 'A'), .01);
        assertEquals(41.75 * 20, ec.weeklyPay(20, 'B'), .01);
        assertEquals(45.5 * 20, ec.weeklyPay(20, 'C'), .01);
        assertEquals(0, ec.weeklyPay(20, 'D'), .01);
    }
    
}
