//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times. I
//Will not lie, cheat, or steal, nor will I accept the actions of those who do
//-- Sean Sy (906311775)
package towerofhanoi;

public class ProjectRunner {
    /**
     * Main method used to run the project
     * 
     * @param args checks argument length to choose whether to use default
     * 5 disks or the Integer parsed from args
     */
    public static void main(String[] args) {
    
        int disks = 5;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        
        HanoiSolver hanoi = new HanoiSolver(disks);
        @SuppressWarnings("unused")
        PuzzleWindow game = new PuzzleWindow(hanoi);
    }
}
