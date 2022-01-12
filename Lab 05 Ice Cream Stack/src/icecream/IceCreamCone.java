/**
 * 
 */
package icecream;

import java.util.Stack;

/**
 * 
 * The IceCreamCone implements the IceCreamConeADT, creating an ice
 * cream cone that holds flavors, which are represented by Strings.
 * 
 * @author Sean Sy (906311775)
 * 
 * @version 9.18.2020
 *
 */
public class IceCreamCone implements IceCreamConeADT {
    private Stack<String> flavors;
    private int numScoops;
    
    /**
     * Creates an ice cream cone with no scoops on it
     */
    public IceCreamCone()
    {
        numScoops = 0;
        flavors = new Stack<String>();
    }

    /**
     * Eat the top scoop of ice cream.
     * 
     * @precondition There exists at least one flavor of ice cream in the ice
     *               cream cone. (The cone isn't empty).
     * @return The flavor of the scoop eaten.
     */
    @Override
    public String eatScoop() {
        
        numScoops--;
        return flavors.pop();
    }

    /**
     * Add a scoop of ice cream to the top of the ice cream cone.
     * 
     * @precondition The flavor isn't null.
     * @param flavor
     *            Flavor of ice cream to be added.
     */
    @Override
    public void addScoop(String flavor) {

        flavors.push(flavor);
        numScoops++;
    }

    /**
     * The number of scoops on the cone.
     * 
     * @return Returns the number of scoops on the cone.
     */
    @Override
    public int numScoops() {
        
        return numScoops;
    }

    /**
     * Check if your cone already contains a specific flavor of ice cream.
     * 
     * @precondition The flavor isn't null.
     * @param flavor
     *            Flavor to be checked for.
     * @return Returns true if the cone already contains the desired flavor.
     */
    @Override
    public boolean contains(String flavor) {
        
        return flavors.contains(flavor);
        
    }

    /**
     * Checks if any scoops of ice cream are left.
     * 
     * @return Returns true if there are no ice cream scoops left in the cone.
     */
    @Override
    public boolean emptyCone() {
        
        return numScoops == 0;
    }

    /**
     * The flavor of the ice cream at the top of the cone.
     * 
     * @precondition There exists at least one flavor of ice cream in the ice
     *               cream cone. (The cone isn't empty).
     * @return Returns the flavor of the top of the cone.
     */
    @Override
    public String currentScoop() {
        
        return flavors.peek();
    }
    
    /**
     * Returns a string representation of the ice cream cone. Format: The
     * flavors are surrounded by brackets: [] The flavors are separated by
     * commas. Example: [Vanilla, Chocolate, Rocky Road] Orientation: Flavors
     * are appended to the right when pushed onto the stack. Flavors are removed
     * from the right when popped off the stack.
     * 
     * @return The string of the ice cream flavors.
     */
    @Override
    public String toString() {
        
        return flavors.toString();
    }
    
    /**
     * Checks to see the equality between two ice cream cones, returning true
     * when the two cones have the same flavors in the same order and
     * returning false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other == null) || (other.getClass() != IceCreamCone.class)) {
            return false;
        }
        return flavors.equals(((IceCreamCone) other).flavors);
    }
}
