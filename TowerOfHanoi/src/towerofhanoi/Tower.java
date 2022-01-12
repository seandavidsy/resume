//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times. I
//Will not lie, cheat, or steal, nor will I accept the actions of those who do
//-- Sean Sy (906311775)
package towerofhanoi;

/**
 * Extension of LinkedStack of Disks objects to replicate one of the three
 * towers from Tower of Hanoi puzzle
 * 
 * @author Sean Sy 906311775
 * @version 10/20/2020
 */
public class Tower extends LinkedStack<Disk> {

    private Position position;
    
    /**
     * Tower constructor to create a new Tower object
     * 
     * @param position Position of the Tower, either left, middle, or right
     */
    public Tower(Position position) {
        
        super();
        this.position = position;
    }
    
    /**
     * Gets the Position of the Tower
     * 
     * @return position value of the Tower 
     */
    public Position position() {
        
        return position;
    }
    
    @Override
    public void push(Disk disk) {
        
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            super.push(disk);
        }
        
        else if (peek().compareTo(disk) == 1) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }
    }
}
