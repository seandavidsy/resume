//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times. I
//Will not lie, cheat, or steal, nor will I accept the actions of those who do
//-- Sean Sy (906311775)
package towerofhanoi;

/**
 * Tests that the methods in Tower run and perform as expected
 * 
 * @author Sean Sy 906311775
 * @version 10/20/2020
 */
public class TowerTest extends student.TestCase {
    
    private Tower tower;
    
    /**
     * Set up method for all test methods to be run before each test
     */
    public void setUp() {
        
        tower = new Tower(Position.LEFT);      
    }
    
    /**
     * Tests that position method returns the correct position of the Tower
     */
    public void testPosition() {
        
        assertEquals(Position.LEFT, tower.position());
    }
    
    /**
     * Tests that push method correctly pushes Disks onto Towers 
     * if they meet the appropriate criteria of not being null and
     * being only pushed on a Tower that is either empty or its top
     * Disk is larger than the one being pushed
     */
    public void testPush() {
        
        Disk disk = null;
        Exception thrown = null;
        try {
            tower.push(disk);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        thrown = null;
        
        tower.push(new Disk(30));
        tower.push(new Disk(20));
        tower.push(new Disk(10));
        
        try {
            tower.push(new Disk(20));
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalStateException);
        
        assertEquals(3, tower.size(), 0.1);
    }

}
