// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times. I
// Will not lie, cheat, or steal, nor will I accept the actions of those who do
// -- Sean Sy (906311775)

package game;
import junit.framework.TestCase;
import student.TestableRandom;

/**
 * Tests that the methods in SimpleArrayBag run and perform as expected
 * 
 * @author Sean Sy (906311775)
 * @version 2020.10.05
 */
public class SimpleArrayBagTest extends TestCase {

    private SimpleArrayBag<String> bag;
    
    /**
     * Set up for all test methods to be run before each test
     */
    public void setUp() {
        
        bag = new SimpleArrayBag<String>();        
    }
    
    /**
     * Tests that add method correctly adds object if there are
     * 25 or less objects in the bag and never adds a null object
     */
    public void testAdd() {
        
        assertFalse(bag.add(null));
        assertTrue(bag.add("object"));
        
        for (int i = 0; i < 25; i++) {
            bag.add("object" + i);
        }
        assertFalse(bag.add("maxobject"));
    }
    
    /**
     * Tests that getCurrentSize method returns the numberOfEntries field
     * representing the amount of objects in the bag and that add and remove
     * methods properly changes numberOfEntries field
     */
    public void testGetCurrentSize() {
        
        assertEquals(0, bag.getCurrentSize());
        
        bag.add("object");
        assertEquals(1, bag.getCurrentSize());
        
        bag.remove("object");
        assertEquals(0, bag.getCurrentSize());
    }
    
    /**
     * Tests that isEmpty method returns true when no objects are in the bag
     * and returns false when there are objects in the bag
     */
    public void testIsEmpty() {
        
        assertTrue(bag.isEmpty());
        
        bag.add("object");
        assertFalse(bag.isEmpty());
    }
    
    /**
     * Tests that pick method returns null if the bag is empty, otherwise
     * that it returns a randomly selected object from the bag
     */
    public void testPick() {
        
        assertNull(bag.pick());
        
        for (int i = 0; i < 10; i++) {
            bag.add("object" + i);
        }
        TestableRandom.setNextInts(3, 5, 9);
        assertEquals("object3", bag.pick());
        assertEquals("object5", bag.pick());
        assertEquals("object9", bag.pick());
    }
    
    /**
     * Tests that remove method correctly removes objects from the bag,
     * returning false if the object being removed is not in the bag and
     * returning true if the object is successfully removed
     */
    public void testRemove() {
        
        bag.add("object1");
        bag.add("object2");
        assertFalse(bag.remove("object"));     
        assertTrue(bag.remove("object2"));
    }
}
