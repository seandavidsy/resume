//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times. I
//Will not lie, cheat, or steal, nor will I accept the actions of those who do
//-- Sean Sy (906311775)
package towerofhanoi;
import java.awt.Color;
import cs2.Shape;
import student.TestableRandom;

/**
 * Implements a Comparable extension of Shape in the form of a Disk
 * as used in the Tower of Hanoi game
 * 
 * @author Sean Sy 906311775
 * @version 10/20/2020
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * Disk constructor to create a new Disk object
     * 
     * @param width the width of the Disk
     */
    public Disk(int width) {
        
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom random = new TestableRandom();
        this.setBackgroundColor(new Color(
            random.nextInt(255), random.nextInt(255), random.nextInt(255)));
    }

    @Override
    public int compareTo(Disk otherDisk) {
        
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        if (this.getWidth() < otherDisk.getWidth()) {
            return -1;
        }
        if (this.getWidth() > otherDisk.getWidth()) {
            return 1;
        }
        return 0;
    }
    
    /**
     * Takes the width of the Disk object and returns it as a String
     * 
     * @return width of Disk object as a String
     */
    public String toString() {
        
        return Integer.toString(this.getWidth());
    }
    
    /**
     * Checks equality between two Disks
     * 
     * @param object the Object that is being checked for equality
     * 
     * @return true if the Disks have the same width, false otherwise
     */
    public boolean equals(Object object) {
        
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        
        if (object.getClass() == this.getClass()) {
            Disk disk = (Disk) object;
            if (disk.getWidth() == this.getWidth()) {
                return true;
            }
        }
        return false;
    }
}
