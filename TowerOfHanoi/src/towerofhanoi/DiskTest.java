//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times. I
//Will not lie, cheat, or steal, nor will I accept the actions of those who do
//-- Sean Sy (906311775)
package towerofhanoi;

/**
 * Tests that the methods in Disk run and perform as expected
 * 
 * @author Sean Sy 906311775
 * @version 10/20/2020
 */
public class DiskTest extends student.TestCase {

    private Disk disk1;
    private Disk disk2;
    private Disk disk3;
    private Disk disk4;
    private Disk disk5;
    
    /**
     * Set up for all test methods to be run before each test
     */
    public void setUp() {
        
        disk1 = new Disk(10);
        disk2 = new Disk(20);
        disk3 = new Disk(30);
        disk4 = new Disk(30);  
        disk5 = null;
    }
    
    /**
     * Tests that compareTo method throws an IllegalArgumentException if the
     * Disk parameter is null, returns 1 if this Disk's width is lesser than
     * the Disk parameter's width, -1 if this Disk's width is greater than the
     * Disk parameter's width, 0 if the two Disks have equal widths
     */
    public void testCompareTo() {
        
        Exception thrown = null;
        try {
            disk1.compareTo(disk5);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        assertEquals(-1, disk1.compareTo(disk2), 0.1);
        assertEquals(1, disk3.compareTo(disk2), 0.1);
        assertEquals(0, disk3.compareTo(disk4), 0.1);
    }
    
    /**
     * Tests that toString method returns the
     * Disk's correct width in String format
     */
    public void testToString() {
        
        assertEquals("10", disk1.toString());
    }
    
    /**
     * Tests that equals method works as intended, returning true only if the
     * two Objects being compared are Disks of equal length and false otherwise
     */
    public void testEquals() {
        
        Object disk6 = new Object();
        
        assertFalse(disk1.equals(disk5));
        assertFalse(disk1.equals(disk6));
        assertTrue(disk1.equals(disk1));
        assertFalse(disk1.equals(disk2));
        assertTrue(disk3.equals(disk4));
    }
}
