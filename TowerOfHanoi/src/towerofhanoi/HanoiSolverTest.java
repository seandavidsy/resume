//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times. I
//Will not lie, cheat, or steal, nor will I accept the actions of those who do
//-- Sean Sy (906311775)
package towerofhanoi;

/**
 * Tests that the methods in HanoiSolver run and perform as expected
 * 
 * @author Sean Sy 906311775
 * @version 10/20/2020
 */
public class HanoiSolverTest extends student.TestCase {

    private HanoiSolver hanoi;
    private Tower left;
    private Tower middle;
    private Tower right;
    
    /**
     * Set up method for all tests to be run before each test
     */
    public void setUp() {
        
        hanoi = new HanoiSolver(5);
        left = hanoi.getTower(Position.LEFT);
        middle = hanoi.getTower(Position.MIDDLE);
        right = hanoi.getTower(Position.RIGHT);
    }
    
    /**
     * Tests that disks method returns the correct
     * amount of disks in HanoiSolver object
     */
    public void testDisks() {
        assertEquals(5, hanoi.disks(), 0.1);
    }
    
    /**
     * Tests that getTower method returns the Tower correctly corresponding
     * to the Position enum parameter and the middle Tower for the default case
     */
    public void testGetTower() {
        
        assertEquals(left.position(),
            hanoi.getTower(Position.LEFT).position());
        assertEquals(right.position(),
            hanoi.getTower(Position.RIGHT).position());
        assertEquals(middle.position(),
            hanoi.getTower(Position.MIDDLE).position());
        assertEquals(middle.position(),
            hanoi.getTower(Position.DEFAULT).position());
    }
    
    /**
     * Tests that toString method returns the toString of left, middle,
     * and right tower in that order as one String
     */
    public void testToString() {
        
        left.push(new Disk(30));
        left.push(new Disk(20));
        right.push(new Disk(10));
        middle.push(new Disk(40));
        
        assertEquals("[20, 30][40][10]", hanoi.toString());
    }
    
    /**
     * Tests that solve method correctly transfers
     * Disks in right Tower to the left Tower 
     */
    public void testSolve() {
        
        right.push(new Disk(50));
        right.push(new Disk(40));
        right.push(new Disk(30));
        right.push(new Disk(20));
        right.push(new Disk(10));
        
        hanoi.solve();
        assertEquals("[10, 20, 30, 40, 50][][]", hanoi.toString());
    }
}
