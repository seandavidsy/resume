//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times. I
//Will not lie, cheat, or steal, nor will I accept the actions of those who do
//-- Sean Sy (906311775)
package towerofhanoi;
import java.util.Observable;

/**
* Solves Tower of Hanoi puzzle with a certain amount of disks and three towers
* 
* @author Sean Sy 906311775
* @version 10/20/2020
*/
public class HanoiSolver extends Observable {

    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;
    
    /**
     * HanoiSolver constructor to create a new HanoiSolver object
     * 
     * @param disks the number of disks in the Tower of Hanoi puzzle
     */
    public HanoiSolver(int disks) {        
        
        numDisks = disks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }
    
    /**
     * Gets the number of disks in the Tower of Hanoi 
     * 
     * @return the number of disks HanoiSolver object has
     */
    public int disks() {
        
        return numDisks;
    }
    
    /**
     * Gets the tower of HanoiSolver of the specified position
     * 
     * @param pos the Position Enum of the tower
     * @return the tower corresponding to the 
     *  Position Enum paramater, middle if default
     */
    public Tower getTower(Position pos) {
        
        switch (pos) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;
        }
    }
    
    /**
     * Returns the toString of the left, middle, and right Tower objects in 
     * that order as one String
     * 
     * @return String representation of left, middle, and right Tower objects
     */
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        s.append(left.toString());
        s.append(middle.toString());
        s.append(right.toString());
        return s.toString();
    }
    
    /**
     * Moves a disk from the top of one tower to the top of another tower
     * 
     * @param source the Tower where the Disk will be popped from
     * @param destination the Tower where the Disk will be pushed onto
     */
    private void move(Tower source, Tower destination) {
        
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
    }
    
    /**
     * private Recursive method that takes the amount of Disks in the puzzle and
     * transfers them from the right Tower to the left Tower with use of a 
     * middle Tower to only move Disks on top of larger Disks
     * 
     * @param currentDisks the amount of Disks needed to be transferred
     * @param startPole starting Tower of Tower of Hanoi puzzle
     * @param tempPole Tower to temporarily hold Disks being transferred
     * @param endPole end Tower where all Disks are being transferred to
     */
    private void solveTowers(int currentDisks, Tower startPole,
        Tower tempPole, Tower endPole) {
        
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            solveTowers(1, startPole, tempPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
        
    }
    
    /**
     * Public method that solves the Tower of Hanoi puzzle by calling
     * private solveTowers method with parameters from the HanoiSolver object
     */
    public void solve() {
        
        solveTowers(numDisks, right, middle, left);
    }
}
