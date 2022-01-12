// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times. I
// Will not lie, cheat, or steal, nor will I accept the actions of those who do
// -- Sean Sy (906311775)

package game;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * Implements an array based bag data structure
 * 
 * @param <T> The type of objects that the bag will hold
 * 
 * @author Sean Sy (906311775)
 * @version 2020.10.05
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {

    /*
     * MAX is a constant referencing the max amount of objects bag can hold
     */
    private T[] bag;
    private static final int MAX = 25;
    private int numberOfEntries;
    
    /**
     * SimpleArrayBag constructor to create a new SimpleArrayBag object
     */
    public SimpleArrayBag() {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[]) new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;
    }
    
    /**
     * Adds the specified object to the bag
     * 
     * @param anEntry Object to be added
     * @return true if item added successfully, false 
     * if object is null or if numberOfEntries >= 25
     */
    @Override
    public boolean add(T anEntry) {
    
        if (anEntry == null) {
            return false;
        }
        
        if (numberOfEntries < MAX) {
            bag[numberOfEntries] = anEntry;
            numberOfEntries++;
            return true;
        }
        
        return false;
    }

    /**
     * Provides the current amount of objects in bag
     * 
     * @return value of numberOfEntries field
     */
    @Override
    public int getCurrentSize() {
        
        return numberOfEntries;
    }

    /**
     * Determines if the bag contains no objects
     *
     * @return true if bag is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        
        return numberOfEntries == 0;
    }

    /**
     * Randomly selects an object from the bag using the TestableRandom class
     * 
     * @return null if the bag is empty, otherwise returns the randomly
     * selected object.
     */
    @Override
    public T pick() {
                
        if (isEmpty()) {
            return null;
        }
        
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);
        return bag[index];
    }

    /**
     * Private helper method used to find the index of the specified object
     * if it is in bag
     * 
     * @param anEntry object being provided the index for
     * @return the index of the object, -1 if the object is not in bag to
     * represent that the object is not in bag
     */
    private int getIndexOf(T anEntry) {
        
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }
        
        return -1;
    }

    /**
     * Removes the specified object from the bag. If multiple
     * copies of the same object appear in the bag, only one is removed.
     * Uses private getIndexOf helper method to determine if the object is in
     * the bag and if it is, provides the index of the object being removed
     *
     * @param anEntry object to be removed
     * @return true if the object was removed successfully, false if the
     * object is not in the bag
     */
    @Override
    public boolean remove(T anEntry) {
        
        if (getIndexOf(anEntry) == -1) {
            return false;
        }
        
        bag[getIndexOf(anEntry)] = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        return true;
    }

}
