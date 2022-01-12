//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times. I
//Will not lie, cheat, or steal, nor will I accept the actions of those who do
//-- Sean Sy (906311775)
package towerofhanoi;
import java.util.EmptyStackException;
import list.ListInterface;
import stack.StackInterface;

/**
 * Implements a singly linked nodes stack data structure
 * 
 * @param <T> The type of objects the LinkedStack will hold
 * 
 * @author Sean Sy 906311775
 * @version 10/20/2020
 */
public class LinkedStack<T> implements StackInterface<T> {

    private Node<T> topNode;
    private int size;
    
    /**
     * LinkedStack constructor to create a new empty LinkedStack object
     */
    public LinkedStack() {
        
        topNode = null;
        size = 0;
    }
    
    /**
     * Gets the amount of Objects in the LinkedStack object
     * 
     * @return the value of the private size field of LinkedStack
     */
    public int size() {
        return size;
    }
    
    @Override
    public void clear() {
        
        while (!isEmpty()) {
            pop();
        }
    }

    @Override
    public boolean isEmpty() {
        
        return size == 0;
    }

    @Override
    public T peek() {
        
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }

    @Override
    public T pop() {
        
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        T data = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return data;
    }

    @Override
    public void push(T anEntry) {
        
        Node<T> newNode = new Node<T>(anEntry, topNode);
        topNode = newNode;
        size++;
    }
    
    /**
     * Returns the contents of LinkedStack as a String
     * 
     * @return String representation of LinkedStack
     */
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        s.append("[");
        Node<T> stringNode = topNode;
        while (stringNode != null) {
            
            if (s.length() > 1) {
                s.append(", ");
            }
            s.append(stringNode.getData());
            stringNode = stringNode.getNextNode();
        }
        
        s.append("]");
        return s.toString();
    }
    
    
    @SuppressWarnings("hiding")
    private class Node<T> {
        
        private T data;
        private Node<T> next;
        
        /**
         * Node constructor to create a new Node object
         * 
         * @param initialData the data contained in the new Node object
         */
        private Node(T initialData) {
            data = initialData; 
        }
        
        /**
         * Node constructor to create a new Node object linked to another Node
         * 
         * @param initialData the data contained in the new Node object
         * @param nextNode the Node object linked as the next Node
         */
        private Node(T initialData, Node<T> nextNode) {
            data = initialData;
            next = nextNode;
        }
        
        /**
         * Gets the next Node object in the link
         * 
         * @return the Node set as the next Node in the link
         */
        private Node<T> getNextNode() {
            return next;
        }
        
        /**
         * Gets the data contained in the Node object
         * 
         * @return the value of the data field of the Node object
         */
        private T getData() {
            return data;
        }
        
        /**
         * Sets the next Node object in the link
         * 
         * @param nextNode Node object that is the new next Node in the link
         */
        @SuppressWarnings("unused")
        private void setNextNode(Node<T> nextNode) {
            
            next = new Node<T>(next.getData(), nextNode);
        }
    }
}



