/**
 * 
 */
package arraystack;

import java.util.EmptyStackException;
/**
 * Implements an array based stack data structure.
 * 
 * @param <T> The type of objects that the stack will hold.
 * 
 * @author Sean Sy (906311775)
 * @version 2020.10.03
 */
public class ArrayBasedStack<T> implements StackADT<T> {
    
    private T[] stackArray;
    private int size;
    private int capacity;
    
    /**
     * Creates an empty ArrayBasedStack
     * @param cap
     *          The amount of objects the ArrayBasedStack can hold
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedStack(int cap) {
        
        size = 0;
        capacity = cap;        
        stackArray = (T[]) new Object[capacity];        
    }
    
    /**
     * Creates an empty ArrayBasedStack with a capacity of 100
     */
    public ArrayBasedStack() {
      
        this(100);
    }

    /**
     * Checks if the stack is empty.
     * @return Returns true if the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        
        return size == 0;
    }

    /**
     *  Checks the item at the top of the
     *  stack without removing it.
     * @return Item at the top of the stack.
     */
    @Override
    public T peek() {
        
        if (size == 0) {
            throw new EmptyStackException();
        }
        return stackArray[size - 1];
    }

    /**
     * Removes the item at the top of
     * the stack.
     * @return The item that was removed.
     */
    @Override
    public T pop() {
        
        if (size == 0) {
            throw new EmptyStackException();
        }
        
        T temp = stackArray[size - 1];
        stackArray[size - 1] = null;
        size--;
        return temp;
    }

    /**
     * Pushes an item onto the stack.
     * @param item Item to be pushed
     *             onto the stack.
     */
    @Override
    public void push(T item) {
       
        if (size == capacity) {
            expandCapacity();
        }
              
        stackArray[size] = item;    
        size++;
    }

    /**
     * Checks if an item is in the stack.
     * @param item Item to be looked for.
     * @return Returns true if the item is
     *         somewhere in the stack.
     */
    @Override
    public boolean contains(T item) {
        
        for (int i = 0; i < size; i++) {
            if (stackArray[i] == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * Number of items in the stack.
     * @return The number of items in 
     *         the stack.
     */
    @Override
    public int size() {

        return size;
    }

    /**
     * Clears the stack (removes all of 
     * the items from the stack).
     */
    @Override
    public void clear() {

        for (int i = size; i > 0; i--) {
            stackArray[i] = null;
            size--;
        }
    }

    /**
     * Returns an array with a copy of each element in the stack with the top of
     * the stack being the last element
     *
     * @return the array representation of the stack
     */
    @Override
    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        T[] copy =   (T[]) new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            copy[i] = this.stackArray[i];
        }
        return copy;
    }
    
    /**
     * Expands the capacity of the stack by doubling its current capacity.
    */
    private void expandCapacity() {

        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[this.capacity * 2];

        for (int i = 0; i < this.capacity; i++) {
            newArray[i] = this.stackArray[i];
        }

        this.stackArray = newArray;
        this.capacity *= 2;
    }
    
    /**
     * Returns the string representation of the stack.
     * 
     * [] (if the stack is empty)
     * [bottom, item, ..., item, top] (if the stack contains items)
     * 
     * @return the string representation of the stack.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        boolean firstItem = true;
        for (int i = 0; i < this.size(); i++) {
            if (!firstItem) {
                builder.append(", ");
            }
            else {
                firstItem = false;
            }

            // String.valueOf will print null or the toString of the item
            builder.append(String.valueOf(this.stackArray[i]));
        }
        builder.append(']');
        return builder.toString();
    }
    
    /**
     * Two stacks are equal iff they both have the same size and contain the
     * same elements in the same order.
     *
     * @param other
     *            the other object to compare to this
     *
     * @return {@code true}, if the stacks are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass().equals(other.getClass())) {
            ArrayBasedStack<?> otherStack = (ArrayBasedStack<?>) other;
            if (this.size() != otherStack.size()) {
                return false;
            }
            Object[] otherArray = otherStack.toArray();
            for (int i = 0; i < this.size(); i++) {
                if (!(this.stackArray[i].equals(otherArray[i])))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
