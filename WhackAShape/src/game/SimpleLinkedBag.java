// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times. I
// Will not lie, cheat, or steal, nor will I accept the actions of those who do
// -- Sean Sy (906311775)

package game;
import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * Implements a linked nodes based bag data structure
 * 
 * @param <T> The type of objects that the bag will hold
 * 
 * @author Sean Sy (906311775)
 * @version 2020.10.05
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {
    
    private Node<T> firstNode;
    private int numberOfEntries;

    /**
     * SimpleLinkedBag constructor to create a new SimpleLinkedBag object
     */
    public SimpleLinkedBag() {
       
        firstNode = null;
        numberOfEntries = 0;
    }
    
    /**
     * Adds the specified object to the bag
     * 
     * @param anEntry Object to be added
     * @return true if item added successfully, false 
     * if object is null 
     */
    @Override
    public boolean add(T anEntry) {
        
        if (anEntry == null) {
            return false;
        }
        
        Node<T> second = new Node<T>(anEntry, firstNode);
        firstNode = second;
        numberOfEntries++;
        return true;
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
     
        Node<T> random = firstNode;
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);
        for (int i = 0; i < index; i++) {
            random = random.getNext();
        }
        return random.getData();
    }

    /**
     * Finds the node that has the object being searched for
     * 
     * @param anEntry the node data being searched for
     * @return the node being referenced if found, null if the object is not
     * in the bag
     */
    public Node<T> getReferenceTo(T anEntry) {
        
        boolean found = false;
        Node<T> currentNode = firstNode;
        
        while (!found && currentNode != null) {
            if (currentNode.getData().equals(anEntry)) {
                found = true;
            }
            else {
                currentNode = currentNode.getNext();
            }
        }
        return currentNode;
    }
    
    /**
     * Removes the specified object from the bag. If multiple
     * copies of the same object appear in the bag, only one is removed.
     * Uses getReferenceTo method to determine if the object is in
     * the bag and if it is, provides the node to be removed
     *
     * @param anEntry object to be removed
     * @return true if the object was removed successfully, false if the
     * object is not in the bag
     */
    @Override
    public boolean remove(T anEntry) {
        
        if (getReferenceTo(anEntry) == null) {
            return false;
        }
        
        Node<T> removedNode = getReferenceTo(anEntry);
        removedNode.setData(firstNode.getData());
        firstNode = firstNode.getNext();
        numberOfEntries--;
        return true;        
    }

}
