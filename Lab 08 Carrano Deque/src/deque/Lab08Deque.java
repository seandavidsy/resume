package deque;

/**
 * A deque implemented using a doubly-linked chain.
 *
 * @param <T>
 *            The type of elements contained in the deque.
 *
 * @author Sean Sy 906311775
 * @version 10/17/2020
 */
public class Lab08Deque<T> extends DLinkedDeque<T>
{

    /**
     * Inserts a new item at the front of the deque.
     * 
     * @param newEntry
     *            the item to insert.
     */
    public void addToFront(T newEntry)
    {
        DLNode<T> newNode = new DLNode<T>(newEntry);
        DLNode<T> oldNode = firstNode;
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = firstNode;
        }
        if (this.size() == 1) {
            lastNode = firstNode;
            firstNode = newNode;
        }
        else {
            firstNode = newNode;
            firstNode.setNextNode(oldNode);
        }
        this.size++;
    }

    /**
     * Insert a new item at the rear of the deque.
     * 
     * @param newEntry
     *            the item to insert.
     */
    public void addToBack(T newEntry)
    {
        DLNode<T> newNode = new DLNode<T>(newEntry);
        DLNode<T> oldNode = lastNode;
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = firstNode;
        }
        if (this.size() == 1) {
            firstNode = lastNode;
            lastNode = newNode;
        }
        else {
            lastNode = newNode;
            lastNode.setPreviousNode(oldNode);
        }
        this.size++;
    }

    /**
     * Remove the item at the front of the deque.
     * 
     * @return The item that was removed
     * @throws EmptyQueueException
     *             if there is not an element at the front
     */
    public T removeFront()
    {        
        DLNode<T> tempNode = firstNode;
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        if (this.size() == 1) {
            firstNode = null;
            lastNode = firstNode;
            size--;
            return tempNode.getData();
        }
        firstNode = firstNode.getNextNode();
        size--;
        return tempNode.getData();
    } 

    /**
     * Remove the item at the rear of the deque.
     * 
     * @return The item that was removed
     * @throws EmptyQueueException
     *                  if there is no element at the front
     */
    public T removeBack()
    {
        DLNode<T> tempNode = lastNode;
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        if (this.size() == 1) {
            firstNode = null;
            lastNode = firstNode;
            size--;
            return tempNode.getData();
        }
        lastNode = lastNode.getPreviousNode();
        size--;
        return tempNode.getData();

    }

    /**
     * Get the item at the front (the head) of the deque. Does not alter the
     * deque.
     * 
     * @return the item at the front of the deque.
     * @throws EmptyQueueException
     *                     if no element at the front
     */
    public T getFront()
    {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            return firstNode.getData();
        }
    }

    /**
     * Get the item at the rear (the tail) of the deque. Does not alter the
     * deque.
     * 
     * @return the item at the rear of the deque.
     * @throws EmptyQueueException
     *              if  no element at rear
     *            
     */
    public T getBack()
    {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            return lastNode.getData();
        }
    }

    /**
     * Check if the deque is empty
     * 
     * @return true if the deque has no items
     */
    public boolean isEmpty()
    {
        return this.size() == 0;
    }

    /**
     * Empty the deque.
     */
    public void clear()
    {
        while (!isEmpty()) {
            removeFront();
        }
    }

    // ----------------------------------------------------------
    /**
     * Returns a string representation of this deque. A deque's string
     * representation is written as a comma-separated list of its contents (in
     * front-to-rear order) surrounded by square brackets, like this:
     * 
     * [52, 14, 12, 119, 73, 80, 35]
     * 
     * An empty deque is simply [].
     *
     * @return a string representation of the deque
     */
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("[");
        DLNode<T> p = firstNode;
        while (p != null)
        {
            if (s.length() > 1) {
                s.append(", ");
            }
            s.append(p.getData());
            p = p.getNextNode();
            
        }
        s.append("]");
        return s.toString();
    }
    
    /**
     * Removes and returns the second entry of this deque The front entry stays
     * the same and the third entry becomes the second.
     * 
     * @return The second object of the deque. Null, if it doesn't exist.
     * @throws EmptyQueueException if the deque is empty before the operation.
     */

    public T removeSecond()
    {
        
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        if (this.size() == 1) {
            return null;
        }
        else {
            DLNode<T> oldNode = firstNode.getNextNode();
            firstNode = firstNode.getNextNode();
            this.size--;
            return oldNode.getData();
        }
    }

    /**
     * Removes and returns the second to last entry of this deque. All other 
     * entries stay the same and the third to last entry becomes the second
     * to last.
     * 
     * @return The object second to last in the deque and null if it doesn't
     * exist.
     * @throws EmptyQueueException if the deque is empty before the operation.
     */
    public T removeSecondToLast()
    {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        if (this.size() == 1) {
            return null;
        }
        else {
            DLNode<T> oldNode = lastNode.getPreviousNode();
            lastNode = lastNode.getPreviousNode();
            this.size--;
            return oldNode.getData();
        }
    }
}
