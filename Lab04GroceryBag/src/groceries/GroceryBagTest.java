package groceries;

/**
 * 
 * The GroceryBagTest class tests the methods from GroceryBag class
 * 
 * @author Sean Sy (906311775)
 * 
 * @version 9.18.2020
 *
 */
public class GroceryBagTest extends student.TestCase 
{
    private GroceryBag bag1;    // unordered
    private GroceryBag bag2;    // unordered with repeat items
    private GroceryBag bag3;    // ordered
    private GroceryBag bag4;    // ordered with repeat items

    /**
     * Sets up each test method.
     */
    public void setUp()
    {
        bag1 = new GroceryBag();
        bag1.add("apples");
        bag1.add("chips");
        bag1.add("yogurt");
        bag1.add("chicken");
        bag1.add("pasta");

        bag2 = new GroceryBag();
        bag2.add("pizza");
        bag2.add("broccoli");
        bag2.add("pasta");
        bag2.add("pasta");
        bag2.add("apples");

        bag3 = new GroceryBag();
        bag3.add("apples");
        bag3.add("chicken");
        bag3.add("chicken");
        bag3.add("pasta");
        bag3.add("pizza");
        bag3.add("soda");
        bag3.add("yogurt");
        bag3.add("wheat");

        bag4 = new GroceryBag();
        bag4.add("chicken");
        bag4.add("chicken");
        bag4.add("pasta");
        bag4.add("pasta");
        bag4.add("yogurt");
    }
   
    /**
     * Tests that the intersection method works as intended
     */
    public void testIntersection()
    {
        GroceryBag bag5 = new GroceryBag();    
        bag5.add("apples");
        bag5.add("pasta");
        
        GroceryBag bag6 = new GroceryBag();
        bag6.add("pizza");
        bag6.add("pasta");
        bag6.add("apples");        
        
        GroceryBag bag7 = new GroceryBag();
        bag7.add("chicken");
        bag7.add("chicken");
        bag7.add("pasta");
        bag7.add("yogurt");
        
        assertTrue(bag5.equals(bag1.intersection(bag2)));
        assertTrue(bag6.equals(bag2.intersection(bag3)));
        assertTrue(bag7.equals(bag3.intersection(bag4)));       
    }
    
    /**
     * Tests that the equals method works as intended, accounting for
     * 6 different possibilities
     */
    public void testEquals()
    {
        GroceryBag bag5 = null;
        GroceryBag bag6 = bag1;
        Object object = new Object();
        
        GroceryBag bag7 = new GroceryBag();
        bag7.add("chips");
        bag7.add("yogurt");
        bag7.add("apples");
        bag7.add("pasta");
        bag7.add("chicken");
        
        assertTrue(bag1.equals(bag1));
        assertFalse(bag1.equals(bag2));
        assertFalse(bag1.equals(bag3));
        assertFalse(bag1.equals(bag4));
        assertFalse(bag1.equals(bag5));
        assertTrue(bag1.equals(bag6));
        assertTrue(bag1.equals(bag7));
        assertFalse(bag1.equals(object));
    }
}
